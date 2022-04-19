package Session11.Asissgnment1;

import java.util.Date;

public class Book {
    public Integer Id;
    public String BookName;
    public String PubliisherName;
    public Date PubliishYear;
    public String Author;
    public Double Price;

    public Book(Integer Id, String bookName, String publiisherName, Date publiishYear, String author, Double price) {
        Id = Id;
        BookName = bookName;
        PubliisherName = publiisherName;
        PubliishYear = publiishYear;
        Author = author;
        Price = price;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getPubliisherName() {
        return PubliisherName;
    }

    public void setPubliisherName(String publiisherName) {
        PubliisherName = publiisherName;
    }

    public Date getPubliishYear() {
        return PubliishYear;
    }

    public void setPubliishYear(Date publiishYear) {
        PubliishYear = publiishYear;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }
}
