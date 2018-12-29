package com.zhang.utils.tree;

import com.zhang.utils.string.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 解析树工具类
 *
 * @author zhangyu
 * @create 2018-12-28 19:42
 **/
public class TreeParse {

    /**
     * 获取树结构数据(得到全部树数据)
     *
     * @param dataList 原数据集合
     * @return 树形结构数据
     */
    public static TreeData getTree(List<TreeData> dataList) {

        List<TreeData> treeList = new ArrayList<>();

        for (TreeData data : dataList) {
            // 如果上级节点是0，则为根节点(这里确保只有一个最上层根节点)
            if (StringUtil.isEqual("0", data.getParentId())) {
                treeList.add(data);
            }
            // 拼接子集
            for (TreeData it : dataList) {
                if (StringUtil.isEqual(it.getParentId(), data.getId())) {
                    if (null == data.getChildren()) {
                        data.setChildren(new ArrayList<>());
                    }
                    data.getChildren().add(it);
                }
            }
        }
        return getTreeData(treeList);
    }

    /**
     * 根据父节点获取树结构数据
     *
     * @param topId           父节点id
     * @param dataList        原数据集合
     * @param isDownRecursive 是否向下遍历
     * @return 树形结构数据
     */
    public static TreeData getTree(String topId, List<TreeData> dataList, boolean isDownRecursive) {

        List<TreeData> treeList = new ArrayList<>();

        // 获取顶层元素集合
        String parentId;
        for (TreeData data : dataList) {
            parentId = data.getParentId();
            if (topId.equals(parentId)) {
                treeList.add(data);
            }
        }

        if (isDownRecursive) {
            // 获取每个顶层元素的子数据集合
            for (TreeData children : dataList) {
                children.setChildren(getSubList(children.getId(), dataList));
            }
        }
        return getTreeData(treeList);
    }

    /**
     * 获取子数据集合
     *
     * @param id
     * @param dataList
     * @return
     */
    private static List<TreeData> getSubList(String id, List<TreeData> dataList) {
        List<TreeData> childList = new ArrayList<>();

        // 子集的直接子对象
        for (TreeData data : dataList) {
            if (id.equals(data.getParentId())) {
                childList.add(data);
            }
        }

        // 子集的间接子对象
        for (TreeData data : childList) {
            data.setChildren(getSubList(data.getId(), childList));
        }

        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }

    /**
     * 得到树数据，如果treeList的长度大于1，则说明不止一个根节点，则构建一个最外层的没有意义的虚拟节点出来作为最顶层根节点
     *
     * @param treeList
     * @return
     */
    private static TreeData getTreeData(List<TreeData> treeList) {
        if (treeList.size() > 1) {
            TreeData topTree = new TreeData();
            topTree.setChildren(treeList);
            return topTree;
            // 如果treeList的长度等于1，说明只有一个根节点
        } else if (treeList.size() == 1) {
            return treeList.get(0);
        } else {
            return null;
        }
    }

}
