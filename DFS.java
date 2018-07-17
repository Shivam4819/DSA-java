/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author shivam
 */

public class DFS extends Node{
    Node root,newnode1,temp,temp1;

    public DFS() {
    root=null;
    }
    
    public void insert() throws InputMismatchException{
        Scanner scanner =new Scanner(System.in);
        boolean flag=true,flag1=true;
        int lastValue=0,num=0,data=0;
        
        while(flag1){
            try{
            System.out.print("enter the no of data-");
            num=scanner.nextInt();
            flag1=false;
            }
            catch(InputMismatchException i){
                System.out.println("wrong input!!..");
                scanner.nextLine();
            }
        }
        flag1=true;
        for (int i = 0; i < num; i++) {
            
            while(flag1){
                try{
                System.out.print("enter data-");
                data=scanner.nextInt();
                flag1=false;
                }
                catch(InputMismatchException e){
                    System.out.println("wrong input!!..");
                    scanner.nextLine();
                }
            }
            flag1=true;

            newnode1=new Node();
            newnode1.left=null;
            newnode1.key=data;
            newnode1.right=null;
            
            
            if(root==null){
                root=newnode1;
                System.out.println("root is inserted");
            }
            else{
                temp=root;
                System.out.println("you are in else");
                flag=true;
                while(flag){
                    
                    System.out.print("where you want to insert-");
                    char choice=scanner.next().charAt(0);
                    if(choice=='l'){
                        if(temp.left==null){
                            temp.left=newnode1;
                            System.out.println("inserted on left");
                            flag=false;
                        }
                        else{
                            temp=temp.left;
                            System.out.println("moved left");
                            flag=true;
                        }
                    }
                    else if(choice=='r'){
                        if(temp.right==null){
                            temp.right=newnode1;
                            System.out.println("inserted on right");
                            flag=false;
                        }
                        else{
                            temp=temp.right;
                            System.out.println("moved right");
                            flag=true;
                        }
                    }
                    else
                        System.out.println("wrong choice");
                }
            }
        }
        
        System.out.print("postorder trversal-");
        printPostorder(root);
        System.out.print("preorder traversal");
        printPostorder(root);
        System.out.println("inorder traversal-");
        printInorder(root);
    }
    
    public void printPostorder(Node root){
        if (root == null)
            return;
        
        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.key + " ");
    }
    
    
    public void printPreorder(Node root){
        if (root == null)
            return;
        System.out.print(root.key + " ");
        printPostorder(root.left);
        printPostorder(root.right);
    }
    
    
    public void printInorder(Node root){
        if (root == null)
            return;
        printPostorder(root.left);
        System.out.print(root.key + " ");
        printPostorder(root.right);
    }
}
