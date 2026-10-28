public interface Printable {
    void print();
}

class Book implements Printable {
    private String title;

    Book(String title) {
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
    }
}