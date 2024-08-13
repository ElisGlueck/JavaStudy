package JavaLessons.Lesson1.Lesson7;

public class Cat {
    private String name;
    private int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public boolean hunger() {

    }

    public void eat(Bowl bowl) {
        bowl.decreaseFood(appetite);
        System.out.printf("%s has eaten %d grams of food.\n", name, appetite);

    }
}
