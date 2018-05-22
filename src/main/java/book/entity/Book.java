package book.entity;

import javax.persistence.Entity;

@Entity
public class Book {
   public int ISBN;
   public String book_Title;

    public int edition_Number;

    public int copy_right;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookTitle() {
        return book_Title;
    }

    public void setBookTitle(String bookTitle) {
        book_Title = bookTitle;
    }

    public int getEdition_Number() {
        return edition_Number;
    }

    public void setEdition_Number(int edition_Number) {
        edition_Number = edition_Number;
    }

    public int getCopy_right() {
        return copy_right;
    }

    public void setCopy_right(int copy_right) {
        copy_right = copy_right;
    }
}
