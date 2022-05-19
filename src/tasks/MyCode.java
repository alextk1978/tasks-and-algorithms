package tasks;

/**
 * @author Alexey Tkachenko
 */
// Даны два отсортированных массива.

// Вывести все элементы первого массива,
// которые не встречаются во втором.

// filter([1, 2, 3], [2, 3, 4]) => [1]

class MyCode {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 5, 7};
        int[] arr2 = {2, 3, 4, 6, 8};

        int k = 0;
        int l = 0;

        while (k < arr1.length) {
            if (arr1[k] != arr2[l]) {
                System.out.println(arr1[k]);
            } else l++;
            k++;
        }
    }
}
