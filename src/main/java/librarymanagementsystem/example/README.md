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

