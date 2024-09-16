package org.example.Library;

public class Book extends LibraryItem {
    protected int pages;

    Book(String itemName, String publisher, int pages, int stock) {
        super(itemName, publisher, stock);
        this.pages = pages;
    }

    int getPages() {
        return this.pages;
    }

}
