package tasks;

/**
 * @author Alexey Tkachenko
 * <p>
 * 1-й тред печатает только нечетные числа от 1 до n
 * 2-й тред печатает только четные числа от 2 до n+1
 * синхронизировать треды (любым способом) чтобы они напечатали числа по порядку:
 * 1
 * 2
 * 3...
 * n можно взять небольшое
 */

public class TwoThreadsOddEven {

    final static boolean[] isLock = {false};
    final static Object object = new Object();

    public static void main(String[] args) {

        new Thread() {
            private final int[] numbers = new int[]{1, 3, 5, 7, 9, 11};

            @Override
            public void run() {
                for (int i : numbers) {
                    synchronized (object) {
                        while (isLock[0]) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i);
                        isLock[0] = !isLock[0];
                        object.notify();
                    }
                }
            }
        }.start();

        new Thread() {
            private final int[] numbers = new int[]{2, 4, 6, 8, 10, 12};

            @Override
            public void run() {
                for (int i : numbers) {
                    synchronized (object) {
                        while (!isLock[0]) {
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println(i);
                        isLock[0] = !isLock[0];
                        object.notify();
                    }
                }
            }
        }.start();
    }
}
