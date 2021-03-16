package gbjc3.les01;


// Задание 3. Сортировка (+ Fruit, Apple, Orange, FruitBox).

public class MainSort {
    public static void main(String[] args) {
        final int NUM_APPLE = 15;
        final int NUM_ORANGE = 6;

        final FruitBox<Apple> appleFruitBox = new FruitBox<>(10);
        for (int i = 0; i < NUM_APPLE; i++) {
            appleFruitBox.add(new Apple());
        }
        System.out.println("Вес коробки с яблоками: " + appleFruitBox.getWeight());

        final FruitBox<Orange> orangeFruitBox = new FruitBox<>(15);
        for (int i = 0; i < NUM_ORANGE; i++) {
            orangeFruitBox.add(new Orange());
        }
        System.out.println("Вес коробки с апельсинами: " + orangeFruitBox.getWeight());
        System.out.println("Коробки равны по весу?  " + appleFruitBox.compare(orangeFruitBox) + "\n");

        System.out.println("Создаем новую коробку, добавляем в нее 4 апельсина...");
        final FruitBox<Orange> orangeFruitBox2 = new FruitBox<>(10);
        for (int i = 0; i < 4; i++) {
            orangeFruitBox2.add(new Orange());
        }
        System.out.println("Вес новой коробки с апельсинами: " + orangeFruitBox2.getWeight());
        System.out.println("\nПересыпаем в нее все апельсины из старой коробки...");
        orangeFruitBox.moveFruits(orangeFruitBox2);

        System.out.println("Вес старой коробки с яблоками: " + appleFruitBox.getWeight());
        System.out.println("Вес старой коробки с апельсинами: " + orangeFruitBox.getWeight());
        System.out.println("Вес новой коробки с апельсинами: " + orangeFruitBox2.getWeight());
        System.out.println("Коробки равны по весу?  " + appleFruitBox.compare(orangeFruitBox2));
    }
}
