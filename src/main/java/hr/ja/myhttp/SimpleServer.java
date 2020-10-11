package hr.ja.myhttp;

import hr.ja.myhttp.gui.LayoutPage;
import hr.ja.myhttp.gui.Page;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.util.PageHolder;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class SimpleServer {

    private List<Class<? extends Page>> pages = new ArrayList<>();

    @SneakyThrows
    public void start(int port) {
        Spark.port(port);

        SiteContext context = new SiteContext();

        for (Class<? extends Page> pageClass : pages) {
            PageHolder pageHolder = new PageHolder(pageClass, context);
        }
        log.debug("http://localhost:" + port);
    }


    public void addPage(Class<? extends Page> page) {
        pages.add(page);
    }


}
