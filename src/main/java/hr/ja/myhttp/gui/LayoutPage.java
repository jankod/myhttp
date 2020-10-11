package hr.ja.myhttp.gui;

import lombok.Getter;
import lombok.Setter;
import spark.Request;
import spark.Response;

import java.time.LocalDateTime;

@Getter
@Setter
public class LayoutPage extends Page {

    private Page page;

    public LayoutPage() {
        setTemplate(layout());
    }

    @Override
    public void onRequest(Request req, Response resp, SiteContext siteContext) {

    }

    private String layout() {
        return """
                   <!doctype html>
                   <html lang="en">
                     <head>
                       <meta charset="utf-8">
                       <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                       <link rel="stylesheet" href=bootstrap.min.css" >
                       <title>${page.title!"Page title"}</title>
                     </head>
                     <body>
                       <div class="main">
                            ${page}      
                       </div>
                       <div class='footer'>footer for all</div>
                       <script src="jquery-3.5.1.slim.min.js"  ></script>
                       <script src="popper.min.js"  ></script>
                       <script src="bootstrap.min.js"  ></script>
                       <script src="main.js"></script>
                     </body>
                   </html>
                   """;
    }

}
