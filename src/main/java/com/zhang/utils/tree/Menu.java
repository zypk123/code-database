package com.zhang.utils.tree;

import java.util.List;

/**
 * 菜单类
 *
 * @author zhangyu
 * @create 2018-06-08 14:38
 **/
public class Menu implements TreeEntity<Menu> {

    /**
     * id
     */
    public String id;

    /**
     * 展示的名称
     */
    public String name;

    /**
     * 上级节点id
     */
    public String parentId;

    /**
     * 孩子节点
     */
    public List<Menu> childList;

    @Override
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

    @Override
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public List<Menu> getChildList() {
        return childList;
    }

    @Override
    public void setChildList(List<Menu> childList) {
        this.childList = childList;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", childList=" + childList +
                '}';
    }

}
