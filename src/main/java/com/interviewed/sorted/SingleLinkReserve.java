package com.interviewed.sorted;

import javax.xml.soap.Node;
import java.io.Serializable;

/**
 * @author: kang.liu
 * @Desc: 单项链表反转
 * @since : 2019/3/10 6:07 PM
 */
public class SingleLinkReserve {

    public static void main(String[] args) {


    }

    /**
     * 迭代法
     * 先将下一节点记录下来，然后让当前节点指向上一节点，
     * 再将当前节点记录下来，让下一节点变成当前节点
     *
     * @param node
     * @return
     */

//    准备两个空结点 pre用来保存先前结点、next用来做临时变量
//            在头结点node遍历的时候此时为1结点
//    next = 1结点.next(2结点)
//            1结点.next=pre(null)
//    pre = 1结点
//            node = 2结点
//            进行下一次循环node=2结点
//            next = 2结点.next(3结点)
//            2结点.next=pre(1结点)=>即完成2->1
//    pre = 2结点
//            node = 3结
    public static NodeModel reserveOfIterable(NodeModel node) {
        NodeModel pre = null;
        NodeModel next = node;
        while (node != null) {
            // 当前节点的下一节点记录
            next = node.next;
            node.next = pre;
            pre =node;
            node =  next;
        }
        return pre;
    }

    /**
     * 递归法
     * 先找到最后一个节点，然后从最后一个节点之前的那个节点的方法体中开始将下一个指向当前一个,
     * 然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点。
     * @param node
     * @return
     */
    public static NodeModel reverseOfRecursion(NodeModel node){
        if (node.next==null){
            return node;
        }
        NodeModel next = node.next;
        next.next=null;
        NodeModel rehead = reverseOfRecursion(next);
        next.next=node;
        return rehead;
    }

}



