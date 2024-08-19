package JavaLessons.Lesson1.Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean hungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = true; // Cat is hungry when created
    }

    public boolean isHungry() {
        return hungry;
    }

    public String getName() {
        return name;
    }

    public void eat(Bowl bowl) {
        if (bowl.getFoodAmount() >= appetite) {
            bowl.decreaseFood(appetite);
            hungry = false; // Cat is no longer hungry after eating
            System.out.printf("%s has eaten %d grams of food and is now full.\n", name, appetite);
        } else {
            System.out.printf("%s could not eat because there is not enough food.\n", name);
        }
    }
}
