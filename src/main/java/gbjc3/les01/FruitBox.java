package gbjc3.les01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// Класс FruitBox, в который можно складывать фрукты.
// Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

// Поменял класс Box на FruitBox, т.к. речь о фруктовых коробках. Возможно, нужно бы добавить родителя Box?
public class FruitBox<T extends Fruit & SpecificFruit> {
    private int capacity;   // если предусмотреть еще размерность/вместимость коробки
    private List <T> fruitBox = new ArrayList<>();

    public FruitBox() {
    }

    public FruitBox(int capacity) {
        this.capacity = capacity;
    }

    public FruitBox(int capacity, List<T> fruitBox) {
        this.capacity = capacity;
        this.fruitBox = fruitBox;
    }

    void add (T fruit){
        fruitBox.add(fruit);
    }

    public double getWeight() {
        double totalWeight = 0;
        for (T fruit : fruitBox) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(FruitBox fruitBox2) {
        //return getWeight() == fruitBox2.getWeight();
        //Нельзя сравнить типы float и double через знак == из-за ошибки округления.
        return (Math.abs(this.getWeight() - fruitBox2.getWeight()) < 0.001);
    }

    public void moveFruits(FruitBox<T> toFruitBox){
        if (toFruitBox == this) return;

        toFruitBox.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
//        this.fruitBox.removeAll(this.fruitBox);

        // Хорошо бы добавить проверку, что новая коробка большей вместимости,
        // чем из перемещаемой коробки.
    }
}