package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.LayoutPage;
import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import spark.Request;
import spark.Response;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BootstrapLayout extends LayoutPage {

    public BootstrapLayout() {
        setTemplate(layout());
    }

    public String isActive(String pageName) {

        String rn = getWebSite().getRouteName(getCurrentPage());
        String routeName = getCurrentPage().getClass().getAnnotation(Route.class).name();
        if(pageName.equals(routeName)) {
            return "active";
        }
        return "";
    }



    public String layout() {
        //language=InjectedFreeMarker
        return """
                <!doctype html>
                <html lang="en">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
                    <link rel="stylesheet" href="bootstrap.min.css" >
                    <title>${currentPage.title!"Page title"}</title>
                  </head>
                  <body>
                  
                  <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                  
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto">
                        <li class="nav-item ${isActive('main')}">
                          <a class="nav-link" href="#home" data-goto='main'>Home </a>
                        </li>
                        <li class="nav-item ${isActive('se')}">
                          <a class="nav-link" href="#se" data-goto="se">Second</a>
                        </li>
                      </ul>
                  
                    </div>
                  </nav>
                  
                  
                  
                    <div id='content'>
                         ${currentPage}      
                    </div>
                    <div class='footer'>footer for all</div>
                    <script src="jquery-3.5.1.min.js"  ></script>
                    <script src="popper.min.js"  ></script>
                    <script src="bootstrap.min.js"  ></script>
                    <script src="main.js"></script>
                  </body>
                </html>
                """;
    }
}
