package org.example.Library;

import java.util.HashMap;
import java.util.Scanner;

public class SubMenu {
    private User user = null;
    private Scanner scanner;
    private HashMap<String, Comic> comicHashMap;
    private HashMap<String, Magazine> magazineHashMap;
    private HashMap<String, DVD> dvdHashMap;

    SubMenu(User user, Scanner scanner, HashMap<String, Comic> comicHashMap, HashMap<String, Magazine> magazineHashMap, HashMap<String, DVD> dvdHashMap) {
        this.user = user;
        this.scanner = scanner;
        this.comicHashMap = comicHashMap;
        this.magazineHashMap = magazineHashMap;
        this.dvdHashMap = dvdHashMap;
    }

    public void run() {
        System.out.println("======= \t \tWellcome " + this.user.getUserName() + " \t\t=======");
        System.out.println("1. View libraries.");
        System.out.println("2. View borrowed items.");
        System.out.println("3. Borrow item. (ID Required)");
        System.out.println("4. Return item. (ID Required)");
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
                borrowItem();
                run();
                break;
            case 4:
                returnItem();
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
        if (this.user.getComicHashMap().isEmpty() && this.user.getMagazineHashMap().isEmpty() && this.user.getDVDHashMap().isEmpty()) {
            System.out.println("You don't have any borrowed items.");
        } else {
            System.out.println("======= \t \tBORROWED ITEMS \t\t=======");
        }
        if (!this.user.getComicHashMap().isEmpty()) {
            System.out.println("------- \t \tCOMIC LIST \t\t-------");
            for (String key : this.user.getComicHashMap().keySet()) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + this.user.getComicHashMap().get(key).getId().toString());
                System.out.println("Title : " + this.user.getComicHashMap().get(key).getItemName());
                System.out.println("Genre : " + this.user.getComicHashMap().get(key).getGenre());
                System.out.println("Volumes : " + this.user.getComicHashMap().get(key).getVolume());
                System.out.println("Publisher : " + this.user.getComicHashMap().get(key).getPublisher());
                System.out.println("Pages : " + this.user.getComicHashMap().get(key).getPages());
            }
            System.out.println("-------------------------------------");
        }
        if (!this.user.getMagazineHashMap().isEmpty()) {
            System.out.println("------- \t \tMAGAZINE LIST \t\t-------");
            for (String key : this.user.getMagazineHashMap().keySet()) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + this.user.getMagazineHashMap().get(key).getId().toString());
                System.out.println("Title : " + this.user.getMagazineHashMap().get(key).getItemName());
                System.out.println("Interval : " + this.user.getMagazineHashMap().get(key).getInterval());
                System.out.println("Publisher : " + this.user.getMagazineHashMap().get(key).getPublisher());
                System.out.println("Pages : " + this.user.getMagazineHashMap().get(key).getPages());
            }
            System.out.println("-------------------------------------");
        }
        if (!this.user.getDVDHashMap().isEmpty()) {
            System.out.println("------- \t \tDVD LIST \t\t-------");
            for (String key : this.user.getDVDHashMap().keySet()) {
                System.out.println("-------------------------------------");
                System.out.println("ID : " + this.user.getDVDHashMap().get(key).getId().toString());
                System.out.println("Title : " + this.user.getDVDHashMap().get(key).getItemName());
                System.out.println("Content Length : " + this.user.getDVDHashMap().get(key).getContentLength());
                System.out.println("Publisher : " + this.user.getDVDHashMap().get(key).getPublisher());
            }
            System.out.println("-------------------------------------");
        }
    }

    private void borrowItem() {
        try {
            String id = Utils.scanText(this.scanner, "ID : ");
            if (this.comicHashMap.containsKey(id) && this.comicHashMap.get(id).getAvailable() > 0 && this.user.getComicHashMap().get(id) == null) {
                if (!this.user.addComic(this.comicHashMap.get(id)))
                    throw new RuntimeException();
                this.comicHashMap.get(id).actionBorrowing();
                System.out.println("Comic borrowed.");
            } else if (this.magazineHashMap.containsKey(id) && this.magazineHashMap.get(id).getAvailable() > 0 && this.user.getMagazineHashMap().get(id) == null) {
                if (!this.user.addMagazine(this.magazineHashMap.get(id)))
                    throw new RuntimeException();
                this.magazineHashMap.get(id).actionBorrowing();
                System.out.println("Magazine borrowed.");
            } else if (this.dvdHashMap.containsKey(id) && this.dvdHashMap.get(id).getAvailable() > 0 && this.user.getDVDHashMap().get(id) == null) {
                if (!this.user.addDVD(this.dvdHashMap.get(id)))
                    throw new RuntimeException();
                this.dvdHashMap.get(id).actionBorrowing();
                System.out.println("DVD borrowed.");
            } else {
                throw new RuntimeException("Item not available.");
            }
        } catch (Exception e) {
            System.out.println("Borrowing item failed.");
            System.out.println("Reason : " + e.getMessage());
        }
    }

    private void returnItem() {
        try {
            String id = Utils.scanText(this.scanner, "ID : ");
            if (this.user.getComicHashMap().get(id) != null) {
                if (!this.user.removeComic(id))
                    throw new RuntimeException();
                this.comicHashMap.get(id).actionReturning();
                System.out.println("Comic returned.");
            } else if (this.user.getMagazineHashMap().get(id) != null) {
                if (!this.user.removeMagazine(id))
                    throw new RuntimeException();
                this.magazineHashMap.get(id).actionReturning();
                System.out.println("Magazine returned.");
            } else if (this.user.getDVDHashMap().get(id) != null) {
                if (!this.user.removeDVD(id))
                    throw new RuntimeException();
                this.dvdHashMap.get(id).actionReturning();
                System.out.println("DVD returned.");
            } else {
                throw new RuntimeException("Item not found");
            }
        } catch (Exception e) {
            System.out.println("Returning item failed.");
            System.out.println("Reason : " + e.getMessage());
        }
    }
}
