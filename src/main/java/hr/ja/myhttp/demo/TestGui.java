package hr.ja.myhttp.demo;

import hr.ja.myhttp.SimpleServer;


public class TestGui {

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        server.addPage(Dashboard.class);
        server.addPage(SecondPage.class);
        server.start(8033);
    }
}



