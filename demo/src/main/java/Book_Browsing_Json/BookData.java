package Book_Browsing_Json;

public class BookData {
    private String title;
    private String genre;
    private String isbn;
    private String publisher;
    private double price;
    private double rating;
    private int copiesSold;

    public BookData() {
    }

    public String getTitle() {
        return title;
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

    public double getRating() {
        return rating;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Genre: " + isbn +
                ", ISBN: " + isbn +
                ", Publisher: " + publisher +
                ", Price: " + price +
                ", Rating: " + rating +
                ", Copies Sold: " + copiesSold;
    }

}