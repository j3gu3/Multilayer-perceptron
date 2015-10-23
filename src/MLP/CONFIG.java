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
    private long seed = 74;
    private double learningRate = 0.403;
    private Random r;

    protected CONFIG() {
        r = new Random(seed);
    }

    public static CONFIG getInstance() {
        if (instance == null) {
            instance = new CONFIG();
        }
        return instance;
    }

    public void resetRandomGenerator(){
        r = new Random(seed);
    }
    public Random getRandomGenerator() {
        return this.r;
    }

    public double getLearningRate() {
        return learningRate;
    }

    public void setLearningRate(double learningRate) {
        this.learningRate = learningRate;
    }

    public long getSeed() {
        return seed;
    }

    public void setSeed(long seed) {
        this.seed = seed;
        resetRandomGenerator();
    }

}
