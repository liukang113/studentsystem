package com.interviewed.sorted;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author: kang.liu
 * @Desc: 链表
 * @since : 2019/3/10 6:07 PM
 */

public class NodeModel implements Serializable {
    int index;
    NodeModel next;

    public NodeModel(int index, NodeModel next) {
      this.index = index;
      this.next = next;
    }

}
