
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);

//      Отслеживание позиции в меню
        int pos = 2;
//      pos == 0 - Фибоначчи
//      pos == 1 - Вампир
//      pos == 2 - Стартовое меню

        while (pos == 0 | pos == 1 | pos == 2){
//          isSkipScan - скип скана, для возврата в меню
            boolean isSkipScan = false;
            Ex a = new Ex();
            switch (pos){
//              Фибоначчи
                case 0:
                    System.out.println("Для выхода введите любое отрицательное число,\nчтобы вернуться в стартовое меню введите 0");
                    System.out.println("Введите количество элементов: ");
                    int count = S.nextInt();

                    if (count > 0){
                        a.fib(count);
                    } else if (count == 0){
                        pos = 2;
                        isSkipScan = true;
                        break;
                    } else {
                        return;
                    }
                    break;
//              Вампир
                case 1:
                    a.vampire();
                    for (int i = 0; i < 7; i++){
                        System.out.println(a.vampireArray[i]);
                    }
                    pos = 2;
                    isSkipScan = true;
                    break;
//              Стартовое меню
                case 2:
                    System.out.println("Выберите, что вам необходимо:");
                    System.out.println("\t0 - Числа Фибонначи\n\t1 - Число-Вампир\nЛюбой другой символ для выхода");
                    break;
                default:
                    return;
            }
            if (!isSkipScan){
                pos = S.nextInt();
            }
        }
    }
}
// Класс Фибоначчи
class Ex {
    String vampireArray[] = new String[7];
//    Функция Фибоначчи
    public int[] fib(int count){
        int empty[] = {};
        if (count > 0){
            int array[] = new int[count];

            System.out.print("Массив для " + count + " элемент(а/ов): ");
            for (int i = 0; i < count; i++){
                if (i > 1){
                    array[i] = array[i-1] + array[i-2];
                } else {
                    array[i] = 1;
                }
                if (i != count-1 ){
                    System.out.print(array[i] + ", ");
                } else {
                    System.out.print(array[i] + "\n");
                }
            }
            return array;
        }
        System.out.println("Шалость не удалась, получите пустой массив");
        return empty;
    }

//  Число-вампира
    public void vampire(){
        int index = 0;
        for (int i = 1000; i < 10000; i++){
            int th = i/1000; // thousands
            int hd = (i-th*1000)/100; // hundred
            int dz = (i-th*1000-hd*100)/10; // dozens
            int un = (i-th*1000-hd*100-dz*10); // units

            String res = check(th,hd,dz,un,i);
            if (res != null){
//              добавляем в массив с результатами
                vampireArray[index] = res;
                index++;
            }
        }
    }
//  Проверка
    private String check(int int11, int int12, int int21, int int22, int num){
//      перебор всех вариантов

        int num1 = ec(int11,int12);
        int num2 = ec(int21,int22);

        if (num1*num2 == num & ((int12 + int22) != 0)){
            return num + " = " + num1 + " * " + num2;
        }
        num1 = ec(int12,int11);
        num2 = ec(int21,int22);

        if (num1*num2 == num & ((int11 + int22) != 0)){
            return num + " = " + num1 + " * " + num2;
        }

        num1 = ec(int11,int12);
        num2 = ec(int22,int21);

        if (num1*num2 == num & ((int12 + int21) != 0)){
            return num + " = " + num1 + " * " + num2;
        }

        num1 = ec(int12,int11);
        num2 = ec(int22,int21);

        if (num1*num2 == num & ((int11 + int21) != 0)){
            return num + " = " + num1 + " * " + num2;
        }

        int temp = int12;
        int12 = int21;
        int21 = temp;

        num1 = ec(int11,int12);
        num2 = ec(int21,int22);

        if (num1*num2 == num & ((int12 + int22) != 0)){
            return num + " = " + num1 + " * " + num2;
        }
        num1 = ec(int12,int11);
        num2 = ec(int21,int22);

        if (num1*num2 == num & ((int11 + int22) != 0)){
            return num + " = " + num1 + " * " + num2;
        }

        num1 = ec(int11,int12);
        num2 = ec(int22,int21);

        if (num1*num2 == num & ((int12 + int21) != 0)){
            return num + " = " + num1 + " * " + num2;
        }
        num1 = ec(int12,int11);
        num2 = ec(int22,int21);

        if (num1*num2 == num & ((int11 + int21) != 0)){
            return num + " = " + num1 + " * " + num2;
        }

        temp = int12;
        int12 = int22;
        int22 = temp;

        num1 = ec(int11,int12);
        num2 = ec(int21,int22);

        if (num1*num2 == num & ((int12 + int22) != 0)){
            return num + " = " + num1 + " * " + num2;
        }
        num1 = ec(int12,int11);
        num2 = ec(int21,int22);

        if (num1*num2 == num & ((int11 + int22) != 0)){
            return num + " = " + num1 + " * " + num2;
        }

        num1 = ec(int11,int12);
        num2 = ec(int22,int21);

        if (num1*num2 == num & ((int12 + int21) != 0)){
            return num + " = " + num1 + " * " + num2;
        }
        num1 = ec(int12,int11);
        num2 = ec(int22,int21);

        if (num1*num2 == num & ((int11 + int21) != 0)){
            return num + " = " + num1 + " * " + num2;
        }

        return null;
    }

//  Перевод в человеческие циферки
    private int ec(int dozens, int units) {
//        easyConverter ec(2,1) -> 21
        return dozens * 10 + units;
    }
}