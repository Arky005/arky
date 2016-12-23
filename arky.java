import java.util.*;
import java.io.*;
import java.nio.file.*;

class arky
{
   static class files
   {  
      /*
       Funcao para ler um arquivo e rotornar uma String
         com o conteudo.
      */
      public static String read(String nome)
      {
         String texto="";
         try{
            FileReader arq= new FileReader(nome);
            BufferedReader ler = new BufferedReader(arq);
            String linha = ler.readLine();
            while(linha!=null)
            {
               texto+=linha+"\n";
               linha = ler.readLine();
            }
            ler.close();
            arq.close();
         } 
         catch(Exception e) { println("ERRO: " +e.getMessage()); }
         return texto;
      }
      /*
         Funcao para ler a linha de um arquivo e retorna-la.
         line: linha para ler.
      */
      public static String read(String nome, int line)
      {
         String linha="";
         try{
            FileReader arq= new FileReader(nome);
            BufferedReader ler = new BufferedReader(arq);
            for(int i=0; i<line; i++)
            {
               linha=ler.readLine();
            }
            ler.close();      
            arq.close();
         } 
         catch(Exception e) { println("ERRO: " +e.getMessage()); }
         return linha;
      }
      /*
         Metodo para escrever em um arquivo.
         append: true para completar arquivo, false para apagar e criar outro.
      */
      public static void write(String nome, String texto, boolean append)
      {
         try{
            FileWriter arq= new FileWriter(nome, append);
            BufferedWriter write = new BufferedWriter(arq);
            write.write(texto);
            write.close();
            arq.close();
         } 
         catch(Exception e) { println("ERRO: " +e.getMessage()); }
      }
      /*
         Metodo para trocar a ordem dos arquivos em um diretorio
         alterando seus nomes.
      */
      public static void changelist(String dir)
      {
         File a=new File(dir);
         File arquivos[]= a.listFiles();
         String newname;
         try{
             for(int i=0; i<arquivos.length; i++)
            {
               newname=dir+(int)(Math.random()*10)+arquivos[i].getName();
               File antigoName=new File(dir+arquivos[i].getName());
               File nName=new File(newname);
               Files.move(antigoName.toPath(), nName.toPath());
            }
         }
         catch(Exception e){ println("ERRO: "+ e.getMessage()); } 
      }
      /*
         Metodo para mostrar todos os arquivos de um diretorio.
      */
      public static void showlist(String dir)
      {
         File a=new File(dir);
         File arquivos[]= a.listFiles();
         for(int i=0; i<arquivos.length; i++)
         {
            println(arquivos[i].getName());
         }
      }
      /*
         Metodo para alterar o nome de um arquivo.
      */
      public static void changename(String file, String newname)
      {
         try{
            File old=new File(file);
            File nName=new File(newname);
            Files.move(old.toPath(), nName.toPath());      
         
         } catch(Exception e){ println("ERRO: "+e.getMessage()); }
      
      }
      /*
         Funcao para saber se existe arquivo com o nome especificado.
      */
      public static boolean exists(String file)
      {  
         String s="";
         boolean resp=false;
         File a=new File(file);
         File b=new File(a.getParent()+"\\");
         File arquivos[]= b.listFiles();
         Path p = Paths.get(file);
         for(int i=0; i<arquivos.length; i++)
         {
            s+=arquivos[i].getName();
         }
         if(s.contains(p.getFileName().toString()))
            resp=true;
        return resp;
      }
      /*
         Metodo para deletar um arquivo ou pasta.
      */
      public static void delete(String file)
      {
         try{
            Path a = Paths.get(file);
            Files.delete(a);
         } catch(Exception e) { println("ERRO: "+ e.getMessage()); }
      }
      
   
   }//classe files
   
   static class arrays
   {
      /*
         Ordena um array pelo metodo de selecao.
         usar: array=selecao(array).
      */
      public static int[] selecao(int[] v)
      {
         int[] novo= new int[v.length];
         novo=v;
         int menor, temp;
         if(novo.length>0)
         {
            for(int i=0; i<novo.length-1; i++)
            {
               menor=i;
               for(int j=(i+1); j<novo.length; j++)
               {
                  if(novo[j]<novo[menor])
                     menor=j;
               }
               temp=novo[menor];
               novo[menor]=novo[i];
               novo[i]=temp;
            }
         }
         return novo;
      }
      /*
         Ordena um array pelo metodo de insercao.
      */
     /* public static int[] insercao(int[]v)
      {
         
      
      }*/
      /*
         Metodo para mostrar os itens de um array de inteiros.
      */
      public static void show(int[]arr)
      {
         for(int i=0; i<arr.length; i++)
         {
            print(arr[i]+"\t");
         }
         println("");
      }
      /*
         Metodo para mostrar os itens de um array de Strings.
      */
      public static void show(String[]arr)
      {
         for(int i=0; i<arr.length; i++)
         {
            print(arr[i]+"\t");
         }
         println("");
      }
      /*
         Metodo para mostrar os itens de um array de booleans.
      */
      public static void show(boolean[]arr)
      {
         for(int i=0; i<arr.length; i++)
         {
            print(arr[i]+"\t");
         }
         println("");
      }
      /*
         Metodo para mostrar os itens de um array de doubles.
      */
      public static void show(double[]arr)
      {
         for(int i=0; i<arr.length; i++)
         {
            print(arr[i]+"\t");
         }
         println("");
      }
      
      
   }//classe arrays


   /*
      Metodo para escrever na tela e pular de linha.
   */
   public static void println(String s)
   {
      System.out.println(s);
   }
   /*
      Metodo para escrever na tela.
   */
   public static void print(String s)
   {
      System.out.print(s);
   }
   /*
      Funcao para ler uma resposta do usuario e retornar 
      uma String.
   */
   public static String read_String(String s)
   {
      Scanner value= new Scanner(System.in);
      System.out.print(s);
      return value.nextLine();
   }
   /*
      Funcao para ler uma resposta do usuario e retornar
      um valor inteiro.
      String s: pergunta.
   */
   public static int read_int(String s)
   {
      int resp=0;
      Scanner value= new Scanner(System.in);
      System.out.print(s);
      try{
         resp=Integer.parseInt(value.nextLine());
      } 
      catch(Exception e)
      {
         println("ERRO" + e.getMessage());
      }
      return resp;
   }
   /*
      Funcao para ler uma resposta do usuario e retornar
      um valor real.
      String s: pergunta.
   */
   public static double read_double(String s)
   {
      double resp=0.0;
      Scanner value= new Scanner(System.in);
      System.out.print(s);
      try{
         resp=Double.parseDouble(value.nextLine());
      } 
      catch(Exception e)
      {
         println("ERRO: " + e.getMessage());
      }
      return resp;
   }
   /*
      Funcao para ler uma resposta do usuario e retornar
      um valor booleano.
      String s: pergunta.
   */
   public static boolean read_boolean(String s)
   {
      boolean resp=false;
      Scanner value= new Scanner(System.in);
      System.out.print(s);
      String getv=value.nextLine();
      if(getv.equals("true")||getv.equals("TRUE")||getv.equals("1")||getv.equals("t")
      ||getv.equals("T")||getv.equals("V")||getv.equals("v"))
         resp=true;
      return resp;
   }
      /*
   
   */
   
   /*
      Metodo para dar uma pausa no programa.
   */
   public static void pause()
   {
      Scanner value= new Scanner(System.in);
      println("Tecle ENTER para continuar...");
      value.nextLine();
   }

   

}