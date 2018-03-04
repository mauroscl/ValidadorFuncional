@FunctionalInterface
interface ICustomPredicate<T, U, V>{
    boolean test(T t, U u, V v);
}
