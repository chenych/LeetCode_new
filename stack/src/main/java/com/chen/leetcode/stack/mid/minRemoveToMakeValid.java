package com.chen.leetcode.stack.mid;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 1249. 移除无效的括号 https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 * <p>
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 * <p>
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * 示例 4：
 * <p>
 * 输入：s = "(a(b(c)d)"
 * 输出："a(b(c)d)"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s[i] 可能是 '('、')' 或英文小写字母
 */
public class minRemoveToMakeValid {
    public String minRemoveToMakeValid(String s) {
        Stack stack = new Stack();
        StringBuffer sb = new StringBuffer();
        Set set = new HashSet();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();

                }
            }
        }
        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)) {
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }
}
