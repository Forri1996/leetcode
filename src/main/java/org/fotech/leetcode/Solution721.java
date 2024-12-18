package org.fotech.leetcode;

import java.util.*;

/**
 * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
 *
 * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。
 * 请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
 *
 * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * 输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * 解释：
 * 第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。
 * 第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
 * 可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
 * ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 * 示例 2：
 *
 * 输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * 输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 *
 * 构建email的并查集
 */
public class Solution721 {

    static Map<String, String> emailArrParent = new HashMap<>();
    public static void main(String[] args) {
        String[][] accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        Map<String, String> emailNameMap = new HashMap<>();
        // 初始化两个map
        for (String[] accountConfig : accounts) {
            for (int i = 1; i < accountConfig.length; i++) {
                // 初始化并查集，每一个父级都是自己
                if (i == 1) {
                    emailArrParent.put(accountConfig[i], accountConfig[i]);
                } else {
                    emailArrParent.put(accountConfig[i], accountConfig[1]);
                }
                emailNameMap.put(accountConfig[i], accountConfig[0]);
            }
        }
        // 合并emailArr中的并查集
        emailArrParent.forEach((email, emailParent) -> {
            // 如果email的父级已经是自己，那么说明是根节点，不处理
            if (Objects.equals(emailArrParent.get(emailParent), emailParent)) {

            } else {
                emailArrParent.put(email, find(emailParent));
            }
        });
        Map<String, List<String>> rootEmailMap = new HashMap<>();
        emailArrParent.forEach((k, v) -> {
            if (rootEmailMap.containsKey(v)) {
                rootEmailMap.get(v).add(k);
            } else {
                List<String> m = new ArrayList<>();
                m.add(k);
                rootEmailMap.put(v, m);
            }
        });
        List<List<String>> result = new ArrayList<>();
        rootEmailMap.forEach((k, v) -> {
            List<String> item = new ArrayList<>();
            item.add(emailNameMap.get(k));
            for (String email : v) {
                item.add(email);
            }
            result.add(item);
        });
        System.out.println(result);
    }

    private static String find(String emailParent) {
        if (emailArrParent.get(emailParent) != emailParent) {
            return find(emailParent);
        }

        return emailParent;
    }

    private static void union(String email1, String email2, Map<String,Integer> emailNameMap) {

    }


}
