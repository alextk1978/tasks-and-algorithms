package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Alexey Tkachenko
 * <p>
 * Для двух массивов a и b напишите функцию comp (a, b) (orcompSame (a, b)), которая проверяет,
 * имеют ли два массива «одинаковые» элементы
 * с одинаковой кратностью (кратность члена - это количество раз, которое он встречается).
 * «одинаковые» здесь означает, что элементы в b являются элементами a в квадрате, независимо от порядка.
 * <p>
 * Examples
 * Valid arrays
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
 * comp(a, b) returns true because in b 121 is the square of 11, 14641 is the square of 121, 20736 the square of 144,
 * 361 the square of 19, 25921 the square of 161, and so on. It gets obvious if we write b's elements in terms of squares:
 * <p>
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
 * Invalid arrays
 * If, for example, we change the first number to something else, comp is not returning true anymore:
 * <p>
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
 * comp(a,b) returns false because in b 132 is not the square of any number of a.
 * <p>
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [121, 14641, 20736, 36100, 25921, 361, 20736, 361]
 * comp(a,b) returns false because in b 36100 is not the square of any number of a.
 */
public class AreTheyTheSame {

    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null) return false;
        if ((a.length != b.length)) return false;

        return Arrays.equals(Arrays.stream(a).map(x -> x * x).sorted().toArray(), Arrays.stream(b).sorted().toArray());
    }

    public static class AreTheyTheSameTest {

        @Test
        public void test1() {
            int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
            int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
            Assertions.assertTrue(AreTheyTheSame.comp(a, b));

            a = new int[]{-121, 144, 19, 161, 19, 144, 19, -11};
            b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};
            Assertions.assertTrue(AreTheyTheSame.comp(a, b));

            a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
            b = new int[]{132, 14641, 20736, 361, 25921, 361, 20736, 361};
            Assertions.assertFalse(AreTheyTheSame.comp(a, b));

            a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
            b = new int[]{121, 14641, 20736, 36100, 25921, 361, 20736, 361};
            Assertions.assertFalse(AreTheyTheSame.comp(a, b));

            int[] c = new int[0];
            int[] d = new int[0];
            Assertions.assertTrue(AreTheyTheSame.comp(c, d));

            a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
            b = new int[0];
            Assertions.assertFalse(AreTheyTheSame.comp(a, b));

            a = new int[]{-121, 144, 19, 161, 19, 144, 19, -11};
            b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736};
            Assertions.assertFalse(AreTheyTheSame.comp(a, b));

            int[] e = null;
            int[] f = null;
            Assertions.assertFalse(AreTheyTheSame.comp(e, f));
        }
    }
}
