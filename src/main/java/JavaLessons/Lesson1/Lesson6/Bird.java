package JavaLessons.Lesson1.Lesson6;

public class Bird extends Animal {

    protected static int birdCount;

    public Bird(String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
        birdCount++;
    }

    public static int getBirdCount() {
        return birdCount;
    }

    @Override
    public void run() {
        if (runDistance < 1) {
            System.out.printf("%s run %d m\n", name, runDistance);
        }
    }

    @Override
    public void swim() {
        System.out.printf("%s couldn't swim\n", name);
    }
}
