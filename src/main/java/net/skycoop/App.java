package net.skycoop;

import net.skycoop.core.Algorithm;

import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class App {

    static Map<Integer, Path> CACHE = new HashMap<>();
    static int INDEX = 0;

    public static void main(String[] args) throws IOException {

        if (args == null || args.length == 0) {
            System.out.println("[Err] : no path");
            return;
        }
        String dir = args[0];
        Path paths = Paths.get(dir);

        Files.walk(paths, FileVisitOption.FOLLOW_LINKS).forEach(p -> {
            if (Files.isRegularFile(p)) {
                CACHE.put(INDEX, p);
                INDEX++;
            }
        });
        System.out.println(CACHE.get(Algorithm.random(CACHE.size())));

    }
}
