import java.util.Scanner;
public class Linear {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double a, b;
		System.out.println("Nhap he so a, b: ");
		a = sc.nextDouble();
		b = sc.nextDouble();
		if (a == 0 && b == 0)
			System.out.println("Vo so nghiem");
		else if (a == 0 && b != 0)
			System.out.println("Vo nghiem");
		else 
			System.out.println("Nghiem la: " + (-b/a));
	}
	
}
