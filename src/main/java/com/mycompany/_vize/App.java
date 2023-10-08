/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany._vize;

/**
 *
 * @author HP
 */
import java.util.Scanner;
public class App {

   
      static void balonPozisyonuBul(int atlamaSayisi, int balonSayisi){
    
        Node head = null;
        Node temp = null;
        for (int i = 1; i <= balonSayisi; i++) 
        {
            Node yeniBalon = new Node(i);
            
            if (head == null) 
            {
                head = yeniBalon;
                head.next = head;
            } 
            else 
            {
                temp.next = yeniBalon;
            }
            
            temp = yeniBalon;
        }
        temp.next = head;
        
        Node current = head;
        
        
       
        Node prev = current;
        current = head;
        
        while(current.next != current)
        {
            for(int i = 1; i < atlamaSayisi; i++)
            {
                prev = current;
                current = current.next;
            }

            prev.next = current.next;
            current = prev.next;
        }
        System.out.println("Patlamayan Balon: " + current.data);
 
      }
     
      
      
    public static class Node{
        public int data;
        public Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) 
    {
        System.out.print("\nHOS GELDINIZ ");

        boolean devamEt = true;
        while(devamEt)
        {
            System.out.print("\nBALON PATLATMA OYUNU");

            Scanner sc = new Scanner(System.in);

            System.out.print("\nBalon Sayisi: ");
            int balonSayisi = sc.nextInt();

            System.out.print("Atlama Sayisi: ");
            int atlamaSayisi = sc.nextInt();

            balonPozisyonuBul(atlamaSayisi,balonSayisi);
            boolean dogrumu = false;
            while(dogrumu == false)
            {
                System.out.println("Tekrar oynamak istiyor musunuz? (E,e/H,h)");
                Scanner scanner = new Scanner(System.in);
                String cevap = scanner.nextLine();
                if(cevap.equalsIgnoreCase("H") || cevap.equalsIgnoreCase("h"))
                {
                  dogrumu = true;
                  devamEt = false;
                }
                else if(cevap.equalsIgnoreCase("E") || cevap.equalsIgnoreCase("e"))
                {
                    dogrumu = true;
                    continue;
                }
                else
                {
                    System.out.print("Lutfen gecerli bir harf girin\n");
                    dogrumu = false;
                }
        
            }
        } 
    }
}
