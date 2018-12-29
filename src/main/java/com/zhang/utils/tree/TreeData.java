package com.zhang.utils.tree;

import java.util.List;

/**
 * 树节点数据
 *
 * @author zhangyu
 * @create 2018-12-28 19:39
 **/
public class TreeData {

    /**
     * id
     */
    private String id;

    /**
     * 名称
     */
    private String name;

    /**
     * 父节点id
     */
    private String parentId;

    /**
     * 子节点
     */
    private List<TreeData> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<TreeData> getChildren() {
        return children;
    }

    public void setChildren(List<TreeData> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TreeData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", children=" + children +
                '}';
    }
}
