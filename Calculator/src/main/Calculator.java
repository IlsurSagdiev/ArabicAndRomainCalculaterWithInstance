package main;

import java.io.*;
import java.util.*;

// класс Калькулятор, здесь происходят основные логические и арифметические оперцаии. 
// Требуется обязательное создание экзмпляра класса.

public class Calculator {

    private final String[] romainNumerals = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private final String[] arabicNumerals = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private boolean isArabic;
    private boolean isRomain;
    int a;
    int b;
    private StringBuilder sb = new StringBuilder();

    // чтение с консоли
    public String readConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите арифметическую операцию в одну строку.\n" +
                "Так же калькулятор поддерживает римские числа\n" +
                "(только целые числа от 1 до 10, например 10 * 10 или IX + VIII):\n");
        return reader.readLine();
    }

    // проверка на числа и парсинг
    public int checkNumber(String s) throws Exception {

        for (int i = 1; i < 11; i++) {
            if (s.equals(arabicNumerals[i])) {
                isArabic = true;
                return i;


            } else if (s.equals(romainNumerals[i])) {
                isRomain = true;
                return i;
            }
        }
        throw new Exception("Вы ввели неподходящие числа, введите числа от 1 до 10");
    }

    // проверка на совместимость символов
    public void checkСompatibility(boolean a, boolean b) throws Exception {
        if (a == b) {
            throw new Exception("Числа не совместимы.");
        }
    }

    // арифметические операции для арабских чисел с выводом реультата
    public void operationsArabic(String s) throws Exception {
        int result = switch (s) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception("Упс! Вы ввели неверный арифметический символ");
        };
        System.out.println("Ответ : " + result);
    }

    // арифметические операции для римских чисел с выводом реультата
    public void operationsRomain(String s) throws Exception {

        int i = 0;
        int result;
        List<RomanNumeral> romanNumerals = Arrays.asList(RomanNumeral.values());

        result = switch (s) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception("Упс! Вы ввели неверный арифметический символ");
        };

        while ((result > 0) && (i < romanNumerals.size())) {
            RomanNumeral currentSymbol = romanNumerals.get(i);
            if (currentSymbol.value <= result) {
                sb.append(currentSymbol.name());
                result -= currentSymbol.value;
            } else {
                i++;
            }
        }
        System.out.println("Ответ : " + sb);
    }

    public boolean isArabic() {
        return isArabic;
    }
    public boolean isRomain() {
        return isRomain;
    }
}


