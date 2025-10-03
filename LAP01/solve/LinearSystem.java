import java.util.Scanner;

public class LinearSystem {
    public static void solveLinearSystem(double a11, double a12, double b1,
                                         double a21, double a22, double b2) {
        System.out.println("\nGiai phuong trinh bac nhat 2 an");
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("He co nghiem duy nhat: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("He co vo so nghiem.");
            } else {
                System.out.println("He vo nghiem.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap he so cua he phuong trinh:");
        System.out.print("a11 = ");
        double a11 = sc.nextDouble();
        System.out.print("a12 = ");
        double a12 = sc.nextDouble();
        System.out.print("b1 = ");
        double b1 = sc.nextDouble();

        System.out.print("a21 = ");
        double a21 = sc.nextDouble();
        System.out.print("a22 = ");
        double a22 = sc.nextDouble();
        System.out.print("b2 = ");
        double b2 = sc.nextDouble();

        solveLinearSystem(a11, a12, b1, a21, a22, b2);

        sc.close();
    }
}
