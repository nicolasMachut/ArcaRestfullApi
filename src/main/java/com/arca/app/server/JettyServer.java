package com.arca.app.server;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JettyServer {

    private Server server;
    public static String databaseName;
    public static String databasePort;
    public static String databaseHost;
    public static String databaseUser;
    public static String databasePwd;
    public static String batchExecuteCommand;


    public JettyServer(String port) throws IOException {

        initServerParameters();

        server = new Server(Integer.valueOf(port));
        final WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setParentLoaderPriority(true);
        final String webappDirLocation = "src/main/webapp/";
        root.setDescriptor(webappDirLocation + "/WEB-INF/web.xml");
        root.setResourceBase(webappDirLocation);
        server.setHandler(root);
    }

    private void initServerParameters() throws IOException {
        try (InputStream input = new FileInputStream("config.properties");){
            Properties prop = new Properties();
            prop.load(input);

            loadParams(prop);

        } catch(Exception e ) {
            throw e;
        }
    }

    private void loadParams(Properties prop) {
        databaseName = prop.getProperty("database_name");
        databasePort = prop.getProperty("database_port");
        databaseHost = prop.getProperty("database_host");
        databaseUser = prop.getProperty("database_user");
        databasePwd = prop.getProperty("database_pwd");
        batchExecuteCommand = prop.getProperty("batch_execute_command");
    }

    public void startServer() {
        try {
            server.start();
            server.join();

        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            server.destroy();
        }
    }
}
