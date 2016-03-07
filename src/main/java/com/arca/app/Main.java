package com.arca.app;

import com.arca.app.server.JettyServer;

import java.io.IOException;

public class Main {

    public static void main (String[] args) throws IOException {

        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = "8282";
        }

        new JettyServer(port).startServer();
    }
}
