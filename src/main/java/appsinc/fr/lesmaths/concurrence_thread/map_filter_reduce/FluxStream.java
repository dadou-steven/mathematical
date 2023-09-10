package appsinc.fr.lesmaths.concurrence_thread.map_filter_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface FluxStream {

    List<Integer> intList = List.of(1, 4, 9, 16);
    Stream<Integer> intStream = intList.stream();
    String[] stringArray = new String[] {"a", "b", "c"};
    Stream<String> stringStream = Arrays.stream(stringArray);
    Stream<String> moreStringStream = Stream.concat(stringStream, Stream.of("d", "e", "f"));
    Stream<Integer> number0Through99 = IntStream.range(0, 100).boxed();

    List<Integer> list = List.of(1, 4, 9, 16);
    Stream<Integer> s = list.stream();
    Stream<Double> t = s.map(Math::sqrt); // ou encore (or), Stream<Double> t = s.map(x -> Math.sqrt(x));
}
