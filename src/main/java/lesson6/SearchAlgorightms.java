package lesson6;

import java.util.Arrays;

public class SearchAlgorightms {
    static int linearSearch(int[] ints, int target) {
        int result = -1;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == target) {
                result = i;
                break;
            }
        }
        return result;
    }

    static int binarySearch(int[] ints, int target) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        if (ints.length == 1) {
            if (ints[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        System.out.println("Ищем " + target + " внутри " + Arrays.toString(ints));
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            System.out.println("Диапазон [" + left + ":" + right + "], mid=" + mid + ", ints[mid]=" + ints[mid]);

            if (target > ints[mid]) {
                left = mid + 1;
            } else if (target < ints[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int interpolationSearch(int[] ints, int target) {
        if (ints == null || ints.length == 0) {
            return -1;
        }
        if (ints.length == 1) {
            if (ints[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        System.out.println("Ищем " + target + " внутри " + Arrays.toString(ints));
        int left = 0;
        int right = ints.length - 1;
        while ((ints[right] != ints[left]) && (target >= ints[left]) && (target <= ints[right])) {
            int guess = left + ((target - ints[left]) * (right - left) / (ints[right] - ints[left]));

            System.out.println("Диапазон [" + left + ":" + right + "], guess=" + guess + ", ints[guess]=" + ints[guess]);

            if (target > ints[guess]) {
                left = guess + 1;
            } else if (target < ints[guess]) {
                right = guess - 1;
            } else {
                return guess;
            }
        }
        return -1;
    }
}
