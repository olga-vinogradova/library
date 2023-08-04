import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private int year;
    private int pageAmount;
    private boolean isAvailable;
    private String issuedTo;

    public Book() {
        this.id = UUID.randomUUID();
    }

    public Book(String title, String author, int year, int pageAmount, boolean isAvailable, String issuedTo) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pageAmount = pageAmount;
        this.isAvailable = isAvailable;
        this.issuedTo = issuedTo;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPageAmount() {
        return pageAmount;
    }

    public void setPageAmount(int pageAmount) {
        this.pageAmount = pageAmount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String toString(){
        return new StringBuilder()
                .append(id + ", ")
                .append(title + ", ")
                .append(author + ", ")
                .append(year + ", ")
                .append(pageAmount + ", ")
                .append(isAvailable + ", ")
                .append(issuedTo + "\n")
                .toString();
    }
}
