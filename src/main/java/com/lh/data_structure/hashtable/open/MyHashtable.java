package com.lh.data_structure.hashtable.open;

import java.util.Arrays;

/**
 * 实现一个哈希表，开放定址法->线性探测解决冲突
 */
public class MyHashtable {
    private static final int CAPACITY = 1 << 3;
    private static Object[] table = new Object[CAPACITY];

    public void set(Object ele) {
        int hashcode;
        int code = (hashcode = ele.hashCode()) ^ (hashcode >>> 16);
        int index = (CAPACITY - 1) & code;
        Object currEle = table[index];
        if (currEle != null) {
            if (currEle.equals(ele)) {
                return;
            }
            for (int i = index + 1; i < table.length; i++) {
                currEle = table[i];
                if (i == (table.length - 1) && currEle != null) {
                    throw new RuntimeException("hash table overflow");
                }
                if (currEle != null) {
                    continue;
                }
                table[i] = ele;
                break;
            }
        } else {
            table[index] = ele;
        }

    }

    @Override
    public String toString() {
        return Arrays.toString(table);
    }

    public static void main(String[] args) {
        MyHashtable table = new MyHashtable();
        table.set("adfgadfg");
        table.set("zxkgnerio");
        table.set("adfjlvndfk");
        table.set("zxkgnerio");
        System.out.println(table.toString());
    }
}
