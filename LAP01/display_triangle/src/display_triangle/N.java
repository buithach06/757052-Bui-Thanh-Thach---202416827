import java.util.Scanner;

public class N {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap chieu cao n: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            // In khoảng trắng bên trái
            String spaces = " ".repeat(n - i);
            // In dấu *
            String stars = "*".repeat(2 * i - 1);

            System.out.println(spaces + stars);
        }
    }
}
