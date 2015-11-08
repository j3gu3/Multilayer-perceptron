
import MLP.MLP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Test {

    public static void main(String[] args) {
        Configuration c = new Configuration();
        MLP mlp = null;
        if (args.length > 1) {
            switch (args[0]) {
                case "--treina":
                    mlp = c.readInputFile(args[1]);
                    mlp.train();
                    c.generateNeuralNetwork(mlp);
                    break;
                case "--testa":
                    mlp = c.readConfigurationFile(args[1]);
                    c.readTestFile(args[2], mlp);
                    break;
                case "--avalia":
                    c.readAvaliationFile(args[1], args[2]);
                    break;
                default:
                    System.out.println("Command not available!");
                    System.out.println("Try one of these: (All parameters are required)");
                    System.out.println("--treina [training_file.txt]");
                    System.out.println("--teste [neural_network.txt] [test_file.txt]");
                    System.out.println("--avalia [test_output.txt] [class_of_reference]");
            }
        } else {
            System.out.println("HELP!");
            System.out.println("Try one of these: (All parameters are required)");
            System.out.println("--treina [training_file.txt]");
            System.out.println("--teste [neural_network.txt] [test_file.txt]");
            System.out.println("--avalia [test_output.txt] [class_of_reference]");
        }

        //MLP mlp = c.readInputFile("car.train");
        //MLP mlp = c.readInputFile("iris.txt");
        //MLP mlp = c.readInputFile("ionosphere.train");
        //mlp.train();
        //c.readTestFile("ionosphere.test", mlp);
        //c.readAvaliationFile("teste.txt", "good");
        //c.readAvaliationFile("teste.txt", "bad");
        //c.generateNeuralNetwork(mlp);
        //MLP mlp2 = c.readConfigurationFile("rede_neural.txt");
        //c.readTestFile("car.test", mlp);
        //c.readTestFile("padroes.txt", mlp);
        //new BruteForce("car.train");
    }
}
