package hr.ja.myhttp;

import hr.ja.myhttp.gui.LayoutPage;
import hr.ja.myhttp.gui.Page;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.util.PageHolder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class SimpleServer {

    private List<Class<? extends Page>> pages = new ArrayList<>();

    private Map<String, PageHolder> pageHolderMap = new HashMap<>();

    @SneakyThrows
    public void start(int port) {
        Spark.port(port);
        Spark.staticFileLocation("public");
        SiteContext context = new SiteContext();

        for (Class<? extends Page> pageClass : pages) {
            PageHolder pageHolder = new PageHolder(pageClass, context);
            log.debug("save page name '{}'", pageHolder.getPageName());
            pageHolderMap.put(pageHolder.getPageName(), pageHolder);
        }
        Spark.get("/page/:name", (request, response) -> {
           // log.debug(request.uri());
            String pageName = request.params(":name");
            //log.debug("Search page name '{}'", pageName);
            PageHolder ph = pageHolderMap.get(pageName);
            if (ph == null) {
                log.warn("Cannot find page '{}'", pageName);
                return "Cannot find page '%s'".formatted(pageName);
            }
            return ph.onRequestPagePart(request, response);

        });
        log.debug("http://localhost:" + port);
    }


    public void addPage(Class<? extends Page> page) {
        pages.add(page);
    }


}
