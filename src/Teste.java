/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rodrigo
 */
public class Teste {

    public static void main(String[] args) {
        Input i1 = new Input(1, "I1");
        Input i2 = new Input(0, "I2");
        Input i3 = new Input(0, "I3");
        Input itheta = new Input(1, "Theta");

        Neuron n1 = new Neuron("N1");
        Neuron n2 = new Neuron("N2");
        Neuron n3 = new Neuron("N3");
        n1.addInputSynapse(i1);
        n1.addInputSynapse(i2);
        n1.addInputSynapse(i3);
        n1.addInputSynapse(itheta);

        n2.addInputSynapse(i1);
        n2.addInputSynapse(i2);
        n2.addInputSynapse(i3);
        n2.addInputSynapse(itheta);

        n3.addInputSynapse(i1);
        n3.addInputSynapse(i2);
        n3.addInputSynapse(i3);
        n3.addInputSynapse(itheta);
        /*
         Synapse s1 = new Synapse(i1, n1, 0.4);
         Synapse s2 = new Synapse(i2, n1, -0.6);
         Synapse s3 = new Synapse(i3, n1, 0.2);
         Synapse stheta = new Synapse(itheta, n1, -0.9);
         n1.addInputSynapse(s1);
         n1.addInputSynapse(s2);
         n1.addInputSynapse(s3);
         n1.addInputSynapse(stheta);*/
        Output o1 = new Output("O1");
        o1.addInputSynapse(n1);
        o1.addInputSynapse(n2);
        o1.addInputSynapse(n3);

        System.out.println(o1.computeOutput(1));
        for (int i = 0; i < 50; i++) {

            i1.setValue(0);
            i2.setValue(0);
            i3.setValue(1);
            System.out.println(o1.computeOutput(1));

            i1.setValue(0);
            i2.setValue(1);
            i3.setValue(0);
            System.out.println(o1.computeOutput(1));

            i1.setValue(0);
            i2.setValue(1);
            i3.setValue(1);
            System.out.println(o1.computeOutput(0));

            i1.setValue(1);
            i2.setValue(1);
            i3.setValue(0);
            System.out.println(o1.computeOutput(0));

            i1.setValue(1);
            i2.setValue(1);
            i3.setValue(1);
            System.out.println(o1.computeOutput(0));

            System.out.println("");
            System.out.println("");
            System.out.println("");

        }
        i1.setValue(1);
        i2.setValue(0);
        i3.setValue(1);
        System.out.println(o1.computeOutput(0));

    }
}
