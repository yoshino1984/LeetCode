package com.yoshino.leetcode.p251to300;

import com.yoshino.leetcode.model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 二叉树的序列化与反序列化
 *
 * @author wangxin
 * 2020/6/16 23:56
 * @since
 **/
public class P297SerializeAndDeserializeBinaryTree {


    /**
     * dfs编码和解码 先序遍历
     *
     */
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        StringBuilder ans = new StringBuilder();
        bfsSerialize(root, ans);
        return ans.toString().substring(1);
    }

    private void bfsSerialize(TreeNode node, StringBuilder ans) {
        if (node == null) {
            ans.append(",null");
            return;
        } else {
            ans.append(",").append(node.val);
        }
        bfsSerialize(node.left, ans);
        bfsSerialize(node.right, ans);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (Objects.isNull(data)) {
            return null;
        }
        String[] strings = data.split(",");
        List<String> dataList = new LinkedList<>(Arrays.asList(strings));
        if (dataList.size() == 0) {
            return null;
        }
        return bfsDeserialize(dataList);
    }

    private TreeNode bfsDeserialize(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(list.remove(0)));
        node.left = bfsDeserialize(list);
        node.right = bfsDeserialize(list);
        return node;
    }

    public static void main(String[] args) {
        P297SerializeAndDeserializeBinaryTree codec = new P297SerializeAndDeserializeBinaryTree();
//        String str = "1,2,3,null,null,4,5,null,null,null,null";
//        TreeNode root = codec.deserialize(str);
//        System.out.println(codec.serialize(root));
//        System.out.println(str.equals(codec.serialize(root)));

        System.out.println(codec.deserialize(codec.serialize(null)));
    }
}
