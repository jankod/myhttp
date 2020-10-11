package hr.ja.myhttp.old;

import hr.ja.myhttp.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;

@Slf4j
public class JavalinServer {
    public static void main(String[] args) {
//        createSeveralUsers();
//        Javalin app = Javalin.create(config-> {
//            config.enableCorsForAllOrigins();
//        }).start(7000);
//        app.get("/", ctx -> ctx.result("Hello World sdsds"));
//
//        app.get("/users", c -> {
//            c.json(User.all());
//        });
//
//        app.get("/routes", c-> {
//            ArrayList<String> routes = new ArrayList<>();
//            routes.add("/page1");
//            routes.add("/page2");
//            routes.add("/page3");
//            c.json(routes);
//        });
      log.debug("Run on http://localhost:7000");
    }

    private static void createSeveralUsers() {
        for (int i = 0; i < 10; i++) {
            User u = new User();
            u.setName(RandomStringUtils.randomAlphabetic(2, 9));
        }

    }
}
