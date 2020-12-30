package gbjc3.les01;


// Задание 3. Сортировка (+ Fruit, Apple, Orange, FruitBox).

public class MainSort {
    public static void main(String[] args) {
        final FruitBox<Apple> appleFruitBox = new FruitBox<>();
        appleFruitBox.add(new Apple());
        appleFruitBox.add(new Apple());
        appleFruitBox.add(new Apple());
        appleFruitBox.add(new Apple());
        final double appleBoxWeight = appleFruitBox.getWeight();
        System.out.println("Вес коробки с яблоками: " + appleBoxWeight);

        final FruitBox<Orange> orangeFruitBox = new FruitBox<>();
        orangeFruitBox.add(new Orange());
        orangeFruitBox.add(new Orange());
        orangeFruitBox.add(new Orange());
        orangeFruitBox.add(new Orange());
        final double orangeBoxWeight = orangeFruitBox.getWeight();
        System.out.println("Вес коробки с апельсинами: " + orangeBoxWeight);

        System.out.println("Коробки равны по весу?  " + appleFruitBox.compare(orangeFruitBox) + "\n");

        System.out.println("Создаем новую коробку, добавляем в нее 3 апельсина и " +
                "пересыпаем в нее 3 апельсина из старой коробки");
        final FruitBox<Apple> appleFruitBox2 = new FruitBox<>();
        appleFruitBox2.add(new Apple());
        appleFruitBox2.add(new Apple());
        appleFruitBox2.add(new Apple());
        appleFruitBox.moveFruits(appleFruitBox2);
        final double appleBoxWeightTwo = appleFruitBox2.getWeight();

        System.out.println("Вес коробки с яблоками: " + appleBoxWeightTwo);
        System.out.println("Вес коробки с апельсинами: " + orangeBoxWeight);
        System.out.println("Коробки равны по весу?  " + appleFruitBox2.compare(orangeFruitBox));
    }
}
