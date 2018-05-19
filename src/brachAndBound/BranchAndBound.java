package brachAndBound;

import brachAndBound.bound.Bound;
import brachAndBound.problem.KnapsackProblem;

public class BranchAndBound {
    private Bound bound = null;
    private KnapsackProblem kp = null;
    private boolean[] sol = null;
    private float optimalBenefit = 0;

    public BranchAndBound(Bound bound, KnapsackProblem kp) {
        this.bound = bound;
        this.kp = kp;
        sol = new boolean[kp.getObjectsNumber()];
    }



    public void calculateOptimalSolution(){
        
    }


    @Override
    public String toString() {
        if(optimalBenefit == 0)
            return "";

        StringBuilder sb = new StringBuilder(kp.toString());
        sb.append("Optimal solution (the objects chosen are marked with 1): ");
        for(boolean b : sol) sb.append(b ? "1" : "0").append(", ");
        sb.append("\nBenefit: ").append(optimalBenefit);
        return sb.toString();
    }
}
