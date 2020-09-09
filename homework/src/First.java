import java.util.Scanner;

public class First
{
    public static void main(String[] args) {

        int count = 0;
        Scanner S = new Scanner(System.in);
        System.out.print("Введите количество пользователей: ");
        count = S.nextInt();

        Person[] persons = new Person[count];
        String tempName, tempNum, tempModel;
        int tempAge;

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

        for (int i = 0; i < count; i++){

            System.out.println("-------------");
            persons[i].displayInfo();
        }
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
            this.num = "nill";
        }
    }

    // Дефолтные значения
    Person(){
        this("", 19, "iOS Device", "NuN");
    }
    // Конструктор без модели телефона
    Person(String name, int age, String num){
        this(name,age,"nill", num);
    }

    // Изменить номер телефона
    void changeNum(String num){
        if (checkCorrectNum(num)){
            this.num = num;
            System.out.println(this.name + " изменил номер телефона");
        } else {
            this.num = "nill";
            System.out.println(this.name + " ввел некорректный номер телефона");
        }
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
