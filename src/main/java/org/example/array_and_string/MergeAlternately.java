package org.example.array_and_string;

public class MergeAlternately {
    /**
     * 双指针遍历，遍历的最大值为两个字符串的最大长度。
     * 所需判断：如果已遍历完，不需要再移动指针。
     */
    public String mergeAlternately(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        int i = 0, j = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while (i < word1Length || j < word2Length) {
            if (i < word1Length) {
                stringBuilder.append(word1.charAt(i));
                ++i;
            }

            if (j < word2Length) {
                stringBuilder.append(word2.charAt(j));
                ++j;
            }

        }
        return stringBuilder.toString();
    }


    /**
     * 优化1: 可以合并为一个指针
     */
    public String mergeAlternately1(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        int i = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while (i < word1Length || i < word2Length) {
            if (i < word1Length) {
                stringBuilder.append(word1.charAt(i));
            }

            if (i < word2Length) {
                stringBuilder.append(word2.charAt(i));
            }
            ++i;
        }
        return stringBuilder.toString();
    }

    /**
     * 优化2: 优化 while 中的判断，使用预计算的常量最大长度。
     */
    public String mergeAlternately2(String word1, String word2) {
        int word1Length = word1.length(), word2Length = word2.length();
        int maxLength = Math.max(word1Length, word2Length);
        int i = 0;

        StringBuilder stringBuilder = new StringBuilder();
        while (i < maxLength) {
            if (i < word1Length) {
                stringBuilder.append(word1.charAt(i));
            }

            if (i < word2Length) {
                stringBuilder.append(word2.charAt(i));
            }
            ++i;
        }
        return stringBuilder.toString();
    }
}
