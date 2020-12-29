package gbjc3.les01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTransformedArray {
    final static String[] array = {"a", "b", "c", "d", "e"};
    final static int ELEMENT1 = 0;
    final static int ELEMENT2 = 4;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(array) + " - исходный массив.");
        try {
            elementsReplace(array, ELEMENT1, ELEMENT2);
            transformToArrayLsit(array);
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
        System.out.println(Arrays.toString(array) + " - измененный массив (задание 1).");
    }

    // Задание 2
    // Написать метод, который преобразует массив в ArrayList.
    private static <T> void transformToArrayLsit(T[] array){
        List transformedArray = new ArrayList();
        System.out.println("Задание 2: ");
        for (T element : array) {
            transformedArray.add(element);
            System.out.println(element);
        }
        System.out.println("-- the end --");
    }
}
