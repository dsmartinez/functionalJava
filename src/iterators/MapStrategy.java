package iterators;

public interface MapStrategy<E, R> {
    public R transform(E element);
}
