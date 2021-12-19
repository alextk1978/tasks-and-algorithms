package tasks;

/**
 * @author Alexey Tkachenko
 *
 * Напишите функцию persistence, которая принимает положительный параметр num и возвращает его мультипликативную стойкость,
 * то есть количество раз, которое вы должны умножать цифры num,пока не дойдете до единственной цифры.
 *
 * Например (Вход -> Выход) :
 *
 * 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
 * 999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
 * 4 --> 0 (because 4 is already a one-digit number)
 */

public class Persist {

    public static void main(String[] args) {
        System.out.println(Persist.persistence(39));
        System.out.println(Persist.persistence(999));
        System.out.println(Persist.persistence(4));
        System.out.println(Persist.persistence(25));
        System.out.println(Persist.persistence(0));
        System.out.println(Persist.persistence(234283732));
    }

    public static int persistence(long n) {
        String s = String.valueOf(n);
        int k = 0;
        while (s.length() > 1) {
            String[] strings = s.split("");
            long l = 1;
            for (String string : strings) {
                l *= Long.parseLong(string);
            }
            s = String.valueOf(l);
            k++;
        }
        return k;
    }
}
