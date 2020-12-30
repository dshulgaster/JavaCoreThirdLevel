package gbjc3.les01;

import java.util.ArrayList;
import java.util.List;

// Класс Box, в который можно складывать фрукты.
// Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;

public class Box <T extends Fruit> {
    private List <T> fruitBox = new ArrayList<>();

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

    public boolean compare(Box box2) {
        //return getWeight() == box2.getWeight();
        //Нельзя сравнить типы float и double через знак == из-за ошибки округления.
        // Для сравнения нужно проверить, что разность чисел меньше 0.001. В остальном отлично
        return (getWeight() - box2.getWeight() < 0.001);
    }

    public void moveFruits(Box<T> toBox){
        toBox.fruitBox.addAll(this.fruitBox);
        this.fruitBox.clear();
    }
}