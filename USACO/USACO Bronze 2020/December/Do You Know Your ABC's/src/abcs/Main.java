package abcs;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nums[] = new int[7]; // create array of seven numbers
		for (int i = 0; i < 7; i++) {
			nums[i] = sc.nextInt(); //read in the 7 numbers
		}
		Arrays.sort(nums); //sort the numbers
		int a = nums[0], b = nums[1]; // a is the smallest number so it must be the first one, // b is the second smallest
		int c = nums[6] - a - b; //c must be equal to the sum (which is the greatest) minus a and b
		System.out.println(a + " " + b + " " + c); // print the three numbers space separated
		sc.close();
	}
}