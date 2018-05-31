package com.lh.util;

import com.skjegstad.utils.BloomFilter;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilter<String> bloomFilter = new BloomFilter<String>(0.1, 100);
        bloomFilter.add("拉普拉斯");
        System.out.println(bloomFilter.contains("拉普拉斯"));
        System.out.println(bloomFilter.contains("拉普斯"));
    }

    @Test
    public void testBigSet() {
        BitSet set = new BitSet();
        set.set(1);
        set.set(2);
        int cardinality = set.cardinality();
        System.out.println(cardinality);
        System.out.println(set.get(1));
    }
}
