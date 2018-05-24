package brachAndBound.bound;

import brachAndBound.problem.KnapsackProblem;
import javafx.util.Pair;

public class SoftBound implements Bound {

    /**
     * optimistic = fill with the high v[i] object
     * pessimistic = actual profit 
     * @param kp
     * @param depth
     * @param weight
     * @param profit
     * @return a tuple: (optimistic, pessimistic)
     */
    @Override
    public Pair<Float, Float> estimate(KnapsackProblem kp, int depth, float weight, float profit) {
        int j = depth + 1;
        float max = 0f;
        while(j < kp.getObjectsNumber()){
            max = max > kp.getPosValue(j) ? max : kp.getPosValue(j);
            j++;
        }

        float opt = profit + max * (kp.getObjectsNumber() - 1 - (depth+1));

        return new Pair<>(opt, profit);
    }

}
