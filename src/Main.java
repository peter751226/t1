import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        List<String> l= new ArrayList<>();
        l.add("abbc");
        l.add("lzh");
        l.add(null);




        Collections.synchronizedList(l);
         l.forEach(System.out::println);
        CompletableFuture.runAsync(()->l.add("c"));
        CompletableFuture.runAsync(()->l.add("cc"));
        CompletableFuture.runAsync(()->l.remove(2));
        l.forEach(System.out::println);

        Optional.of("css")
               // .map(s->s.length())
                .stream().forEach(System.out::println);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        l.forEach(System.out::println);
        List<String> l1= new ArrayList<>();
        l1.add("1");
        l1.add("2");
        l1.add(null);
        l1.add(null);
        l1.add(null);
        System.out.println(l1.stream().collect(Collectors.toSet()).stream().count());





    }
}
