package com.yiqizuoye.pojo.collection.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: kang.liu
 * Date  : 2018/5/10 14:06
 * Description:
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Company implements Comparable<Company> {
    private int no;
    private String name;
    private int num;
    private String founder;
    private String info;

    public Company() {
        super();
    }

    public Company(int no, String name, int num, String founder, String info) {
        this.no = no;
        this.name = name;
        this.num = num;
        this.founder = founder;
        this.info = info;
    }

    @Override
    public int compareTo(Company o) {
        //公司编号
        int a = this.no - o.no;
        if (a != 0) {
            return a;
        } else {
            //公司名称
            CollationKey key = Collator.getInstance().getCollationKey(this.name);
            CollationKey key2 = Collator.getInstance().getCollationKey(o.name);
            int b = key.compareTo(key2);
            if (b != 0) {
                return b;
            } else {
                //创始人
                CollationKey key3 = Collator.getInstance().getCollationKey(this.founder);
                CollationKey key4 = Collator.getInstance().getCollationKey(o.founder);
                int c = key3.compareTo(key4);
                if (c != 0) {
                    return c;
                } else {
                    //公司人数
                    return this.num - o.num;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Company [no=" + no + ", name=" + name + ", num=" + num + ", founder=" + founder + ", info=" + info
                + "]";
    }


    public static void main(String[] args) {
        TreeMap<Company, String> map=new TreeMap<>();
        map.put(new Company(1001, "百度", 2000, "李彦宏", "全球最大的中文搜索引擎、致力于让网民更便捷地获取信息，找到所求"), "有钱的公司，任性！！");
        map.put(new Company(1010, "腾讯", 10000, "马化腾", "深圳市腾讯计算机系统有限公司成立于1998年11月，由马化腾、张志东、许晨晔、陈一丹、曾李青五位创始人共同创立"), "有钱的公司，任性！！");
        map.put(new Company(1020, "阿里巴巴", 20000, "马云", "阿里巴巴网络技术有限公司（简称：阿里巴巴集团）"), "有钱的公司，任性！！");
        map.put(new Company(1050, "京东", 8000, "刘强东", "京东（JD.com）是中国最大的自营式电商企业，2015年第一季度在中国自营式B2C电商市场的占有率为56.3%"), "有钱的公司，任性！！");
        map.put(new Company(1030, "小米", 5000, "雷军", "小米公司成立于2010年4月，是一家专注于智能产品自主研发的移动互联网公司"), "有钱的公司，任性！！");
        Set<Company> companies = map.keySet();
        companies.forEach(company -> {
            System.out.println(company+"  "+map.get(company));

        });


    }
}