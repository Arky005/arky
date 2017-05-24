import java.io.*;
import java.util.*;

public class estudo
{


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

 


   public static void main(String [] args)
   {
	  arky ark=new arky();
      arky.gui menu1=ark.new gui("arky class", 500, 500 );
	  
	  
	  /*
	  
	  */
	  
   }






}