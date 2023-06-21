package Medium;

import utils.TreeNode;
import utils.TreeUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTreeFromInorderAndPostorder {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String []str=br.readLine().split(" ");
        ArrayList<Integer> A=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            A.add(Integer.parseInt(str[i]));
        str=br.readLine().split(" ");
        ArrayList<Integer> B=new ArrayList<>();
        for(int i=0;i<str.length;i++)
            B.add(Integer.parseInt(str[i]));
        BinaryTreeFromInorderAndPostorder obj=new BinaryTreeFromInorderAndPostorder();
        TreeUtils.print(obj.buildTree(A,B));
    }
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B){
        HashMap<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<A.size();i++)
            mp.put(A.get(i), i);
        return buildTreeUtil(B,A,0,B.size()-1,0,A.size()-1,mp);
    }
    public TreeNode buildTreeUtil(ArrayList<Integer> A, ArrayList<Integer> B, int s1, int e1, int s2, int e2, HashMap<Integer,Integer> mp){
        if(s1>e1)
            return null;
        int pos=mp.get(A.get(e1));
        TreeNode root=new TreeNode(A.get(e1));
        root.left=buildTreeUtil(A,B,s1,s1+pos-s2-1,s2,pos-1,mp);
        root.right=buildTreeUtil(A,B,s1+pos-s2,e1-1,pos+1,e2,mp);
        return root;
    }
}
