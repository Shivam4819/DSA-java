/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsa;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author shivam
 */
 class Nodes{
    protected int key;
    protected Nodes left,right;

}
public class ContinuousTree {
   Nodes root,newnode1,temp,temp1;
   
    public ContinuousTree() {
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

            newnode1=new Nodes();
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
        
        continuoustree(root);
    } 
       
     public void continuoustree(Nodes root){
        
        boolean flag=true; 
        Nodes temp1=null,temp2=null; 
        Queue<Nodes> q1=new LinkedList<>();
        Queue<Nodes> q2=new LinkedList<>();
        Iterator itr=q1.iterator();
        Iterator itr2=q2.iterator();  
        q1.add(root);
        
        while(itr.hasNext()|| itr2.hasNext()){
            while(itr.hasNext()){
                if(q1.element().left  != null)
                    q2.add(q1.element().left);

                if(q1.element().right != null)
                     q2.add(q1.element().right);
              
                System.out.print(q1.element().key+" ");
                temp1=q1.element();
                q1.remove();
            }
            while (itr2.hasNext())
            {
                if (q2.element().left != null)
                    q1.add(q2.element().left);

                if (q2.element().right != null)
                    q1.add(q2.element().right);
                
                System.out.print(q2.element().key+" ");
                temp2=q2.element();
                
                if(temp1.key-temp2.key==1 ||temp1.key-temp2.key==-1){
                    flag=false;
                }
                q2.remove();
                
            }
        }
        if(flag==false)
             System.out.println("continuous tree");
        else
             System.out.println("not continous");
        
    }
}
