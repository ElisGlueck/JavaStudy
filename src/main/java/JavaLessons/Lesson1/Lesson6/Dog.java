package JavaLessons.Lesson1.Lesson6;

public class Dog extends Animal {

    public static int dogCount;

    public Dog(String name, int runDistance, int swimDistance) {
        super(name, runDistance, swimDistance);
        dogCount++;
    }

    public static int getDogCount() {
        return dogCount;
    }

    @Override
    public void run() {
        if (runDistance < 400) {
            System.out.printf("%s run %d m\n", name, runDistance);
        }
    }

    @Override
    public void swim() {
        if (swimDistance < 100) {
            System.out.printf("%s swims %d m\n", name, swimDistance);
        }
    }
}
