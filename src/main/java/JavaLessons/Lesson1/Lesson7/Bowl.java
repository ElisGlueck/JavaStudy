package JavaLessons.Lesson1.Lesson7;

public class Bowl {
    private int foodAmount;

    public void putFood(int amount) {
        this.foodAmount += amount;
        System.out.printf("The food amount has been increased by %d grams. There are now %d grams of food in the bowl.", amount, foodAmount);
    }

    public void decreaseFood(int amount) {
        this.foodAmount -= amount;
        System.out.printf("The food amount has been decreased by %d grams. There are now %d grams of food in the bowl.", amount, foodAmount);
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}

