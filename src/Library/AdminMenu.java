package org.example.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    private List<User> userList = new ArrayList<>();
    private Scanner scanner;
    private HashMap<String, Comic> comicHashMap;
    private HashMap<String, Magazine> magazineHashMap;
    private HashMap<String, DVD> dvdHashMap;

    AdminMenu(List<User> userList, Scanner scanner, HashMap<String, Comic> comicHashMap, HashMap<String, Magazine> magazineHashMap, HashMap<String, DVD> dvdHashMap) {
        this.userList = userList;
        this.scanner = scanner;
        this.comicHashMap = comicHashMap;
        this.magazineHashMap = magazineHashMap;
        this.dvdHashMap = dvdHashMap;
    }

    public void run() {
        System.out.println("======= \t \tWellcome ADMIN \t\t=======");
        System.out.println("1. View libraries.");
        System.out.println("2. View borrowed items.");
        System.out.println("3. Add Item.");
        System.out.println("4. Delete item. (ID Required)");
        System.out.println("5. Logout");
        int selection = Utils.scanInt(this.scanner, "Selection : ");
        switch (selection) {
            case 1:
                printLibraries();
                run();
                break;
            case 2:
                printBorrowedItems();
                run();
                break;
            case 3:
                addItem();
                run();
                break;
            case 4:
                deleteItem();
                run();
                break;
            case 5:
                System.out.println("Logged out.");
                break;
            default:
                System.out.println("Selection is not available.");
                run();
        }
    }

    private void printLibraries() {
        if (this.comicHashMap.isEmpty() && this.magazineHashMap.isEmpty() && this.dvdHashMap.isEmpty()) {
            System.out.println("Library is empty.");
        } else {
            System.out.println("======= \t \tLIBRARIES \t\t=======");
        }
        if (!this.comicHashMap.isEmpty()) {
            System.out.println("------- \t \tCOMIC LIST \t\t-------");
            for (String key : this.comicHashMap.keySet()) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + this.comicHashMap.get(key).getId().toString());
                System.out.println("Title : " + this.comicHashMap.get(key).getItemName());
                System.out.println("Genre : " + this.comicHashMap.get(key).getGenre());
                System.out.println("Volumes : " + this.comicHashMap.get(key).getVolume());
                System.out.println("Publisher : " + this.comicHashMap.get(key).getPublisher());
                System.out.println("Pages : " + this.comicHashMap.get(key).getPages());
                System.out.println("Stock : " + this.comicHashMap.get(key).getAvailable() + "/" + this.comicHashMap.get(key).getStock());
            }
            System.out.println("-------------------------------------");
        }
        if (!this.magazineHashMap.isEmpty()) {
            System.out.println("------- \t \tMAGAZINE LIST \t\t-------");
            for (String key : this.magazineHashMap.keySet()) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + this.magazineHashMap.get(key).getId().toString());
                System.out.println("Title : " + this.magazineHashMap.get(key).getItemName());
                System.out.println("Interval : " + this.magazineHashMap.get(key).getInterval());
                System.out.println("Publisher : " + this.magazineHashMap.get(key).getPublisher());
                System.out.println("Pages : " + this.magazineHashMap.get(key).getPages());
                System.out.println("Stock : " + this.magazineHashMap.get(key).getAvailable() + "/" + this.magazineHashMap.get(key).getStock());
            }
            System.out.println("-------------------------------------");
        }
        if (!this.dvdHashMap.isEmpty()) {
            System.out.println("------- \t \tDVD LIST \t\t-------");
            for (String key : this.dvdHashMap.keySet()) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + this.dvdHashMap.get(key).getId().toString());
                System.out.println("Title : " + this.dvdHashMap.get(key).getItemName());
                System.out.println("Content Length : " + this.dvdHashMap.get(key).getContentLength());
                System.out.println("Publisher : " + this.dvdHashMap.get(key).getPublisher());
                System.out.println("Stock : " + this.dvdHashMap.get(key).getAvailable() + "/" + this.dvdHashMap.get(key).getStock());
            }
            System.out.println("-------------------------------------");
        }
    }

    private void printBorrowedItems() {
        boolean found = false;
        if (userList.size() <= 1) {
            System.out.println("Nothing found.");
            return;
        }
        for (User user : this.userList) {
            if (user.checkSuperUser()) {
                continue;
            }
            if (user.getComicHashMap().isEmpty() && user.getMagazineHashMap().isEmpty() && user.getDVDHashMap().isEmpty()) {
                continue;
            } else {
                System.out.println("======= \t \tUSER : " + user.getUserName() + " \t\t=======");
                System.out.println("======= \t \tBORROWED ITEMS \t\t=======");
                found = true;
            }
            if (!user.getComicHashMap().isEmpty()) {
                System.out.println("------- \t \tCOMIC LIST \t\t-------");
                for (String key : user.getComicHashMap().keySet()) {
                    System.out.println("-------------------------------------");
                    System.out.println("ID : " + user.getComicHashMap().get(key).getId().toString());
                    System.out.println("Title : " + user.getComicHashMap().get(key).getItemName());
                    System.out.println("Genre : " + user.getComicHashMap().get(key).getGenre());
                    System.out.println("Volumes : " + user.getComicHashMap().get(key).getVolume());
                    System.out.println("Publisher : " + user.getComicHashMap().get(key).getPublisher());
                    System.out.println("Pages : " + user.getComicHashMap().get(key).getPages());
                }
                System.out.println("-------------------------------------");
            }
            if (!user.getMagazineHashMap().isEmpty()) {
                System.out.println("------- \t \tMAGAZINE LIST \t\t-------");
                for (String key : user.getMagazineHashMap().keySet()) {
                    System.out.println("-------------------------------------");
                    System.out.println("ID : " + user.getMagazineHashMap().get(key).getId().toString());
                    System.out.println("Title : " + user.getMagazineHashMap().get(key).getItemName());
                    System.out.println("Interval : " + user.getMagazineHashMap().get(key).getInterval());
                    System.out.println("Publisher : " + user.getMagazineHashMap().get(key).getPublisher());
                    System.out.println("Pages : " + user.getMagazineHashMap().get(key).getPages());
                }
                System.out.println("-------------------------------------");
            }
            if (!user.getDVDHashMap().isEmpty()) {
                System.out.println("------- \t \tDVD LIST \t\t-------");
                for (String key : user.getDVDHashMap().keySet()) {
                    System.out.println("-------------------------------------");
                    System.out.println("ID : " + user.getDVDHashMap().get(key).getId().toString());
                    System.out.println("Title : " + user.getDVDHashMap().get(key).getItemName());
                    System.out.println("Content Length : " + user.getDVDHashMap().get(key).getContentLength());
                    System.out.println("Publisher : " + user.getDVDHashMap().get(key).getPublisher());
                }
                System.out.println("-------------------------------------");
            }
        }
        if (!found) {
            System.out.println("Nothing found.");
        }
    }

    public void addItem() {
        System.out.println("======= \t \tADD ITEM \t\t=======");
        System.out.println("1. Comic.");
        System.out.println("2. Magazine.");
        System.out.println("3. DVD.");
        System.out.println("4. Back.");
        int selection = Utils.scanInt(this.scanner, "Selection : ");
        switch (selection) {
            case 1:
                addComic();
                break;
            case 2:
                addMagazine();
                break;
            case 3:
                addDVD();
                break;
            case 4:
                break;
            default:
                System.out.println("Selection is not available.");
                addItem();
        }
    }

    private void addComic() {
        try {
            String itemName = Utils.scanText(this.scanner, "Title : ");
            String publisher = Utils.scanText(this.scanner, "Publisher : ");
            int pages = Utils.scanInt(this.scanner, "Pages : ");
            String genre = Utils.scanText(this.scanner, "Genre : ");
            int volume = Utils.scanInt(this.scanner, "Volume : ");
            int stock = Utils.scanInt(this.scanner, "Stock : ");
            Comic newComic = new Comic(itemName, publisher, pages, genre, volume, stock);
            this.comicHashMap.put(newComic.getId().toString(), newComic);
        } catch (Exception e) {
            System.out.println("Error adding Comic.");
            System.out.println("Reason : " + e.getMessage());
        }
    }

    private void addMagazine() {
        try {
            String itemName = Utils.scanText(this.scanner, "Title : ");
            String publisher = Utils.scanText(this.scanner, "Publisher : ");
            int pages = Utils.scanInt(this.scanner, "Pages : ");
            String interval = Utils.scanText(this.scanner, "Interval : ");
            int stock = Utils.scanInt(this.scanner, "Stock : ");
            Magazine newMagazine = new Magazine(itemName, publisher, pages, interval, stock);
            this.magazineHashMap.put(newMagazine.getId().toString(), newMagazine);
        } catch (Exception e) {
            System.out.println("Error adding Magazine.");
            System.out.println("Reason : " + e.getMessage());
        }
    }

    private void addDVD() {
        try {
            String itemName = Utils.scanText(this.scanner, "Title : ");
            String publisher = Utils.scanText(this.scanner, "Publisher : ");
            String contentLength = Utils.scanText(this.scanner, "Content Length : ");
            int stock = Utils.scanInt(this.scanner, "Stock : ");
            DVD dvd = new DVD(itemName, publisher, contentLength, stock);
            this.dvdHashMap.put(dvd.getId().toString(), dvd);
        } catch (Exception e) {
            System.out.println("Error adding DVD.");
            System.out.println("Reason : " + e.getMessage());
        }
    }

    private void deleteItem() {
        try {
            String id = Utils.scanText(this.scanner, "ID : ");
            if (this.comicHashMap.get(id) != null) {
                if (this.comicHashMap.get(id).getAvailable() != this.comicHashMap.get(id).getStock())
                    throw new RuntimeException("Someone is still borrowing this comic.");
                this.comicHashMap.remove(id);
                System.out.println("Comic deleted.");
            } else if (this.magazineHashMap.get(id) != null) {
                if (this.magazineHashMap.get(id).getAvailable() != this.magazineHashMap.get(id).getStock())
                    throw new RuntimeException("Someone is still borrowing this magazine.");
                this.magazineHashMap.remove(id);
                System.out.println("Magazine deleted.");
            } else if (this.dvdHashMap.get(id) != null) {
                if (this.dvdHashMap.get(id).getAvailable() != this.dvdHashMap.get(id).getStock())
                    throw new RuntimeException("Someone is still borrowing this DVD.");
                this.dvdHashMap.remove(id);
                System.out.println("DVD deleted.");
            } else {
                throw new RuntimeException("Item not found");
            }
        } catch (Exception e) {
            System.out.println("Deleting item failed.");
            System.out.println("Reason : " + e.getMessage());
        }
    }
}
