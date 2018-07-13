/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Iterator;
import java.util.InputMismatchException;
/**
 *
 * @author shivam
 */
public class Node {
    protected int key;
    protected Node left,right;
}

class Tree extends Node{
    
    Node root,newnode1,temp,temp1;

    public Tree() {
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
            if(i==num-1){
                lastValue=data;
            }
            
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
                            temp1=temp;
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
                            temp1=temp;
                            System.out.println("moved right");
                            flag=true;
                        }
                    }
                    else
                        System.out.println("wrong choice");
                }
            }
        }
        printPreorder(root);
        System.out.println("want to delete value or not \n 1)yes \t  2)no");
        int choice=scanner.nextInt();
        if(choice==1)
            delete(lastValue);
        
    }
    
    public void printPreorder(Node root){
        if (root == null)
            return;
        System.out.print(root.key + " ");
        printPreorder(root.left);
        printPreorder(root);
    }
    
    public void delete(int lastValue){
        Node value;
        boolean flag1=true;
        int deleteValue=0;
        Scanner scanner =new Scanner(System.in);
        
        while(flag1){
                try{
                System.out.println("enter which data you want to delete");
                deleteValue=scanner.nextInt();
                flag1=false;
                }
                catch(InputMismatchException e){
                    System.out.println("wrong input!!..");
                    scanner.nextLine();
                }
            }
        
        value=levelorder(root,deleteValue);
        value.key=lastValue;
        if(temp1.right.key==lastValue){
            temp1.right=null;
        }
        else if(temp1.left.key==lastValue){
            temp1.left=null;
        }
        System.out.println("second time traversal");
        printPreorder(root);
    }
    public Node levelorder(Node root,int deleteValue){
        
        Node temp1,temp2=null; 
        Queue<Node> q1=new LinkedList<>();
        Queue<Node> q2=new LinkedList<>();
        Iterator itr=q1.iterator();
        Iterator itr2=q2.iterator();  
        q1.add(root);
        
        while(itr.hasNext()|| itr2.hasNext()){
            while(itr.hasNext()){
                if(q1.element().left  != null)
                    q2.add(q1.element().left);

                if(q1.element().right != null)
                     q2.add(q1.element().right);
              
                temp1=q1.element();
                if(temp1.key==deleteValue){
                    temp2=temp1;
                }
                q1.remove();
            }
            while (itr2.hasNext())
            {
                if (q2.element().left != null)
                    q1.add(q2.element().left);

                if (q2.element().right != null)
                    q1.add(q2.element().right);

                temp1=q2.element();
                 if(temp1.key==deleteValue){
                     temp2=temp1;
                }
                q2.remove();
            }
        }
        return temp2;
    }
}