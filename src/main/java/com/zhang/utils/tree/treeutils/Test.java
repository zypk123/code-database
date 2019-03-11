package com.zhang.utils.tree.treeutils;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @create 2019-03-11 17:39
 **/
public class Test {
    public static void main(String[] args) {

        List<Tree> data = new ArrayList<>();

        // String id, String parentId, String code, String name
        data.add(new Tree("1", "0", "001", "根节点1"));
        data.add(new Tree("2", "0", "002", "根节点2"));
        data.add(new Tree("3", "1", "003", "子节点1.1"));
        data.add(new Tree("4", "3", "004", "子节点1.1.1"));
        data.add(new Tree("5", "2", "005", "子节点2.1"));

        System.out.println("=======" + JSON.toJSONString(TreeUtil.createTree(data)));


    }
}
