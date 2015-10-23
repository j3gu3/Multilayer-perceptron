
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
        MLP mlp = c.readInputFile("car.train");
        mlp.train();
        //c.generateNeuralNetwork(mlp);
        //MLP mlp2 = c.readConfigurationFile("rede_neural.txt");
        c.readTestFile("car.test", mlp);
    }
}
