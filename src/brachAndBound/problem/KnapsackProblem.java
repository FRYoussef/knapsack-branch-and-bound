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
    // the object´s weight
    private Float oWeight[] = null;
    // the object´s value
    private Float oValue[] = null;

    /**
     * The params oWeight and oValue must be ordered
     * @param k_WEIGHT
     * @param oWeight oWeight[0] >= oWeight[1] >= ... >= oWeight[n]
     * @param oValue oValue[0] >= oValue[1] >= ... >= oValue[n]
     */
    public KnapsackProblem(float k_WEIGHT, Float[] oWeight, Float[] oValue) throws Exception {
        if(oWeight.length != oValue.length)
            throw new Exception("The object´s weight and value arrays must be the same length");

        K_WEIGHT = k_WEIGHT;
        this.oWeight = oWeight;
        this.oValue = oValue;
    }

    public Float[] getoWeight() {
        return oWeight;
    }

    public void setoWeight(Float[] oWeight) {
        this.oWeight = oWeight;
    }

    public Float[] getoValue() {
        return oValue;
    }

    public void setoValue(Float[] oValue) {
        this.oValue = oValue;
    }

    public int getObjectsNumber(){
        return oValue.length;
    }

    public float getK_WEIGHT() {
        return K_WEIGHT;
    }

    public static KnapsackProblem getRandomKnapsackProblem(int n){
        Random r = new Random(System.currentTimeMillis());
        float kWeight = r.nextFloat() + r.nextInt(MAX_WEIGHT_KNAPSACK);
        ArrayList<Float> alWeight = new ArrayList<Float>(n);
        ArrayList<Float> alValue = new ArrayList<Float>(n);

        for(int i = 0; i < n; i++){
            alWeight.add(r.nextFloat() + r.nextInt(MAX_WEIGHT));
            alValue.add(r.nextFloat() + r.nextInt(MAX_VALUE));
        }

        alWeight.sort(Float::compareTo);
        Collections.reverse(alWeight);
        alValue.sort(Float::compareTo);
        Collections.reverse(alValue);

        KnapsackProblem kP = null;

        try {
            kP = new KnapsackProblem(kWeight, alWeight.toArray(new Float[n]), alValue.toArray(new Float[n]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kP;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Knapsack´s weight: " + K_WEIGHT + "\n");
        sb.append("Object´s weight: ");
        for(Float f : oWeight) sb.append(f).append(", ");
        sb.append("\nObject´s value: ");
        for(Float f : oValue) sb.append(f).append(", ");
        return sb.append("\n").toString();
    }
}
