package appsinc.fr.lesmaths.concurrence_thread.map_filter_reduce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Words1 {

    public static List<File> allFilesIn(File folder) {
        List<File> files = new ArrayList<>();
        for (File file : Objects.requireNonNull(folder.listFiles())) {
            if (file.isDirectory()) {
                files.addAll(allFilesIn(file));
            } else if (file.isFile()) {
                files.add(file);

            }
        }
        return files;
    }

    public static List<File> onlyFilesWithSuffix(List<File> files, String suffix) {
        List<File> result = new ArrayList<>();
        for (File file : files) {
            if (file.getName().endsWith(suffix)) {
                result.add(file);
            }
        }
        return result;
    }

    public static List<String> getWords(List<File> files) throws IOException {
        List<String> words = new ArrayList<String>();
        for (File file : files) {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                for (String word : line.split("\\W+")) {
                    if (! word.isEmpty()) {
                        words.add(word);
                    }
                }
            }
            reader.close();
        }
        return words;
    }

    public static void main(String[] args) throws IOException {
        List<File> allFiles = allFilesIn(new File("."));
        List<File> javaFiles = onlyFilesWithSuffix(allFiles, ".java");
        List<String> words = getWords(javaFiles);
        for (String s : words) {
            System.out.println(s);
        }
    }
}
