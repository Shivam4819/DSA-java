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
public class ArrayBinaryTree {
    
   int[] arr=new int[10];
   
    public void initalize()throws InputMismatchException{
        
        for(int i=0;i<10;i++){
            arr[i]=0;
        }
    }
    public void insertIntoArray() throws InputMismatchException{
        Scanner scanner =new Scanner(System.in);
        boolean flag1=true;
        int place=0,data=0,num=0;
        
        initalize();
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

            
            
            if(arr[0]==0){
                arr[0]=data;
                System.out.println("root is inserted");
            }
            else{
                    
                    System.out.print("where you want to insert-");
                    char choice=scanner.next().charAt(0);
                    if(choice=='l'){
                        
                            place=(2*i)+1;
                            arr[place]=data;
                            System.out.println("inserted on left");
                        
                    }
                    else if(choice=='r'){
                            place=(2*i)+2;
                            arr[place]=data;
                            System.out.println("inserted on right");
                                                
                    }
                    else
                        System.out.println("wrong choice");
                
            }
        }
        
        
    }
    
    public void displayArray(){
    for(int i=0;i<10;i++){
            System.out.println(arr[i]+" ");
        }
    }
}
