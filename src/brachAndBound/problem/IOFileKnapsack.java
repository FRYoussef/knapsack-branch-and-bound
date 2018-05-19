package brachAndBound.problem;

import java.io.*;

public class IOFileKnapsack {

    public static KnapsackProblem getKnapSack(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        int n;
        float kWeight;
        Float oWeight[] = null;
        Float oValue[] = null;

        n = Integer.parseInt(br.readLine());
        kWeight = Float.parseFloat(br.readLine());
        oWeight = new Float[n];
        oValue = new Float[n];

        for(int i = 0; i < n; i++)  oWeight[i] = Float.parseFloat(br.readLine());
        for(int i = 0; i < n; i++)  oValue[i] = Float.parseFloat(br.readLine());

        br.close();
        return new KnapsackProblem(kWeight, oWeight, oValue);
    }

    public static void writeKnapsack(KnapsackProblem kp, String file) throws Exception {
        if(kp == null)
            throw new Exception("There is no knapsack");

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file)));

        bw.write(kp.getObjectsNumber() + "");
        bw.newLine();
        bw.write(kp.K_WEIGHT + "");
        bw.newLine();
        for(Float f : kp.getoWeight()){
            bw.write(f.toString());
            bw.newLine();
        }

        for(Float f : kp.getoValue()){
            bw.write(f.toString());
            bw.newLine();
        }

        bw.close();
    }

}
