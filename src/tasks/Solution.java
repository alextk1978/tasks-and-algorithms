package tasks;

import java.util.LinkedHashMap;

/**
 * @author Alexey Tkachenko
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {9, 4, 9, 6, 7, 4, 5};
        System.out.println(getElem(arr));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("Hi");
            }
        });
        thread.start();
    }

    public static Integer getElem(int[] a) {

        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        map.put(a[0], 1);
        for (int i = 1; i < a.length; i++) {
            if (!map.containsKey(a[i])) {
                map.put(a[i], 1);
            } else {
                map.remove(a[i]);
            }
        }
        return map.keySet().iterator().next();
    }
}
