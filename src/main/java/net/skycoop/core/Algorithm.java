package net.skycoop.core;

import org.apache.commons.lang3.RandomUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class Algorithm {

    public static <T> T random(Collection<T> data) {
        Iterator<T> iterable = data.iterator();
        int index = random(data.size());
        T t;
        do {
            t = iterable.hasNext() ? iterable.next() : null;
            index--;
        } while (index >= 0);
        return t;
    }

    public static int random(int range) {
        return RandomUtils.nextInt(0, range);
    }
}
