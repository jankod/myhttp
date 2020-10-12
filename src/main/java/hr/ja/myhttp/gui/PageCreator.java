package hr.ja.myhttp.gui;

import hr.ja.myhttp.util.Page;
import spark.Request;
import spark.Response;

@FunctionalInterface
public interface PageCreator {

    Page createPage(Request req, Response res, SiteContext context);
}
