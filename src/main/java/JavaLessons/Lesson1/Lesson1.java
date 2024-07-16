package JavaLessons.Lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        System.out.println(checkSumSignV2(-15, 6));
        printColor();
        printColorV2(120);
        compareNumbers();
    }


    public static void printThreeWords() {
        System.out.println("Orange\nBanana\nApple\n");

    }
    public static void checkSumSign() {
        int a = 15;
        int b = 17;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else System.out.println("Сумма отрицательная");
    }
    private static boolean checkSumSignV2(int first, int second) {
        return first + second >= 0;
    }

    public static void printColor() {
        int value = 333;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void printColorV2(int value) {
        int q = value == 10 ? 100500 : 0;
        System.out.println(value <= 0 ? "Red" : value <= 100 ? "Yellow" : "Green");
    }
    public static void compareNumbers() {
        int a = 46;
        int b = 994;
        if (a >= b) {
            System.out.println("a >= b");
        } else System.out.println("a < b");
    }
}
