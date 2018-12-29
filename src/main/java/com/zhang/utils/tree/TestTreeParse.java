package com.zhang.utils.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @create 2018-12-28 20:05
 **/
public class TestTreeParse {
    public static void main(String[] args) {

        List<TreeData> dataList = new ArrayList<>();

        TreeData data1 = new TreeData();
        data1.setId("1");
        data1.setParentId("0");
        data1.setName("根节点1");

        TreeData data2 = new TreeData();
        data2.setId("2");
        data2.setParentId("1");
        data2.setName("子节点1.1");

        TreeData data3 = new TreeData();
        data3.setId("3");
        data3.setParentId("2");
        data3.setName("子节点1.1.1");

        TreeData data4 = new TreeData();
        data4.setId("4");
        data4.setParentId("0");
        data4.setName("根节点2");

        TreeData data5 = new TreeData();
        data5.setId("5");
        data5.setParentId("4");
        data5.setName("子节点2.1");

        TreeData data6 = new TreeData();
        data6.setId("6");
        data6.setParentId("5");
        data6.setName("子节点2.1.1");

        dataList.add(data1);
        dataList.add(data2);
        dataList.add(data3);
        dataList.add(data4);
        dataList.add(data5);
        dataList.add(data6);

//        System.out.println(TreeParse.getTree(dataList));

        System.out.println(TreeParse.getTree("1", dataList, true));
    }
}
