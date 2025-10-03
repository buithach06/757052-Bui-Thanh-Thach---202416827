import java.util.Scanner;

public class Quadratic {
    public static void solveQuadratic(double a, double b, double c) {
        System.out.println("\nGiai phuong trinh bac hai ax^2 + bx + c = 0");

        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phuong trinh co vo so nghiem.");
                } else {
                    System.out.println("Phuong trinh vo nghiem.");
                }
            } else {
                double x = -c / b;
                System.out.println("Phuong trinh bac nhat, nghiem duy nhat: x = " + x);
            }
            return;
        }

        // Tinh delta
        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            System.out.println("Phuong trinh co 2 nghiem phan biet: x1 = " + x1 + ", x2 = " + x2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            System.out.println("Phuong trinh co nghiem kep: x = " + x);
        } else {
            System.out.println("Phuong trinh vo nghiem (khong co nghiem thuc).");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap a = ");
        double a = sc.nextDouble();
        System.out.print("Nhap b = ");
        double b = sc.nextDouble();
        System.out.print("Nhap c = ");
        double c = sc.nextDouble();

        solveQuadratic(a, b, c);

        sc.close();
    }
}
