# Library Management System- ASGN1

### to compile the project using Maven & run the application

Use the "mvn clean install" command on the terminal to get the jar files

Then to run the compiled application, use
"java -jar target/library-management-system.jar"

OR

simply click the Debug java button

## Features

1. Book.java class
-represents a book in the library. It stores information about each bookID, title, author, total copies, available copies, due date for borrowed books, & return date for returned books. 

2. Member.java class
-represents a member in the library. It stores information about each member with a unique member ID, name, age, phone no., dues of the member, & also stores a list of the books the member has borrowed.

3. Library.java
-represents a library in a library management system. It provides methods for adding & removing books & members, finding members by name or phone number, finding books by ID, & displaying information about members & their borrowed books & fines.


4. LibraryManagementSystem.java class
- It provides an interface for interacting with the library as both a librarian & a member

Inside the LibraryManagementSystem: 
- Librarian functionalities: register member, remove member, add book, remove book, View all members along with their books & fines to be paid, View all books.
- Member functionalities: view available books, borrow book, return book, view borrowed books, pay dues.

#### registerMember
- in the registerMember function, if the phone number is unique, it proceeds to create a new Member object with the inputted name, age & phone no. If not, then the isPhoneNoUsed func from the Library classs is called & you would have to use a unique phone no. which isnt already registered with the library

#### addbook
- in addbook, generateUniqueBookId is a func in which I return the current value of bookIdctr & then increment it by 1 which ensures that we get a unique BookID each time.


#### borrowBook
- the borrowBook func firstly gets the currently logged-in member using lib.getCurrentLoggedInMember();
if the member already has 2 borrowed books, it prints that they've reached the maximum borrowing limit, & func returns, preventing them from borrowing another book.

- It checks if the member has any borrowed books &, if so, iterates through them to check if any of the borrowed books are overdue. An overdue book is one where the current date is after the due date (after a 10-second time gap since we assume 1sec=1day). If an overdue book is found, it prints that the member has an overdue book & cannot borrow another until it's returned. The function then returns, preventing further borrowing.

- If the book is available & all conditions are met, it calculates the due date for the book using bookToBorrow.calculateDueDate() & sets this due date in the book object using bookToBorrow.setDueDate(dueDate).

- It decrements both the available copies & total copies of the book by 1 (since one copy has been borrowed).

- It adds the borrowed book to the member's list of borrowed books using currMember.getBooksBorrowed().add(bookToBorrow).


#### returnBook

- Initialized a variable returndate to null. This variable will be used to store the return date of the book being returned.

- It prompts the user to enter the Book ID of the book they want to return.

- If the book is not found, or if the book with the given ID is not in the member's list of borrowed books, it prints that the book was not found in the borrowed list, & the function returns.

- if its found, it retrieves the due date of the book from the book object using bookToReturn.getDueDate() & stores it in dueDate.

- time diff bw dueDate & returndate is calculated using ChronoUnit func in the java.time.temporal package.

            long secondsLate = ChronoUnit.SECONDS.between(dueDate, returndate);
            double fine = Math.round(Math.abs(secondsLate) * 3.0); // fine of 3 Rs per sec


- If a fine is applicable (i.e., returndate is after dueDate), it adds the fine amount to the member's dues using currMember.setDues(currMember.getDues() + fine) & prints the fine amount.

- It updates the total copies of the book using lib.updateTotalCopies(bookToReturn.getBookId(), bookToReturn.getTotalCopies() + 1). This increases the total copies of the book as it's returned.

- It sets the return date of the book to the returndate using bookToReturn.setReturnDate(returndate).

- It increments the available copies of the book by 1 using bookToReturn.setAvailableCopies(bookToReturn.getAvailableCopies() + 1) to reflect that one more copy is available for borrowing.

- It removes the book from the member's list of borrowed books using booksBorrowed.remove(bookToReturn) since book has been returnd to library.


#### payDues 

- It retrieves the amount of dues that the current member has using currMember.getDues() & stores it in the variable dues.

- It prompts the user to enter the amount they want to pay & reads the payment amount using double payment = sc.nextDouble();

- It checks if the entered payment amount is less than or equal to zero (payment <= 0). If the payment amount is not valid (zero or negative), it prints that the payment amount is invalid & returns. If the member is trying to pay more than their dues, it prints that they cannot pay more than their dues, & the function returns.

- If the payment amount is valid & less than or equal to the member's dues, it subtracts the payment amount from the member's dues using currMember.setDues(dues - payment) to update the remaining dues.
