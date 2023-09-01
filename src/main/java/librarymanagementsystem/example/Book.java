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
        try {
            if (totalCopies >= 0) {
                this.totalCopies = totalCopies;
            } else {
                throw new IllegalArgumentException("Total copies cannot be negative.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    
    
    public int getAvailableCopies() {
        return availableCopies;
    }
    public void setAvailableCopies(int availableCopies) {
        try {
            if (availableCopies >= 0) {
                this.availableCopies = availableCopies;
            } else {
                throw new IllegalArgumentException("Available copies cannot be negative.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;

    public LocalDateTime calculateDueDate() {
       // 10 days from now; assuming 1sec=1day
        return LocalDateTime.now().plusSeconds(10);
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate =dueDate;
    }
    public LocalDateTime getDueDate() {//store due date 
        return dueDate;
    }

    //imp 
    public LocalDateTime getReturnDate() {
        return LocalDateTime.now();
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}