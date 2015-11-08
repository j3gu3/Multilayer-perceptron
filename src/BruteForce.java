
import MLP.CONFIG;
import MLP.MLP;

/**
 *
 * @author Rodrigo
 */
public class BruteForce {

    public BruteForce(String inputFile) {
        double bestLR = -1;
        int bestSeed = -1;
        double bestAccuracy = -1;
        for (int i = 0; i < 5; i++) {
            double lr = (int) (Math.random() * 1000);
            lr /= 1000;
            CONFIG.getInstance().setLearningRate(lr);

            if (bestLR == -1) {
                bestLR = lr;
            }

            for (int j = 0; j < 5; j++) {
                int seed = (int) (Math.random() * 100);
                CONFIG.getInstance().setSeed(seed);

                if (bestSeed == -1) {
                    bestSeed = seed;
                }

                Configuration c = new Configuration();
                MLP mlp = c.readInputFile(inputFile);
                double accuracy = mlp.train();
                System.out.println("-->LR: " + lr + " Seed: " + seed + " Accuracy: " + accuracy);
                if (bestAccuracy == -1) {
                    bestAccuracy = accuracy;
                } else {
                    if (accuracy > bestAccuracy) {
                        bestAccuracy = accuracy;
                        bestLR = lr;
                        bestSeed = seed;
                    }
                }
            }
        }

        System.out.println("========================");
        System.out.println("LR: " + bestLR + " Seed: " + bestSeed + " Accuracy: " + bestAccuracy);
    }

}
