package com.zhang.utils.tree.treeutils;

import java.util.ArrayList;
import java.util.List;

/**
 * 树工具类
 *
 * @author zhangyu
 * @create 2019-03-11 17:27
 **/
public class TreeUtil {

    /**
     * 递归构建树
     *
     * @param trees 转换后得树对象集合
     * @return
     */
    public static List<Tree> createTree(List<Tree> trees) {
        List<Tree> newTrees = new ArrayList<>();
        for (Tree tree : trees) {
            // 如果父节点是0，则为顶级节点
            if ("0".equals(tree.getParentId())) {
                newTrees.add(findChildren(tree, trees));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param tree  树对象
     * @param trees 转换后得树对象集合
     * @return
     */
    public static Tree findChildren(Tree tree, List<Tree> trees) {
        for (Tree it : trees) {
            if (tree.getId().equals(it.getParentId())) {
                if (tree.getChildren() == null) {
                    tree.setChildren(new ArrayList<>());
                }
                tree.getChildren().add(findChildren(it, trees));
            }
        }
        return tree;
    }

}



