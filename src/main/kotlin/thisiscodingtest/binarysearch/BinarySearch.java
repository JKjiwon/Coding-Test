package thisiscodingtest.binarysearch;

import java.util.NoSuchElementException;

public class BinarySearch {

    public static int recursiveSearch(int[] array, int target, int start, int end) {
        if (start > end) {
            throw new NoSuchElementException("찾으려는 값이 없습니다.");
        }

        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid + 1;
        } else if (array[mid] > target) {
            return recursiveSearch(array, target, start, mid - 1);
        } else {
            return recursiveSearch(array, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 6, 8};
        int rec = recursiveSearch(array, 7, 0, 5);
        int loop = loopSearch(array, 7, 0, 5);
        System.out.println(rec);
        System.out.println(loop);
    }

    public static int loopSearch(int[] array, int target, int start, int end) {
        int left = start;
        int right = end;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == array[mid]) {
                return mid + 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        throw new NoSuchElementException("찾으려는 값이 없습니다.");
    }
}
