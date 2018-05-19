package brachAndBound.bound;

import brachAndBound.problem.KnapsackProblem;

public interface Bound {

    void estimate(KnapsackProblem kP, int depth, float weight, float benefit, Float pes, Float opt);

}
