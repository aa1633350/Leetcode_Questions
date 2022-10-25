package com.example.demo.Coding.GeneralCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FlattenMapRecursiveAlgo {

    static Map<String, Object> flatMap(Map<String, Object> map) {
        Map<String, Object> flatenedMap = new HashMap<>();
        map.forEach((key, value) -> {
            if(value instanceof Map) {
                flatenedMap.putAll(flatMap((Map) value));
            } else {
                flatenedMap.put(key, value);
            }
        });

        return flatenedMap;
    }
    private static void addKeys(String currentPath, Map<String, Object> mockData,  Map<String, String> map) {
        mockData.forEach((key,value) -> {
            if(value instanceof Map) {
                String pathPrefix = currentPath.isEmpty() ? "" : currentPath + ".";
                Iterator<Map.Entry<String, Object>> itr = mockData.entrySet().iterator();
                while(itr.hasNext()) {
                    Map.Entry<String, Object> entry = itr.next();
                    addKeys(pathPrefix + entry.getKey(), (Map)entry.getValue(), map);
                }
            } else  {
                map.put(key, (String) value);
            }
        });
    }
    public static void main(String[] args) {

        Map<String, Object> mockData = new HashMap<>();
        mockData.put("invoiceId","1");
        mockData.put("invoiceNumber","000001");
        mockData.put("invoiceStatus","Work in Progress");
        LinkedHashMap<Object, Object> totalValue = new LinkedHashMap<>();
        totalValue.put("currency","USD");
        totalValue.put("amount",3000);
        mockData.put("total",totalValue);
        //Map<String, Object> outputMap = flatMap(mockData);
        Map<String, String> map = new HashMap<>();
        addKeys("", mockData ,map);
        String x = "Some";

    }


}
