package mycollection;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ListArray<String> a = new ListArray<>();
        a.add("Вася");
        a.add("Маша");
        a.add("Оля");
        a.add("Настя");
        a.add("Настя");
        a.add("Петя");
        a.add("Дима");
        a.printElements();

        a.remove("Настя");
        a.printElements();

    }
}