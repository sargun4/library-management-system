package librarymanagementsystem.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {
    private List<Book> books;
    private List<Member> members;
    private Member currentLoggedInMember; //keepin track of member

    public Member getCurrentLoggedInMember() { 
        return currentLoggedInMember;
    }
    public void setCurrentLoggedInMember(Member member) {
        this.currentLoggedInMember = member;
    }

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public boolean isPhoneNoUsed(String phoneNo) {
        for (Member member : members) {
            if (member.getphoneNo().equals(phoneNo)) {
                return true; //phone no is already in use
            }
        }
        return false; //phone no is not in use
    }
    
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }
    
    public List<Member> getMembers() {
        return members;
    }
    
    public void addBook(Book book) {
        try {
            books.add(book);
            System.out.println("Enter Total Copies:");
            Scanner sc = new Scanner(System.in);
            int totalCopies = sc.nextInt();
            sc.nextLine(); 
    
            if (totalCopies >= 0) {
                book.setTotalCopies(totalCopies); 
                book.setAvailableCopies(totalCopies);

                // System.out.println("Book Added Successfully! Book ID: " + bookId);
            } else {
                throw new IllegalArgumentException("Total copies cannot be negative.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void removeBook(int bookId) {
        try {
            Book bookToRemove = findBook(bookId);
            if (bookToRemove != null) {
                books.remove(bookToRemove);
                System.out.println("Book Removed Successfully!");
            } else {
                System.out.println("Book with ID " + bookId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void registerMember(Member member) {
        try {
            members.add(member);
            System.out.println("Member Successfully Registered with ID: " + member.getMemberId());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public void removeMember(int memberId) {
        try {
            Member memberToRemove = findMemberById(memberId);
            if (memberToRemove != null) {
                members.remove(memberToRemove);
                System.out.println("Member Removed Successfully!");
            } else {
                System.out.println("Member with ID " + memberId + " not found.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    public Member findMember(String name, String phoneNo) {//earches for a member by their name and phone no
        for (Member member : members) {
            if (member.getName().equals(name) && member.getphoneNo().equals(phoneNo)) {
                return member;
            }
        }
        return null; //Member not found
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null; //Book not found
    }

    private Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null; //Member not foun
    }
    public void viewAllMembersWithBooksAndFines() {
        System.out.println("Members with Borrowed Books and Fines:");
        
        for (Member member : members) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            System.out.println("Phone Number: " + member.getphoneNo());
            
            List<Book> borrowedBooks = member.getBooksBorrowed();
            
            if (borrowedBooks.isEmpty()) {
                System.out.println("No books borrowed.");
            } else {
                System.out.println("Borrowed Books:");
                for (Book book : borrowedBooks) {
                    System.out.println("- Book ID: " + book.getBookId());
                    System.out.println("- Title: " + book.getTitle());
                    System.out.println("- Author: " + book.getAuthor());
                }
            }
            
            double dues = member.getDues();
            System.out.println("Fines to be Paid: " + dues + " Rs.");
            System.out.println("--------------------------");
        }
    }
    

    public void updateTotalCopies(int bookId, int newTotalCopies) {
        Book bookToUpdate = findBook(bookId);
    
        if (bookToUpdate != null) {
            bookToUpdate.setTotalCopies(newTotalCopies);
            System.out.println("Total copies updated successfully!");
        } else {
            System.out.println("Book with ID " + bookId + " not found.");
        }
    }
    
}