import java.util.Scanner;
import java.util.Random;

public class Fourth {
    public static void main(String[] args) {
        System.out.print("Привет, сколько автомобилей будем добавлять? - ");
        Scanner S = new Scanner(System.in);
        int count = -1;
        do {
            if (S.hasNextInt()){
                count = S.nextInt();
            }  else {
                System.out.println("Введите число, а не буковки");
            }
        } while (count == -1);

        Car[] cars = new Car[count];

        System.out.println("0 - Ввести все данные ручками\n1 - Установить случайные значения");
        System.out.println("Другое - выход");

        int ch = -1;

        if (S.hasNextInt()){
            ch = S.nextInt();
            if ((ch != 0) && (ch != 1)){
                System.out.println("Выходим, до связи...");
                return;
            } else {
                switch (ch){
                    case 0:
                        for (int i = 0; i <= count - 1; i++){
                            cars[i] = new Car();
                            cars[i].inputData(i);
                        }
                        break;
                    case 1:
                        for (int i = 0; i <= count - 1; i++){
                            cars[i] = new Car();
                        }
                        break;
                }
                System.out.println("Все данные введены!");
            }
        } else {
            System.out.println("Выходим, до связи...");
            return;
        }

        // Меню
        ch = 0;
        while (ch >= 0) {
            boolean skip = false;
            switch (ch){
                case 0:
                    // Начальное Меню
                    System.out.println("1 - Вывести все данные\n2 - Редактировать данные\nОтрицательное число для выхода");
                    break;
                case 1:
                    // Вывести все данные
                    for(int i = 0; i <= count - 1; i++){
                        cars[i].showData();
                        System.out.println("-------------");
                    }
                    ch = 0;
                    skip = true;
                    break;
                case 2:
                    // Редактировать данные
                    for(int i = 0; i <= count - 1; i++) {
                        int num = i + 1;
                        System.out.println("ID - " + (num));
                        cars[i].showData();
                        System.out.println("-------------");
                    }
                    System.out.println("Какую машину редактируем (id)?");
                    int carID = -1;
                    do {
                        if (S.hasNextInt()){
                            int t_id = S.nextInt();
                            if (t_id > 0) {
                                carID = t_id - 1;
                            }
                        }
                    } while(carID == -1);
                    System.out.println("0 - модель\n1 - мощность\n2 - стоимость\n3 - владельца");
                    int tch = -1;
                    if (S.hasNextInt()){
                        tch = S.nextInt();
                    } else {
                        return;
                    }
                    switch (tch){
                        case 0:
                            cars[carID].changeModel();
                            ch = 0;
                            skip = true;
                            break;
                        case 1:
                            cars[carID].changeHP();
                            ch = 0;
                            skip = true;
                            break;
                        case 2:
                            cars[carID].changeCost();
                            ch = 0;
                            skip = true;
                            break;
                        case 3:
                            cars[carID].changeOwner();
                            ch = 0;
                            skip = true;
                            break;
                        default:
                            System.out.println("Выходим в главное меню!");
                            ch = 0;
                            break;
                    }
                    break;
                default:
                    break;
            }
            if (!skip) {
                if (S.hasNextInt()) {
                    int t_int = S.nextInt();

                    if (t_int >= 0) {
                        ch = t_int;
                    } else {
                        ch = -1;
                    }

                } else {
                    ch = -1;
                }
            }
        }
    }
}


class Car {
    String model;
    int hp;
    int cost;
    String owner;
    // Стандартные значения
    {
        cost = 0;
        owner = "";
    }
    // Конструкторы -----
    Car(String model, int hp, int cost, String owner){
        this.model = model;
        this.hp = hp;
        this.cost = cost;
        this.owner = owner;
    }
    Car(String model, int hp, int cost){
        this(model, hp, cost, "");
    }
    Car(String model, int hp){
        this(model, hp, 0, "");
    }
    Car(){
        setRandData();
    }

    // Методы -----------

    // Вывести все данные
    void showData() {
        System.out.println("Название автомобиля: " + this.model);
        System.out.println("Мощность (л.с): " + this.hp);
        if ( cost == 0 ){
            System.out.println("Автомобиль еще не поступил в продажу");
        } else {
            System.out.println("Стоимость автомобиля: " + this.cost);
            if (owner == ""){
                System.out.println("Владельца еще нет");
            } else {
                System.out.println("Владелец автомобиля: " + this.owner);
            }
        }
    }

    // Установить случайние значения ( из класса Const )
    void setRandData() {
        Random random = new Random();
        int pos = random.nextInt(Const.MODEL_ARRAY.length);
        model = Const.MODEL_ARRAY[pos];

        pos = random.nextInt(Const.HP_ARRAY.length);
        hp = Const.HP_ARRAY[pos];

        pos = random.nextInt(Const.COST_ARRAY.length);
        cost = Const.COST_ARRAY[pos];
    }

    void inputData(int num){
        String tempModel =  "";
        int tempHP = -1;
        int tempCost = -1;
        String tempOwner = null;

        Scanner S = new Scanner(System.in);
        do {
            System.out.println("Введите модель автомобиля (" + (num+1) +")");
            if (S.hasNextLine()){
                tempModel = S.nextLine();
            }
        } while ( tempModel == "");
        do {
            System.out.println("Введите мощность автомобиля (" + (num+1) +")");
            if (S.hasNextInt()){
                tempHP = S.nextInt();
            }
        } while ( tempHP <= 0 );
        do {
            System.out.println("Введите стоимость автомобиля (" + (num+1) +")");
            System.out.println("Если автомобиль еще не в продаже введите 0");
            if (S.hasNextInt()){
                int temp = S.nextInt();
                if (temp > -1){
                    tempCost = temp;
                }
            }
        } while ( tempCost == -1 );
        if (tempCost != 0){
            do {
                System.out.println("Введите владельца " + tempModel);
                System.out.println("Если у автомобиля еще нет владельца - введите 0");
                if (S.hasNextLine()){
                    String temp = S.nextLine();
                    if ( temp == "0" ){
                        tempOwner = "";
                    } else {
                        tempOwner = temp;
                    }
                } else if(S.hasNextInt()) {
                    int temp = S.nextInt();
                    if (temp == 0) {
                        tempOwner = "";
                    }
                }
            } while ( tempOwner == null );
        }

        model = tempModel;
        hp = tempHP;
        cost = tempCost;
        owner = tempOwner;

        System.out.println("Автомобиль добавлен");
        showData();
    }

    void changeModel(){
        Scanner S = new Scanner(System.in);
        String temp = "";
        do {
            System.out.println("Введите новое значение параметра: Mодель авто");
            if (S.hasNextLine()){
                temp = S.nextLine();
            }
        } while ( temp == "" );
        this.model = temp;
        System.out.println("Данные были изменены");
    }

    void changeHP(){
        Scanner S = new Scanner(System.in);
        int temp = -1;
        do {
            System.out.println("Введите новое значение параметра: Мощность авто");
            if (S.hasNextInt()){
                int t_temp = S.nextInt();
                if (t_temp > 0){
                    temp = t_temp;
                }
            }
        } while ( temp == -1);
        this.hp = temp;
        System.out.println("Данные были изменены");
    }

    void changeCost(){
        Scanner S = new Scanner(System.in);
        int temp = -1;
        do {
            System.out.println("Введите новое значение параметра: Стоимость авто");
            System.out.println("0, если автомобиль не в продаже");
            if (S.hasNextInt()){
                int t_temp = S.nextInt();
                if (t_temp >= 0){
                    temp = t_temp;
                }
            }
        } while ( temp == -1);
        this.cost = temp;
        System.out.println("Данные были изменены");
    }

    void changeOwner(){
        if (this.cost == 0) {
            System.out.println("Автомобиль не в продаже, брат, что ты хочешь?");
        } else {
            Scanner S = new Scanner(System.in);
            String temp = null;
            do {
                System.out.println("Введите новое значение параметра: Владелец авто");
                if (S.hasNextLine()){
                    temp = S.nextLine();
                }
            } while ( temp == null );
            this.owner = temp;
            System.out.println("Данные были изменены");
        }
    }

}

// класс Константных значений
class Const {
    public static String[] MODEL_ARRAY = {"Bmw", "Audi", "Mercedes", "Lada", "Honda", "Kia", "Range Rover"};
    public static int[] HP_ARRAY = {89, 99, 101, 142, 159, 249, 256, 278, 345, 550};
    public static int[] COST_ARRAY = {150000, 200000, 400000, 500000, 750000, 900000, 150000, 2000000, 5000000};
}

