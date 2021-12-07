package main.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @className: no21
 * @description: TODO 类描述
 * @author: fuguo
 * @date: 2021/12/4
 **/
public class no21 {
    static int [] a = {1,2,3,4,5};
    public static void oneSort(int [] arr){
        for(int i = 0; i < arr.length - 1; i++){
            int max = i;
            for(int j = i + 1; j < arr.length;j++){
                if(arr[max] < arr[j]){
                    max = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }
        for(int num : arr){
            System.out.println(num);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [][] arr = new int[n][2];
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < 2; j++){
                arr[i][j] = scanner.nextInt();
            }
        }
        //Arrays.sort(arr,(a,b)->b[1]-a[1]);
        for(int i = 0; i < arr.length - 1; i++){
            int max = i;
            for(int j = i + 1; j < arr.length;j++){
                if(arr[max][1] < arr[j][1]){
                    max = j;
                }
            }
            int [] tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < 2; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
