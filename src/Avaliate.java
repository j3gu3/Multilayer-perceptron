
import java.io.BufferedReader;
import java.io.FileReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Avaliate {

    private final String fileName;
    private final String className;

    private double vp;// True Positive? (Verdadeiro Positivo)
    private double vn;// True Negative? (Verdadeiro Negativo)
    private double fp;// False Positive? (Falso Positivo)
    private double fn;// False Negative? (Falso Negativo)
    
    private int total;
    private int accuracy;

    public Avaliate(String fileName, String className) {
        this.fileName = fileName;
        this.className = className;
        readFile();
    }

    private void readFile() {
        vp = 0;
        fp = 0;
        total = 0;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            while ((line = br.readLine()) != null) {
                //total++;
                String[] classes = line.split(" ");
                if (classes.length == 2) {
                    //classes[0] -> qual era a classe correta
                    //classes[1] -> como foi classificado
                    if(classes[0].equals(className)){
                        total++;
                    }
                    if (classes[0].equals(className) && classes[1].equals(className)) {
                        vp++;
                    }
                    if (!classes[0].equals(className) && classes[1].equals(classes[0])) {
                        vn++;
                    }
                    if (classes[0].equals(className) && !classes[1].equals(className)) {
                        fn++;
                    }
                    if (!classes[0].equals(className) && classes[1].equals(className)) {
                        fp++;
                    }

                }
            }
            System.out.println(this.toString());
        } catch (Exception e) {

        }
    }
    
    public double getAccuracy(){
        return (vp+vn)/(vp+vn+fp+fn);
    }

    public double getPrecision() {
        return vp / (vp + fp);
    }

    public double getCoverage() {
        return vp / (vp + fn);
    }

    public double getF1() {
        return 2 * getPrecision() * getCoverage() / (getPrecision() + getCoverage());
    }

    @Override
    public String toString() {
        return "Avaliate{" + "vp=" + vp + ", vn=" + vn + ", fp=" + fp + ", fn=" + fn + ", total=" + total + ", accuracy=" + accuracy + '}';
    }
    
}
