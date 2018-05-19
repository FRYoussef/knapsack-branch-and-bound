package brachAndBound.bound;

import brachAndBound.problem.KnapsackProblem;
import javafx.util.Pair;

public class HardBound implements Bound {

    /**
     * optimistic = greedy with partitioned objects
     * pessimistic = greedy with whole objects
     * @param kp
     * @param depth
     * @param weight
     * @param profit
     * @return (optimistic, pessimistic)
     */
    @Override
    public Pair<Float, Float> estimate(KnapsackProblem kp, int depth, float weight, float profit) {
        float gap = kp.K_WEIGHT - weight;
        Float pes = profit;
        Float opt = profit;
        int j = depth + 1;
        while(j < kp.getObjectsNumber() && kp.getPosWeight(j) <= gap)
        { // we can select the whole object
            gap = gap - kp.getPosWeight(j);
            opt = opt + kp.getPosValue(j);
            pes = pes + kp.getPosValue(j);
            j++;
        }
        if(j < kp.getObjectsNumber()){
            // greedy solution with partitioned object
            opt = opt + (gap/kp.getPosWeight(j)) * kp.getPosValue(j);
            j++;
            // now greedy solution with whole objects
            while(j < kp.getObjectsNumber() && gap > 0f)
            {
                if(kp.getPosWeight(j) <= gap){
                    gap = gap - kp.getPosWeight(j);
                    pes = pes + kp.getPosValue(j);
                }
                j++;
            }
        }
        return new Pair<>(opt, pes);
    }

}
