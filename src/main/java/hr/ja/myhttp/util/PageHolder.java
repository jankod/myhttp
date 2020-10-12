package hr.ja.myhttp.util;

import hr.ja.myhttp.gui.LayoutPage;
import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import spark.Request;
import spark.Response;
import spark.Spark;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Getter
public class PageHolder {

    private Class<? extends Page> pageClass;
    private Route route;
    private SiteConfiguration configuration;

    private String pageName;

    ThreadLocal<HttpServletRequest> currentRequest = new ThreadLocal<>();

    @SneakyThrows
    public PageHolder(Class<? extends Page> pageClass, SiteConfiguration configuration) {
        this.pageClass = pageClass;
        //Page page = pageClass.getConstructor().newInstance();
        route = pageClass.getAnnotation(Route.class);
        this.configuration = configuration;
        log.debug("Route '{}' Page {}", route.value(), pageClass.getSimpleName());
        Spark.get(route.value(), this::onRequest);
        pageName = route.name() != null ? route.name() : route.value();
    }

    @SneakyThrows
    private Object onRequest(Request request, Response response) {
        HttpServletRequest req = request.raw();
        currentRequest.set(req);
        Page page = pageClass.getConstructor().newInstance();
        SiteContext context = new SiteContext();
        page.onRequest(req, response.raw(), context);
        //String pageHtmlPart = TemplateParser.parsePage(page);
        LayoutPage layoutPage = configuration.getLayoutPage().getConstructor().newInstance();
        layoutPage.setCurrentPage(page);
        layoutPage.onRequest(req, response.raw(), context);

        return TemplateParser.parsePage(layoutPage);
    }

    @SneakyThrows
    public String onRequestPagePart(Request req, Response resp) {
        Page page = pageClass.getConstructor().newInstance();
        SiteContext siteContext = new SiteContext();
        page.onRequest(req.raw(), resp.raw(), siteContext);
        String pageHtmlPart = TemplateParser.parsePage(page);

        if(!StringUtils.isEmpty(page.getJs())) {
            resp.raw().setHeader("jsCallBack", "execNewJs");
        }
        return addJs(pageHtmlPart, page.getJs());
        //„return pageHtmlPart;
    }

    private String addJs(String pageHtmlPart, String js) {
        if(StringUtils.isEmpty(js)) {
            return pageHtmlPart;
        }

        //language=InjectedFreeMarker
        String html = pageHtmlPart + """
                <script>
                function execNewJs () {
                    %s
                };
                </script>
                """.formatted(js);
        return html;
    }
}
