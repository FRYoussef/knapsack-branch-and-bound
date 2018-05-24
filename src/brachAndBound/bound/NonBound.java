package brachAndBound.bound;

import brachAndBound.problem.KnapsackProblem;
import javafx.util.Pair;

public class NonBound implements Bound {

    /**
     * optimistic = + infinite
     * pessimistic = - infinite
     * @param kp
     * @param depth
     * @param weight
     * @param profit
     * @return a tuple: (+infinite, -infinite)
     */
    @Override
    public Pair<Float, Float> estimate(KnapsackProblem kp, int depth, float weight, float profit) {
        return new Pair<>(Float.MAX_VALUE, Float.MIN_VALUE);
    }

}
