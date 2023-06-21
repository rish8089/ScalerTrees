package Easy;

import utils.TreeNode;
import utils.TreeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class InorderTraversal {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        int []a=new int[str.length];
        for(int i=0;i<str.length;i++)
            a[i]=Integer.parseInt(str[i]);
        InorderTraversal obj=new InorderTraversal();
        System.out.println(obj.inorderTraversal(TreeUtils.buildTree(a)));
    }
    public ArrayList<Integer> inorderTraversal(TreeNode A){
        if(A==null)
            return new ArrayList<>();
        ArrayList<Integer> left=inorderTraversal(A.left);
        left.add(A.val);
        left.addAll(inorderTraversal(A.right));
        return left;
    }
}
