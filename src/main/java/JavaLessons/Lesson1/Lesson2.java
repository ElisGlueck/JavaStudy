package JavaLessons.Lesson1;

public class Lesson2 {
    public static void main(String[] args) {
      System.out.println(numberBetween(5, 3));
      positiveOrNegative(0);
      System.out.println(positiveOrNegative2(-4));
      printAString("Fine", 2);
      System.out.println(leapYear(1900));
    }

    public static boolean numberBetween(int a, int b){
        return a + b >= 10 && a + b <= 20;

    }
    public static void positiveOrNegative(int value) {
        System.out.println(value < 0 ? "Negative" : "Positive");
    }
    public static boolean positiveOrNegative2(int value) {
        return value < 0;
    }
    public static void printAString (String word, int number) {
        for (int i = 0; i < number; i++) {
            System.out.println(word);
        }
    }
    public static boolean leapYear(int value) {
        return value %4 == 0 && value %100 != 0 || value %400 == 0;
    }

}
