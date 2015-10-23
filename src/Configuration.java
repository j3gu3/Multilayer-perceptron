
import MLP.Input;
import MLP.MLP;
import MLP.Neuron;
import MLP.Output;
import MLP.Synapse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodrigo
 */
public class Configuration {
    private double accuracy;
    //private MLP mlp;
    public MLP readInputFile(String filename) {
        MLP mlp = null;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            mlp = readMLPConfig(line);

            line = br.readLine();
            readMLPAttributes(line, mlp);

            while ((line = br.readLine()) != null) {
                readMLPData(line, mlp);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (mlp != null) {
            mlp.init();
        }
        return mlp;
    }

    private void readMLPData(String line, MLP mlp) throws NumberFormatException {
        ArrayList<Double> values = new ArrayList<>();
        String[] args = line.split(" ");
        for (int i = 0; i < args.length - 1; i++) {
            values.add(Double.parseDouble(args[i]));
        }
        mlp.addValues(values, args[args.length - 1]);
    }

    private void readMLPAttributes(String line, MLP mlp) {
        String[] args = line.split(" ");
        for (int i = 0; i < args.length - 1; i++) {
            mlp.addAttribute(args[i]);
        }
        mlp.setClasseName(args[args.length - 1]);
    }

    private MLP readMLPConfig(String line) throws NumberFormatException {
        int cycles = 0;
        int firstLayer = 0;
        int secondLayer = 0;
        int classes = 0;
        String[] args = line.split(" ");
        if (args.length == 4) {
            cycles = Integer.parseInt(args[0]);
            firstLayer = Integer.parseInt(args[1]);
            secondLayer = Integer.parseInt(args[2]);
            classes = Integer.parseInt(args[3]);
        } else {
            System.out.println("Numero de Argumentos Errados");
        }
        return new MLP(cycles, firstLayer, secondLayer, classes);

    }

    public void generateNeuralNetwork(MLP mlp) {

        try {
            FileWriter fileWriter = new FileWriter("rede_neural.txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            List<String> attributes = mlp.getAttributes();

            for (String attribute : attributes) {
                bw.write(attribute + " ");
            }
            bw.newLine();
            for (Neuron first : mlp.getFirst()) {
                if (!first.getName().equals("1")) {
                    bw.write(first.getName() + " ");
                }
            }
            bw.newLine();
            for (Neuron second : mlp.getSecond()) {
                if (!second.getName().equals("1")) {
                    bw.write(second.getName() + " ");
                }
            }
            bw.newLine();
            for (Neuron output : mlp.getOutputs()) {
                if (!output.getName().equals("1")) {
                    bw.write(output.getName() + " ");
                }
            }
            bw.newLine();

            //Synapses
            for (Neuron first : mlp.getFirst()) {
                ArrayList<Synapse> inputSynapses = first.getInputSynapses();
                for (Synapse inputSynapse : inputSynapses) {
                    bw.write(inputSynapse.getOrigin().getName() + " " + inputSynapse.getDestination().getName() + " " + inputSynapse.getWeight());
                    bw.newLine();
                }
            }
            for (Neuron second : mlp.getSecond()) {
                ArrayList<Synapse> inputSynapses = second.getInputSynapses();
                for (Synapse inputSynapse : inputSynapses) {
                    bw.write(inputSynapse.getOrigin().getName() + " " + inputSynapse.getDestination().getName() + " " + inputSynapse.getWeight());
                    bw.newLine();
                }
            }
            for (Neuron output : mlp.getOutputs()) {
                ArrayList<Synapse> inputSynapses = output.getInputSynapses();
                for (Synapse inputSynapse : inputSynapses) {
                    bw.write(inputSynapse.getOrigin().getName() + " " + inputSynapse.getDestination().getName() + " " + inputSynapse.getWeight());
                    bw.newLine();
                }
            }

            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public MLP readConfigurationFile(String filename) {
        MLP mlp = null;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            String[] attributes = line.split(" ");

            line = br.readLine();
            String[] first = line.split(" ");

            line = br.readLine();
            String[] second = line.split(" ");

            line = br.readLine();
            String[] output = line.split(" ");

            mlp = new MLP(0, first.length, second.length, output.length);

            for (String attribute : attributes) {
                mlp.addAttribute(attribute);
            }

            for (String output1 : output) {
                mlp.addClass(output1);
            }

            mlp.initWithoutSynapses();

            for (Neuron f : mlp.getFirst()) {
                for (Neuron i : mlp.getInputs()) {
                    if (!f.getName().equals("1")) {
                        line = br.readLine();
                        String[] values = line.split(" ");
                        //System.out.println(line);
                        double weight = Double.parseDouble(values[values.length - 1]);
                        //System.out.println("--"+i.getName()+" "+f.getName()+" "+ weight);
                        Synapse s = new Synapse(i, f, weight);
                        f.addInputSynapse(s);
                    }
                }
                // System.out.println("TROCOU F");
            }
            //System.out.println("");
            for (Neuron sec : mlp.getSecond()) {
                for (Neuron f : mlp.getFirst()) {
                    //System.out.println(sec.getName());
                    if (!sec.getName().equals("1")) {
                        line = br.readLine();
                        String[] values = line.split(" ");
                        //System.out.println(line);
                        double weight = Double.parseDouble(values[values.length - 1]);
                        //System.out.println("--"+f.getName()+" "+sec.getName()+" "+ weight);
                        Synapse s = new Synapse(f, sec, weight);
                        sec.addInputSynapse(s);
                    }
                }

            }
            //System.out.println("");
            for (Output o : mlp.getOutputs()) {
                for (Neuron sec : mlp.getSecond()) {
                    if (!o.getName().equals("1")) {
                        line = br.readLine();
                        String[] values = line.split(" ");
                        //System.out.println(line);
                        double weight = Double.parseDouble(values[values.length - 1]);
                        //System.out.println("--"+sec.getName()+" "+o.getName()+" "+ weight);
                        Synapse s = new Synapse(sec, o, weight);
                        o.addInputSynapse(s);
                    }
                }

            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mlp;
    }

    public void readTestFile(String filename, MLP mlp) {
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            //mlp = readMLPConfig(line);

            line = br.readLine();
            //readMLPAttributes(line, mlp);

            FileWriter fileWriter = new FileWriter("teste.txt");
            BufferedWriter bw = new BufferedWriter(fileWriter);
            double lines = 0;
            accuracy = 0;
            while ((line = br.readLine()) != null) {
                lines++;
                readMLPTestData(line, mlp, bw);
            }
            System.out.println(accuracy/lines);
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void readMLPTestData(String line, MLP mlp, BufferedWriter bw) throws IOException {
        ArrayList<Double> values = new ArrayList<>();
        String[] args = line.split(" ");
        for (int i = 0; i < args.length - 1; i++) {
            values.add(Double.parseDouble(args[i]));
        }
        String result = mlp.test(values, args[args.length - 1]);

        bw.append(args[args.length - 1] + " " + result);
        bw.newLine();
        //System.out.println(args[args.length - 1] + " " + result);
        if(result.equals(args[args.length - 1])){
            //System.out.println("AQUI");
            accuracy++;
        }
    }

}
