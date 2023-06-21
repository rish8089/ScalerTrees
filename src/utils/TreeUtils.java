package utils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
    public static TreeNode buildTree(int []arr){
        if(arr.length==0 || arr[0]==-1)
            return null;
        Queue<QNode> q=new LinkedList<>();
        TreeNode root=new TreeNode(arr[0]);
        q.add(new QNode(0,root));
        int idx=0;
        while(!q.isEmpty()){
            QNode qnd=q.poll();
            if(idx+1<arr.length && arr[idx+1]!=-1){
                qnd.nd.left=new TreeNode(arr[idx+1]);
                q.add(new QNode(idx+1, qnd.nd.left));
            }
            if(idx+2<arr.length && arr[idx+2]!=-1){
                qnd.nd.right=new TreeNode(arr[idx+2]);
                q.add(new QNode(idx+2, qnd.nd.right));
            }
            idx+=2; //processed 2 nodes so increased idx by 2
        }
        return root;
    }
    public static void print(TreeNode root){
        if(root==null)
            return;
        System.out.print(root.val+" ");
        print(root.left);
        print(root.right);
    }
    static class QNode{
        int idx;
        TreeNode nd;
        QNode(int idx, TreeNode nd){
            this.idx=idx;
            this.nd=nd;
        }
    }
}
