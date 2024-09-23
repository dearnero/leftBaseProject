package com.hf.left.hot;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: TODO
 * @author: huang fu
 * @date: 2024/9/23 21:13
 * @version: 1.0
 */
public class HDecodeString {

    public String decodeString(String s) {
        LinkedList<String> ans = new LinkedList();
        int idx = 0;
        while (idx < s.length()){
            char key = s.charAt(idx);
            if (Character.isDigit(key)){
                String digit = getDigit(s, idx);
                ans.addLast(digit);
                idx = idx + digit.length();
            } else if (key == '[' || Character.isLetter(key)){
                ans.addLast(String.valueOf(key));
                idx++;
            } else {
                idx++;
                List<String> arr = new ArrayList<>();
                while (!"[".equals(ans.peekLast())){
                    arr.add(ans.pollLast());
                }
                Collections.reverse(arr);
                // 删除“[”
                ans.pollLast();
                int count = Integer.parseInt(ans.pollLast());
                for (int i = 0; i < count; i++) {
                    for (int j = 0; j < arr.size(); j++) {
                        ans.addLast(arr.get(j));
                    }
                }
            }
        }
        return getString(ans);
    }

    public static void main(String[] args) {
        System.out.println(new HDecodeString().decodeString("2[abc]3[cd]ef"));
    }

    String getDigit(String s, int idx){
        StringBuffer sb = new StringBuffer();
        while (Character.isDigit(s.charAt(idx))){
            sb.append(s.charAt(idx));
            idx++;
        }
        return sb.toString();
    }

    String getString(LinkedList<String> ans){
        StringBuffer sb = new StringBuffer();
        for (String an : ans) {
            sb.append(an);
        }
        return sb.toString();
    }




}
