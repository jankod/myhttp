package hr.ja.myhttp.demo;

import hr.ja.myhttp.gui.Route;
import hr.ja.myhttp.gui.SiteContext;
import hr.ja.myhttp.gui.table.Table;
import hr.ja.myhttp.model.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@Getter
@Setter
@Route(value = "/second", name = SecondPage.NAME)
public class SecondPage extends BasePage {

    public static final String NAME = "se";

    private String data2;

    private Table<User> table = new Table<>();


    public SecondPage() {

        table.addColumn(User::getId).setHeader("ID");
        table.addColumn(User::getName).setHeader("Name");

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
        User u1 = new User();
        u1.setName("user1");
        u1.setId(22L);

        User u2 = new User();
        u2.setName("user 2");
        u2.setId(323L);

        ArrayList<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);

        table.setData(users);
    }
}
