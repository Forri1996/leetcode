package org.fotech.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;

    }
    public List<Integer> findAnagrams2(String s, String p) {
        // 将s和p转换成List
        List<Character> sList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Character> pList = p.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < sList.size() - pList.size()+1; i++) {
            // 截取sList的子串
            List<Character> subList = sList.subList(i, i + pList.size());
            // 判断子串是否是pList的字母异位词
            if (isAnagram(subList, pList)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isAnagram(List<Character> subList, List<Character> pList) {
        List<Character> pListCopy = new ArrayList<>(pList);
        List<Character> subListCopy = new ArrayList<>(subList);
        pListCopy.sort(Character::compareTo);
        subListCopy.sort(Character::compareTo);

        return Objects.equals(pListCopy.toString(), subListCopy.toString());
    }

    public static void main(String[] args) {
        Solution438 solution = new Solution438();
        List<Integer> result = solution.findAnagrams("cbaebabacd", "abc");
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
