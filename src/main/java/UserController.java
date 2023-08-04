import exception.ContactCreationCancelledException;

import javax.swing.*;
import java.util.ArrayList;

public class UserController {
    private int issuedBooksQuantity = 0;
    ArrayList<User> user = new ArrayList<>();
    public void addUser(){
        try{
            user.add(collectUserInfo());
            JOptionPane.showMessageDialog(null,"User was successfully registered");
            System.out.println(user.toString());

        }catch (Exception exception) {
            JOptionPane.showMessageDialog(null, exception.getMessage());
        }
    }

    private User collectUserInfo() throws ContactCreationCancelledException {
        User user = new User();
        user.setFirstName(this.getUserInput("Enter the first name: "));
        user.setLastName(this.getUserInput("Enter the last name: "));
        user.setPhoneNumber(this.getUserInput("Enter the phone number: "));
        user.setPersonalNumber(this.getUserInput("Enter the personal number: "));
        if(
                user.getFirstName() == null || user.getPhoneNumber() == null
                || user.getLastName() == null || user.getPersonalNumber() == null ||
                user.getFirstName().isBlank() || user.getLastName().isBlank() ||
                user.getPhoneNumber().isBlank() || user.getPersonalNumber().isBlank()
        ){
            int userChoice = JOptionPane.showConfirmDialog(null,"Please note, that all the fields should be filled in. " +
                    "Do you want to start again?");
            if (userChoice == JOptionPane.YES_OPTION) {
                return this.collectUserInfo();
            }
            throw new ContactCreationCancelledException("Contact creation failed");
        }
        return user;
    }

    public User findUserByPersonalNumber(String enteredPersonalNumber){
        for (User user : user) {
            if (user.getPersonalNumber().equals(enteredPersonalNumber)) {
                JOptionPane.showMessageDialog(null, user);
                return user;
            }
        }
        JOptionPane.showMessageDialog(null, "No user were found");
        return null;
    }

    public void increaseIssuedBooksQuantity(User user) {
        if (user.getIssuedBooksQuantity() < 5){
            user.setIssuedBooksQuantity(user.getIssuedBooksQuantity() + 1);
        }else {
            throw new RuntimeException("Unable to issue more then 5 books per person");
        }
    }

    public void decreaseIssuedBooksQuantity(User user) {
        if (user.getIssuedBooksQuantity() > 0){
            user.setIssuedBooksQuantity(user.getIssuedBooksQuantity() - 1);
        }else {
            throw new RuntimeException("There is no issued books for this user");
        }
    }

    private String getUserInput(String message) {
        return JOptionPane.showInputDialog(message);
    }
}
