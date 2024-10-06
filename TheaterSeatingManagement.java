import java.util.Scanner;
public class TheaterSeatingManagement {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            char[][] seatingChart = {
                    {'A', 'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'A', 'A'},
                    {'A', 'A', 'A', 'A', 'A', 'A'}
            };
    
            while (true) {
                System.out.println("\n---- Theater Seating Management ----");
                System.out.println("1. Display Seating Chart");
                System.out.println("2. Book a Seat");
                System.out.println("3. Cancel a Booking");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int option = scanner.nextInt();
    
                switch (option) {
                    case 1:
                        displaySeatingChart(seatingChart);
                        break;
                    case 2:
                        bookSeat(seatingChart, scanner);
                        break;
                    case 3:
                        cancelBooking(seatingChart, scanner);
                        break;
                    case 4:
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option! Please choose again.");
                }
            }
        }
    
        public static void displaySeatingChart(char[][] seatingChart) {
            System.out.println("\nSeating Chart:");
            System.out.println("    Seat 1 Seat 2 Seat 3 Seat 4 Seat 5 Seat 6");
            for (int i = 0; i < seatingChart.length; i++) {
                System.out.print("Row " + (char) ('A' + i) + "  ");
                for (int j = 0; j < seatingChart[i].length; j++) {
                    System.out.print(seatingChart[i][j] + "     ");
                }
                System.out.println();
            }
        }
    
        public static void bookSeat(char[][] seatingChart, Scanner scanner) {
            System.out.print("Enter row letter (A-E): ");
            char row = scanner.next().toUpperCase().charAt(0);
            System.out.print("Enter seat number (1-6): ");
            int seatNumber = scanner.nextInt();
    
            int rowIndex = row - 'A';
            int seatIndex = seatNumber - 1;
    
            if (isValidSeat(rowIndex, seatIndex, seatingChart)) {
                if (seatingChart[rowIndex][seatIndex] == 'A') {
                    seatingChart[rowIndex][seatIndex] = 'B';
                    System.out.println("Seat successfully booked!");
                } else {
                    System.out.println("Seat is already booked!");
                }
            } else {
                System.out.println("Invalid seat selection. Please try again.");
            }
        }
    
        public static void cancelBooking(char[][] seatingChart, Scanner scanner) {
            System.out.print("Enter row letter (A-E): ");
            char row = scanner.next().toUpperCase().charAt(0);
            System.out.print("Enter seat number (1-6): ");
            int seatNumber = scanner.nextInt();
    
            int rowIndex = row - 'A';
            int seatIndex = seatNumber - 1;
    
            if (isValidSeat(rowIndex, seatIndex, seatingChart)) {
                if (seatingChart[rowIndex][seatIndex] == 'B') {
                    seatingChart[rowIndex][seatIndex] = 'A';
                    System.out.println("Booking successfully canceled!");
                } else {
                    System.out.println("Seat is not booked yet!");
                }
            } else {
                System.out.println("Invalid seat selection. Please try again.");
            }
        }
    
        public static boolean isValidSeat(int rowIndex, int seatIndex, char[][] seatingChart) {
            return rowIndex >= 0 && rowIndex < seatingChart.length && seatIndex >= 0 && seatIndex < seatingChart[0].length;
        }
    }

