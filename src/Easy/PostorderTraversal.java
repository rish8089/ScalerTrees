package Easy;

import utils.TreeNode;
import utils.TreeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class PostorderTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int []a=new int[str.length];
        for(int i=0;i<str.length;i++)
            a[i]=Integer.parseInt(str[i]);
        PostorderTraversal obj=new PostorderTraversal();
        System.out.println(obj.postorderTraversal(TreeUtils.buildTree(a)));
    }
    public ArrayList<Integer> postorderTraversal(TreeNode A){
        Stack<TreeNode> s=new Stack<>();
        pushLeftMostBranch(A,s);
        ArrayList<Integer> res=new ArrayList<>();
        HashSet<TreeNode> hs=new HashSet<>();
        while(!s.isEmpty()){
            TreeNode nd=s.peek();
            if(!hs.contains(nd)){
                pushLeftMostBranch(nd.right,s);
                hs.add(nd);
            }else{
                res.add(nd.val);
                s.pop();
            }
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
