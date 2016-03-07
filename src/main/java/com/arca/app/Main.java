package com.arca.app;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

/**
 * Created by nicolas on 26/02/16.
 */
public class Main {

    public static void main (String[] args) {

        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = "8082";
        }

        Server jettyServer = new Server(Integer.valueOf(port));
        final WebAppContext root = new WebAppContext();

        root.setContextPath("/");
        root.setParentLoaderPriority(true);

        final String webappDirLocation = "src/main/webapp/";
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);

        jettyServer.setHandler(root);

        try {
            jettyServer.start();
            MongoDbConnector.INSTANCE.getCollection("arcaFile");
            jettyServer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jettyServer.destroy();
        }
    }
}
