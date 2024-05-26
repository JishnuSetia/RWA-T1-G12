import java.util.Scanner;

public class calendar {
    public static void main(String[] args) {
        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };
        String[] days = {
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the year:");
        int year = sc.nextInt();
        sc.nextLine();

        int monthInd = -1;
        while (true) {
            System.out.println("Enter the month:");
            String month = sc.nextLine().trim();
            boolean chk = false;
            for (int i = 0; i < months.length; i++) {
                if (months[i].equalsIgnoreCase(month)) {
                    chk = true;
                    monthInd = i;
                    break;
                }
            }
            if (chk) {
                break;
            } else {
                System.out.println("Invalid month. Please enter again.");
            }
        }

        int dayIndex = -1;
        while (true) {
            System.out.println("Enter the starting day:");
            String day = sc.nextLine().trim();
            boolean chk = false;
            for (int i = 0; i < days.length; i++) {
                if (days[i].equalsIgnoreCase(day)) {
                    chk = true;
                    dayIndex = i;
                    break;
                }
            }
            if (chk) {
                break;
            } else {
                System.out.println("Invalid day. Please enter again.");
            }
        }
        sc.close();

        int daysInMonth;
        if (monthInd == 1) { 
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                daysInMonth = 29;
            } else {
                daysInMonth = 28;
            }
        } else if (monthInd == 3 || monthInd == 5 || monthInd == 8 || monthInd == 10) { // April, June, September, November
            daysInMonth = 30;
        } else {
            daysInMonth = 31;
        }

        int[][] calendar = new int[6][7];
        int date = 1;

        for (int i = 0; i < calendar.length && date <= daysInMonth; i++) {
            for (int j = dayIndex; j < 7 && date <= daysInMonth; j++) {
                calendar[i][j] = date++;
            }
            dayIndex = 0; 
        }

        for (int i = 0; i < days.length; i++) {
            System.out.print(days[i].substring(0, 3) + "\t");
        }
        System.out.println();
        for (int i = 0; i < calendar.length; i++) {
            for (int j = 0; j < calendar[i].length; j++) {
                if (calendar[i][j] == 0) {
                    System.out.print("\t");
                } else {
                    System.out.print(calendar[i][j] + "\t");
                }
            }
            System.out.println();
        }
    }
}
