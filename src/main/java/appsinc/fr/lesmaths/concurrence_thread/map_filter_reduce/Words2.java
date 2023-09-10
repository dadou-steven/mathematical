package appsinc.fr.lesmaths.concurrence_thread.map_filter_reduce;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Words2 {

    static Stream<File> allFilesIn(File folder) {
        File[] children = folder.listFiles();
        assert children != null;
        Stream<File> descendants = Arrays.stream(children)
                .filter(File::isDirectory)
                .flatMap(Words2::allFilesIn);
        return Stream.concat(descendants, Arrays.stream(children)
                .filter(File::isFile));
    }

    static Predicate<File> endsWith(String suffix) {
        return f -> f.getPath().endsWith(suffix);
    }

    public static void main(String[] args) throws IOException {
        Stream<File> files = allFilesIn(new File("."))
                .filter(endsWith(".java"));
        Stream<Path> paths = files.map(File::toPath);
        Stream<List<String>> fileContents = paths.map(path -> {
            try {
                return Files.readAllLines(path);
            } catch (IOException ioException) {
                throw new UncheckedIOException(ioException);
            }
        });
        Stream<String> lines = fileContents.flatMap(List::stream);
        Stream<String> words = lines.flatMap((line -> Arrays.stream(line.split("\\W+"))
                .filter(s -> s.length() > 0)));
        words.forEach(System.out::println);

    }
}
