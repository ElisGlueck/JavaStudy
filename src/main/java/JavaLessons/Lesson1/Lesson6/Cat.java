package JavaLessons.Lesson1.Lesson6;

public class Cat extends Animal {

    protected static int catCount;
    private static final int catRunMaxDistanceInMeters = 200;
    private static final int catSwimMaxDistanceInMeters = 25;

    public Cat(String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
        catCount++;
    }

    public static int getCatCount() {
        return catCount;
    }

    @Override
    public void run() {
        if (runDistance <= catRunMaxDistanceInMeters) {
            System.out.printf("%s run %d m\n", name, runDistance);
        }
        else System.out.printf("%s says it's too far for it. Try something in %d meters range.\n", name, runDistance);
    }

    @Override
    public void swim() {
        if (swimDistance <= catSwimMaxDistanceInMeters) {
            System.out.printf("%s swims %d m\n", name, swimDistance);
        }
        else System.out.printf("%s says it's too far for it. Try something in %d meters range.\n", name, swimDistance);
    }
}
