package brachAndBound;

public class Node implements Comparable{

    private boolean []solution = null;
    private int depth;
    private float weight;
    private float profit;
    private float opProfit;

    public Node(int n) {
        solution = new boolean[n];

        depth = -1;
    }

    public Node(int depth, boolean[] solution) {
        this.solution = solution.clone();
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

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public float getOpProfit() {
        return opProfit;
    }

    public void setOpProfit(float opProfit) {
        this.opProfit = opProfit;
    }

    public void setSolDepth(boolean b){
        solution[depth] = b;
    }

    @Override
    public int compareTo(Object o) {
        Node n = (Node)o;
        int res = 0;
        if(opProfit > n.getOpProfit()) res = 1;
        else if(n.getOpProfit() > opProfit) res = -1;
        return res;
    }
}
