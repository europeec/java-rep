import java.util.Scanner;

public class First
{
    public static void main(String[] args) {

        int count = 0;
        Scanner S = new Scanner(System.in);
        System.out.print("Введите количество пользователей: ");
        count = S.nextInt();

        while (!(count > 0 )){
            System.out.println("Странное количество пользвателей. Может еще раз попробуешь?");
            System.out.print("Введите количество пользователей: ");
            count = S.nextInt();
        }
        Person[] persons = new Person[count];
        String tempNum;

        // Добавление новых пользователей
        for (int i = 0; i < count; i++){
            System.out.println("Данные для " + (i+1) + " пользователя");

            Scanner T = new Scanner(System.in);
            persons[i] = new Person();

            // Ввод имени
            System.out.print("Имя: ");
            persons[i].name = T.nextLine();

            // Ввод возраста
            System.out.print("Возраст: ");
            persons[i].age = T.nextInt();

            // Ввод модели телефона
            System.out.print("Модель: ");
            T = new Scanner(System.in);
            persons[i].model = T.nextLine();

            T = new Scanner(System.in);

            // Ввод и проверка номера телефона
            System.out.print("Номер телефона: ");
            while (!T.hasNext()){
                //
            }
            tempNum = T.nextLine();
            if (persons[i].checkCorrectNum(tempNum)) {
                persons[i].num = tempNum;
            } else {
                while (!persons[i].checkCorrectNum(tempNum)){
                    System.out.print("Введите правильный номер телефона: ");
                    while (!T.hasNext()){
                        //
                    }
                    tempNum = T.nextLine();
                }
                persons[i].num = tempNum;
            }
            System.out.println(persons[i].name + " добавлен!");
        }

        Scanner T = new Scanner(System.in);
        int var = 1;
        do {
            System.out.println("------------------------------");
            System.out.println("То, что я могу сделать:");
            System.out.println("\t1)Вывести информацию о всех пользователях");
            System.out.println("\t2)Вывести информацию о количестве пользователей");
            System.out.println("\t3)Поменять данные о телефоне для пользователя");
            System.out.print("Введите цифру, которая тебя интересует или 0 - для выхода: ");
            var = T.nextInt();

            switch (var) {
                case 0:
                    System.out.println("Выходим..");
                    return;
                //        Выводим информацию о всех пользователях
                case 1:
                    for (int i = 0; i < count; i++) {

                        System.out.println("\n-------------");
                        persons[i].displayInfo();
                    }
                    break;
                //        Выводим информацию о количестве пользователей
                case 2:
                    System.out.println("Всего пользователей: " + count);
                    break;
                //        Меняем данные о телефоне для пользователей
                case 3:
                    System.out.println("------------------------------");
                    System.out.println("У кого меняем?");
                    for (int i = 0; i < count; i++) {
                        System.out.println("\t" + (i + 1) + ") " + persons[i].name + ", номер телефона: " + persons[i].num);
                    }
                    System.out.println("Введите цифру, либо 0 - для выхода");

                    var = T.nextInt();
                    persons[var - 1].changeAboutPhone();

                    break;
                default:
                    System.out.println("Я еще не научился");
                    break;
            }
        } while (var != 0);
    }
}

// MARK: Person
class Person{
    String name;
    int age;
    String model;
    String num;


    // Конструктор (все данные)
    Person(String name, int age, String model, String num){
        this.name = name;
        this.age = age;
        this.model = model;
        if (checkCorrectNum(num)) {
            this.num = num;
        } else {
            this.num = "NuN";
        }
    }

    // Дефолтные значения
    Person(){
        this("NuN", 0, "NuN", "NuN");
    }

    void changeAboutPhone(){
        System.out.println("\n------------------------------");
        System.out.println("Изменение информации о телефоне ");
        System.out.println("Старый номер телефона: " + this.num);
        System.out.print("\tМеняем? 1 - да, 0 - нет");

        Scanner T = new Scanner(System.in);
        switch (T.nextInt()){
            case 1:
                this.changeNum();
                break;
            default:
                System.out.println("Хорошо, дальше");
                break;
        }

        System.out.println("Старая модель телефона: " + this.model);
        System.out.print("\tМеняем? 1 - да, 0 - нет: ");

        switch (T.nextInt()){
            case 1:
                this.changeModel();
                break;
            default:
                break;
        }
        System.out.println("Редактирование завершено!");
    }

    // Изменить номер телефона
    void changeNum(){
        System.out.println("Изменение номера телефона");
        System.out.print("\tВведите новый номер телефона: ");
        Scanner S = new Scanner(System.in);
        String num = S.nextLine();

        if (!checkCorrectNum(num)) {
            while (!checkCorrectNum(num)) {
                System.out.println("\tОшибка! Проверьте правильность введеных данных");
                System.out.print("\tВведите номер телефона еще раз: ");
                num = S.nextLine();
            }
        }
        this.num = num;
    }

    // Меняем модель телефона
    void changeModel(){
        System.out.println("Изменение модели телефона");
        System.out.print("\tВведите новую модель телефона: ");
        Scanner S = new Scanner(System.in);
        String model = S.nextLine();
        this.model = model;
    }

    // Вывести данные
    void displayInfo(){
        System.out.println("Name: " + this.name + ", " + this.age + " y.o");
        System.out.println("Model: " + this.model + ", " + this.num);
    }

    // Проверка правильности номера
    boolean checkCorrectNum(String num){
        if (num.length() != 12) {
            return false;
        } else if (num.indexOf("+7") == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Сравнение возраста
    boolean isEqualAge(Person person){
        if (this.age == person.age) {
            System.out.println(this.name + " и " + person.name + " одного возраста!");
            return true;
        } else if (this.age > person.age){
            System.out.println(this.name + " старше, чем " + person.name);
            return false;
        } else {
            System.out.println(person.name + " старше, чем " + this.name);
            return false;
        }
    }
}
