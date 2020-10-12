package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.gui.table.Table;
import hr.ja.myhttp.gui.table.TableHeader;
import hr.ja.myhttp.model.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Getter
@Setter
@Route(value = "/second", name = SecondPage.NAME)
public class SecondPage extends BasePage {

    public static final String NAME = "se";

    private String data2;

    private Table<User> table = new Table<>();

    public SecondPage() {

        table.createColumn(User::getId).setHeader("ID");
        table.createColumn(User::getName)
                .setHeader(new TableHeader("Name"));

        //language=InjectedFreeMarker
        setTemplate("""
                <h2>Second page</h2>
                <a href='/' data-goto='main'>Main page full load</a>
                <p>${link('Main page ajax', 'main')}</p>
                <p>Data 2: ${data2}</p>
                <p>Table</p>
                                
                ${table}
                                
                """);
        // language=JavaScript
        setJs("""
                let pero = "setJs second page";
                console.log("delaj "+ pero);
                """);
        data2 = RandomStringUtils.randomAlphabetic(8);
    }

    @Override
    public void onRequest(HttpServletRequest req, HttpServletResponse resp, SiteContext siteContext) {

        table.setData(User.all());
    }
}
