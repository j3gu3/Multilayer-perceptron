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
public class Input extends Neuron{

    public Input() {
    }

    public Input (String name){
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
    protected double computeOutput() {
        //System.out.print("Output "+getName()+": ");
        //System.out.println(output);
        return this.output;
    }

    public void setValue(double value) {
        this.output = value;
    }
    
    
    
    
}
