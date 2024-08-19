package com.example.demo.Coding.GeneralCode;

//Find the second-largest element in an array in a single iteration without extra space.
public class SecondLargestElementInArray {

    public static void main(String[] args) {
        int [] arr = {8,7,5,9,6,0,1,9};

        System.out.println(findSecondLargest(arr));
    }

    private static int findSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else {
                if(arr[i] > secondLargest && arr[i] != largest) {
                    secondLargest = arr[i];
                }
            }

        }

        return  secondLargest;
    }
}
