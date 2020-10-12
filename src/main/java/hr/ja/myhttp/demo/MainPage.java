package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.util.Page;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Getter
@Setter
@Route(value = "/", name = MainPage.NAME)
public class MainPage extends BasePage {

    public static final String NAME = "main";

    String data1;
    String linkSecond = link("second", "se");

    public MainPage() {
        //language=InjectedFreeMarker
        String html = """
                    <script type='application/javascript' type='module'>
                if (typeof pero === "function") {
                   // console.log("function pero() exist ", pero);
                }
                                
                function pero() {
                    //console.log("pero()");
                }
                </script>
                <h1>Dashboard</h1>
                <p>${data1}</p> 
                <p>Link 1 ${link('Second', 'se')}</p>
                <p>Link 2 ${linkSecond}</p>      
                """;
        setTemplate(html);
        data1 = RandomStringUtils.randomAlphabetic(2);
        setTitle("Dashboard");
    }

    @Override
    public void onRequest(HttpServletRequest req, HttpServletResponse resp, SiteContext siteContext) {
    }
}
