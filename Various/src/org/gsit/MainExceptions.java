package org.gsit;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MainExceptions {

    public static void main(String[] args) {
        doStuff();
    }

    private static void doStuff() {
        try {
            tryDoStuff();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static void tryDoStuff() throws IOException {
        doOtherStuff();
        InputStream aaa = Files.newInputStream(Paths.get("aaaa"));
    }

    private static void doOtherStuff() throws ArrayIndexOutOfBoundsException {
        new ArrayList<>().get(10);
    }
}
