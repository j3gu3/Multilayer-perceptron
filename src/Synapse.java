
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Synapse {

    private Neuron origin;
    private Neuron destination;
    private double weight;

    /**
     * Create a Synapse with the origin and the destination
     *
     * @param origin
     * @param destination
     */
    public Synapse(Neuron origin, Neuron destination) {
        this.origin = origin;
        this.destination = destination;
        init();
    }

    /**
     * Can be used for test purpose
     *
     * @param origin
     * @param destination
     * @param weight
     */
    public Synapse(Neuron origin, Neuron destination, double weight) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    private void init() {
        weight = (2 * CONFIG.getInstance().getRandomGenerator().nextDouble()) - 1;
    }

    public Neuron getOrigin() {
        return origin;
    }

    public void setOrigin(Neuron origin) {
        this.origin = origin;
    }

    public Neuron getDestination() {
        return destination;
    }

    public void setDestination(Neuron destination) {
        this.destination = destination;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

}
