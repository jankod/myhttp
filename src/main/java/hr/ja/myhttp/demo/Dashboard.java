package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.gui.Page;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import spark.Request;
import spark.Response;
import spark.Session;

@Route(value = "/", name = "main")
@Getter
@Setter
public class Dashboard extends Page {

    String data1;
    String linkSecond = link("second", "se");

    public Dashboard() {

        String html = """
                <h1>Dashboard</h1>
                <p>${data1}</p> 
                <p>Link 1 ${link('second', 'se')}</p>
                <p>Link 2 ${linkSecond}</p>      
                """;
        setTemplate(html);
        data1 = RandomStringUtils.randomAlphabetic(2);
        setTitle("Dashboard");
    }

    @Override
    public void onRequest(Request req, Response resp, SiteContext siteContext) {
    }
}
