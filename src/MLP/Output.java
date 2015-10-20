package MLP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Output extends Neuron {

    public Output(String name) {
        super(name);
    }

    public Output() {
    }

    public double computeTest(double valueExpected) {
        double result = super.computeOutput();
        double rr = Math.round(result);
        if (rr != valueExpected) {
            System.out.println("NOK");
        } else {
            System.out.println("OK");
        }
        return result;
    }

    public double computeOutput(double valueExpected) {
        double result = super.computeOutput();
        double rr = Math.round(result);
        if (rr != valueExpected) {
            System.out.println("NOK");
            adjustWeight(result, valueExpected);
        } else {
            System.out.println("OK");
        }
        return result;
    }

    protected void adjustWeight(double computed, double expected) {
        //DELTA
        error = (expected - computed);
        for (Synapse inputSynapse : getInputSynapses()) {
            //System.out.println("Ajustando Peso de "+inputSynapse.getOrigin()+" para "+inputSynapse.getDestination()+": ERA: "+inputSynapse.getWeight());
            double Yj = this.output;
            double Xi = inputSynapse.getOrigin().output;
            double deltaW = CONFIG.getInstance().getLearningRate() * Xi * Yj * (1 - Yj) * error;
            //System.out.println(" | "+inputSynapse.getWeight()+" + LR:"+CONFIG.getInstance().getLearningRate()+" * Xi:"+Xi +" * Yj:"+Yj+" * 1 - Yj:" + (1-Yj)+ " * erro:"+error);
//            double deltaW = CONFIG.getInstance().getLearningRate() * Xi * (1 - Yj);
//            System.out.println(" | "+ CONFIG.getInstance().getLearningRate()+" * "+Xi+" * ( 1 -"+Yj+")");

            inputSynapse.setWeight(inputSynapse.getWeight() + deltaW);
            //System.out.println(" FICOU: "+ inputSynapse.getWeight());
            inputSynapse.getOrigin().adjustWeight();
        }
    }

}
