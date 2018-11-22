package kata6;

import java.io.File;
import java.util.Iterator;

//dado un array de ficheros te devuelve un iterador de ficheros
public class Main {
    public static void main(String[] args) {
        File root = new File("/");
        File[] files = root.listFiles();//conviertes el array files en un iterador
        new Histogram<>(megabytes(lengths(iteratorOf(files))));
    }
    
    private static <T>Iterator<T> iteratorOf(T[] items){
        return new Iterator<T>(){
            int index = 0;
            //si la longitud es 10 y el indice 1, hay siguientes
            //si la logitud es 10 y el indice 10, no hay mas
            @Override
            public boolean hasNext(){
                return index < items.length;
            }
            //retorna la posicion del indice, y luego avanza el indice del array
            @Override
            public T next(){
                return items[index++];
            }
        };      
    }
    
    private static Iterator<Long> lengths(Iterator<File> iterator){
        return new Iterator<Long>(){
            @Override
            public boolean hasNext(){
                return iterator.hasNext();
            }
            
            @Override
            public Long next(){
                return iterator.next().length();
            }
        };
    }

    private static Iterator<Integer> megabytes(Iterator<Long> iterator) {
        return new Iterator<Integer>(){
            @Override
            public boolean hasNext(){
                return iterator.hasNext();
            }
            
            @Override
            public Integer next(){
                return (int) (iterator.next()/(1024*1024));
            }
        };
    }

    void execute() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    int execute(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
