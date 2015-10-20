
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

    public void addValues(ArrayList<Double> values, double expected) {
        values.add(expected);
        if (values.size() == inputs.size()) {
            data.add(values);
        } else {
            System.out.println("NUMBER OF ATTRIBUTES IS WRONG!");
        }
    }

    public void train() {
        for (int i = 0; i < cycles; i++) {
            System.out.println("Cycle: " + (i + 1));
            for (ArrayList<Double> values : data) {
                for (int j = 0; j < values.size() - 1; j++) {
                    inputs.get(j).setValue(values.get(j));
                }
                for (Output o : outputs) {
                    System.out.print(o.getName() + ": " + o.computeOutput(values.get(values.size() - 1)));
                }
                System.out.println("");
            }
            System.out.println("============");
        }
    }

    public void test(ArrayList<Double> values, double expected) {
        System.out.println("Test:");
        for (int j = 0; j < values.size(); j++) {
            inputs.get(j).setValue(values.get(j));
        }
        for (Output o : outputs) {
            System.out.print(o.getName() + ": " + o.computeTest(expected));
        }
        System.out.println("");
    }
}
