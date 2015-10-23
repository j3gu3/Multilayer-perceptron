package MLP;

/**
 * Output Neuron, this will contain the output of the Neural Network
 * @author Rodrigo
 */
public class Output extends Neuron {

    public Output(String name) {
        super(name);
    }

    public Output() {
    }

    /**
     * Compute the Output of this Neuron
     * @return computed output | y
     */
    @Override
    public double computeOutput() {
        return super.computeOutput();
    }

    /**
     * Adjust the weight of the Output Neuron Uses the equation: weight += ∆wij
     *
     * ∆wij = ηxi * yj * (1 - yj) * δj 
     * δj = (dj - yj ) (Last Layer)
     *
     * i = previous layer | j = current layer 
     * xi = output of the neuron in the previous layer 
     * yj = output of the current layer.
     * dj = expected value 
     * η = learning rate
     * @param expected value expected
     */
    public void adjustWeight(double expected) {
        double computed = this.output; //δj = (Dj - Yj)
        error = (expected - computed);
        for (Synapse inputSynapse : getInputSynapses()) {
            double learningRate = CONFIG.getInstance().getLearningRate();
            double Xi = inputSynapse.getOrigin().output;
            double Yj = this.output;
            double deltaW = learningRate * Xi * Yj * (1 - Yj) * error; // ηxi * yj * (1 - yj) * δj

            inputSynapse.setWeight(inputSynapse.getWeight() + deltaW);;
        }
    }

}
