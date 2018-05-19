package brachAndBound;

public class Node {

    private boolean []solution = null;
    private int depth;
    private float weight;
    private float benefit;
    private float opBenefit;

    public Node(int n) {
        solution = new boolean[n];
    }

    public Node(boolean[] solution, int depth) {
        solution = solution.clone();
        this.depth = depth + 1;
    }

    public boolean[] getSolution() {
        return solution;
    }

    public void setSolution(boolean[] solution) {
        this.solution = solution;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBenefit() {
        return benefit;
    }

    public void setBenefit(float benefit) {
        this.benefit = benefit;
    }

    public float getOpBenefit() {
        return opBenefit;
    }

    public void setOpBenefit(float opBenefit) {
        this.opBenefit = opBenefit;
    }
}
