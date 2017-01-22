import java.io.*;
import java.util.*;

public class estudo
{


   public static String inverte(String s)
   {
      String resp="";
      if(s.length()>0)
      {
         for(int i=s.length()-1; i>=0; i--)
         {
            resp+=s.charAt(i);
         }
      
      } 
      else System.out.println("ERRO");
   
      return resp;
   }

   public static boolean palindromo(String s)
   {
      boolean resp=false;
      int count=0;
   
      if(s.length()>0)
      {
         for(int i=0; i<s.length()-1; i++)
         {
            if(s.charAt(i)==s.charAt(s.length()-1-i))
               count++;
            else i=s.length()-1;
         }
      
         if(count==s.length()-1)
            resp=true;
      
      } 
      else System.out.println("ERRO");
   
   
      return resp;
   }

   public static String toMaiuscula(String s)
   {
      String resp="";
      if(s.length()>0)
      {
         for(int i=0; i<s.length(); i++)
         {
            if(s.charAt(i)>='a'&&s.charAt(i)<='z')
            {
               resp+= ""+(char)(s.charAt(i)-32);
            }
            else
               resp+=s.charAt(i);
         }
      } 
      else System.out.println("ERRO");
   
      return resp;
   }

   public static double somatorio(int v)
   {
      double resp=0.0;
      double number=v;
   
      for(int i=0; i<=v; i++)
      {
         resp+=number;
         number--;
      }
   
      return resp;
   }


   public static void wesley_safadao(int dia, int mes, int ano)
   {
      double random=Math.random();
      double anjo, safadeza;
   
      if(random>0.5)
      {
         if(dia<10)
            anjo=somatorio(mes)+(ano/10)/(15*dia);
         else
            anjo=somatorio(mes)+(ano/10)/dia;
         safadeza=100-anjo;
       
      } 
      else {
      
         if(dia<10)
            safadeza=somatorio(mes)+(ano/10)/(15*dia);
         else
            safadeza=somatorio(mes)+(ano/10)/dia;
         anjo=100-safadeza;   
      
      }
     
   
      System.out.println("\n\n"+safadeza+"% safado\n"+anjo+"% anjo");
   
   }




   public static void main(String [] args)
   {
      /*
      System.out.println(inverte("OI"));
      System.out.println(""+palindromo("ARARA")+" "+ palindromo("OI") +" "+ palindromo("SUBINOONIBUS"));
      System.out.println(toMaiuscula("arroz"));
      System.out.println(""+somatorio(5));
      wesley_safadao(10,3,1998);
   
      int [] valores= new int [10];
   
      valores[0]=4;
      valores[1]=1;
      valores[2]=8;
      valores[3]=2;
      valores[4]=5;
      valores[5]=400;
      valores[6]=-11;
      valores[7]=8;
      valores[8]=2;
      valores[9]=5;
   
      arky.arrays.show(valores);   
      valores=arky.arrays.selecao(valores);
      arky.arrays.show(valores); 
      
      
     // arky.files.write("C:/Users/otavi/Desktop/Steam.exe", arky.files.read("E:/Steam/Steam.exe"), false);
    //  arky.files.write("C:/Users/otavi/Desktop/code.jpg", arky.files.read("C:/Users/otavi/Pictures/GTA5_2016_06_08_18_02_30_575.png"), false);
      arky.println("OK");
     */
     
     
      arky ark=new arky();
      arky.encrypter encrypt =ark.new encrypter();
      
      encrypt.create(arky.files.read("C:/Users/otavi/Desktop/jhfguy.txt"));
      arky.files.write("C:/Users/otavi/Desktop/new.txt", encrypt.get(), false);
      arky.println(encrypt.undo(arky.files.read("C:/Users/otavi/Desktop/new.txt")));
           
            
      
      arky.pause();
   
   }






}