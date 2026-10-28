abstract class Media {
    protected String title;

    Media(String title) {
        this.title = title;
    }

    abstract double lateFee(int lateDays);
}

class Book extends Media {
    Book(String title) {
        super(title);
    }

    @Override
    double lateFee(int lateDays) {
        return lateDays * 2.0;
    }
}

class DVD extends Media {
    DVD(String title) {
        super(title);
    }

    @Override
    double lateFee(int lateDays) {
        return lateDays * 5.0;
    }
}

class Magazine extends Media {
    Magazine(String title) {
        super(title);
    }

    @Override
    double lateFee(int lateDays) {
        return lateDays * 1.5;
    }
}