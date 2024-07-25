package JavaLessons.Lesson1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static void main(String[] args) {
        square();
        zeroToOneAndViceVersa();
        array100();
        multiplyUnderSix();
        multiplyUnderSixV2();
        crossArray();
        lenArray(6, 15);
        minMaxArray(10);
        minMaxArrayV2(4);
        System.out.println(sumTwoPartArray(3, 4, 5, 7, 2, 2, 1));
        System.out.println(sumTwoPartArrayV2(3, 4, 5, 7, 2, 2, 1));
        shiftArray(5, 5, 7, 6, 6);
        shiftArrayV2(3, 5, 7, 6, 2);
        shiftArrayV3(5, 10, 34, 5, 12, 6, 3, 5);
    }

    public static void square() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if ((i == 2 || i == 3) && (j == 2 || j == 3)) {
                    System.out.print("  ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    // Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void zeroToOneAndViceVersa() {
        System.out.print("int[] arr = {");
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (arr[i] == 0) ? 1 : 0;
            System.out.print(arr[i]);
            if (i < arr.length -1) {
                System.out.print(", ");
            }
        }
        System.out.print("}\n");
    }

// Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
    public static void array100() {
        System.out.print("int[] arr = {");
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
           arr[i] = i + 1;
           System.out.print(arr[i]);
            if (i < arr.length -1) {
                System.out.print(", ");
            }
        }
        System.out.print("}\n");
    }
// Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
public static void multiplyUnderSix() {
    System.out.print("int[] arr = {");
    int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
    for (int i = 0; i < arr.length; i++) {
        arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
        System.out.print(arr[i]);
        if (i < arr.length -1) {
            System.out.print(", ");
        }
    }
    System.out.print("}\n");
}
public static void multiplyUnderSixV2() {
        System.out.print("int[] arr = {");
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
            System.out.print(arr[i]);
            if (i < arr.length -1) {
                System.out.print(", ");
            }
        }
        System.out.print("}\n");
    }
// Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
public static void crossArray() {
    int[][] arr = new int[5][5];
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr.length; j++) {
          if ((i == j) || (i == arr.length - 1 - j)) {
              arr[i][j] = 1;
          }
          System.out.print(arr[i][j] + " ");
      }
        System.out.println();
    }
}
// Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
public static void lenArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
          arr[i] = initialValue;
            System.out.print(arr[i] + " ");
        }
    System.out.println();
}
// Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
    public static int[] minMaxArray(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    public static int[] minMaxArrayV2(int length) {
        int[] arr = new int[length];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                }
            else if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Max is " + max + ". Min is " + min);
        return arr;
    }
// Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
    public static boolean sumTwoPartArray(int ... arr) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];
            leftSum += arr[i];
            if (leftSum == totalSum) {
                return true;
            }
        }
        return false;
    }

    public static boolean sumTwoPartArrayV2(int... arr) {
        for (int i = 0; i < arr.length; i++){
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++) {
               leftSum += arr[j];
            }
            for (int j = i; j < arr.length; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                return true;
            }
            }
        return false;
        }
// Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.
    public static void shiftArray(int n, int... arr) {
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            int last = arr[arr.length - 1];
            for (int j = arr.length - 1; j > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[0] = last;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void shiftArrayV2(int n, int... arr) {
        System.out.println(Arrays.toString(arr));
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            temp[(i + n) % arr.length] = arr[i];
        }
        System.arraycopy(temp, 0, arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
    public static void shiftArrayV3(int n, int... arr) {
        System.out.println(Arrays.toString(arr));
        int length = arr.length;
        n = n % length;
        if (n < 0) {
            n += length;
        }
        reverse(arr, 0, length - 1);
        reverse(arr, 0, n - 1);
        reverse(arr, n, length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
