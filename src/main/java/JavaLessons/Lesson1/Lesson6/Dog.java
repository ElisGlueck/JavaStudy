package JavaLessons.Lesson1.Lesson6;

public class Dog extends Animal {

    public static int dogCount;
    private static final int dogRunMaxDistanceInMeters = 400;
    private static final int dogSwimMaxDistanceInMeters = 100;

    public Dog(String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run() {
        if (runDistance <= dogRunMaxDistanceInMeters) {
            System.out.printf("%s run %d m\n", name, runDistance);
        }
        else System.out.printf("%s says it's too far for it. Try something in %d meters range.\n", name, runDistance);
    }

    @Override
    public void swim() {
        if (swimDistance <= dogSwimMaxDistanceInMeters) {
            System.out.printf("%s swims %d m\n", name, swimDistance);
        }
        else System.out.printf("%s says it's too far for it. Try something in %d meters range.\n", name, swimDistance);
    }
}
