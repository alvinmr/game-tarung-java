package com.utils;

import java.io.IOException;

public class Console {
    public static void log(String args) {
        System.out.println(args);
    }

    public static void wait(String text) throws IOException {
        System.out.print("\n\n" + text);
        System.in.read();
    }
}
