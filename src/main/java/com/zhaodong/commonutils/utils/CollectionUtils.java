package com.zhaodong.commonutils.utils;


import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionUtils {
    public static Integer[] fillToIntArray(int size){
        return IntStream.range(1,size+1).boxed().toArray(Integer[]::new);
    }

    public static String[] fillToStrArray(int size){
        return IntStream.range(1,size+1).boxed().toArray(String[]::new);
    }

    //切分大list，为每份200个的小list
    public static  List<List<String>> divideList(List<String> bigList,int size){
        int n = size;
        List<List<String>> result = IntStream.range(0, bigList.size())
                .filter(i -> i % n == 0)
                .mapToObj(i -> bigList.subList(i, Math.min(i + n, bigList.size())))
                .collect(Collectors.toList());
        return result;
    }




}
