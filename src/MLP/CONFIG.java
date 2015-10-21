package MLP;


import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class CONFIG {

    private static CONFIG instance = null;
    private final long seed = 6;
    private final double learningRate = 0.2;
    private final Random r;

    protected CONFIG() {
        r = new Random(seed);
    }

    public static CONFIG getInstance() {
        if (instance == null) {
            instance = new CONFIG();
        }
        return instance;
    }

    public Random getRandomGenerator() {
        return this.r;
    }

    public double getLearningRate() {
        return learningRate;
    }

}
