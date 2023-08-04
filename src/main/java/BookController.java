import exception.BookCreationCancelledException;

import javax.swing.*;
import java.util.ArrayList;

public class BookController {
        private final ArrayList<Book> book = new ArrayList<>();
        private final UserController userController;

        public BookController(UserController userController){
            this.userController = userController;
        }
        public void addBook(){
            try{
                book.add(collectBookInfo());
                JOptionPane.showMessageDialog(null,"Book was successfully added to library register");

            } catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(null,"Invalid input! Please enter correct number!");
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage());
            }
        }

        private Book collectBookInfo() throws BookCreationCancelledException {
            Book book = new Book();
            book.setTitle(this.getUserInput("Enter the title: "));
            book.setAuthor(this.getUserInput("Enter the author name: "));

            try {
                book.setYear(Integer.parseInt(this.getUserInput("Enter the year of publication: ")));
                book.setPageAmount(Integer.parseInt(this.getUserInput("Enter the page amount: ")));
            }catch (NumberFormatException numberFormatException){
                throw new NumberFormatException("Invalid input! Please check if year of publication and page amount fields filled correctly");
            }
            book.setAvailable(true);
            if(
                    book.getTitle() == null || book.getAuthor() == null
                            || book.getYear() <= 1700 || book.getPageAmount() <= 0 ||
                            book.getTitle().isBlank() || book.getAuthor().isBlank()
            ){
                int userChoice = JOptionPane.showConfirmDialog(null,"Please note, that all the fields should be filled in correctly. " +
                        "Do you want to start again?");
                if (userChoice == JOptionPane.YES_OPTION) {
                    return this.collectBookInfo();
                }
                throw new BookCreationCancelledException("Contact creation failed");
            }
            return book;
        }

    public void issueBook() {
        Book foundBook = this.findBook();
        if (foundBook == null){
            return;
        }
        int userChoice = JOptionPane.showConfirmDialog(null, " \n Do you want to issue this book");
        if (userChoice == JOptionPane.YES_OPTION) {
            try {
            if (foundBook.isAvailable()) {
                String enteredPersonalNumber = this.getUserInput("Please enter user's personal number");
                User foundUser = userController.findUserByPersonalNumber(enteredPersonalNumber);

                    userController.increaseIssuedBooksQuantity(foundUser);

                    foundBook.setIssuedTo(foundUser.getPersonalNumber());
                    foundBook.setAvailable(false);

                    JOptionPane.showMessageDialog(null, "Book issued successfully");

                } else{
                JOptionPane.showMessageDialog(null, "This book is not available");
                }
            }catch (RuntimeException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }

    public void issuedBooksList() {
        ArrayList<Book> issuedBooks = new ArrayList<>();
        for (Book book : this.book){
            if (!book.isAvailable()){
                issuedBooks.add(book);
            }
        }
        if (issuedBooks.isEmpty()){
            JOptionPane.showMessageDialog(null, "No books issued");
        }else{
            for (Book book : issuedBooks){
                String bookList = book.toString();
                JOptionPane.showMessageDialog(null, "List of issued books: \n" + bookList + "\n");
            }
        }
    }
    public void returnBook() {
        Book foundBook = this.findBook();

        int userChoice = JOptionPane.showConfirmDialog(null, " \n Do you want to return this book");
        if (userChoice == JOptionPane.YES_OPTION) {

            if (!foundBook.isAvailable()) {
                String enteredPersonalNumber = this.getUserInput("Please enter user's personal number");
                User foundUser = userController.findUserByPersonalNumber(enteredPersonalNumber);
                try {
                    if (enteredPersonalNumber.equals(foundBook.getIssuedTo())) {
                        userController.decreaseIssuedBooksQuantity(foundUser);

                        foundBook.setIssuedTo(null);
                        foundBook.setAvailable(true);

                        JOptionPane.showMessageDialog(null, "Book returned successfully");

                    }}catch (RuntimeException e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "This book is available");
            }
        }
    }
    public Book findBook (){
        String value = this.getUserInput("Please enter the book title or author");
        for (Book book : book) {
            if (book.getTitle().equalsIgnoreCase(value) || book.getAuthor().equalsIgnoreCase(value)) {
                JOptionPane.showMessageDialog(null, book);
                return book;
            }
        }JOptionPane.showMessageDialog(null, "No books were found");
        return null;
    }

    public void displayBooksList() {
        String bookList = book.toString();
        JOptionPane.showMessageDialog(null,bookList + "\n");
    }
    public void removeBook() {
        Book bookToRemove = findBook();
        if (bookToRemove != null){
            int userChoice = JOptionPane.showConfirmDialog(null, " \n Are you sure you want to delete this book");
            if (userChoice == JOptionPane.YES_OPTION) {
                book.remove(bookToRemove);
                JOptionPane.showMessageDialog(null, "Book was successfully deleted");
            }
        }
    }
        private String getUserInput(String message) {
            return JOptionPane.showInputDialog(message);
        }

}


