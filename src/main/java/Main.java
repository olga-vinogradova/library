import javax.swing.*;

public class Main {
    UserController userController = new UserController();
    BookController bookController = new BookController(userController);
    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }
    void start(){
        String userChoice = "";
        while (!userChoice.equals("9")){
            userChoice = JOptionPane.showInputDialog(
                    new StringBuilder()
                            .append("Welcome to Library, Please choose an option: ")
                            .append("\n1. Register user")
                            .append("\n2. Issue book")
                            .append("\n3. View issued books")
                            .append("\n4. Return book")
                            .append("\n5. Add new book")
                            .append("\n6. Find book")
                            .append("\n7. See books list")
                            .append("\n8. Remove book")
                            .append("\n9. Exit")
                            .toString()
            );
            switch (userChoice){
                case "1":
                    this.userController.addUser();
                    break;
                case "2":
                    this.bookController.issueBook();
                    break;
                case "3":
                    this.bookController.issuedBooksList();
                    break;
                case "4":
                    this.bookController.returnBook();
                    break;
                case "5":
                    this.bookController.addBook();
                    break;
                case "6":
                    this.bookController.findBook();
                    break;
                case "7":
                    this.bookController.displayBooksList();
                    break;
                case "8":
                    this.bookController.removeBook();
                    break;
            }
        }
    }
}
