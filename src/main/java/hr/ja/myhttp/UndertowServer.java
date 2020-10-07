package hr.ja.myhttp;

import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;

@Slf4j
public class UndertowServer {

    public static void main(final String[] args) {
        StopWatch stop = new StopWatch();
        stop.start();
        Undertow server = Undertow.builder()
                .addHttpListener(9000, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {

                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
                        exchange.getResponseSender().send("Hello World");
                        log.debug("dela exchange {}", exchange.getRequestURL());
                    }
                }).build();
        server.start();
        stop.stop();
        log.debug("time {}", stop.getTime());
    }
}