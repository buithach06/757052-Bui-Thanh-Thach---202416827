import java.util.Scanner;
import java.util.Arrays;

public class SortSum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("nhap so phan tu cua day: ");
		int n = sc.nextInt();
		System.out.println("nhap cac phan tu: ");
		int[] numbers = new int[n];
		int sum = 0;
		double aver = 0;
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
			sum += numbers[i];
		}
		aver = sum/n;
		Arrays.sort(numbers);
		System.out.println("tong: " + sum);
		System.out.println("trung binh: " + aver);
		System.out.println("day: " + Arrays.toString(numbers));
		
	
		sc.close();
		
	}
}
