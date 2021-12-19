package tasks;

/**
 * @author Alexey Tkachenko
 *
 * Учитывая треугольник последовательных нечетных чисел:
 *
 *              1
 *           3     5
 *        7     9    11
 *    13    15    17    19
 * 21    23    25    27    29
 * ...
 * Вычислите сумму чисел в n- й строке этого треугольника (начиная с индекса 1), например: (Вход -> Выход)
 *
 * 1 --> 1
 * 2 --> 3 + 5 = 8
 */

public class RowSumOddNumbers {

    public static void main(String[] args) {
        System.out.println(RowSumOddNumbers.rowSumOddNumbers(1));
        System.out.println(RowSumOddNumbers.rowSumOddNumbers(2));
        System.out.println(RowSumOddNumbers.rowSumOddNumbers(42));
    }

    public static int rowSumOddNumbers(int n) {
        int l = n * (n - 1) + 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += l;
            l += 2;
        }
        return sum;
    }
}
