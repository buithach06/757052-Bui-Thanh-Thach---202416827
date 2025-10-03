

import javax.swing.JOptionPane;

public class calculate {
    public static void main(String[] args) {
        try {
            String strNum1 = JOptionPane.showInputDialog("Nhập số thứ nhất:");
            double num1 = Double.parseDouble(strNum1);

            // Nhập số thứ hai
            String strNum2 = JOptionPane.showInputDialog("Nhập số thứ hai:");
            double num2 = Double.parseDouble(strNum2);

            // Tính toán
            double sum = num1 + num2;
            double difference = num1 - num2;
            double product = num1 * num2;

            String result;
            if (num2 != 0) {
                double quotient = num1 / num2;
                result = "Tổng: " + sum
                       + "\nHiệu: " + difference
                       + "\nTích: " + product
                       + "\nThương: " + quotient;
            } else {
                result = "Tổng: " + sum
                       + "\nHiệu: " + difference
                       + "\nTích: " + product
                       + "\nThương: Không thể chia cho 0!";
            }

            // Hiển thị kết quả
            JOptionPane.showMessageDialog(null, result);

            System.exit(0);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Lỗi: Vui lòng nhập số hợp lệ!");
        }
    }
}
