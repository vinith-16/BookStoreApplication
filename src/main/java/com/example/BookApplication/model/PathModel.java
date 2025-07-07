package com.example.BookApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SMS")
public class PathModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookNo;

    @Column(name = "title")
    private String title;
    
    @Column(name = "author")
    private String author;
    
    @Column(name = "publisher")
    private String publisher;
    
    @Column(name = "category")
    private String category;
    
    @Column(name = "price")
    private long price;

    public PathModel() {
    }

    public PathModel(Long bookNo, String title, String author, String publisher, String category, int price) {
        this.bookNo = bookNo;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.category = category;
        this.price = price;
    }

    public Long getBookNo() {
        return bookNo;
    }

    public void setBookNo(Long bookNo) {
        this.bookNo = bookNo;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

   /* @Override
    public String toString() {
        return "PathModel [bookNo=" + bookNo + ", title=" + title + ", author=" + author +
                ", publisher=" + publisher + ", category=" + category + ", price=" + price + "]";
    }*/
}
