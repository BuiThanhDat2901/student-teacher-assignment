package assignment.t2012e.entity;

public class Teacher {
    private String id;
    private String fullName;
    private String phone;
    private String email;

    public Teacher() {
    }

    public Teacher(String id, String fullName, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("\n%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s |",
                "", id, "",
                "", fullName, "",
                "", email, "",
                "", phone, ""
        );
    }

    public String getRollNumber() {
        return id;
    }

    public void setRollNumber(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}