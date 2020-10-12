package hr.ja.myhttp.demo;

import hr.ja.myhttp.SimpleServer;


public class TestGui {

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        server.addPage(MainPage.class);
        server.addPage(SecondPage.class);
        server.setLayoutPage(BootstrapLayout.class);

        //server.addPage(MainPage.NAME, (req, resp, context) -> new MainPage());

        server.start(8033);
    }
}



