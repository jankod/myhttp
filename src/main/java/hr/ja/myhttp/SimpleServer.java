package hr.ja.myhttp;

import hr.ja.myhttp.exception.PageDefineException;
import hr.ja.myhttp.gui.LayoutPage;
import hr.ja.myhttp.gui.PageCreator;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.util.Page;
import hr.ja.myhttp.util.PageHolder;
import hr.ja.myhttp.util.SiteConfiguration;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
public class SimpleServer {

    private Map<String, PageHolder> pageHolderMap = new HashMap<>();

    private SiteConfiguration configuration;

    public SimpleServer() {
        configuration = new SiteConfiguration();
    }


    @SneakyThrows
    public void start(int port) {
        // TODO: check if all page has unique page name
        Spark.port(port);
        Spark.staticFileLocation("/public");


        for (Class<? extends Page> pageClass : configuration.getPages()) {
            PageHolder pageHolder = new PageHolder(pageClass, configuration);
            String pageName = pageHolder.getPageName();

            if (pageHolderMap.containsKey(pageName)) {
                throw new PageDefineException("Page name is defined twice: '%s'".formatted(pageName));
            }
            pageHolderMap.put(pageName, pageHolder);
        }

        Spark.get("/page/:name", (request, response) -> {
            /// log.debug(request.uri());
            request.raw().getParameter("");
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
        configuration.getPages().add(page);
    }

    public void setLayoutPage(Class<? extends LayoutPage> layoutPage) {
        configuration.setLayoutPage(layoutPage);
    }

}
