package tasks;

/**
 * @author Alexey Tkachenko
 */
@FunctionalInterface
public interface TernaryIntPredicate <T, U, I, R>{
    R test(T t, U u, I i);
}

class TernaryIntPredicateClass {
    public static final TernaryIntPredicate<Integer, Integer, Integer, Boolean> allValuesAreDifferentPredicate =
            (a, b, c) -> !a.equals(b) && !a.equals(c) && !b.equals(c);
}
