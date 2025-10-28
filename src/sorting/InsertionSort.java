package sorting;

import java.sql.SQLOutput;
import java.util.Scanner;

public class InsertionSort {
    int[] arr;

    public InsertionSort(int[] arr){
        this.arr=arr;
    }

    public int[] sort(){
        //the smallest element will be pushed to the left everytime for each iteration
        for(int j=1;j<this.arr.length;j++){
            int key = arr[j];
            int i = j-1;
            //insert j into the sorted sequence arr[0...j-1]
            while(i>=0 && arr[i]>key){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1]=key;
        }
        return this.arr;
    };

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("INSERTION SORT ");
        System.out.println("Enter number of array elements: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < n; i++){
            System.out.println("Enter element " +  (i+1) + " :");
            arr[i] = s.nextInt();
        }
        InsertionSort sorting = new InsertionSort(arr);
        int[] sortedArray = sorting.sort();
        System.out.println("Sorted Array: ");
        for(int i =0; i < sortedArray.length; i++){
            System.out.print(arr[i]+ " ");
        }
    }
};

