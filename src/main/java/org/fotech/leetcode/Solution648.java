package org.fotech.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution648 {
    // 这里用哈希解乏比较简单。但实际上是一道前缀树问题。
    // 哈希时间耗时比较多，前缀书性能更强
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet<>(dictionary);
        List<String> sentenceList = Arrays.asList(sentence.split(" "));
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < sentenceList.size(); i++) {
            stb.append(replaceWord(sentenceList.get(i), set));
            if (i != sentenceList.size() - 1) {
                stb.append(" ");
            }
        }

        return stb.toString();
    }

    private String replaceWord(String str, Set<String> dictionary) {
        for (int i = 0; i < str.length(); i++) {
            if (dictionary.contains(str.substring(0, i + 1))) {
                return str.substring(0, i+1);
            }
        }

        return str;
    }

    public static void main(String[] args) {
        List<String> dic = Arrays.asList("a","b","c");
        String sen = "aadsfasf absbs bbab cadsfafs";
        Solution648 solution648 = new Solution648();
        System.out.println(solution648.replaceWords(dic, sen));
    }
}
