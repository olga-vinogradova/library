import java.util.UUID;

public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String personalNumber;
    private int issuedBooksQuantity;

    public User() {
        this.id = UUID.randomUUID();
    }

    public User(UUID id, String firstName, String lastName,String phoneNumber, String personalNumber, int issuedBooksQuantity) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.personalNumber = personalNumber;
        this.issuedBooksQuantity = issuedBooksQuantity;
    }

    public int getIssuedBooksQuantity() {
        return issuedBooksQuantity;
    }

    public void setIssuedBooksQuantity(int issuedBooksQuantity) {
        this.issuedBooksQuantity = issuedBooksQuantity;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

public String toString(){
        return new StringBuilder()
                .append(id + ", ")
                .append(firstName + ", ")
                .append(lastName + ", ")
                .append(phoneNumber + ", ")
                .append(personalNumber + "\n")
                .toString();
}
}
