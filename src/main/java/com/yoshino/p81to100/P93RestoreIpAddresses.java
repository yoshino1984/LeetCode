package com.yoshino.p81to100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 复原IP地址
 **/
public class P93RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(s, 0, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(String s, int level, int index, LinkedList<String> path, List<String> ans) {
        if (level == 4) {
            if (index == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }

        for (int i = index; i < s.length() && i < index + 3; i++) {
            String curIp = s.substring(index, i + 1);
            if (valid(curIp)) {
                path.addLast(curIp);
                dfs(s, level + 1, i + 1, path, ans);
                path.removeLast();
            }
        }
    }

    private boolean valid(String curIp) {
        if (curIp.length() > 1 && curIp.startsWith("0")) {
            return false;
        }
        int val = Integer.parseInt(curIp);
        return val >= 0 && val <= 255;
    }
}
