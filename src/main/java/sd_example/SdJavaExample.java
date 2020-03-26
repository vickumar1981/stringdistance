package sd_example;

import com.github.vickumar1981.stringdistance.util.ArrayDistance;

public class SdJavaExample {
    public static void main(String[] args) {
        Double levenshtein = ArrayDistance.levenshtein(
            new Ch[]{Ch.of('m'), Ch.of('a'), Ch.of('r'), Ch.of('t'), Ch.of('h'), Ch.of('a')},
            new Ch[]{Ch.of('m'), Ch.of('a'), Ch.of('r'), Ch.of('h'), Ch.of('t'), Ch.of('a')}
        );
        System.out.println("result: " + levenshtein);
    }
}
