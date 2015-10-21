package MLP;


import java.util.ArrayList;
import java.util.Iterator;
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
public class Neuron {

    private ArrayList<Synapse> inputSynapses = new ArrayList<>();
    private ArrayList<Synapse> outputSynapses = new ArrayList<>();

    protected double output = 0.0;
    protected double error = 0.0;

    protected String name; /*Just for test purpose*/


    public Neuron() {
    }

    public Neuron(String name) {
        this.name = name;
    }

    public void addInputSynapse(ArrayList ns) {
        for (Iterator it = ns.iterator(); it.hasNext();) {
            Neuron n = (Neuron) it.next();
            Synapse s = new Synapse(n, this);
            n.addOutputSynapse(this);
            inputSynapses.add(s);
        }
    }

    public void addInputSynapse(Neuron n) {
        Synapse s = new Synapse(n, this);
        n.addOutputSynapse(this);
        inputSynapses.add(s);
    }

    public void addInputSynapse(Synapse s) {
        inputSynapses.add(s);
    }

    public ArrayList<Synapse> getInputSynapses() {
        return inputSynapses;
    }

    public void addOutputSynapse(Neuron n) {
        Synapse s = new Synapse(this, n);
        outputSynapses.add(s);
    }

    public void addOutputSynapse(Synapse s) {
        outputSynapses.add(s);
    }

    public ArrayList<Synapse> getOutputSynapses() {
        return outputSynapses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double computeOutput() {
        double result = 0;
        String debug = "";
        for (Synapse inputSynapse : getInputSynapses()) {
            inputSynapse.getOrigin().computeOutput();
            result += inputSynapse.getWeight() * inputSynapse.getOrigin().getOutput();
            //debug += (inputSynapse.getWeight() + " * " + inputSynapse.getOrigin().getOutput() + " + ");
        }
        //System.out.print("Output "+name+": ");
        //System.out.print(debug);
        //System.out.println(" = " + result + " Sigmoid:"+computeSigmoidalCurve(result));
        output = computeSigmoidalCurve(result);
        return output;
    }

    public void adjustWeight() {
        double err = 0;
        for (Synapse outputSynapse : outputSynapses) { // DELTAj = SUM (weightJK * deltaK) | Hidden layers
            err += outputSynapse.getWeight() * outputSynapse.getDestination().error;
        }
        this.error = err;

        for (Synapse inputSynapse : inputSynapses) {
            //System.out.print("Ajustando Peso de "+inputSynapse.getOrigin()+" para "+inputSynapse.getDestination()+": ERA: "+inputSynapse.getWeight());
            double learningRate = CONFIG.getInstance().getLearningRate();
            double Yj = this.output;
            double Xi = inputSynapse.getOrigin().output;
            double deltaW = learningRate * Xi * Yj * (1 - Yj) * error;
            //System.out.println(" | "+inputSynapse.getWeight()+" + LR:"+CONFIG.getInstance().getLearningRate()+" * Xi:"+Xi +" * Yj:"+Yj+" * 1 - Yj:" + (1-Yj)+ " * erro:"+error);
//            double deltaW = CONFIG.getInstance().getLearningRate() * Xi * (1 - Yj);
//            System.out.println(" | "+ CONFIG.getInstance().getLearningRate()+" * "+Xi+" * ( 1 -"+Yj+")");

            inputSynapse.setWeight(inputSynapse.getWeight() + deltaW);
            //System.out.println(" FICOU: "+ inputSynapse.getWeight());
        }
    }

    public double getOutput() {
        return output;
    }

    protected double computeSigmoidalCurve(double value) {
        return 1 / (1 + Math.pow(Math.E, -value));
        /* if(value > 0)
         return 1;
         return 0;*/
    }

    @Override
    public String toString() {
        return name;
    }

}
