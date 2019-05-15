package com.example.testname.specialClasses;

class Server {
    private static final Server ourInstance = new Server();

    static Server getInstance() {
        return ourInstance;
    }

    private Server() {
    }
}
