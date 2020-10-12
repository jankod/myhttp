package hr.ja.myhttp.demo;

import hr.ja.myhttp.SimpleServer;
import hr.ja.myhttp.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;


public class TestGui {

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        server.addPage(MainPage.class);
        server.addPage(SecondPage.class);
        server.setLayoutPage(BootstrapLayout.class);

        //server.addPage(MainPage.NAME, (req, resp, context) -> new MainPage());

        initData();

        server.start(8033);
    }

    private static void initData() {
        for (int i = 0; i < 10; i++) {
            User u1 = new User();
            u1.setName(RandomStringUtils.randomAlphabetic(10));
            u1.setId(RandomUtils.nextLong(1, 50));
            u1.save();
        }

    }
}



