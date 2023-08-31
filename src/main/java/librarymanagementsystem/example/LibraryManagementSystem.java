package librarymanagementsystem.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        System.out.println("Library Portal Initialized");
        System.out.println("--------------------------");
        while (true) {
            System.out.println("1. Enter as librarian");
            System.out.println("2. Enter as member");
            System.out.println("3. Exit");
            System.out.println("--------------------------");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    librarianMenu(lib, sc);
                    break;
                case 2:
                    memberMenu(lib, sc);
                    break;
                case 3:
                    System.out.println("Thanks for visiting!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
    
    private static void librarianMenu(Library lib, Scanner sc) {
        System.out.println("--------------------------");
        while (true) {
            System.out.println("1. Register Member");
            System.out.println("2. Remove Member");
            System.out.println("3. Add Book");
            System.out.println("4. Remove Book");
            System.out.println("5. View all members along with their books and fines to be paid");
            System.out.println("6. View all books");
            System.out.println("7. Back");
        
            int choice = sc.nextInt();
            sc.nextLine();
        
            switch (choice) {
                case 1:
                    registerMember(lib, sc);
                    break;
                case 2:
                    removeMember(lib, sc);
                    break;
                case 3:
                    addBook(lib, sc);
                    break;
                case 4:
                    removeBook(lib, sc);
                    break;
                case 5:
                    lib.viewAllMembersWithBooksAndFines();
                    break;
                case 6:
                    listBooks(lib);
                    break;
                case 7:
                    System.out.println("Exiting the librarian menu.");
                    return; 
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }     
    }

    //librarian functionalities
    // Inside the registerMember function
    private static void registerMember(Library lib, Scanner sc) {
        System.out.println("--------------------------");

        System.out.println("Enter Member Name:");
        String name = sc.nextLine();

        System.out.println("Enter Member Age:");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Member Phone Number:");
        String phoneNo = sc.nextLine();
        System.out.println("--------------------------");
        Member newMember = new Member(name, age, phoneNo);
        lib.registerMember(newMember);

        // System.out.println("Member Successfully Registered with ID: " + newMember.getMemberId() );
    }

    private static void removeMember(Library lib, Scanner sc) {
        System.out.println("--------------------------");
        System.out.println("Enter Member ID to Remove:");
        int memberId = sc.nextInt();
        sc.nextLine();
    
        lib.removeMember(memberId);
    }
    private static void addBook(Library lib, Scanner sc) {
        System.out.println("--------------------------");
        System.out.println("Enter Book ID:");
        int bookId = sc.nextInt();
        sc.nextLine();
    
        System.out.println("Enter Book Title:");
        String title = sc.nextLine();
    
        System.out.println("Enter Author Name:");
        String author = sc.nextLine();

        System.out.println("--------------------------");
        // System.out.println("Enter Total Copies:");
        // int totalCopies = sc.nextInt();
        // sc.nextLine();
        Book newBook = new Book(bookId, title, author);
        lib.addBook(newBook);
    }
    
    private static void removeBook(Library lib, Scanner sc) {
        System.out.println("--------------------------");
        System.out.println("Enter Book ID to Remove:");
        int bookId = sc.nextInt();
        sc.nextLine();
        lib.removeBook(bookId);
        System.out.println("--------------------------");
    }
    
    
    
    private static void listBooks(Library lib) {
        List<Book> books = lib.getAvailableBooks();
        System.out.println("--------------------------");
        System.out.println("List of Available Books:");
        
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
    
        for (Book book : books) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Total Copies: " + book.getTotalCopies());
            System.out.println("Available Copies: " + book.getAvailableCopies());
            System.out.println("--------------------------");
        }
    }
    
    private static void listMembers(Library lib) {
        List<Member> members = lib.getMembers();
        System.out.println("--------------------------");
        System.out.println("List of Registered Members:");
    
        if (members.isEmpty()) {
            System.out.println("No members at the moment.");
            return;
        }
    
        for (Member member : members) {
            System.out.println("Member ID: " + member.getMemberId());
            System.out.println("Name: " + member.getName());
            System.out.println("Age: " + member.getAge());
            System.out.println("Phone Number: " + member.getphoneNo());
            System.out.println("--------------------------");
        }
    }
    
    private static void memberMenu(Library lib, Scanner sc) {
        System.out.println("--------------------------");
        System.out.println("Enter Member Name:");
        String name = sc.nextLine();
    
        System.out.println("Enter Member Phone Number:");
        String phoneNo = sc.nextLine();
    
        Member currMember = lib.findMember(name, phoneNo);
    
        if (currMember == null) {
            System.out.println("Member not found.");
            return;
        }
    
        lib.setCurrentLoggedInMember(currMember); // Set the currently logged-in member
    
        while (true) {
            System.out.println("Member Menu:");
            System.out.println("1. View Available Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. View My Books");
            System.out.println("5. Pay Dues");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
    
            switch (choice) {
                case 1:
                    viewAvailableBooks(lib);
                    break;
                case 2:
                    borrowBook(lib, sc);
                    break;
                case 3:
                    returnBook(lib, sc);
                    break;
                case 4:
                    viewMyBooks(lib);
                    break;
                case 5:
                    payDues(lib, sc);
                    break;
                case 6:
                    lib.setCurrentLoggedInMember(null); // Log out the member
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
    private static void viewAvailableBooks(Library lib) {
        List<Book> availableBooks = lib.getAvailableBooks();
        System.out.println("--------------------------");
        System.out.println("Available Books:");
        for (Book book : availableBooks) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Total Copies: " + book.getTotalCopies());
            System.out.println("---------------------------------");
        }
    }
    
    // borr
    private static void borrowBook(Library lib, Scanner sc) {
        System.out.println("--------------------------");
        System.out.println("Enter the Book ID to borrow:");
        int bookId = sc.nextInt();
        sc.nextLine();
    
        Member currMember = lib.getCurrentLoggedInMember();
    
        Book bookToBorrow = lib.findBook(bookId);
    
        if (bookToBorrow == null) {
            System.out.println("Book with ID " + bookId + " not found.");
            return;
        }
    
        if (currMember.getBooksBorrowed().size() >= 2) {
            System.out.println("You've reached the maximum borrowing limit.");
            return;
        }
    
        if (!bookToBorrow.isAvailable()) {
            System.out.println("Sorry, the book is not available for borrowing.");
            return;
        }
    
        LocalDateTime dueDate = bookToBorrow.calculateDueDate();
        bookToBorrow.setDueDate(dueDate); 

        bookToBorrow.setAvailableCopies(bookToBorrow.getAvailableCopies() - 1);
        currMember.getBooksBorrowed().add(bookToBorrow);

        //due date is 10 sec after borrowed time
        System.out.println("Book successfully borrowed! Due date: " + dueDate);
        }    
            
        
    private static void returnBook(Library lib, Scanner sc) {
        System.out.println("--------------------------");
        Member currMember = lib.getCurrentLoggedInMember();
        List<Book> booksBorrowed = currMember.getBooksBorrowed();
        
        if (booksBorrowed.isEmpty()) {
            System.out.println("You haven't borrowed any books.");
            return;
        }
        
        LocalDateTime returndate = null;
    
        System.out.println("Borrowed Books:");
        for (Book book : booksBorrowed) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
    
            returndate = book.getReturnDate(); // Assign val
    
            System.out.println("Return Date: " + (returndate != null ? returndate : "Not set"));
            System.out.println("---------------------------------");
        }
        
        System.out.println("Enter the Book ID to return:");
        int bookId = sc.nextInt();
        sc.nextLine();
        
        Book bookToReturn = lib.findBook(bookId);
        
        if (bookToReturn == null || !booksBorrowed.contains(bookToReturn)) {
            System.out.println("Book not found in your borrowed list.");
            return;
        }
        
        LocalDateTime currDate = LocalDateTime.now(); 
        LocalDateTime dueDate = bookToReturn.getDueDate(); //stored due date
        
        System.out.printf("Due date: %s%n", dueDate);
        System.out.printf("return date: %s%n", returndate);//ythis is the return date
        

        ///calc fine if due date is passed
        if (dueDate != null && returndate.isAfter(dueDate)) {
            long secondsLate = ChronoUnit.SECONDS.between(dueDate, returndate);
            //logic-taking rounded off val of absolute diff of dueDate & returndate
            double fine = Math.round(Math.abs(secondsLate) * 3.0); // fine of 3 Rs per sec
            currMember.setDues(currMember.getDues() + fine);
            System.out.println("A fine of " + fine + " rupees has been applied for late return.");
        }

        bookToReturn.setReturnDate(currDate);

        bookToReturn.setAvailableCopies(bookToReturn.getAvailableCopies() + 1);
        booksBorrowed.remove(bookToReturn);

        System.out.println("Book successfully returned!");
    }
        
    private static void viewMyBooks(Library lib) {
        Member currMember = lib.getCurrentLoggedInMember();
        List<Book> booksBorrowed = currMember.getBooksBorrowed();
    
        if (booksBorrowed.isEmpty()) {
            System.out.println("You haven't borrowed any books.");
            return;
        }
    
        System.out.println("Borrowed Books:");
        for (Book book : booksBorrowed) {
            System.out.println("Book ID: " + book.getBookId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("---------------------------------");
        }
    }
    
    private static void payDues(Library lib, Scanner sc) {
        Member currMember = lib.getCurrentLoggedInMember();
        double dues = currMember.getDues();
    
        if (dues == 0) {
            System.out.println("You don't have any dues.");
            return;
        }
    
        System.out.println("Your current dues: " + dues + " Rs.");
        System.out.println("Enter the amount to pay:");
        double payment = sc.nextDouble();
        sc.nextLine();
    
        if (payment <= 0) {
            System.out.println("Invalid payment amount.");
            return;
        }
        if (payment > dues) {
            System.out.println("You cannot pay more than your dues.");
            return;
        }
        currMember.setDues(dues - payment);
        System.out.println("Payment of " + payment + " Rs. successfully done. Remaining dues: " + currMember.getDues());
    }
    
}
