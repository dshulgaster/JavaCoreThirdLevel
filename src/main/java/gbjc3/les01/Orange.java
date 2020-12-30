package gbjc3.les01;

public class Orange extends Fruit {
    public Orange() {
        //this.weight = 1.5f;   // теперь задается в контрукторе родителя
        super(1.5f);
    }

    public double getWeight() {
        return weight;
    }
}