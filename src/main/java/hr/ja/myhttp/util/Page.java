package hr.ja.myhttp.util;

import hr.ja.myhttp.form.FormUtil;
import hr.ja.myhttp.form.FormWidget;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.gui.Widget;
import hr.ja.myhttp.util.PageHolder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import spark.Request;
import spark.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Page extends Widget {

    private String js;

    private String title;

    private List<Widget> widgets = new ArrayList<>();

    public void onRequest(HttpServletRequest req, HttpServletResponse resp, SiteContext siteContext) {
    }

    public void add(Widget widget) {
        widgets.add(widget);
    }

    public WebSite getWebSite() {
        return new WebSite();
    }

    public FormWidget form(Object o) {
        return FormUtil.toForm(o);
    }

}
