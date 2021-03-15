package gbjc3.les01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTransformedArray {
    final static String[] arrStr = {"a", "b", "c", "d", "e"};
    final static Integer[] arrInt = {4, 5, 6, 7, 8, 16};
    final static int ELEMENT1 = 0;
    final static int ELEMENT2 = 4;

    public static void main(String[] args) {
        System.out.println("Задание 1. Меняем элементы массивов с индексом " + ELEMENT1 + " и " + ELEMENT2);
        try {
            System.out.println(Arrays.toString(arrStr) + " - исходный массив 1.");
            elementsReplace(arrStr, ELEMENT1, ELEMENT2);
            System.out.println(Arrays.toString(arrInt) + " - исходный массив 2.");
            elementsReplace(arrInt, ELEMENT1, ELEMENT2);
            transformToArrayLsit(arrStr);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Введенные значения выходят за пределы массива");
        }
    }

    // Задание 1
    // Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа).

    private static <T> void elementsReplace(T[] array, int elementFirst, int elementSecond) {
        T temporary = array[elementSecond];
        array[elementSecond] = array[elementFirst];
        array[elementFirst] = temporary;
        System.out.println(Arrays.toString(array) + " - измененный массив.");
    }

    // Задание 2
    // Написать метод, который преобразует массив в ArrayList.
    private static <T> void transformToArrayLsit(T[] arr){
        List transformedArr = new ArrayList();
        System.out.println("\nЗадание 2: преобразуем массив в ArrayList.");
        for (T element : arr) {
            transformedArr.add(element);
        }
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        System.out.println("Преобразованный ArrayList: " + transformedArr.toString());
    }
}
