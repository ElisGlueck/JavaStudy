package JavaLessons.Lesson1.Lesson5;

import java.time.LocalDate;

public class Lesson5 {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivan Ivanov", "Engineer", "iivanov@gmail.com", "892312312", 30000, LocalDate.of(1990, 5, 15));
        empArray[1] = new Employee("Petr Petrov", "Developer", "ppetrov@mailbox.com", "892312313", 35000, LocalDate.of(1989, 6, 20));
        empArray[2] = new Employee("Lidia Lidina", "Designer", "llidina@gmail.com", "892312314", 25000, LocalDate.of(1999, 7, 25));
        empArray[3] = new Employee("Svetlana Svetova", "QA-Engineer", "ssvetova@company.com", "892312315", 28000, LocalDate.of(1980, 8, 30));
        empArray[4] = new Employee("Anna Anina", "Manager", "aanina@company.com", "892312316", 33000, LocalDate.of(1983, 9, 5));


        for (int i = 0; i < empArray.length; i++) {

           if (empArray[i].getAge() >= 40) {
               System.out.println(empArray[i]);
           }
        }
    }

}
