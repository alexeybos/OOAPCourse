package org.skillsmart.lesson10;

public class BloomFilter extends AbstractBloomFilter {

    private int filter_len;
    private int bloom;

    public BloomFilter(int len) {
        filter_len = len;
        bloom = 2 << (len - 1);
    }

    private int hash1(String str)
    {
        int prevRes = 0;
        for(int i=0; i<str.length(); i++)
        {
            int code = str.charAt(i);
            prevRes = (prevRes * 17 + code) % filter_len;
        }
        return prevRes;
    }

    private int hash2(String str)
    {
        int prevRes = 0;
        for(int i=0; i<str.length(); i++)
        {
            int code = str.charAt(i);
            prevRes = (prevRes * 223 + code) % filter_len;
        }
        return prevRes;
    }

    @Override
    public void add(String value) {
        int index1 = 1 << hash1(value);
        int index2 = 1 << hash2(value);
        bloom |= index1;
        bloom |= index2;
    }

    @Override
    public boolean isValue(String value) {
        int index1 = 1 << hash1(value);
        int index2 = 1 << hash2(value);
        return ((bloom & index1) == index1) && ((bloom & index2) == index2);
    }

    @Override
    public BloomFilter mergeFilter(BloomFilter filter2) {
        // нет реализации, т.к. не придумал, как получить битовый массив от filter2
        // в рамках корректного построения АТД
        return null;
    }
}
