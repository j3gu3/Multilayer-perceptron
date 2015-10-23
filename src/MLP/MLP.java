package MLP;

import java.util.ArrayList;
import java.util.HashMap;
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
    private final int numClasses;

    private ArrayList<String> attributes = new ArrayList<>();
    private String classeName;
    private ArrayList<String> classes = new ArrayList<>();

    private ArrayList<Input> inputs = new ArrayList<>();
    private ArrayList<Neuron> first = new ArrayList<>();
    private ArrayList<Neuron> second = new ArrayList<>();
    private ArrayList<Output> outputs = new ArrayList<>();

    private ArrayList<ArrayList<Double>> data = new ArrayList<>();
    //private HashMap<ArrayList<Double>, ArrayList<String>> dataExpected = new HashMap<>();
    private ArrayList<String> expected = new ArrayList<>();

    public MLP(int cycles, int firstLayer, int secondLayer, int classes) {
        this.cycles = cycles;
        this.firstLayer = firstLayer;
        this.secondLayer = secondLayer;
        this.numClasses = classes;
    }

    public void init() {
        inputs.clear();
        first.clear();
        second.clear();
        outputs.clear();
        Input BIAS = new Input(1, "1");//BIAS
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
        for (int i = 0; i < classes.size(); i++) {
            //Output o = new Output("O" + i);
            Output o = new Output(classes.get(i));
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

    public List<String> getAttributes() {
        return attributes;
    }

    public void addClass(String className) {
        if (!classes.contains(className)) {
            classes.add(className);
        }
    }

    public void addAttribute(String attribute) {
        this.attributes.add(attribute);
    }

    public void setClasseName(String classeName) {
        this.classeName = classeName;
    }

    public String getClasseName() {
        return classeName;
    }

    public void addValues(ArrayList<Double> values, String classExpected) {
        //values.add(expected);
        //if (values.size() == inputs.size()) {
        this.data.add(values);
        this.expected.add(classExpected);
        if (!classes.contains(classExpected)) {
            classes.add(classExpected);
        }
        //} else {
        //  System.out.println("NUMBER OF ATTRIBUTES IS WRONG!");
        //}
    }

    private ArrayList<Double> getExpectedClassOutput(String className) {
        int i = this.classes.indexOf(className);
        ArrayList<Double> expectedOutput = new ArrayList<>();
        for (int j = 0; j < this.classes.size(); j++) {
            double v = 0.0;
            if (j == i) {
                v = 1.0;
            }
            expectedOutput.add(v);
        }
        return expectedOutput;
    }

    public double train() {
        double accuracy = 0;
        for (int i = 0; i < cycles; i++) {
            accuracy = 0;
            System.out.println("Cycle: " + (i + 1));
            for (int k = 0; k < data.size(); k++) {
                ArrayList<Double> values = data.get(k);

                String classExpected = expected.get(k);
                ArrayList<Double> valuesExpected = getExpectedClassOutput(classExpected);

                for (int j = 0; j < values.size(); j++) {
                    inputs.get(j).setValue(values.get(j));
                }
                this.feedforward();

                int outCount = 0;
                boolean error = false;
                ArrayList<Double> res = new ArrayList<>();
                //ArrayList<Double> res2 = new ArrayList<>();
                Double maior = null;
                int index = -1;

                for (Output o : outputs) {
                    res.add(0.0);
                    double result = o.getOutput();
                    if (maior == null) {
                        maior = result;
                        index = outCount;
                    } else {
                        if (result > maior) {
                            maior = result;
                            index = outCount;
                        }
                    }

                    outCount++;
                }
                res.set(index, 1.0);

                //System.out.println(res + " - "+valuesExpected+" === "+res.equals(valuesExpected));
                if (!valuesExpected.equals(res)) {
                    //  System.out.println("NOK");
                    backpropagation(valuesExpected);
                } else {
                    //System.out.println("OK");
                    accuracy++;
                }
            }
            System.out.println("Accuracy = " + accuracy + " / " + data.size() + " = " + (accuracy / data.size()));
            System.out.println("============");
        }
        return accuracy;
    }

    public String test(ArrayList<Double> values, String expected) {
        //System.out.println("Test:");
        for (int j = 0; j < values.size(); j++) {
            inputs.get(j).setValue(values.get(j));
        }

        this.feedforward();

        //ArrayList<Double> valuesExpected = getExpectedClassOutput(expected);
        ArrayList<Double> res = new ArrayList<>();
        //System.out.println(expected + " -> " + valuesExpected);
        int outCount = 0;
        Double maior = null;
        int index = -1;
        for (Output o : outputs) {
            res.add(0.0);
            double result = o.getOutput();
            if (maior == null) {
                maior = result;
                index = outCount;
            } else {
                if (result > maior) {
                    maior = result;
                    index = outCount;
                }
            }

            outCount++;
        }
        res.set(index, 1.0);
        /*if (!valuesExpected.equals(res)) {
            //   System.out.println("NOK");
        } else {
            //  System.out.println("OK");
        }*/
        //System.out.println("");
        //System.out.println(res);
        try {
            return classes.get(res.indexOf(1.0));
        } catch (IndexOutOfBoundsException e) {
            return "UNDEFINED";
        }
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

    public ArrayList<Input> getInputs() {
        return inputs;
    }

    public void setInputs(ArrayList<Input> inputs) {
        this.inputs = inputs;
    }

    public void setFirst(ArrayList<Neuron> first) {
        this.first = first;
    }

    public ArrayList<Neuron> getFirst() {
        return first;
    }

    public void setSecond(ArrayList<Neuron> second) {
        this.second = second;
    }

    public ArrayList<Neuron> getSecond() {
        return second;
    }

    public void setOutputs(ArrayList<Output> outputs) {
        this.outputs = outputs;
    }

    public ArrayList<Output> getOutputs() {
        return outputs;
    }

    /**
     * Used to build the MLP without the Synapses
     */
    public void initWithoutSynapses() {
        inputs.clear();
        first.clear();
        second.clear();
        outputs.clear();
        Input BIAS = new Input(1, "1");//BIAS
        inputs.add(BIAS);
        for (int i = 0; i < attributes.size(); i++) {
            Input in = new Input("I" + i);
            inputs.add(in);
        }
        first.add(BIAS);
        for (int i = 0; i < firstLayer; i++) {
            Neuron n = new Neuron("F" + i);
            first.add(n);
        }
        second.add(BIAS);
        for (int i = 0; i < secondLayer; i++) {
            Neuron n = new Neuron("S" + i);
            second.add(n);
        }
        for (int i = 0; i < classes.size(); i++) {
            //Output o = new Output("O" + i);
            Output o = new Output(classes.get(i));
            outputs.add(o);
        }
    }

}
