package librarymanagementsystem.example;

import java.time.LocalDateTime;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int totalCopies;
    private int availableCopies;
    public Book(int bookId,String title,String author){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
    }
    public boolean isAvailable() {
        return availableCopies > 0;
    }
    public int getBookId() {
        return bookId;
    }
    public String getTitle() {
        return title;
    }
    // public void setTitle(String title) {
    //     this.title = title;
    // }
    public String getAuthor() {
        return author;
    }
    public int getTotalCopies() {
        return totalCopies;
    }
    public void setTotalCopies(int totalCopies) { 
        this.totalCopies = totalCopies;
    }
    public int getAvailableCopies() {
        return availableCopies;
    }
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }


    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    //check
    public LocalDateTime calculateDueDate() {
       // Calculate and return due date as 10 days from now
        return LocalDateTime.now().plusSeconds(10);
    }

    //check
    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate =dueDate;
    }
    public LocalDateTime getDueDate() {//stores due date 
        return dueDate;
    }

    //imp check~!!!!
    public LocalDateTime getReturnDate() {
        return LocalDateTime.now();
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}