package com.yoshino.p61to80;

import java.util.Stack;
import java.util.stream.Collectors;

public class P71SimplifyPath {

    /**
     * 一次遍历，需要区分四种情况
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param path
     * @return
     */
    public String simplifyPath(String path) {
        String[] pathStrs = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String pathStr : pathStrs) {
            if (pathStr.isBlank()) {
                continue;
            }
            if (".".equals(pathStr)) {
                continue;
            }
            if (!stack.isEmpty() && "..".equals(pathStr)) {
                stack.pop();
            }
            if (!"..".equals(pathStr)) {
                stack.push(pathStr);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {

    }
}
