package hr.ja.myhttp.util;

import hr.ja.myhttp.gui.LayoutPage;
import hr.ja.myhttp.gui.Page;
import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;
import spark.Spark;

@Slf4j
@Getter
public class PageHolder {

    private Class<? extends Page> pageClass;
    private SiteContext context;
    private Route route;

    private String pageName;

    @SneakyThrows
    public PageHolder(Class<? extends Page> pageClass, SiteContext context) {
        this.pageClass = pageClass;
        this.context = context;
        //Page page = pageClass.getConstructor().newInstance();
        route = pageClass.getAnnotation(Route.class);
        log.debug("Route '{}' Page {}", route.value(), pageClass.getSimpleName());
        Spark.get(route.value(), this::onRequest);
        pageName = route.name() != null ? route.name() : route.value();
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

    @SneakyThrows
    public String onRequestPagePart(Request req, Response resp) {
        Page page = pageClass.getConstructor().newInstance();
        page.onRequest(req, resp, context);
        String pageHtmlPart = TemplateParser.parsePage(page);
        return pageHtmlPart;
    }
}
