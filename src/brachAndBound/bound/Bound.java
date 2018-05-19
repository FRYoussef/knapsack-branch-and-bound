package brachAndBound.bound;

import brachAndBound.problem.KnapsackProblem;
import javafx.util.Pair;

public interface Bound {

    Pair<Float, Float> estimate(KnapsackProblem kp, int depth, float weight, float profit);

}
