package com.yiqizuoye.pojo.efficient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: kang.liu
 * @since : 2019/3/10 6:07 PM
 */
public class ListGroupByTest {
    public static void main(String[] args) {
        List<PeopleGroup> peopleGroups = new ArrayList<>();
        peopleGroups.add(new PeopleGroup("lk", 10, 1));
        peopleGroups.add(new PeopleGroup("lk", 10, 1));
        peopleGroups.add(new PeopleGroup("lk", 10, 1));
        peopleGroups.add(new PeopleGroup("lk", 11, 1));
        peopleGroups.add(new PeopleGroup("lk", 12, 1));
        peopleGroups.add(new PeopleGroup("lk", 10, 2));
        peopleGroups.add(new PeopleGroup("lk", 11, 2));
        peopleGroups.add(new PeopleGroup("my", 18, 1));
        peopleGroups.add(new PeopleGroup("my", 18, 1));
        peopleGroups.add(new PeopleGroup("my", 18, 1));
        peopleGroups.add(new PeopleGroup("my", 18, 1));
        peopleGroups.add(new PeopleGroup("my", 18, 2));
        peopleGroups.add(new PeopleGroup("my", 19, 1));
        peopleGroups.add(new PeopleGroup("my", 19, 2));
        Map<List<? extends Serializable>, Long> collect = peopleGroups.stream().
                collect(Collectors.groupingBy(peopleGroup ->
                Arrays.asList(peopleGroup.getName(), peopleGroup.getAge(), peopleGroup.getGender()), Collectors.counting()))
                ;
        collect.forEach((o, o2) -> {
            System.out.println("key: " + o+" value:"+o2);
        });
    }
}
