package JavaLessons.Lesson1.Lesson7;

public class Bowl {
    private int foodAmount;

    public void putFood(int amount) {
        this.foodAmount += amount;
        System.out.printf("The food amount has been increased by %d grams. There are now %d grams of food in the bowl.", amount, foodAmount);
    }

    public void decreaseFood(int amount) {
        if (this.foodAmount >= amount) {
            this.foodAmount -= amount;
            System.out.printf("The food amount has been decreased by %d grams. There are now %d grams of food in the bowl.\n", amount, foodAmount);
        } else {
            System.out.printf("Not enough food for this action. Only %d grams of food is available in the bowl.\n", foodAmount);
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
        if (foodAmount == 0) {
            System.out.printf("You took an empty bowl\n");
        }
        else System.out.printf("You took a bowl with %d grams of food.\n", foodAmount);
    }
}

