package JavaLessons.Lesson1.Lesson6;

public class Cat extends Animal {

    protected static int catCount;

    public Cat(String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run() {
        if (runDistance < 200) {
            System.out.printf("%s run %d m\n", name, runDistance);
        }
    }

    @Override
    public void swim() {
        if (swimDistance < 25) {
            System.out.printf("%s swims %d m\n", name, swimDistance);
        }
    }
}
