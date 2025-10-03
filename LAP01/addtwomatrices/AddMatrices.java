import java.util.Scanner;

public class AddMatrices {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap kich thuoc cua ma tran: ");
		int m = sc.nextInt();
		int n = sc.nextInt();
		System.out.println("Nhap cac phan tu cua ma tran thu nhat: ");
		int[][] A = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		System.out.println("Nhap cac phan tu cua ma tran thu hai: ");
		int[][] B = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				B[i][j] = sc.nextInt();
			}
		}
		int[][] C = new int[m][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				C[i][j] = A[i][j] + B[i][j];
			}
		}
		System.out.println("Tong hai ma tran la: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();}
	}
	
}
