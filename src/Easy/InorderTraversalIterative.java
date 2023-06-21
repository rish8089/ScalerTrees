package Easy;

import com.sun.source.tree.Tree;
import utils.TreeNode;
import utils.TreeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalIterative {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int []a=new int[str.length];
        for(int i=0;i<str.length;i++)
            a[i]=Integer.parseInt(str[i]);
        InorderTraversalIterative obj=new InorderTraversalIterative();
        System.out.println(obj.inorderTraversal(TreeUtils.buildTree(a)));
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A){
        Stack<TreeNode> s=new Stack<>();
        pushLeftMostBranch(A,s);
        ArrayList<Integer> res=new ArrayList<>();
        while(!s.isEmpty()){
            TreeNode nd=s.pop();
            res.add(nd.val);
            pushLeftMostBranch(nd.right,s);
        }
        return res;
    }
    private void pushLeftMostBranch(TreeNode A, Stack<TreeNode> s){
        while(A!=null){
            s.add(A);
            A=A.left;
        }
    }
}
