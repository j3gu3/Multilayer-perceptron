package MLP;

import java.util.Random;

/**
 * Configuration of the MLP
 * @author Rodrigo
 */
public class CONFIG {

    private static CONFIG instance = null;
    /**
     * Seed to generate the random values
     */
    private long seed = 74;
    /**
     * Learning Rate η, used in the backpropagation to adjust the weights
     */
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

    public void resetRandomGenerator() {
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
