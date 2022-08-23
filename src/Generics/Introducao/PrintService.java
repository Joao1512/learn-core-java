package Generics.Introducao;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    List<T> list = new ArrayList<>();

    public void add(T value) {
        list.add(value);
    }

    public void print() {
        System.out.println(list);
    }
}
