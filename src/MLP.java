
import MLP.Input;
import MLP.Output;
import MLP.Neuron;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class MLP {

    private final int cycles;
    private final int firstLayer;
    private final int secondLayer;
    private final int classes;

    private List<String> attributes = new LinkedList<String>();

    private ArrayList<Input> inputs = new ArrayList<>();
    private ArrayList<Neuron> first = new ArrayList<>();
    private ArrayList<Neuron> second = new ArrayList<>();
    private ArrayList<Output> outputs = new ArrayList<>();

    private ArrayList<ArrayList<Double>> data = new ArrayList<>();
    private ArrayList<ArrayList<Double>> expected = new ArrayList<>();

    public MLP(int cycles, int firstLayer, int secondLayer, int classes) {
        this.cycles = cycles;
        this.firstLayer = firstLayer;
        this.secondLayer = secondLayer;
        this.classes = classes;
    }

    public void init() {
        inputs.clear();
        first.clear();
        second.clear();
        outputs.clear();
        Input BIAS = new Input(1, "BIAS");
        inputs.add(BIAS);
        for (int i = 0; i < attributes.size(); i++) {
            Input in = new Input("I" + i);
            inputs.add(in);
        }
        first.add(BIAS);
        for (int i = 0; i < firstLayer; i++) {
            Neuron n = new Neuron("F" + i);
            n.addInputSynapse(inputs);
            first.add(n);
        }
        second.add(BIAS);
        for (int i = 0; i < secondLayer; i++) {
            Neuron n = new Neuron("S" + i);
            n.addInputSynapse(first);
            second.add(n);
        }
        for (int i = 0; i < classes; i++) {
            Output o = new Output("O" + i);
            if (secondLayer != 0) {
                o.addInputSynapse(second);
            } else if (firstLayer != 0) {
                o.addInputSynapse(first);
            } else { // Perceptron?
                o.addInputSynapse(inputs);
            }
            outputs.add(o);
        }
    }

    public void addAttribute(String attribute) {
        this.attributes.add(attribute);
    }

    public void addValues(ArrayList<Double> values, ArrayList<Double> expected) {
        //values.add(expected);
        if (values.size() == inputs.size() - 1 && expected.size() == classes) {
            this.data.add(values);
            this.expected.add(expected);
        } else {
            System.out.println("NUMBER OF ATTRIBUTES IS WRONG!");
        }
    }

    public void train() {
        for (int i = 0; i < cycles; i++) {
            double accuracy = 0;
            System.out.println("Cycle: " + (i + 1));
            for (int k = 0; k < data.size(); k++) {
                ArrayList<Double> values = data.get(k);
                ArrayList<Double> valuesExpected = expected.get(k);

                for (int j = 0; j < values.size(); j++) {
                    inputs.get(j).setValue(values.get(j));
                }
                this.feedforward();

                int outCount = 0;
                boolean error = false;
                for (Output o : outputs) {
                    double result = Math.round(o.getOutput());
                    System.out.println(o.getName() + ": "+o.getOutput()+" -> "+expected.get(outCount));
                    if (result != valuesExpected.get(outCount)) {
                        error = true;
                    }
                    outCount++;
                }
                if(error){
                    System.out.println("NOK");
                    backpropagation(valuesExpected);
                }else{
                    //System.out.println("OK");
                    accuracy++;
                }
            }
            System.out.println("Accuracy = " + accuracy + " / "+ data.size() + " = " + (accuracy/data.size()));
            System.out.println("============");
        }
    }

    public void test(ArrayList<Double> values, ArrayList<Double> expected) {
        System.out.println("Test:");
        for (int j = 0; j < values.size(); j++) {
            inputs.get(j).setValue(values.get(j));
        }
        
        this.feedforward();
        
        int outCount = 0;
        boolean error = false;
        for (Output o : outputs) {
            double result = Math.round(o.getOutput());
            System.out.println(o.getName() + ": "+o.getOutput()+" -> "+expected.get(outCount));
            if (result != expected.get(outCount)) {
                error = true;
            }
            outCount++;
        }
        if(error){
            System.out.println("NOK");
        }else{
            System.out.println("OK");
        }
                
//        int outCount = 0;
//        for (Output o : outputs) {
//            System.out.print(o.getName() + ": " + o.computeTest(expected.get(outCount)));
//            outCount++;
//        }
        System.out.println("");
    }

    public void feedforward() {
        for (Neuron f : first) {
            f.computeOutput();
        }
        for (Neuron s : second) {
            s.computeOutput();
        }
        for (Output o : outputs) {
            o.computeOutput();
        }
    }

    public void backpropagation(ArrayList<Double> expected) {
        int outCount = 0;
        for (Output o : outputs) {
            o.adjustWeight(expected.get(outCount));
            outCount++;
        }
        for (Neuron s : second) {
            s.adjustWeight();
        }
        for (Neuron f : first) {
            f.adjustWeight();
        }
    }
}
