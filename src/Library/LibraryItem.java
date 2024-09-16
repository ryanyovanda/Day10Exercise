package org.example.Library;

import java.util.UUID;

public class LibraryItem {
    protected String itemName;
    protected String publisher;
    protected UUID id;
    protected int stock;
    protected int available;

    LibraryItem(String itemName, String publisher, int stock) {
        this.itemName = itemName;
        this.publisher = publisher;
        this.id = UUID.randomUUID();
        this.stock = stock;
        this.available = stock;
    }

    public UUID getId() {
        return this.id;
    }

    String getItemName() {
        return this.itemName;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public int getStock() {
        return this.stock;
    }

    public int getAvailable() {
        return this.available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public void actionBorrowing() {
        if (this.available > 0) {
            this.available--;
        } else {
            System.out.println("Item is not available.");
        }
    }

    public void actionReturning() {
        this.available++;
    }
}
