package hr.ja.myhttp.util;

import hr.ja.myhttp.gui.LayoutPage;
import hr.ja.myhttp.gui.Page;
import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import lombok.SneakyThrows;
import spark.Request;
import spark.Response;
import spark.Spark;

public class PageHolder {

    private Class<? extends Page> pageClass;
    private SiteContext context;
    private Route route;

    @SneakyThrows
    public PageHolder(Class<? extends Page> pageClass, SiteContext context) {
        this.pageClass = pageClass;
        this.context = context;
        //Page page = pageClass.getConstructor().newInstance();
        route = pageClass.getAnnotation(Route.class);
        Spark.get(route.value(), this::onRequest);
    }

    @SneakyThrows
    private Object onRequest(Request request, Response response) {
        Page page = pageClass.getConstructor().newInstance();
        page.onRequest(request, response, context);

        //String pageHtmlPart = TemplateParser.parsePage(page);
        LayoutPage layoutPage = new LayoutPage();
        layoutPage.onRequest(request, response, context);
        layoutPage.setPage(page);

        return TemplateParser.parsePage(layoutPage);
    }
}
