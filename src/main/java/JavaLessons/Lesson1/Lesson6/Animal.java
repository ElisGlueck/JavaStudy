package JavaLessons.Lesson1.Lesson6;

public abstract class Animal {
    protected String name;
    protected int runDistance;
    protected int swimDistance;
    private static int animalCount;

    public Animal() {
        animalCount++;
    }

    public Animal(String name, int runDistance, int swimDistance) {
        this();
        this.name = name;
        this.runDistance = runDistance;
        this.swimDistance = swimDistance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public int getSwimDistance() {
        return swimDistance;
    }

    public void setSwimDistance(int swimDistance) {
        this.swimDistance = swimDistance;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public abstract void run();

    public abstract void swim();


// Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
// У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
}
