package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.Widget;
import hr.ja.myhttp.util.Page;

public class BasePage extends Page {

    public String link(String label, Class<? extends Page> pageClass) {
        return "???";
    }


    public String link(String label, String routeName) {
        //language=InjectedFreeMarker
        return "<a data-goto='%s' href='#%s'>%s</a>".formatted(routeName, routeName, label);
    }

    public String getPageRouteName(Class<? extends Page> pageClass) {
        return "";
    }
}
