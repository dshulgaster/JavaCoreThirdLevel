package gbjc3.les01;


// Задание 3. Сортировка (+ Fruit, Apple, Orange, FruitBox).

public class MainSort {
    public static void main(String[] args) {
        final int NUM_APPLE = 12;
        final int NUM_ORANGE = 5;

        final FruitBox<Apple> appleFruitBox = new FruitBox<>();
        for (int i = 0; i < NUM_APPLE; i++) {
            appleFruitBox.add(new Apple());
        }
        final double appleBoxWeight = appleFruitBox.getWeight();
        System.out.println("Вес коробки с яблоками: " + appleBoxWeight);

        final FruitBox<Orange> orangeFruitBox = new FruitBox<>();
        for (int i = 0; i < NUM_ORANGE; i++) {
            orangeFruitBox.add(new Orange());
        }
        final double orangeBoxWeight = orangeFruitBox.getWeight();
        System.out.println("Вес коробки с апельсинами: " + orangeBoxWeight);

        System.out.println("Коробки равны по весу?  " + appleFruitBox.compare(orangeFruitBox) + "\n");

        System.out.println("Создаем новую коробку, добавляем в нее 3 апельсина и " +
                "пересыпаем в нее 3 апельсина из старой коробки");
        final FruitBox<Orange> orangeFruitBox2 = new FruitBox<>();
        for (int i = 0; i < 3; i++) {
            orangeFruitBox2.add(new Orange());
        }
        orangeFruitBox.moveFruits(orangeFruitBox2);
        final double orangeBoxWeightTwo = orangeFruitBox2.getWeight();

        System.out.println("Вес коробки с яблоками: " + appleBoxWeight);
        System.out.println("Вес коробки с апельсинами: " + orangeBoxWeightTwo);
        System.out.println("Коробки равны по весу?  " + appleFruitBox.compare(orangeFruitBox2));
    }
}
