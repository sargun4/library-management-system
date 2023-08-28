package librarymanagementsystem.example;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private static int memberIdctr = 1;
    private int memberId;
    private String name;
    private int age;
    private String phoneNo;
    private double dues;
    private List<Book> booksBorrowed;

    public Member(String name, int age, String phoneNo) {
        this.memberId = memberIdctr++; //assigning member id's frm 1 in th order they are being registered in lib
        this.name = name;
        this.age = age;
        this.phoneNo = phoneNo;
        this.dues = 0; //initially no dues
        this.booksBorrowed = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }
    // public void setMemberId(int memberId) {
    //     this.memberId = memberId;
    // }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getphoneNo() {
        return phoneNo;
    }
    public double getDues() {
        return dues;
    }
    public void setDues(double dues) {
        this.dues = dues;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }
    public void setBorrowedBooks(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }
}
