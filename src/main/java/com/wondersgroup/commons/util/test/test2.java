package com.wondersgroup.commons.util.test;


import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.*;

/**
 * TODO
 *
 * @author tangjunlin
 * @date 2021/11/11 17:05
 * @since
 */
public class test2 {
    public static void main(String[] args) {
        // 循环遍历Map的4中方法
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, 2);
        // 1. entrySet遍历，在键和值都需要时使用（最常用）
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }
        // 2. 通过keySet或values来实现遍历,性能略低于第一种方式
        // 遍历map中的键
        for (Integer key : map.keySet()) {
            System.out.println("key = " + key);
        }
        // 遍历map中的值
        for (Integer value : map.values()) {
            System.out.println("key = " + value);
        }
        // 3. 使用Iterator遍历
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        // 4. java8 Lambda
        // java8提供了Lambda表达式支持，语法看起来更简洁，可以同时拿到key和value，
        // 不过，经测试，性能低于entrySet,所以更推荐用entrySet的方式
        map.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

    }

    @Test
    public void test() {
        int shi = 0;
        int qu = 0;
        int shiqu = 0;
        int allTatal = 0;


        ArrayList<String[]> allPcJieruData = pcJieruSituation();

        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i < allPcJieruData.size(); i++) {
            //分组
            String itemID = allPcJieruData.get(i)[0];
            String region = allPcJieruData.get(i)[1];
            System.out.println(itemID + "  " + region);
            ArrayList<String> groupList = map.get(itemID);
            if (groupList == null) {
                groupList = new ArrayList<>();
            }
            groupList.add(region);
            map.put(itemID, groupList);
        }
        System.out.println(allPcJieruData.size());
        System.out.println(map);
        System.out.println("分组数量为（即总事项数）：" + map.size());
        allTatal = map.size();
        System.out.println("总事项数：" + allTatal);

        Iterator<Map.Entry<String, ArrayList<String>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, ArrayList<String>> entry = it.next();
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());

            ArrayList<String> allist = entry.getValue();
            Boolean is1 = false;
            Boolean is2 = false;
            for (int i = 0; i < allist.size(); i++) {
                //如果全都是SH00SH为市
                //如果有市级也有区的为市区
                //如果只有区的则为区
                String regions = allist.get(i);
                if (regions.equals("SH00SH")) {
                    is1 = true;
                } else {
                    is2 = true;
                }
            }
            if (is1 && is2) {//如果有市级也有区的
                shiqu++;
            } else if (!is1 && is2) {//如果只有区的则为区
                qu++;
            } else if (is1 && !is2) {//如果全都是SH00SH为市
                shi++;
            }
        }

        System.out.println("有市级也有区的"+shiqu);
        System.out.println("全都是SH00SH为市"+shi);
        System.out.println("只有区的"+qu);
    }


    public ArrayList<String[]> pcJieruSituation() {
        ArrayList<String[]> list = new ArrayList<String[]>();
        String stingJson = "[{\"ST_ITEM_ID\":\"10001\",\"ST_ITEM_REGION\":\"SH00SH\"},{\"ST_ITEM_ID\":\"10001\",\"ST_ITEM_REGION\":\"SH00BS\"},{\"ST_ITEM_ID\":\"10001\",\"ST_ITEM_REGION\":\"SH00YP\"},{\"ST_ITEM_ID\":\"10002\",\"ST_ITEM_REGION\":\"SH00SH\"},{\"ST_ITEM_ID\":\"10003\",\"ST_ITEM_REGION\":\"SH00PD\"},{\"ST_ITEM_ID\":\"10003\",\"ST_ITEM_REGION\":\"SH00JS\"}]";
//        com.alibaba.fastjson.JSONObject js=new com.alibaba.fastjson.JSONObject();
        JSONArray array = JSONArray.parseArray(stingJson);
        for (int i = 0; i < array.size(); i++) {
            String[] str = new String[2];
            String id = array.getJSONObject(i).getString("ST_ITEM_ID");
            String region = array.getJSONObject(i).getString("ST_ITEM_REGION");
            str[0] = id;
            str[1] = region;
            list.add(str);
        }
        return list;
    }

}
