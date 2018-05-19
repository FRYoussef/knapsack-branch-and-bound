package brachAndBound.problem;

public class ObjectKP implements Comparable{

    // the object´s weight
    private Float oWeight = null;
    // the object´s value
    private Float oValue = null;

    public ObjectKP(Float oWeight, Float oValue) {
        this.oWeight = oWeight;
        this.oValue = oValue;
    }

    public Float getoWeight() {
        return oWeight;
    }

    public void setoWeight(Float oWeight) {
        this.oWeight = oWeight;
    }

    public Float getoValue() {
        return oValue;
    }

    public void setoValue(Float oValue) {
        this.oValue = oValue;
    }

    @Override
    public int compareTo(Object o) {
        ObjectKP ob = (ObjectKP)o;
        float c1 = (oValue/oWeight);
        float c2 = (ob.getoValue()/ob.getoWeight());
        int res = 0;
        if(c1 > c2) res = 1;
        else if (c2 > c1) res = -1;
        return res;
    }
}
