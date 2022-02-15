package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Alexey Tkachenko
 */
class CombiningPredicates {

    /**
     * The method represents the conjunction operator for a list of predicates.
     * For an empty list it returns the always true predicate.
     */
    public static IntPredicate conjunctAll(List<IntPredicate> predicates) {
        IntPredicate intPredicate = x -> true;
        for (IntPredicate predicate : predicates) {
            intPredicate = intPredicate.and(predicate);
        }
        return intPredicate;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        List<Boolean> values;
        if (strings[0].trim().length() == 0) {
            values = List.of();
        } else {
            values = Arrays.stream(strings)
                    .map(Boolean::parseBoolean)
                    .collect(Collectors.toList());
        }

        List<IntPredicate> predicates = new ArrayList<>();
        values.forEach(v -> predicates.add(x -> v));

        System.out.println(conjunctAll(predicates).test(0));
    }

    public static <T> Predicate<T> xor(Predicate<T> predicate1, Predicate<T> predicate2) {
        Predicate<T> b = predicate1.or(predicate2);
        Predicate<T> b2 = predicate1.and(predicate2);
        Predicate<T> res = (predicate1.or(predicate2)).and(predicate1.and(predicate2).negate());
        return null;
    }

}
