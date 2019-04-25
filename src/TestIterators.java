import iterators.*;
import java.util.*;
/*
Tests the map, filter, and reduce iterators with array lists.
Creates strategy objects as anonymous instances of the appropriate interfaces.
*/
public class TestIterators{
    static public void main(String[] args){

// The list contains [1 2 3 4 5 6 7 8]
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 8; i++)
            list.add(i);
// Compute the square roots
        Collection<Double> squareRoots =
                Iterators.map(new MapStrategy<Integer, Double>(){
                    public Double transform(Integer i){
                        return Math.sqrt(i);
                    }
                }, list);
        System.out.println(squareRoots);
// Convert to string representations
        Collection<String> stringReps =
                Iterators.map(new MapStrategy<Integer, String>(){
                    public String transform(Integer i){
                        return i + "";
                    }
                }, list);
        System.out.println(stringReps);
// Keep the even numbers
        Collection<Integer> evens =
                Iterators.filter(new FilterStrategy<Integer>(){
                    public boolean accept(Integer i){
                        return i % 2 == 0;
                    }
                }, list);
        System.out.println(evens);

       
// Sum the numbers
        int sum = Iterators.reduce(0, new ReduceStrategy<Integer>(){
            public Integer combine(Integer first, Integer second){
                return first + second;
            }
        }, list);
        System.out.println(sum);
    }
}