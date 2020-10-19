package net.skycoop.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AlgorithmTest {


    @Test
    public void random() {
        Map<Integer, Integer> cache = new HashMap<>();
        int count = 10000;
        while (count != 0) {
            int num = Algorithm.random(10);
            count--;
            cache.put(num, cache.getOrDefault(num, 0) + 1);
        }

        int size = 0;

        int min = 10000 / 10 - 100, max = 10000 / 10 + 100;

        System.out.println(cache);

        for (int i = 0; i < 10; i++) {
            Integer num = cache.remove(i);
            assertNotNull(num);
            size += num;
            assertTrue(num >= min && num <= max);
        }
        assertEquals(10000, size);
    }

    @Test
    public void testRandom() {

    }
}
