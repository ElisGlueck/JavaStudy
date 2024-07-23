package JavaLessons.Lesson1;

public class Lesson3 {
    public static void main(String[] args) {
        square();
        zeroToOneAndViceVersa();
        array100();
        multiplyUnderSix();
        multiplyUnderSixV2();
        crossArray();
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

// Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
// Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
// Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

}
