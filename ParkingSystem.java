import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        System.out.println("*");
        System.out.println("*         WELCOME TO PARKING        *");
        System.out.println("*             SYSTEM                *");
        System.out.println("*");

        System.out.println("    _OWNER_   ");
        System.out.println("MR. FAHIM MORSHED");

        Scanner in = new Scanner(System.in);
        System.out.print("Total parking slots: ");
        int totalSlots = in.nextInt();

        ParkingManagementSystem parkingSystem = new ParkingManagementSystem(totalSlots);

        System.out.print("How many members want to register? ");
        int numberOfMembers = in.nextInt();
        for (int i = 0; i < numberOfMembers; i++) {
            parkingSystem.memberRegistration();
        }

        while (true) {
            System.out.println("\nWhat do you want?");
            System.out.println("1. Park a car");
            System.out.println("2. Remove a car");
            System.out.println("3. View parked cars");
            System.out.println("4. Check available slots");
            System.out.println("5. View registered member list");
            System.out.println("6. Register a new member");
            System.out.println("7. Exit");

            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    parkingSystem.parkCar();
                    parkingSystem.askForMore();
                    break;
                case 2:
                    parkingSystem.removeCar();
                    parkingSystem.askForMore();
                    break;
                case 3:
                    parkingSystem.viewParkedCars();
                    parkingSystem.askForMore();
                    break;
                case 4:
                    parkingSystem.availableSlot();
                    parkingSystem.askForMore();
                    break;
                case 5:
                    parkingSystem.viewRegisteredMembers();
                    parkingSystem.askForMore();
                    break;
                case 6:
                    parkingSystem.registerNewMember();
                    break;
                case 7:
                    System.out.println("Allah Hafiz");
                    in.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}