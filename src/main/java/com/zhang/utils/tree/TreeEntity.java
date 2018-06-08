package com.zhang.utils.tree;

import java.util.List;

/**
 * 树形数据实体接口
 *
 * @author zhangyu
 * @create 2018-06-08 14:46
 **/
public interface TreeEntity<E> {

    String getId();

    String getParentId();

    void setChildList(List<E> childList);


}
