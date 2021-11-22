package com.exception.reraise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @author :liukang07
 * @version :1.0
 * @date :2021/11/22 5:29 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String userName;

    private List<String> positionList = new ArrayList<>();

    public User addPosition(String... position) {
        positionList.addAll(Arrays.asList(position));
        return this;
    }

    public static void main(String[] args) {
        User user = User.builder().userName("张三").build().addPosition("经理");
        System.out.println(user.getPositionList());
    }
}
