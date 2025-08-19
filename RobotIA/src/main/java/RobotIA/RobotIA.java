package RobotIA;
import edu.stanford.nlp.pipeline.*;
        import edu.stanford.nlp.ling.*;
        import org.deeplearning4j.models.embeddings.loader.WordVectorSerializer;
import org.deeplearning4j.models.word2vec.Word2Vec;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Nesterovs;
import org.nd4j.linalg.lossfunctions.LossFunctions;
import com.sun.speech.freetts.*;

        import java.io.*;
        import java.nio.file.*;
        import java.util.*;

public class RobotIA {
    private String nombre;
    private String personalidad;
    private int nivelDeAmabilidad;
    private MultiLayerNetwork modelo;
    private StanfordCoreNLP pipeline;
    private Word2Vec word2Vec;

    public RobotIA(String nombre, String personalidad, int nivelDeAmabilidad) {
        this.nombre = nombre;
        this.personalidad = personalidad;
        this.nivelDeAmabilidad = nivelDeAmabilidad;
        this.pipeline = inicializarNLP();
        this.word2Vec = cargarWord2Vec();
        this.modelo = entrenarDesdeCSV("src/main/resources/entrenamiento.csv");
    }

    private StanfordCoreNLP inicializarNLP() {
        Properties props = new Properties();
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");
        return new StanfordCoreNLP(props);
    }

    private Word2Vec cargarWord2Vec() {
        try {
            return WordVectorSerializer.readWord2VecModel("src/main/resources/modelo-es.bin");
        } catch (Exception e) {
            throw new RuntimeException("No se pudo cargar el modelo Word2Vec", e);
        }
    }

    public void interactuarConUsuario() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🤖 Hola, soy " + nombre + ". Puedes hablar o escribir. Di 'salir' para terminar.");

        while (true) {
            String entrada = escucharORleer(scanner);
            if (entrada.equalsIgnoreCase("salir")) {
                decir("Hasta luego");
                break;
            }
            List<String> subordenes = dividirFraseEnOrdenes(entrada);
            for (String orden : subordenes) {
                INDArray features = vectorizarFrase(orden);
                INDArray resultado = modelo.output(features);
                double confianza = resultado.maxNumber().doubleValue();
                int accion = Nd4j.argMax(resultado, 1).getInt(0);

                if (confianza < 0.75) {
                    decir("No entiendo bien la orden: " + orden);
                    System.out.println("Indícame la acción correcta (adelante / izquierda / derecha):");
                    String accionCorrecta = scanner.nextLine();
                    guardarEnCSV("src/main/resources/entrenamiento.csv", orden, accionCorrecta);
                    this.modelo = entrenarDesdeCSV("src/main/resources/entrenamiento.csv");
                    decir("He aprendido esa orden");
                } else {
                    ejecutarAccion(accion);
                    responderConPersonalidad();
                }
            }
        }
        scanner.close();
    }

    private String escucharORleer(Scanner scanner) {
        try {
            // Puedes integrar CMUSphinx aquí, por ahora solo consola:
            System.out.print("Tú: ");
            return scanner.nextLine();
        } catch (Exception e) {
            return "";
        }
    }

    private INDArray vectorizarFrase(String texto) {
        Annotation doc = new Annotation(texto);
        pipeline.annotate(doc);
        List<CoreLabel> tokens = doc.get(CoreAnnotations.TokensAnnotation.class);

        INDArray vector = Nd4j.zeros(word2Vec.getLayerSize());
        int count = 0;
        for (CoreLabel token : tokens) {
            String palabra = token.lemma().toLowerCase();
            if (word2Vec.hasWord(palabra)) {
                vector.addi(Nd4j.create(word2Vec.getWordVector(palabra)));
                count++;
            }
        }
        if (count > 0) vector.divi(count);
        return vector.reshape(1, word2Vec.getLayerSize());
    }

    private List<String> dividirFraseEnOrdenes(String frase) {
        String[] partes = frase.toLowerCase().split("\\s*y\\s*|\\s*luego\\s*|\\s*después\\s*|\\,");
        List<String> ordenes = new ArrayList<>();
        for (String p : partes) {
            if (!p.trim().isEmpty()) ordenes.add(p.trim());
        }
        return ordenes;
    }

    private MultiLayerNetwork entrenarDesdeCSV(String rutaCSV) {
        try {
            List<String> lineas = Files.readAllLines(Paths.get(rutaCSV));
            List<double[]> entradas = new ArrayList<>();
            List<double[]> salidas = new ArrayList<>();

            for (String linea : lineas) {
                if (!linea.trim().isEmpty() && !linea.startsWith("#")) {
                    String[] partes = linea.split(",");
                    INDArray in = vectorizarFrase(partes[0]);
                    entradas.add(in.toDoubleVector());
                    salidas.add(convertirAccionAArray(partes[1]));
                }
            }

            INDArray trainingData = Nd4j.create(entradas.toArray(new double[]));
            INDArray labels = Nd4j.create(salidas.toArray(new double[]));

            NeuralNetConfiguration.ListBuilder conf = new NeuralNetConfiguration.Builder()
                    .seed(42).weightInit(WeightInit.XAVIER)
                    .updater(new Nesterovs(0.1, 0.9))
                    .list();

            conf.layer(0, new DenseLayer.Builder()
                    .nIn(word2Vec.getLayerSize()).nOut(50)
                    .activation(Activation.RELU).build());

            conf.layer(1, new OutputLayer.Builder(LossFunctions.LossFunction.NEGATIVELOGLIKELIHOOD)
                    .nIn(50).nOut(3)
                    .activation(Activation.SOFTMAX).build());

            MultiLayerNetwork model = new MultiLayerNetwork(conf.build());
            model.init();
            model.fit(trainingData, labels);
            return model;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private double[] convertirAccionAArray(String accion) {
        return switch (accion.toLowerCase()) {
            case "adelante" -> new double[]{1, 0, 0};
            case "izquierda" -> new double[]{0, 1, 0};
            case "derecha" -> new double[]{0, 0, 1};
            default -> new double[]{0, 0, 0};
        };
    }

    private void ejecutarAccion(int accion) {
        switch (accion) {
            case 0 -> decir("Moviéndome hacia adelante");
            case 1 -> decir("Girando a la izquierda");
            case 2 -> decir("Girando a la derecha");
        }
    }

    private void responderConPersonalidad() {
        if (personalidad.equalsIgnoreCase("amigable")) {
            decir("¿Necesitas algo más?");
        } else {
            decir("¿Qué más puedo hacer por ti?");
        }
    }

    private void guardarEnCSV(String ruta, String frase, String accion) {
        try {
            String linea = frase + "," + accion + System.lineSeparator();
            Files.write(Paths.get(ruta), linea.getBytes(),
                    StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.err.println("Error guardando nueva orden: " + e.getMessage());
        }
    }

    private void decir(String texto) {
        System.out.println("🤖 " + texto);
        Voice voice = VoiceManager.getInstance().getVoice("kevin16");
        if (voice != null) {
            voice.allocate();
            voice.speak(texto);
            voice.deallocate();
        }
    }

    public static void main(String[] args) throws Exception {
        RobotIA robot = new RobotIA("Robbie", "amigable", 9);
        robot.interactuarConUsuario();
    }
}