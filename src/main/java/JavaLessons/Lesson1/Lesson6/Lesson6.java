// Создать классы Собака и Кот с наследованием от класса Животное.
// Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
// Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
// У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
// * Добавить подсчет созданных котов, собак и животных.


package JavaLessons.Lesson1.Lesson6;

public class Lesson6 {
    public static void main(String[] args) {

        Cat cat1 = new Cat("Barsik", 4, 6);
        Dog dog1 = new Dog("Bobik", 2, 300);
        Bird bird1 = new Bird("Swift", 24, 10);

        cat1.run();
        dog1.swim();

        System.out.println("Number of animals: " + Animal.getAnimalCount());
        System.out.println("Number of cats: " + Cat.getCatCount());
        System.out.println("Number of dogs: " + Dog.getDogCount());
        System.out.println("Number of birds: " + Bird.getBirdCount());
    }
}
