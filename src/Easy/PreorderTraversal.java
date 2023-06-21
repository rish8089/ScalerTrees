package Easy;

import utils.TreeNode;
import utils.TreeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class PreorderTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int []a=new int[str.length];
        for(int i=0;i<str.length;i++)
            a[i]=Integer.parseInt(str[i]);
        PreorderTraversal obj=new PreorderTraversal();
        System.out.println(obj.preorderTraversal(TreeUtils.buildTree(a)));
    }
    public ArrayList<Integer> preorderTraversal(TreeNode A){
        Stack<TreeNode> s=new Stack<>();
        ArrayList<Integer> res=new ArrayList<>();
        pushLeftMostBranch(A,s,res);
        while(!s.isEmpty()){
            TreeNode nd=s.pop();
            pushLeftMostBranch(nd.right,s,res);
        }
        return res;
    }
    private void pushLeftMostBranch(TreeNode A, Stack<TreeNode> s, ArrayList<Integer> res){
        while(A!=null){
            s.add(A);
            res.add(A.val);
            A=A.left;
        }
    }
}
