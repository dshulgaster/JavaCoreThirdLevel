package gbjc3.les01;


// Задание 3. Сортировка (+ Fruit, Apple, Orange, Box).

public class MainSort {
    public static void main(String[] args) {
        final Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        final double appleBoxWeight = appleBox.getWeight();
        System.out.println("Вес коробки с яблоками: " + appleBoxWeight);

        final Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        final double orangeBoxWeight = orangeBox.getWeight();
        System.out.println("Вес коробки с апельсинами: " + orangeBoxWeight);

        System.out.println("Коробки равны по весу?  " + appleBox.compare(orangeBox) + "\n");

        System.out.println("Создаем новую коробку, добавляем в нее 3 апельсина и " +
                "пересыпаем в нее 3 апельсина из старой коробки");
        final Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        appleBox.moveFruits(appleBox2);
        final double appleBoxWeightTwo = appleBox2.getWeight();

        System.out.println("Вес коробки с яблоками: " + appleBoxWeightTwo);
        System.out.println("Вес коробки с апельсинами: " + orangeBoxWeight);
        System.out.println("Коробки равны по весу?  " + appleBox2.compare(orangeBox));
    }
}
