package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Getter
@Setter
@Route(value = "/", name = MainPage.NAME)
public class MainPage extends BasePage {

    public static final String NAME = "main";

    String linkSecond = link("second", "se");
    UserForm userForm;

    public MainPage() {
        //language=InjectedFreeMarker
        String html = """
                <h1>Main page</h1>
                <p>Link 1 ${link('Second', 'se')}</p>
                <p>Link 2 ${linkSecond}</p>
                
                <p>Form</p>
                <p>${form(userForm)}</p>      
                """;
        //language=JavaScript
        setJs("""
                console.log("Exec from setJs MainPage")
                """);
        setTemplate(html);
        setTitle("Dashboard");
    }

    @Override
    public void onRequest(HttpServletRequest req, HttpServletResponse resp, SiteContext siteContext) {
        userForm = new UserForm();
    }
}
