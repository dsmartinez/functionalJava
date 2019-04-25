import iterators.*;
import java.util.Collection;

public class Iterators {

    public static<E> E reduce(E baseElement, ReduceStrategy<E> strategy, Collection<E> c){
        for (E element : c)
            baseElement = strategy.combine(baseElement, element);
        return baseElement;
    }

    public static<E, R> Collection<R> map(MapStrategy<E, R> strategy, Collection<E> c){
        try{
            Collection<R> results = c.getClass().newInstance();
            for (E element : c)
                results.add(strategy.transform(element));
            return results;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public static<E> Collection<E> filter(FilterStrategy< E> strategy, Collection<E> c){
        //TODO implement this
        return null;
    }

    //public static
}
