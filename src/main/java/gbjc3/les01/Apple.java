package gbjc3.les01;

public class Apple extends Fruit implements SpecificFruit {
    public Apple() {
        //this.weight = 1.0f;   // теперь задается в контрукторе родителя
        super(1.0f);
    }

    public double getWeight() {
        return weight;
    }
}
