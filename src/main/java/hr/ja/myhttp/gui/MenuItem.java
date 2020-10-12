package hr.ja.myhttp.gui;

import hr.ja.myhttp.util.Page;
import lombok.extern.slf4j.Slf4j;

public class MenuItem {


    private String name;
    private Class<? extends Page> pageClass;

    public MenuItem(String name, Class<? extends Page> pageClass) {
        this.name = name;
        this.pageClass = pageClass;
    }
}
