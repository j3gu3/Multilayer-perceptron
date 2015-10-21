
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
public class Teste {

    public static void main(String[] args) {
        
        MLP mlp = new MLP(2, 1, 0, 1);
        mlp.addAttribute("p");
        mlp.addAttribute("q");
        
//        mlp.init();
//        
//        mlp.addValues(new ArrayList<Double>( Arrays.asList(1.0,1.0) ), 0);
//        mlp.addValues(new ArrayList<Double>( Arrays.asList(1.0,0.0) ), 1);
//        mlp.addValues(new ArrayList<Double>( Arrays.asList(0.0,1.0) ), 1);
//        mlp.addValues(new ArrayList<Double>( Arrays.asList(0.0,0.0) ), 0);
//        
//        
//        mlp.train();
//        
//        mlp.test(new ArrayList<Double>( Arrays.asList(1.0,0.0) ), 1);
        
//        
//        Input i1 = new Input(1, "I1");
//        Input i2 = new Input(0, "I2");
//        //Input i3 = new Input(0, "I3");
//        
//        Input BIAS = new Input(1, "Bias");
//        
//        ArrayList<Input> inputs = new ArrayList<>();
//        inputs.add(i1);
//        inputs.add(i2);
//        //inputs.add(i3);
//        //inputs.add(iBIAS);
//
//        Neuron n1 = new Neuron("N1");
//        //Neuron n2 = new Neuron("N2");
//        //Neuron n3 = new Neuron("N3");
//        n1.addInputSynapse(BIAS);
//        //n2.addInputSynapse(BIAS);
//        //n3.addInputSynapse(BIAS);
//        
//        n1.addInputSynapse(inputs);
//        //n2.addInputSynapse(inputs);
//        //n3.addInputSynapse(inputs);
//        
//        ArrayList<Neuron> first = new ArrayList<>();
//        first.add(n1);
//        //first.add(n2); 
//       //first.add(n3);
//        //first.add(nBIAS);
//        Output o1 = new Output("O1");
//        //Input oBIAS = new Input(1, "OBias");
//        o1.addInputSynapse(first);
//        o1.addInputSynapse(BIAS);
//        //o1.addInputSynapse(oBIAS);
//
//        for (int i = 0; i < 10; i++) {
//            /*i1.setValue(1); i2.setValue(0); i3.setValue(0);
//            System.out.println(o1.computeOutput(1));
//            
//            i1.setValue(0); i2.setValue(1); i3.setValue(0);
//            System.out.println(o1.computeOutput(1));
//
//            i1.setValue(0); i2.setValue(0); i3.setValue(1);
//            System.out.println(o1.computeOutput(1));
//
//            i1.setValue(0); i2.setValue(1); i3.setValue(1);
//            System.out.println(o1.computeOutput(0));
//
//            i1.setValue(1); i2.setValue(1); i3.setValue(0);
//            System.out.println(o1.computeOutput(0));
//
//            i1.setValue(1); i2.setValue(1); i3.setValue(1);
//            System.out.println(o1.computeOutput(0));*/
//            
//            i1.setValue(1); i2.setValue(1);
//            System.out.println(o1.computeOutput(0));
//            
//            i1.setValue(1); i2.setValue(0);
//            System.out.println(o1.computeOutput(1));
//            
//            i1.setValue(0); i2.setValue(1);
//            System.out.println(o1.computeOutput(1));
//            
//            i1.setValue(0); i2.setValue(0);
//            System.out.println(o1.computeOutput(0));
//            
//            System.out.println(""); System.out.println("");
//        }
//        /*i1.setValue(0); i2.setValue(0); i3.setValue(0);
//        System.out.println(o1.computeOutput(0));
//        
//        i1.setValue(1); i2.setValue(0); i3.setValue(1);
//        System.out.println(o1.computeOutput(0));*/
//        
//        i1.setValue(1); i2.setValue(1);
//        System.out.println(o1.computeOutput(0));
    }
}
