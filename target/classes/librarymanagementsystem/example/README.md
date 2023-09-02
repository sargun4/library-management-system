# Library Management System- ASGN1

### to compile the project using Maven and run the application

Use the "mvn clean install" command on the terminal to get the jar files

Then to run the compiled application, use
"java -jar target/library-management-system.jar"

OR

simply click the Debug java button

## Features

1. Book.java class
-represents a book in the library. It stores information about each bookID, title, author, total copies, available copies, due date for borrowed books, and return date for returned books. 

2. Member.java class
-represents a member in the library. It stores information about each member with a unique member ID, name, age, phone no., dues of the member, and also stores a list of the books the member has borrowed.

3. Library.java
-represents a library in a library management system. It provides methods for adding and removing books and members, finding members by name or phone number, finding books by ID, and displaying information about members and their borrowed books and fines.

4. LibraryManagementSystem.java class
- It provides an interface for interacting with the library as both a librarian and a member

Inside the LibraryManagementSystem: 
- Librarian functionalities: register member, remove member, add book, remove book, View all members along with their books and fines to be paid, View all books.
- Member functionalities: view available books, borrow book, return book, view borrowed books, pay dues.

###
- in the registerMember function, if the phone number is unique, it proceeds to create a new Member object with the inputted name, age & phone no. If not, then the isPhoneNoUsed func from the Library classs is called and you would have to use a unique phone no. which isnt already registered with the library

###
- in addbook, generateUniqueBookId is a func in which I return the current value of bookIdctr and then increment it by 1 which ensures that we get a unique BookID each time.


###
- the borrowBook func firstly gets the currently logged-in member using lib.getCurrentLoggedInMember();
if the member already has 2 borrowed books, it prints that they've reached the maximum borrowing limit, and func returns, preventing them from borrowing another book.

- It checks if the member has any borrowed books and, if so, iterates through them to check if any of the borrowed books are overdue. An overdue book is one where the current date is after the due date (after a 10-second period since we assume 1sec=1day). If an overdue book is found, it prints a message indicating that the member has an overdue book and cannot borrow another until it's returned. The function then returns, preventing further borrowing.

- If the book is not available (all copies are already borrowed), it prints a message indicating that the book is not available for borrowing, and the function returns.
If the book is available and all conditions are met, it calculates the due date for the book using bookToBorrow.calculateDueDate() and sets this due date in the book object using bookToBorrow.setDueDate(dueDate).

- It decrements both the available copies and total copies of the book by 1 (one more copy has been borrowed).

- It adds the borrowed book to the member's list of borrowed books using currMember.getBooksBorrowed().add(bookToBorrow).


### the returnBook
- It gets the list of books that the current member has borrowed using currMember.getBooksBorrowed().

- It checks if the list of borrowed books is empty, indicating that the member hasn't borrowed any books. If so, it prints a message stating that the member hasn't borrowed any books and returns, aborting the return process.

- It initializes a variable returndate to null. This variable will be used to store the return date of the book being returned.

- It then prints a list of borrowed books along with their Book ID, title, author, and return date (if set). This provides the member with a summary of the books they have borrowed.

- It prompts the user to enter the Book ID of the book they want to return.

- It reads the Book ID input from the user.

- It attempts to find the book with the given Book ID using lib.findBook(bookId).

- If the book is not found, or if the book with the given ID is not in the member's list of borrowed books, it prints a message indicating that the book was not found in the borrowed list, and the function returns, aborting the return process.

- It retrieves the due date of the book from the book object using bookToReturn.getDueDate() and stores it in a variable dueDate.

- It calculates the fine (if any) based on the due date and the actual return date. If the returndate is after the dueDate, it means the book is returned late, and a fine is calculated. The fine is calculated as 3 rupees per second for the duration the book is late.

- If a fine is applicable (i.e., returndate is after dueDate), it adds the fine amount to the member's dues using currMember.setDues(currMember.getDues() + fine) and prints a message indicating the fine amount.

- It updates the total copies of the book using lib.updateTotalCopies(bookToReturn.getBookId(), bookToReturn.getTotalCopies() + 1). This increases the total copies of the book as it's returned.

- It sets the return date of the book to the returndate using bookToReturn.setReturnDate(returndate).

- It increments the available copies of the book by 1 using bookToReturn.setAvailableCopies(bookToReturn.getAvailableCopies() + 1) to reflect that one more copy is available for borrowing.

- It removes the book from the member's list of borrowed books using booksBorrowed.remove(bookToReturn).

<!-- After returning the book, we update the available copies of the book by incrementing it by 1 (bookToReturn.setAvailableCopies(bookToReturn.getAvailableCopies() + 1)).

We also remove the book from the member's borrowed list (booksBorrowed.remove(bookToReturn)). -->


### the payDues 
- It starts by getting the currently logged-in member (the one who wants to pay their dues) using lib.getCurrentLoggedInMember() and stores it in the variable currMember.

- It retrieves the amount of dues that the current member has using currMember.getDues() and stores it in the variable dues.

- It prints a separator line to separate this action from previous menu output.

- It checks if the member has any dues (dues == 0). If the member has no dues, it prints a message indicating that there are no dues to pay, and the function returns, ending the dues payment process.

If the member has dues, it prints a message indicating the current amount of dues ("Your current dues: " + dues + " Rs.").

- It prompts the user to enter the amount they want to pay and reads the payment amount using double payment = sc.nextDouble();.

- It checks if the entered payment amount is less than or equal to zero (payment <= 0). If the payment amount is not valid (zero or negative), it prints a message indicating that the payment amount is invalid and returns, aborting the payment process.

- It checks if the entered payment amount is greater than the member's total dues (payment > dues). If the member is trying to pay more than their dues, it prints a message indicating that they cannot pay more than their dues, and the function returns, aborting the payment process.

If the payment amount is valid and less than or equal to the member's dues, it subtracts the payment amount from the member's dues using currMember.setDues(dues - payment) to update the remaining dues.

- It prints a success message indicating that the payment was successful, the amount paid (payment), and the remaining dues after the payment ("Payment of " + payment + " Rs. successfully done. Remaining dues: " + currMember.getDues()).