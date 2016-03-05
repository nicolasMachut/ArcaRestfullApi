package com.arca.app;

import com.arca.app.resources.EntryPoint;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicolas on 26/02/16.
 */
public class Main {

    public static void main (String[] args) {
        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = "8080";
        }

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        Server jettyServer = new Server(Integer.valueOf(port));
        jettyServer.setHandler(context);

        ServletHolder jerseyServlet = context.addServlet(
                org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);
        jerseyServlet.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");
        jerseyServlet.setInitParameter("com.sun.jersey.config.property.packages", "com.arca.app.resources");

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
                "jersey.config.server.provider.classnames",EntryPoint.class.getCanonicalName());

        try {
            jettyServer.start();
            jettyServer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jettyServer.destroy();
        }
    }

    private static class PackagesResourceConfig extends ResourceConfig {
        public PackagesResourceConfig(Map<String, Object> initMap) {
        }
    }
}
