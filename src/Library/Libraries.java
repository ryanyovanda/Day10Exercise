package org.example.Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Libraries {

    public static HashMap<String, Comic> getComics() {
        HashMap<String, Comic> comicMap = new HashMap<>();
        Comic newComic = new Comic("Naruto", "Shueisha", 35, "action", 1,2);
        comicMap.put(newComic.getId().toString(), newComic);
        newComic = new Comic("Naruto", "Shueisha", 40, "action", 2,2);
        comicMap.put(newComic.getId().toString(), newComic);
        newComic = new Comic("Bleach", "Shueisha", 45, "romance, action", 10,2);
        comicMap.put(newComic.getId().toString(), newComic);
        return comicMap;
    }

    public static HashMap<String, Magazine> getMagazines() {
        HashMap<String, Magazine> magazineMap = new HashMap<>();
        Magazine newMagazine = new Magazine("Shonen Jump Weekly", "Shueisha", 300, "Weekly",2);
        magazineMap.put(newMagazine.getId().toString(), newMagazine);
        newMagazine = new Magazine("Shonen Jump Monthly", "Shueisha", 500, "Monthly",2);
        magazineMap.put(newMagazine.getId().toString(), newMagazine);
        newMagazine = new Magazine("Monthly Sunday Gene-X", "Shogakukan", 120, "Monthly",2);
        magazineMap.put(newMagazine.getId().toString(), newMagazine);
        return magazineMap;
    }

    public static HashMap<String, DVD> getDVDs() {
        HashMap<String, DVD> dvdMap = new HashMap<>();
        DVD dvd = new DVD("The Lord of the Rings", "Amazon MGM Studios", "1hr20min",2);
        dvdMap.put(dvd.getId().toString(), dvd);
        dvd = new DVD("The Lord of the Rings 2", "Amazon MGM Studios", "3hr40min",2);
        dvdMap.put(dvd.getId().toString(), dvd);
        dvd = new DVD("The Lord of the Rings 3", "Amazon MGM Studios", "2hr10min",2);
        dvdMap.put(dvd.getId().toString(), dvd);
        return dvdMap;
    }
}
