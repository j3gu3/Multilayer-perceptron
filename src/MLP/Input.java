package MLP;

/**
 * Input neuron
 * @author Rodrigo
 */
public class Input extends Neuron {

    public Input() {
    }

    public Input(String name) {
        super(name);
    }

    public Input(double value) {
        output = value;
    }

    public Input(double value, String name) {
        super(name);
        //super.name = name;
        output = value;
    }

    @Override
    public double computeOutput() {
        return this.output;
    }

    public void setValue(double value) {
        this.output = value;
    }

}
