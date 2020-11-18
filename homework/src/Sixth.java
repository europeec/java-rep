import java.util.Scanner;

public class Sixth {
//    сотни, тысячи..
    private static  final String[] hundredAndMore = {"hundred ", "thousand ", "million ", "billion ", "thousand-billion "};
//    10, 20..
    private static  final String[] dozens = {"ten ", "twenty ", "thirty ", "forty ", "fifty ", "sixty ", "seventy ", "eighty ", "ninety "};
//    1..19
    private static  final String[] otherDigits = {"one ", "two ", "three ", "four ", "five ", "six ", "seven ", "eight ", "nine ", "ten ",
            "eleven ", "twelve ", "thirteen ", "fourteen ", "fifteen ", "sixteen ", "seventeen ", "eighteen ", "nineteen "};

    public static void main(String[] args) {
        long input = 0;
        int counter = 0;

        String result = "";
        Scanner S = new Scanner(System.in);

        System.out.println("Введите число");
        if (S.hasNextLong()) {
            input = S.nextLong();
            String res = "";

            if (input == 0) {
                res = "zero";
            }

            while (input != 0) {
                int num = (int) input % 1000;
                res = convertValueToString(num, counter) + res;

                input /= 1000;
                counter++;
            }

            System.out.println(res);
        }



    }

    private static String convertValueToString(int num, int counter) {
        String res = "";

        if (num > 0) {
            if (num < 100) {
                if (counter != 0) {
                    res = lessHundred(num) + addNameDigits(counter);
                } else {
                    res = lessHundred(num);
                }
            } else {
                res = moreHundred(num, counter);
            }
        }
        return res;
    }

//  num < 100
    public static String lessHundred(int num) {
        String res;

        if (num < 20) {
            res = otherDigits[num - 1];
        } else {
            int ones = num % 10;
            int dozen = num / 10;
            if (ones == 0) {
                res = dozens[dozen - 1];
            } else {
                res = dozens[dozen - 1] + otherDigits[ones - 1];
            }
        }

        return res;
    };

//  num > 100
    public static String moreHundred(int num, int counter) {
        String res = "";

        int hundreds = num / 100;
        int lessHundred = num % 100;

        res += otherDigits[hundreds - 1] + hundredAndMore[0];

        if (lessHundred != 0) {
//          если последние 2 цифры, не 00
            res += lessHundred(lessHundred);
        }
//          если это не последние 3 цифры числа, то добавляем разрядность
        if (counter != 0) {
            res += addNameDigits(counter);
        }
        return res;
    }
     public static String addNameDigits(int counter) {
        String res;
        res = hundredAndMore[counter];

        return res;
    }


}
