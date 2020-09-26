package hr.ja.myhttp;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import hr.ja.myhttp.model.User;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j()
public class Main {

	public void delay() {
		var user = new User();

		long id = 222;
		user.setId(id);
		user.setName("pero");

		user.save();

		Collection<User> users = User.search(user1 -> user1.getId() > 2);
		log.debug("Found users {}", users);

		User us = User.get(id);

		log.debug("user with id {} = {}", id, us);

		us.deleteThis();

		List<User> all = User.all();

		log.debug("ll {}", all);

	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.delay();

		main.server();

	}

	private void server() throws IOException {
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

		HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
		server.setExecutor(threadPoolExecutor);
		server.createContext("/", new HttpHandler() {
			@Override
			public void handle(HttpExchange exchange) throws IOException {
				log.debug("a je ovo " + exchange.getRequestURI());

				String html = """
						<html >
						<head>
						    <meta charset="utf-8">
						    </head>
						<body>Ovo 232 čžć</body>
						</html>

						""";

				byte[] bytes = html.getBytes(StandardCharsets.UTF_8);
				Headers header = exchange.getRequestHeaders();

				// header.add("Content-Type", "text/html; charset=utf-8");
				exchange.sendResponseHeaders(200, bytes.length);

				OutputStream out = exchange.getResponseBody();
				out.write(bytes);
				out.flush();
				out.close();

			}
		});

		server.start();
	}
}
