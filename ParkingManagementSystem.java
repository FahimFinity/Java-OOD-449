import java.util.ArrayList;
import java.util.Scanner;
class ParkingManagementSystem {
    private int totalSlots, availableSlots;
    private ArrayList<String> parkedCarsList;
    private ArrayList<Member> membersList;
    private Scanner in;

    public ParkingManagementSystem(int totalSlots) {
        this.totalSlots = totalSlots;
        this.availableSlots = totalSlots;
        this.parkedCarsList = new ArrayList<>();
        this.membersList = new ArrayList<>();
        this.in = new Scanner(System.in);
    }

    public void memberRegistration() {
        System.out.print("member name: ");
        String name = in.nextLine();
        System.out.print("license number: ");
        String licenseNum = in.nextLine();

        for (Member member : membersList) {
            if (member.getLicenseNumber().equals(licenseNum)) {
                System.out.println("this license number is already registered.");
                return;
            }
        }
        membersList.add(new Member(name, licenseNum));
        System.out.println("member registered successfully.");
    }
    public void registerNewMember() {
        while (true) {
            memberRegistration();
            System.out.print("Do you want to register another member? (yes/no): ");
            String response = in.nextLine();
            if (!response.equalsIgnoreCase("yes")) {
                break;
            }
        }
    }
    public boolean ifMember(String licenseNum){
        for (Member member : membersList) {
            if (member.getLicenseNumber().equals(licenseNum)) {
                return true;
            }
        }
        return false;
    }
    public void parkCar() {
        if (availableSlots == 0) {
            System.out.println("sorry, no available slots.");
            return;
        }
        System.out.print("license number: ");
        String licenseNum = in.nextLine();
        if (parkedCarsList.contains(licenseNum)) {
            System.out.println("this car is already parked.");
            return;
        }
        if (!ifMember(licenseNum)) {
            System.out.println("you are not registered member.");
            return;
        }
        parkedCarsList.add(licenseNum);
        availableSlots--;
        System.out.println("car parked successfully.");
    }
    public void removeCar() {
        if (availableSlots == totalSlots) {
            System.out.println("there are no parked cars.");
            return;
        }
        System.out.print("license number : ");
        String licenseNumber = in.nextLine();
        if (parkedCarsList.remove(licenseNumber)) {
            availableSlots++;
            System.out.println("car removed successfully. Have a safe journey. Allah Hafiz.");
        } else {
            System.out.println("sorry, this car is not parked here.");
        }
    }
    public void viewParkedCars() {
        if (availableSlots == totalSlots) {
            System.out.println("parking is empty.");
            return;
        }
        System.out.println("parked cars:");
        for (int i = 0; i < parkedCarsList.size(); i++) {
            System.out.println(i + ": " + parkedCarsList.get(i));
        }
    }
    public void availableSlot() {
        System.out.println("available parking slots: " + availableSlots);
    }
    public void viewRegisteredMembers() {
        if (membersList.isEmpty()) {
            System.out.println("no registered members.");
            return;
        }
        System.out.println("registered members are :");
        for (int i=0;i<membersList.size();i++) {
            Member member=membersList.get(i);
            System.out.println(i + " : " + "name: " + member.getMemberName() + "\nlicense Number: " + member.getLicenseNumber());
        }
    }
    public void askForMore() {
        System.out.print("do you want anything else? (yes/no): ");
        String response = in.nextLine();
        if (response.equalsIgnoreCase("no")) {
            System.out.println("Allah Hafiz");
            in.close();
            System.exit(0);
        }
    }
}