package JavaLessons.Lesson1.Lesson7;

//Расширить задачу про котов и тарелки с едой, выполнив следующие пункты:
//Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды (например, в миске 10 еды,
// а кот пытается покушать 15-20).
//Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
// Если коту удалось покушать (хватило еды), сытость = true.
//Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт
// (это сделано для упрощения логики программы).
//Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести
// информацию о сытости котов в консоль.
//Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.

public class Lesson7 {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 20),
                new Cat("Murzik", 15),
                new Cat("Murka", 50),
                new Cat("Dymka", 15),
                new Cat("Nura", 30)
        };

        Bowl bowl = new Bowl(0);
        bowl.putFood(55);

        for (Cat cat : cats) {
            cat.eat(bowl);
        }

        boolean anyHungry = false;
        for (Cat cat : cats) {
            if (cat.isHungry()) {
                System.out.printf("%s is still hungry.\n", cat.getName());
                anyHungry = true;
            }
        }

        if (!anyHungry) {
            System.out.println("All cats are well-fed!");
        }

    }


}
