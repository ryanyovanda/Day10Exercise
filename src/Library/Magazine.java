package org.example.Library;

public class Magazine extends Book {
    private String interval;

    Magazine(String itemName, String publisher, int pages, String interval, int stock) {
        super(itemName, publisher, pages, stock);
        this.interval = interval;
    }

    public String getInterval() {
        return interval;
    }
}
