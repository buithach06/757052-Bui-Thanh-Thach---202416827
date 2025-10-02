package DaysInMonth;

import java.util.Scanner;

public class Days {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int month = -1;
        int year = -1;

        while (true) {
            System.out.print("Nhập tháng (số, tên đầy đủ hoặc viết tắt): ");
            String monthInput = scanner.nextLine().trim();
            month = parseMonth(monthInput);

            System.out.print("Nhập năm (số nguyên dương, đầy đủ): ");
            String yearInput = scanner.nextLine().trim();

            if (month != -1 && isValidYear(yearInput)) {
                year = Integer.parseInt(yearInput);
                break; // nhập hợp lệ
            } else {
                System.out.println("❌ Dữ liệu không hợp lệ, vui lòng nhập lại!\n");
            }
        }

        int days = getDaysInMonth(month, year);
        System.out.println("✅ Tháng " + month + " năm " + year + " có " + days + " ngày.");
        scanner.close();
    }

    // Chuyển chuỗi nhập thành số tháng (1-12)
    public static int parseMonth(String input) {
        input = input.toLowerCase();
        switch (input) {
            case "1": case "january": case "jan.": case "jan": return 1;
            case "2": case "february": case "feb.": case "feb": return 2;
            case "3": case "march": case "mar.": case "mar": return 3;
            case "4": case "april": case "apr.": case "apr": return 4;
            case "5": case "may": return 5;
            case "6": case "june": case "jun.": case "jun": return 6;
            case "7": case "july": case "jul.": case "jul": return 7;
            case "8": case "august": case "aug.": case "aug": return 8;
            case "9": case "september": case "sep.": case "sep": return 9;
            case "10": case "october": case "oct.": case "oct": return 10;
            case "11": case "november": case "nov.": case "nov": return 11;
            case "12": case "december": case "dec.": case "dec": return 12;
            default: return -1;
        }
    }

    // Kiểm tra năm có hợp lệ không
    public static boolean isValidYear(String input) {
        if (!input.matches("\\d+")) return false; // phải toàn số
        try {
            int year = Integer.parseInt(input);
            return year >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Kiểm tra năm nhuận
    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        return year % 4 == 0;
    }

    // Trả về số ngày trong tháng
    public static int getDaysInMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                return -1;
        }
    }
}
