package io.github.julianjupiter.app;

import io.github.julianjupiter.app.server.Server;
import io.github.julianjupiter.app.server.TomcatServer;

public class Main {
	public static void main(String[] args) {
		Server app = new TomcatServer();
		app.run(args);
	}
}
