package brachAndBound.problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class KnapsackProblem {

    private static final int MAX_WEIGHT_KNAPSACK = 60;
    private static final int MAX_WEIGHT = 20;
    private static final int MAX_VALUE = 80;

    // the knapsack weight
    public final float K_WEIGHT;
    private ObjectKP objs[] = null;

    /**
     * The param objs must be ordered
     * @param k_WEIGHT
     * @param objs objs[0] >= objs[1] >= ... >= objs[n]
     */
    public KnapsackProblem(float k_WEIGHT, ObjectKP []objs){
        K_WEIGHT = k_WEIGHT;
        this.objs = objs;
    }

    public int getObjectsNumber(){ return objs.length; }

    public float getPosWeight(int pos){
        return objs[pos].getoWeight();
    }

    public float getPosValue(int pos){
        return objs[pos].getoValue();
    }

    public ObjectKP[] getObjs() {
        return objs;
    }

    public static KnapsackProblem getRandomKnapsackProblem(int n){
        Random r = new Random(System.currentTimeMillis());
        float kWeight = r.nextFloat() + r.nextInt(MAX_WEIGHT_KNAPSACK);
        ArrayList<ObjectKP> alObjs = new ArrayList<ObjectKP>(n);

        for(int i = 0; i < n; i++)
            alObjs.add(new ObjectKP(r.nextFloat() + r.nextInt(MAX_WEIGHT), r.nextFloat() + r.nextInt(MAX_VALUE)));

        alObjs.sort(ObjectKP::compareTo);
        Collections.reverse(alObjs);

        return new KnapsackProblem(kWeight, alObjs.toArray(new ObjectKP[n]));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Knapsack´s weight: " + K_WEIGHT + "\n");
        sb.append("\nObject´s value: ");
        for(ObjectKP o : objs) sb.append(o.getoValue()).append(", ");
        sb.append("\nObject´s weight: ");
        for(ObjectKP o : objs) sb.append(o.getoWeight()).append(", ");
        return sb.append("\n").toString();
    }
}
