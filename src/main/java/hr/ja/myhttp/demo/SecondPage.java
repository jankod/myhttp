package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.Page;
import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.gui.Table;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import spark.Request;
import spark.Response;


@Data
@Route(value = "/second", name="se")
public class SecondPage extends Page {

    private String data2;

    private Table table = new Table();


    public SecondPage() {

        //language=InjectedFreeMarker

        setTemplate("""
                
                <h2>Second page</h2>
                <a href='/'>Main page</a>
                <p>Data 2: ${data2}</p>
                <p>Table</p>
                ${table}
                """);
        setJs("""
                console.log("delaj");
                """);
        data2 = RandomStringUtils.randomAlphabetic(8);
    }

    @Override
    public void onRequest(Request req, Response resp, SiteContext siteContext) {
    }
}
