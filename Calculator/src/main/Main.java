package main;

import static main.Calculator.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();
        String firstNum = null;
        String secondNum = null;
        String operation = null;

        String[] buffer = calculator.readConsole().split(" ");    // читаем с консоли и заносим в массив по частям
        try {
            firstNum = buffer[0];                             // дергаем первое число
            secondNum = buffer[2];                            // дергаем второе число
            operation = buffer[1];                            // дергаем арифм операцию
        } catch (ArrayIndexOutOfBoundsException aiooBE) {     // ловим эксепшн на случай неправильного ввода строки  с задачей
            throw new ArrayIndexOutOfBoundsException          // да, выглядит тупо, но так красивее выглядит в консоли)
                    ("Вы забыли ввести пробелы после введенного числа и арифметического символа");
        }
        calculator.a = calculator.checkNumber(firstNum);                                          // инициализируем статик пременную a калькулятора
        calculator.b = calculator.checkNumber(secondNum);                                         // инициализируем статик пременную b калькулятора
        calculator.checkСompatibility(calculator.isArabic(), calculator.isRomain());              // проверяем совместимость введенных данных

        if (calculator.isRomain()) {                                    // проверка на тип чисел, через флаг
            calculator.operationsRomain(operation);                     // отправляем на операцию
        } else {
            calculator.operationsArabic(operation);                     // отправляем на операцию
        }
    }
}
