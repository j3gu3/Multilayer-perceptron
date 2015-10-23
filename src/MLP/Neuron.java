package MLP;


import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Rodrigo
 */
public class Neuron {

    /**
     * All Synapses that connects the previous layer to this Neuron
     */
    private ArrayList<Synapse> inputSynapses = new ArrayList<>();
    
    /** * All Synapses that connects this layer to the next Layer */
    private ArrayList<Synapse> outputSynapses = new ArrayList<>();
    
    /**
     * Output of the Neuron
     */
    protected double output = 0.0;
    
    /**
     * Given by:
     * δj= ∑(Wjk * δk) (Hidden layers)
     * δj = (dj - yj ) (Last Layer)
     */
    protected double error = 0.0;

    protected String name; 


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

    /**
     * Compute the Output of the Neuron
     * Given by: 
     * output = xθ * wθ + ∑(xi * wi)
     * xθ = BIAS output (1)
     * wθ = weight of the synapse
     * xi = output of the previous neuron
     * wi = weight of the synapse from the xi to the current neuron
     * @return 
     */
    public double computeOutput() {
        double result = 0;
        for (Synapse inputSynapse : getInputSynapses()) {
            inputSynapse.getOrigin().computeOutput();
            result += inputSynapse.getWeight() * inputSynapse.getOrigin().getOutput();
        }
        output = computeSigmoidFunction(result);
        return output;
    }

    /**
     * Adjust the weight of the Output Neuron Uses the equation: weight += ∆wij
     *
     * ∆wij = ηxi * yj * (1 - yj) * δj 
     * δj= ∑(Wjk * δk) (Hidden layers)
     *
     * i = previous layer | j = current layer 
     * xi = output of the neuron in the previous layer 
     * yj = output of the current layer.
     * Wjk = weight of the synapse from the current layer(j) to the Neuron(k) in the next layer
     * δk = error of the Neuron(k) that is in the next layer
     * dj = expected value 
     * η = learning rate
     */
    public void adjustWeight() {
        double err = 0;
        for (Synapse outputSynapse : outputSynapses) { // DELTAj = SUM (weightJK * deltaK) | Hidden layers
            err += outputSynapse.getWeight() * outputSynapse.getDestination().error;
        }
        this.error = err;

        for (Synapse inputSynapse : inputSynapses) {
            double learningRate = CONFIG.getInstance().getLearningRate();
            double Yj = this.output;
            double Xi = inputSynapse.getOrigin().output;
            double deltaW = learningRate * Xi * Yj * (1 - Yj) * error;
            inputSynapse.setWeight(inputSynapse.getWeight() + deltaW);;
        }
    }

    public double getOutput() {
        return output;
    }

    /**
     * Compute the Sigmoid Function
     * Given by: 1 / (1 + e^(-value))
     * 
     * @param value
     * @return 
     */
    protected double computeSigmoidFunction(double value) {
        return 1 / (1 + Math.pow(Math.E, -value));
    }

    @Override
    public String toString() {
        return name;
    }

}
