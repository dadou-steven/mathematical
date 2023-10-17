package appsinc.fr;

import appsinc.fr.poo.canine.Comparable;

import java.util.Arrays;
import java.util.Random;

public class AlgorithmeDeRecherche {

    // Tri par selection | Quadratique - O(n^2)
    public static void selectionSort (int[] list) {
        int minIndex;
        int nextSmallest;

        for (int unSortedStart = 0; unSortedStart < list.length-1; unSortedStart++) {
            minIndex = unSortedStart;
            for (int currentIndex = unSortedStart+1; currentIndex < list.length; currentIndex++) {
                if (list[currentIndex] < list[minIndex]) {
                    minIndex = currentIndex;
                }
            }

            nextSmallest = list[minIndex];
            list[minIndex] = list[unSortedStart];
            list[unSortedStart] = nextSmallest;
        }
    }

    // Tri par fusion | Linearithmique - O(nlog(n)
    public static void mergeSort(int[] list, int start, int end) {
        if (start == end) {
            return;
        } else if (start == end-1) {
            if (list[start] <= list[end]) {
                return;
            } else {
                int temp = list[start];
                list[start] = list[end];
                list[end] = temp;
            }
        }

        int mid = (end - start) / 2;
        mergeSort(list, start, start + mid);
        mergeSort(list, start + mid + 1, end);
        merge(list, start, start + mid, end);
    }

    private static void merge(int[] list, int leftHalfStart, int rightHalfStart, int end) {
        int leftHalfSize = rightHalfStart - leftHalfStart + 1;
        int rightHalfSize = end - rightHalfStart;

        int[] leftHalf = new int[leftHalfSize];
        int[] rightHalf = new int[rightHalfSize];

        for (int i = 0; i < leftHalfSize; ++i) {
            leftHalf[i] = list[leftHalfStart + i];
        }
        for (int j = 0; j < rightHalfSize; ++j) {
            rightHalf[j] = list[rightHalfSize + 1 + j];
        }

        int i = 0;
        int j = 0;

        int k = leftHalfStart;
        while (i < leftHalfSize && j < rightHalfSize) {
            if (leftHalf[i] <= leftHalf[j]) {
                list[k] = leftHalf[i];
                i++;
            } else {
                list[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        while (i < leftHalfSize) {
            list[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightHalfSize) {
            list[k] = rightHalf[j];
            j++;
            k++;
        }
    }

    // Algorithme de recherche | linéaire - O(n)
    public static boolean searchInArray(int target, int[] array) {
        boolean result = false;
        for (int element : array) {
            if (element == target) {
                result = true;
                break;
            }
        }
        return  result;
    }

    // Tri par insertion | Quadratique - O(n^2)
    public static void insertion(int[] list) {
        for (int unsortedStart = 1; unsortedStart <list.length; unsortedStart++) {
            int nextInsert = list[unsortedStart];
            int currentIdent = unsortedStart -1;

            while (currentIdent >= 0 && list[currentIdent] > nextInsert) {
                list[currentIdent+1] = list[currentIdent];
                currentIdent--;
            }
            list[currentIdent+1] = nextInsert;
        }
    }

    // Algorithme de recherche binaire
    /*
    public static int binarySearch(Comparable[] list, Comparable target) {
        int start = 0, end = list.length - 1, mid = 0;
        while (start<= end) {
            mid = (start + end) / 2;
            if (list[mid].compareTo(target) == 0) {
                return mid;
            } else if (target.compareTo(list[mid]) < 0) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
     */

    public static void main(String[] args) {
        // Constant - O(1)
        Integer[] numbers = new Integer[1000000];
        Random rand = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(1000000);
        }
        System.out.println(Arrays.toString(numbers));
    }
}
