package Book_Browsing_Json;

public class BookData {
    private String bookName;
    private String genre;
    private String isbn;
    private String publisher;
    private double price;
    private int copiesSold;

    public BookData() {
    }

    public String getBookName() {
        return bookName;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public double getPrice() {
        return price;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    @Override
    public String toString() {
        return "Title: " + bookName +
                ", Genre: " + genre +
                ", ISBN: " + isbn +
                ", Publisher: " + publisher +
                ", Price: " + price +
                ", Copies Sold: " + copiesSold;
    }
}