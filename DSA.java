/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;
import java.util.Queue;

/**
 *
 * @author shivam
 */
public class DSA {
        
    /**
     * @param args the command line arguments
     */
    
    
    
    public static void main(String[] args) {
        // TODO code application logic 
        BinaryTree tree =new BinaryTree();
            tree.insert();
        
        BFS bfs=new BFS();
            bfs.insert();
        
        DFS dfs=new DFS();
            dfs.insert();
        ContinuousTree continoustree=new ContinuousTree();
            continoustree.insert();
     
        ArrayBinaryTree arrayrepresent=new ArrayBinaryTree();
            arrayrepresent.insertIntoArray();
            arrayrepresent.displayArray();
     
     }
}

 