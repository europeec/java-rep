import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class Fiveth
{
	public static final String PATH = "homework/src/other/";
	public static final String PATH_TO_TEXT = PATH + "text.txt";
	public static final String PATH_TO_FIRST = PATH + "firstPart.txt";
	public static final String PATH_TO_SECOND = PATH + "secondPart.txt";

	public static String reverse(String str){
		char[] chars = str.toCharArray();
		String res = "";
		for (int i = chars.length - 1; i >= 0; i--){
			res += chars[i];
		}
		return res;
	}
	public static void main(String[] args) {

		Scanner S = new Scanner(System.in);

		// 1 задача

		int a = 0;
		int b = 0;
		String TEMP = "";
		// Инициализация а
		System.out.print("Введите значение числа а: ");
		if (S.hasNextInt()){
			a = S.nextInt();
		} else {
			TEMP = S.next();
			System.out.println("Доигрались! Вы ввели что-то непонятное, теперь а будет всегда == 0.\nДоволен?");
		}
		S.reset();
		// Инициализация b
		System.out.print("Введите значение числа b: ");
		if (S.hasNextInt()){
			b = S.nextInt();
		} else {
			TEMP = S.next();
			System.out.println("Доигрались! Вы ввели что-то непонятное, теперь b будет всегда == 0.\nДоволен?");
		}


		// Пробуем посчитать
		try {
			float res = (float) a/b;
			System.out.printf("Результат деления: %s", String.valueOf(res));
		} catch(Exception e) {
			// если он решил, что считать слишком сложно
		}



	//		2 задача
		File textFile = new File(PATH_TO_TEXT);
	//		Заполняем файл циферками
		try {
			Scanner readFile = new Scanner(textFile);
	//			Проверка, что там уже есть 200 строчек
	//			Чтобы не перезаписывать их каждый раз
			int count = 0;

			while (readFile.hasNext()) {
				readFile.nextLine();
				count += 1;
			}
	//			Если там не 200 строчек, то это нужно исправить
			if (count != 200) {
				PrintWriter pw = new PrintWriter(textFile);

	//		    	Заполняем
				Random rand = new Random();
				for (int i = 0; i < 200; i++){
					pw.printf("%d: %d\n", (i+1), rand.nextInt(200));
				}
				System.out.println("Текстовый файл успешно заполнен");
				pw.close();
			}


		} catch (Exception e) {
			System.out.println("err: Что-то произошло при заполнении файла ");
			System.err.print(e.getMessage());
		}


	//		Читаем файл
		System.out.print("\nВведите число от 1 до 200: ");
		int needID = -1;
		while(needID == -1) {
			if (S.hasNext()){
				int _t = S.nextInt();
				if (_t > 0 && _t < 201) {
					needID = a;
				}
			} else {
				System.out.print("Возомжно, вы меня не услашали, но нужно ЧИСЛО от 1 до 200\nПростите за капс, но.. :");
			}
		}
		try {
			System.out.println("Читаем файл..");
			Scanner readFile = new Scanner(textFile);

			while (readFile.hasNextLine()){
				String temp = readFile.nextLine();
				String[] parts = temp.split(": ", 2);
				int id = Integer.parseInt(parts[0]);
				if (needID == id){
					System.out.println("Мы все нашли, получите и распишитесь");
					System.out.println(temp);
					break;
				}
			}
		} catch (Exception e){
			System.err.print(e.getMessage());
		}

//		3 Задание
		File p1 = new File(PATH_TO_FIRST);
		File p2 = new File(PATH_TO_SECOND);

		try {
			Scanner read1 = new Scanner(p1);
			Scanner read2 = new Scanner(p2);

			String text1 = "";
			String text2 = "";

			while (read1.hasNextLine()){
				text1 += read1.nextLine();
			}

			while (read2.hasNextLine()){
				text2 += read2.nextLine();
			}

			PrintWriter pw1 = new PrintWriter(p1);
			pw1.print(reverse(text2));

			PrintWriter pw2 = new PrintWriter(p2);
			pw2.print(reverse(text1));

			pw1.close();
			pw2.close();
		} catch (Exception e) {
			System.err.print(e.getMessage());
		}


	}
}

