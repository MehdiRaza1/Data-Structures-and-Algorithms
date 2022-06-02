package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        /* Random arrayValues = new Random();

        int[] randomArray = new int[1000];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = arrayValues.nextInt(50);
        }

        print(randomArray);

        System.out.println();

        */

	int[] numbers = {-423,345,3,0,111,2,3,4,23,234,234,234,0,1,1,-123,0,-1,56,72,23,34,5,3,2,5,23,423,
            345,-3,0,0,111,2,3,4,23,234,234,234,0,1,1,0,56,23,34,5,3,2,5,23,1};

//    int[] numbers = {72,23,234,3,24};

//    int[] numbers = {1,2,3,4,5,6};

    print(numbers);

    System.out.println();

//    Arrays.sort(numbers);

//    SelectionSort(numbers);

//    ImprovedBubbleSort(numbers);

//    BooleanBubbleSort(numbers);

//    quickSort(numbers,0,numbers.length-1);

    mergeSort(numbers, 0, numbers.length-1);

    print(numbers);

    System.out.println();

    }

    private static void print(int[] arr) {
        for (int j : arr)
            System.out.print(j + " ");
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
    }

    private static void BooleanBubbleSort(int[] arr) {

        boolean isSorted = true;
        int lastSorted = arr.length - 1;

        while (isSorted) {
            isSorted = false;
            for (int i = 0; i< lastSorted; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr,i,i+1);
                    isSorted = true;
                }
            }
            lastSorted--;
        }
    }

    private static void ImprovedBubbleSort(int[] arr) {

        int arrLength = arr.length-1;

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arrLength; j++) {
                if (arr[j] > arr[j+1])
                    swap(arr,j,j+1);
            }
            arrLength--;
        }
    }

    private static int[] SelectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = getMinIndex(arr,i);
            if (i != minIndex)
                swap(arr, i, minIndex);
        }
        return arr;
    }

    private static int getMinIndex(int[] arr, int startIndex) {

        for (int j = startIndex; j < arr.length; j++) {
            if (arr[j] < arr[startIndex])
                startIndex = j;
        }
        return startIndex;
    }

    private static void quickSort(int[] arr, int left, int right) {

        if (left >= right) return;

        int pivot = arr[(left+right)/2];

        int index = partition(arr,left,right,pivot);

        quickSort(arr, left, index-1);

        quickSort(arr, index, right);
    }

    private static int partition(int[] arr, int left, int right, int pivot) {

        while (left<=right) {

            while (arr[left] < pivot) left++;

            while (arr[right] > pivot) right--;

            if (left<=right)
                swap(arr,left++,right--);
        }
        return left;
    }

    private static void mergeSort(int[] arr, int leftStart, int rightEnd) {

            if (leftStart >= rightEnd) return;

            int mid = (leftStart + rightEnd) / 2;

            mergeSort(arr, leftStart, mid);

            mergeSort(arr, mid + 1, rightEnd);

            mergeHalves(arr, leftStart, mid, rightEnd);
        }

    private static void mergeHalves(int[] arr, int leftStart, int mid, int rightEnd) {

        int[] temp = new int[arr.length];

        for (int i = leftStart; i <= rightEnd; i++)
            temp[i] = arr[i];

        int left = leftStart;
        int right = mid + 1 ;
        int index = leftStart;

//        Traversing Through Array
        while (left <= mid && right <= rightEnd) {

            if (temp[left] <= temp[right])
                arr[index++] = temp[left++];
            else
                arr[index++] = temp[right++];
        }
//        If Left Array is Exhausted
        while (left <= mid)
            arr[index++] = temp[left++];

//        If Right Array is Exhausted
        while (right <= rightEnd)
            arr[index++] = temp[right++];

    }




}
