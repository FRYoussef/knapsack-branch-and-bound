package brachAndBound.problem;

import java.io.*;

public class IOFileKnapsack {

    public static KnapsackProblem getKnapSack(String file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(new File(file)));
        int n;
        float kWeight;
        ObjectKP objs[] = null;

        n = Integer.parseInt(br.readLine());
        kWeight = Float.parseFloat(br.readLine());
        objs = new ObjectKP[n];

        for(int i = 0; i < n; i++)
            objs[i] = new ObjectKP(Float.parseFloat(br.readLine()), Float.parseFloat(br.readLine()));

        br.close();
        return new KnapsackProblem(kWeight, objs);
    }

    public static void writeKnapsack(KnapsackProblem kp, String file) throws Exception {
        if(kp == null)
            throw new Exception("There is no knapsack");

        BufferedWriter bw = new BufferedWriter(new FileWriter(new File(file)));

        bw.write(kp.getObjectsNumber() + "");
        bw.newLine();
        bw.write(kp.K_WEIGHT + "");
        bw.newLine();
        for(ObjectKP o : kp.getObjs()){
            bw.write(o.getoWeight() + "");
            bw.newLine();
            bw.write(o.getoValue() + "");
            bw.newLine();
        }

        bw.close();
        System.out.println("Saved!!!");
    }
}
