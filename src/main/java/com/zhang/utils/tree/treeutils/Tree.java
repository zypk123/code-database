package com.zhang.utils.tree.treeutils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形数据结构
 *
 * @author zhangyu
 * @create 2019-03-11 17:24
 **/
public class Tree {

    private String id;

    private String parentId;

    private String code;

    private String name;

    private List<Tree> children = new ArrayList<>();

    public Tree() {

    }

    public Tree(String id, String parentId, String code, String name) {
        this.id = id;
        this.parentId = parentId;
        this.code = code;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tree> getChildren() {
        return children;
    }

    public void setChildren(List<Tree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "id='" + id + '\'' +
                ", parentId='" + parentId + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", children=" + children +
                '}';
    }
}
