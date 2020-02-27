package ru.itmo.java;

import java.util.Arrays;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new int[]{};
        }

        int save = inputArray[inputArray.length - 1];

        System.arraycopy(inputArray, 0, inputArray, 1, inputArray.length - 1);

        inputArray[0] = save;

        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     * <p>
     * Если входной массив пуст или равен null - вернуть 0
     * <p>
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return 0;
        }
        Arrays.sort(inputArray);

        return inputArray.length == 1 ?
                inputArray[0] :
                Math.max(inputArray[0] * inputArray[1],
                        inputArray[inputArray.length - 2] * inputArray[inputArray.length - 1]);
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     * <p>
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int calc = 0;

        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a' || input.charAt(i) == 'b') {
                calc++;
            }
        }

        return (int) Math.floor(calc * 100.0 / input.length());
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }

        boolean answer = true;

        for (int i = 0; i < input.length() / 2 && answer; i++) {
            answer = input.charAt(i) == input.charAt(input.length() - i - 1);
        }

        return answer;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int charCounter = 1;
        StringBuilder resultBuilder = new StringBuilder().append(input.charAt(0));

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == resultBuilder.charAt(resultBuilder.length() - 1)) {
                charCounter++;
            } else {
                resultBuilder.append(charCounter);
                charCounter = 1;
                resultBuilder.append(input.charAt(i));
            }
        }

        return resultBuilder.toString() + charCounter;
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.isEmpty() || two.isEmpty()) {
            return false;
        }

        char[] arrayOne = one.toCharArray();
        char[] arrayTwo = two.toCharArray();
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        boolean result = one.length() == two.length();

        for (int i = 0; i < one.length() && result; i++) {
            result = arrayOne[i] == arrayTwo[i];
        }

        return result;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        boolean[] charInString = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            if (charInString[(int) s.charAt(i)]) {
                return false;
            }
            charInString[(int) s.charAt(i)] = true;
        }

        return true;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     * <p>
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null) {
            return new int[][]{{}};
        }

        for (int i = 0; i < m.length; i++) {
            for (int j = i; j < m[i].length; j++) {
                int t = m[i][j];                     //хоть где-то, кроме плюсов, есть свап?!?!?!
                m[i][j] = m[j][i];                   //не, ну правда, сложно им что ли
                m[j][i] = t;                         //мдэ.
            }
        }

        return m;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     * <p>
     * Запрещается пользоваться функций join
     * <p>
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (inputStrings == null || inputStrings.length == 0) {
            return "";
        }
        separator = separator == null ? ' ' : separator;

        StringBuilder resultBuilder = new StringBuilder();

        for (int i = 0; i < inputStrings.length - 1; i++) {
            resultBuilder.append(inputStrings[i]).append(separator);
        }

        return resultBuilder.toString() + inputStrings[inputStrings.length - 1];
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null) {
            return 0;
        }

        int result = 0;

        for (String inputString : inputStrings) {
            if (inputString.startsWith(prefix)) {
                result++;
            }
        }

        return result;
    }
}
