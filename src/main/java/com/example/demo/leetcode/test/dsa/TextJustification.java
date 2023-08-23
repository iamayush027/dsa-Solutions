package com.example.demo.leetcode.test.dsa;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();

        String[] words = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth = 16;

        List<String> result = textJustification.fullJustify(words, maxWidth);
        for (String line : result) {
            System.out.print("|");
            System.out.println(line+"|");

        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int startIndex = 0;
        while (startIndex < words.length) {
            int endIndex = findEndIndex(words, startIndex, maxWidth);
            result.add(justifyLine(words, startIndex, endIndex, maxWidth));
            startIndex = endIndex + 1;
        }
        return result;
    }

    private String justifyLine(String[] words, int startIndex, int endIndex, int maxWidth) {
        if (startIndex == endIndex || endIndex+1==words.length) {
            return leftJustify(words, startIndex,endIndex, maxWidth);
        }
        int totalLength = findTotalLength(words, startIndex, endIndex);
        int totalSpaces = maxWidth - totalLength;
        int totalWords = endIndex - startIndex;
        int spacesBetweenWords = totalSpaces / totalWords;
        int extraSpace = totalSpaces % totalWords;
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            sb.append(words[i]);
            if(i<endIndex) {
                int spacesToAdd = spacesBetweenWords + (extraSpace > 0 ? 1 : 0);
                sb.append(" ".repeat(spacesToAdd));
                extraSpace--;
            }
        }
        return sb.toString();
    }

    private int findTotalLength(String[] words, int startIndex, int endIndex) {
        int length = 0;
        for (int i = startIndex; i <= endIndex; i++) length += words[i].length();
        return length;
    }

    private String leftJustify(String[] words, int startIndex, int endIndex, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for(int i=startIndex;i<=endIndex;i++) {
            sb.append(words[i]);
            if(i<endIndex)
            {
                sb.append(" ");
            }
        }
        sb.append(" ".repeat(maxWidth - sb.length()));
        return sb.toString();
    }

    private int findEndIndex(String[] words, int startIndex, int maxWidth) {
        int endIndex = startIndex;
        int lineLength = words[endIndex].length();
        while (endIndex + 1 < words.length && lineLength + words[endIndex + 1].length() + 1 <= maxWidth) {
            endIndex++;
            lineLength += words[endIndex].length() + 1;
        }
        return endIndex;
    }
}
