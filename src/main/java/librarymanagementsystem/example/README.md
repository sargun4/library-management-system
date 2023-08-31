# Library Management System

This is a Java-based Library Management System that allows librarians to manage books and members, and members to borrow and return books.

## Getting Started

These instructions will guide you on how to set up and run the Library Management System on your local machine.

### Prerequisites

- Java Development Kit (JDK) installed
- Apache Maven installed

### Installing

1. Clone the repository to your device:

git clone https://github.com/your-username/library-management-system.git

2. Navigate to the project directory:

cd library-management-system

3. Compile the project using Maven:

mvn clean compile

## Running the Application

1. Run the application using the following command:

mvn exec:java -Dexec.mainClass="# library-management-system.example.LibraryManagementSystem"

2. Follow the on-screen prompts to use the Library Management System.

## Features

Inside the LibraryManagementSystem: 
- Librarian functionalities: register member, remove member, add book, remove book, View all members along with their books and fines to be paid, View all books.
- Member functionalities: view available books, borrow book, return book, view borrowed books, pay dues.

