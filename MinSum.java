/*
Problem statement : you are given an array of integers. You are required 
to compute the minimum sum of the array. If there are two equal elements
increase one of them such that the sum is minimal
 */

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class MinSum{

    private static int minSum(int[] arr){
	Map<Integer, Boolean> encounters = new HashMap<>(arr.length);
	int sum = 0;
	for(int i : arr){
	    Boolean b = encounters.get(i);
	    if(b == null){
		sum += i;
		encounters.put(i, true);
	    }else{
		int j = i;
		while(b != null){
		    ++j;
		    b = encounters.get(j);
		}
		sum += j;
		encounters.put(j, true);
	    }
	}
	return sum;
    } 

    public static void main(String[] args){
	Scanner stdin = new Scanner(System.in);
	int N = stdin.nextInt();
	int[] arr = new int[N];
	for(int i = 0 ; i < N ; ++i){
	    arr[i] = stdin.nextInt();
	}
	System.out.printf("The result is %d\n", minSum(arr));
    }


}
