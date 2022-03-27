package su.nsk.iae.post.dsm;

import java.io.IOException;

import su.nsk.iae.post.dsm.manager.client.DSMMClientImpl;
import su.nsk.iae.post.dsm.manager.client.DSMMClientLauncher;
import su.nsk.iae.post.dsm.server.ServerLauncher;

public class AppLauncher {
	//TODO Rename constants DSM_NAME (name of your dsm) DSM_DIRECTORY (directory for generated files by your generator)
	public static final String DSM_NAME = "ST_dsm";
	public static final String DSM_DIRECTORY = "st";

	private static final String DEFAULT_HOST = "localhost";
	private static final int DEFAULT_PORT = 8025;

	private static ServerLauncher serverLauncher;

	public static void main(String[] args) {
//		int port = DEFAULT_PORT;
//		String host = DEFAULT_HOST;
//		for (int i = 0; i < args.length; i++) {
//			String arg = args[i];
//			switch (arg) {
//			case "-port":
//				i++;
//				port = Integer.parseInt(args[i]);
//				break;
//			case "-host":
//				i++;
//				host = args[i];
//				break;
//			}
//		}
//
//		serverLauncher = new ServerLauncher();
//		serverLauncher.start(host, port);
//
//		Runtime.getRuntime().addShutdownHook(new Thread(() -> stop()));
//
//		System.out.println("[" + DSM_NAME + "] Server started");
//		try {
//			System.in.read();
//		} catch (IOException e) {
//			System.out.println("[" + DSM_NAME + "] Caught an exception");
//			e.printStackTrace();
//		} finally {
//			stop();
//		}

		DSMMClientLauncher cl = new DSMMClientLauncher(new DSMMClientImpl());
		cl.start("127.0.0.1", 8080);
	}

	static void stop() {
		System.out.println("[" + DSM_NAME + "] Server stoped");
		if (serverLauncher != null) {
			serverLauncher.shutdown();
			serverLauncher = null;
		}
	}
}