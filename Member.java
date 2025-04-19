import java.util.ArrayList;
import java.util.Scanner;

class Member {
    private String name;
    private String licenseNumber;

    public Member(String name, String licenseNumber) {
        this.name = name;
        this.licenseNumber = licenseNumber;
    }
    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }
    public String getLicenseNumber() {
        return licenseNumber;
    }
    public void setMemberName(String name){
        this.name = name;
    }
    public String getMemberName() {
        return name;
    }
}