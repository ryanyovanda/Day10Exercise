package org.example.Library;

public class DVD extends LibraryItem {
    private String contentLength;

    DVD(String itemName, String publisher, String contentLength, int stock) {
        super(itemName, publisher, stock);
        this.contentLength = contentLength;
    }

    public String getContentLength() {
        return contentLength;
    }
}
