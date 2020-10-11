package hr.ja.myhttp.gui;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import spark.Request;
import spark.Response;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public abstract class Page extends Widget {

    private Breadcrumb breadcrumb;

    private String js;

    private String title;

    public void onRequest(Request req, Response resp, SiteContext siteContext) {

    }


    private List<Widget> widgets = new ArrayList<>();

    public void add(Widget widget) {
        widgets.add(widget);
    }


    public String link(String label, Class<? extends Page> pageClass) {
        return "???";
    }



    public String link(String label, String routeName) {
        //language=InjectedFreeMarker
        return "<a data-goto='%s' href='#%s'>%s</a>".formatted(routeName, routeName, label);
    }


}
