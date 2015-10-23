
import MLP.MLP;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class TesteIris {

    public static void main(String[] args) {
        /*MLP mlp = new MLP(3, 2, 2, 2);
        mlp.addAttribute("sepallength");
        mlp.addAttribute("sepalwidth");
        mlp.addAttribute("petallength");
        mlp.addAttribute("petalwidth");

        mlp.init();

        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.5, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.9, 3.0, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.7, 3.2, 1.3, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.6, 3.1, 1.5, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.6, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.2, 2.2, 4.5, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.6, 2.5, 3.9, 1.1)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.9, 3.2, 4.8, 1.8)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.1, 2.8, 4.0, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.4, 3.9, 1.7, 0.4)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.9, 3.1, 1.5, 0.1)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.4, 3.7, 1.5, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.8, 3.4, 1.6, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.1, 2.9, 4.7, 1.4)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.6, 2.9, 3.6, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.7, 3.1, 4.4, 1.4)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.6, 3.0, 4.5, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.8, 2.7, 4.1, 1.0)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.6, 3.4, 1.4, 0.3)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.4, 1.5, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.4, 2.9, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.3, 2.5, 4.9, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.1, 2.8, 4.7, 1.2)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.4, 2.9, 4.3, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.6, 3.0, 4.4, 1.4)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.8, 2.8, 4.8, 1.4)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.7, 3.0, 5.0, 1.7)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.6, 3.6, 1.0, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.3, 1.7, 0.5)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.8, 3.4, 1.9, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.0, 1.6, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.4, 1.6, 0.4)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.2, 3.5, 1.5, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.2, 3.4, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.7, 3.2, 1.6, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.8, 3.1, 1.6, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.4, 3.4, 1.5, 0.4)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.3, 2.3, 4.4, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.6, 3.0, 4.1, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.5, 2.5, 4.0, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.5, 2.6, 4.4, 1.2)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.1, 3.0, 4.6, 1.4)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.8, 2.6, 4.0, 1.2)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.5, 1.3, 0.3)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.5, 2.3, 1.3, 0.3)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.4, 3.2, 1.3, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.5, 1.6, 0.6)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.8, 1.9, 0.4)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.8, 3.0, 1.4, 0.3)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.8, 1.6, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.6, 3.2, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.3, 3.7, 1.5, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.3, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(7.0, 3.2, 4.7, 1.4)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.4, 3.2, 4.5, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.9, 3.1, 4.9, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.5, 2.3, 4.0, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.5, 2.8, 4.6, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.7, 2.8, 4.5, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.3, 3.3, 4.7, 1.6)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.9, 2.4, 3.3, 1.0)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.6, 2.9, 4.6, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.2, 2.7, 3.9, 1.4)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 2.0, 3.5, 1.0)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.9, 3.0, 4.2, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.0, 2.2, 4.0, 1.0)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.8, 3.0, 1.4, 0.1)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.3, 3.0, 1.1, 0.1)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.8, 4.0, 1.2, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.7, 4.4, 1.5, 0.4)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.4, 3.9, 1.3, 0.4)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.5, 1.4, 0.3)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.7, 3.8, 1.7, 0.3)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.8, 1.5, 0.3)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.4, 3.4, 1.7, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.7, 1.5, 0.4)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.0, 2.9, 4.5, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.7, 2.6, 3.5, 1.0)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.5, 2.4, 3.8, 1.1)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.5, 2.4, 3.7, 1.0)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.8, 2.7, 3.9, 1.2)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.0, 2.7, 5.1, 1.6)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.4, 3.0, 4.5, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.0, 3.4, 4.5, 1.6)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.7, 3.1, 4.7, 1.5)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.2, 4.1, 1.5, 0.1)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.5, 4.2, 1.4, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.9, 3.1, 1.5, 0.1)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 3.2, 1.2, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.5, 3.5, 1.3, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.9, 3.1, 1.5, 0.1)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.4, 3.0, 1.3, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 3.4, 1.5, 0.2)), "Iris-setosa");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.0, 2.3, 3.3, 1.0)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.6, 2.7, 4.2, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.7, 3.0, 4.2, 1.2)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.7, 2.9, 4.2, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(6.2, 2.9, 4.3, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.1, 2.5, 3.0, 1.1)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(5.7, 2.8, 4.1, 1.3)), "Iris-versicolor");
        mlp.addValues(new ArrayList<Double>(Arrays.asList(4.7, 3.2, 1.3, 0.2)), "Iris-setosa");

                */
        
        MLP mlp = (new Configuration()).readInputFile("iris.txt");

        
        mlp.train();
        //(new Configuration()).generateNeuralNetwork(mlp);
        
        //MLP mlp = (new Configuration()).readConfigurationFile("rede_neural.txt");
        
        //(new Configuration()).generateNeuralNetwork(mlp2);
        
        (new Configuration()).readTestFile("padroes.txt", mlp);
       /* mlp.test(new ArrayList<Double>(Arrays.asList(6.7, 3.1, 4.4, 1.4)), "Iris-versicolor");
        mlp.test(new ArrayList<Double>(Arrays.asList(5.1, 2.5, 3.0, 1.1)), "Iris-versicolor");
        mlp.test(new ArrayList<Double>(Arrays.asList(4.9, 3.1, 1.5, 0.1)), "Iris-setosa");
        mlp.test(new ArrayList<Double>(Arrays.asList(4.8, 3.1, 1.6, 0.2)), "Iris-setosa");

        mlp.test(new ArrayList<Double>(Arrays.asList(5.7, 3.8, 1.7, 0.3)), "Iris-setosa");
        mlp.test(new ArrayList<Double>(Arrays.asList(5.2, 3.5, 1.5, 0.2)), "Iris-setosa");*/
       
        

    }
}
