package lesson6;

import java.util.Arrays;

public class SortingAlgorithms {
    static void bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
        }
    }

    static int partition(int[] values, int left, int right) {
        int x = values[right];
        int less = left;

        for (int i = left; i < right; ++i) {
            if (values[i] <= x) {
//                swap(values[i], values[less]);
                int temp = values[i];
                values[i] = values[less];
                values[less] = temp;
                ++less;
            }
        }
        int temp = values[right];
        values[right] = values[less];
        values[less] = temp;
        return less;
    }

    static void quickSortImpl(int[] values, int left, int right) {
        if (left < right) {
            System.out.println("anchor=" + values[right]);
            int q = partition(values, left, right);
            System.out.println("after partition with left=" + left + ", right=" + right +  " arr=" + Arrays.toString(values));
            quickSortImpl(values, left, q - 1);
            quickSortImpl(values, q + 1, right);
        }
    }

    static void quickSort(int[] values) {
        if (values.length != 0) {
            quickSortImpl(values, 0, values.length - 1);
        }
    }
}
