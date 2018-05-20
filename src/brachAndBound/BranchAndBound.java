package brachAndBound;

import brachAndBound.bound.Bound;
import brachAndBound.problem.KnapsackProblem;
import javafx.util.Pair;

import java.util.Collections;
import java.util.PriorityQueue;

public class BranchAndBound {
    private Bound bound = null;
    private KnapsackProblem kp = null;
    private boolean[] bestSol = null;
    private float bestProfit = 0f;
    private double time = 0d;
    private int visitedNodes = 0;

    public BranchAndBound(Bound bound, KnapsackProblem kp) {
        this.bound = bound;
        this.kp = kp;
        bestSol = new boolean[kp.getObjectsNumber()];
    }

    public void calculateOptimalSolution(){
        time = System.currentTimeMillis();
        boolean firstSol = true;
        Node x, y = new Node(kp.getObjectsNumber());
        PriorityQueue<Node> pq = new PriorityQueue<Node>(Collections.reverseOrder());
        Pair<Float, Float > tuple = null;
        tuple = bound.estimate(kp, y.getDepth(), y.getWeight(), y.getProfit());
        y.setOpProfit(tuple.getKey());
        bestProfit = tuple.getValue();

        pq.clear();
        pq.add(y);
        while(!pq.isEmpty() && pq.peek().getOpProfit() >= bestProfit){
            y = pq.poll();
            x = new Node(y.getDepth(), y.getSolution());
            //we will try to select this object
            if(y.getWeight() + kp.getPosWeight(x.getDepth()) <= kp.K_WEIGHT)
            {
                visitedNodes++;
                x.setSolDepth(true);
                x.setWeight(y.getWeight() + kp.getPosWeight(x.getDepth()));
                x.setProfit(y.getProfit() + kp.getPosValue(x.getDepth()));
                x.setOpProfit(y.getOpProfit());
                if(x.getDepth() == kp.getObjectsNumber()-1)
                {
                    if(x.getProfit() >= bestProfit || firstSol){
                        bestSol = x.getSolution().clone();
                        bestProfit = x.getProfit();
                        firstSol = false;
                    }
                }
                else
                    pq.add(x);
            }

            //we will try to no select the object
            tuple = bound.estimate(kp, y.getDepth(), y.getWeight(), y.getProfit());
            if(tuple.getKey() >= bestProfit){
                visitedNodes++;
                x = new Node(y.getDepth(), y.getSolution());
                x.setOpProfit(tuple.getKey());
                x.setSolDepth(false);
                x.setWeight(y.getWeight());
                x.setProfit(y.getProfit());
                if(x.getDepth() == kp.getObjectsNumber()-1 )
                {
                    if(x.getProfit() >= bestProfit || firstSol){
                        bestSol = x.getSolution().clone();
                        bestProfit = x.getProfit();
                        firstSol = false;
                    }
                }
                else
                {
                    pq.add(x);
                    if(bestProfit < tuple.getValue())
                        bestProfit = tuple.getValue();
                }
            }

        }
        time = System.currentTimeMillis() - time;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(kp.toString());
        sb.append("Optimal solution (the objects chosen are marked with 1): ");
        for(boolean b : bestSol) sb.append(b ? "1" : "0").append(", ");
        sb.append("\nProfit: ").append(bestProfit);
        sb.append("\nTime: ").append(time).append("ms");
        sb.append("\nNodes explored: ").append(visitedNodes);
        sb.append("\nMean time per node: ").append(time/visitedNodes).append("ms");
        return sb.toString();
    }
}
