package hr.ja.myhttp.gui;

import lombok.Data;

import java.util.TreeMap;
import java.util.TreeSet;

@Data
public class Menu {

    private TreeSet<MenuItem> items = new TreeSet<>();

    public void add(MenuItem menuItem) {
        items.add(menuItem);
    }
}
