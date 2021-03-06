package com.chen.leetcode.stack.easy;

import java.util.Stack;

/**
 * 844. 比较含退格的字符串 https://leetcode-cn.com/problems/backspace-string-compare/
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 */
public class backspaceCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackt = new Stack();
        Stack<Character> stacks = new Stack();
        for (char c : S.toCharArray()) {
            if (!stacks.isEmpty() && c == '#') {
                stacks.pop();
            } else {
                if (c == '#') {
                    continue;
                }

                stacks.push(c);
            }
        }

        for (char c : T.toCharArray()) {
            if (!stackt.isEmpty() && c == '#') {
                stackt.pop();
            } else {
                if (c == '#') {
                    continue;
                }
                stackt.push(c);
            }
        }
        return String.valueOf(stackt).equals(String.valueOf(stacks));
    }

    public static void main(String[] args) {
        System.out.println(new backspaceCompare().backspaceCompare("y#fo##f", "y#f#o##f"));
    }
}
