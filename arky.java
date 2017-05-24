/**
* arky class
* @author Otavio Morais
* @version 0.2
*/

import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout.*;


class arky
{
	
	class gui
	{
		private String frameName;
		private boolean exitOnClose;
		public JFrame frame;
		private int nButtons, nTextFields, nLabels, nCheckBoxes;
		public JButton[] button;
		public JTextField[] textField;
		public JLabel[] label;
		public JCheckBox[] checkBox;
		private int frameWidth, frameHeight;
		private JPanel panel;
		private Insets insets;
		public JProgressBar bar;
		
		/**
		* "gui" class constructor.
		* @param  frameName  frame's name
		* @param  frameWidth  frame's width
		* @param  frameHeight  frame's height
		*/
		public gui(String frameName, int frameWidth, int frameHeight)
		{
			this.frameName=frameName;
			this.frameWidth=frameWidth;
			this.frameHeight=frameHeight;
			create();
			exitOnClose(true);
			nButtons=0; nTextFields=0; nLabels=0;
		}
		/**
		* Creates the graphic interface according to constructor's parameters.
		*/
		private void create()
		{
			frame = new JFrame(frameName);
			frame.setSize(frameWidth, frameHeight);
			frame.setVisible(true);
			panel=new JPanel();
			panel.setLayout(null);
			insets = panel.getInsets();
			panel.setBounds(insets.left, insets.top, frameWidth, frameHeight);
			panel.setVisible(true);
			frame.add(panel);
			checkBox= new JCheckBox[20];
			button = new JButton[20];
			textField= new JTextField[20];
			label=new JLabel[20];
			frame.setLocation((getScreenWidth()/2)-(frameWidth/2), (getScreenHeight()/2)-(frameHeight/2));
			frame.setResizable(false);
		}
	
		/**
		* Creates a button in the frame and returns it. 
		* @param  name  button's name
		* @param  x  x position
		* @param  y  y position
		* @param  width  button's width
		* @param  height  button's height
		* @param  showID  show its ID for later use
		* @return  the generated button
		*/
		public JButton addButton(String name, int x, int y, int width, int height, boolean showID)
		{
			if(showID)
				button[nButtons]=new JButton(nButtons+" "+name);
			else
				button[nButtons]=new JButton(name);
			button[nButtons].setVisible(true);
			button[nButtons].setBounds(x+insets.left, y+insets.top, width, height);
			panel.add(button[nButtons]);
			nButtons+=1;
			return button[nButtons-1];
		}
		/**
		* Creates a text field in the frame and returns it. 
		* @param  x  x position
		* @param  y  y position
		* @param  width  text field's width
		* @param  height  text field's height
		* @param  showID  show its ID for later use
		* @return  the generated text field
		*/
		public JTextField addTextField(int x, int y, int width, int height, boolean showID)
		{
			textField[nTextFields]=new JTextField(20);
			textField[nTextFields].setVisible(true);
			textField[nTextFields].setBounds(x+insets.left, y+insets.top, width, height);
			panel.add(textField[nTextFields]);
			if(showID)
				textField[nTextFields].setText(""+nTextFields);
			nTextFields+=1;
			return textField[nTextFields-1];
		}
		/**
		* Creates a label in the frame and returns it. 
		* @param  text  label's text
		* @param  x  x position
		* @param  y  y position
		* @param  width  label's width
		* @param  height  label's height
		* @param  showID  show its ID for later use
		* @return  the generated label
		*/
		public JLabel addLabel(String text, int x, int y, int width, int height, boolean showID)
		{
			if(showID)
				label[nLabels]=new JLabel(nLabels+" "+text);
			else 
				label[nLabels]=new JLabel(text);
			label[nLabels].setVisible(true);
			label[nLabels].setBounds(x+insets.left, y+insets.top, width, height);
			panel.add(label[nLabels]);
			nLabels+=1;
			return label[nLabels-1];
		}
		/**
		* Creates a checkbox in the frame and returns it. 
		* @param  text  checkbox's name
		* @param  x  x position
		* @param  y  y position
		* @param  width  checkbox's width
		* @param  height  checkbox's height
		* @param  showID  show its ID for later use
		* @return  the generated checkbox
		*/
		public JCheckBox addCheckBox(String text, int x, int y, int width, int height, boolean showID)
		{
			if(showID)
				checkBox[nCheckBoxes]=new JCheckBox(nCheckBoxes+" "+text);
			else 
				checkBox[nCheckBoxes]=new JCheckBox(text);
			checkBox[nCheckBoxes].setVisible(true);
			checkBox[nCheckBoxes].setBounds(x+insets.left, y+insets.top, width, height);
			panel.add(checkBox[nCheckBoxes]);
			nCheckBoxes+=1;
			return checkBox[nCheckBoxes-1];
		}
		/**
		* Creates an image in the frame and returns it. 
		* @param  path  image's location
		* @param  x  x position
		* @param  y  y position
		* @param  width  image's width
		* @param  height  image's height
		* @return  the generated image
		*/
		public JLabel addImage(String path, int x, int y, int width, int height)
		{
			JLabel img = new JLabel(new ImageIcon(path));
			img.setBounds(x+insets.left, y+insets.top, width, height);
			img.setVisible(true);
			panel.add(img);
			return img;
		}
		/**
		* Creates a progress bar in the frame and returns it. 
		* @param  value  progress bar's value
		* @param  x  x position
		* @param  y  y position
		* @param  width  progress bar's width
		* @param  height  progress bar's height
      * @return  the generated progress bar
		*/
		public JProgressBar addProgressBar(int value, int x, int y, int width, int height)
		{
			bar = new JProgressBar();
			bar.setValue(value);
			bar.setBounds(x+insets.left, y+insets.top, width, height);
			bar.setVisible(true);
			panel.add(bar);
			return bar;
		}
		/**
		* Edits the value, size and position of the progress bar. 
		* @param  value  progress bar's value
		* @param  x  x position
		* @param  y  y position
		* @param  width  progress bar's width
		* @param  height  progress bar's height
		*/
		public void editProgressBar(int value, int x, int y, int width, int height)
		{
			if(bar!=null)
			{
				bar.setValue(value);
				bar.setBounds(x+insets.left, y+insets.top, width, height);
			}
		}
		/**
		* Opens a filechooser in the frame. 
		* @return  the selected file or path.
		*/
		public File openFileChooser()
		{
			File ans=null;
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int open = fc.showOpenDialog(frame);
			if(open == JFileChooser.APPROVE_OPTION) 
				ans = fc.getSelectedFile();
			return ans;
		}
		/**
		* Sets the frame size. 
		* @param  width  frame's width
		* @param  height  frame's height
		*/
		public void setFrameSize(int width, int height)
		{
			frame.setSize(width, height);	
		}
		/**
		* Sets if the frame will exit or hide when it closes. 
		* @param  b  true to exit, false to hide
		*/
		public void exitOnClose(boolean b)
		{
			frame.setDefaultCloseOperation(b ? JFrame.EXIT_ON_CLOSE : JFrame.DISPOSE_ON_CLOSE);
		}
		/**
		* Hides the frame. 
		*/
		public void hide()
		{
			frame.setVisible(false);
		}
		/**
		* Shows the frame. 
		*/
		public void show()
		{
			frame.setVisible(true);
		}
		/**
		* @return the screen width
		*/
		public int getScreenWidth()
		{
			return (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		}
		/**
		* @return the screen height
		*/
		public int getScreenHeight()
		{
			return (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		}
		/**
		* Reset the frame after adding components
		*/
		public void noBug()
		{
			hide();
			show();
		}
	
	}//gui end

	static class files
	{  
		
		/**
		* Reads a file and returns a String with its content. 
		* @param  name  file's location
		* @return  String with file's content
		*/
		public static String read(String name)
		{
			String text="";
			try{
				FileReader fl= new FileReader(name);
				BufferedReader rd = new BufferedReader(fl);
				String line = rd.readLine();
				while(line!=null)
				{
					text+=line+"\n";
					line = rd.readLine();
				}
				rd.close();
				fl.close();
			} 
			catch(Exception e) { println("ERROR: " +e.getMessage()); }
			return text;
		}
		/**
		* Reads a file and returns the number of lines. 
		* @param  name  file's location
		* @return  int with the number of lines
		*/
		public static int lines(String name)
		{
			int ln=0;
			try{
				FileReader fl= new FileReader(name);
				BufferedReader rd = new BufferedReader(fl);
				String line = rd.readLine();
				while(line!=null)
				{
					ln++;
					line = rd.readLine();
				}
				rd.close();
				fl.close();
			} 
			catch(Exception e) { println("ERROR: " +e.getMessage()); }
			return ln;
		}
		/**
		* Reads a determined line of a file and returns a String with its content. 
		* @param  name  file's location
		* @param  line  line to read
		* @return  String with line's content
		*/
		public static String read(String name, int line)
		{
			String ln="";
			try{
				FileReader fl= new FileReader(name);
				BufferedReader rd = new BufferedReader(fl);
				for(int i=0; i<line; i++)
				{
					ln=rd.readLine();
				}
				rd.close();      
				fl.close();
			} 
			catch(Exception e) { println("ERROR: " +e.getMessage()); }
			return ln;
		}
		/**
		* Writes in an existing file or create a new and writes in it.
		* @param  name  file's location
		* @param  text  text to write in the file
		* @param  append  create a new or append in existing text
		*/
		public static void write(String name, String text, boolean append)
		{
			try{
				FileWriter fl= new FileWriter(name, append);
				BufferedWriter wr = new BufferedWriter(fl);
				wr.write(text);
				wr.close();
				fl.close();
			} 
			catch(Exception e) { println("ERROR: " +e.getMessage()); }
		}
		/**
		* Moves a file or rename it.
		* @param  file  file's location
		* @param  newname  new file's location or name
		*/
		public static void move(String file, String newname)
		{
			try{
				File old=new File(file);
				File nName=new File(newname);
				Files.move(old.toPath(), nName.toPath());      
			} 
			catch(Exception e){ println("ERROR: "+e.getMessage()); }
		}
		/**
		* Checks if a file or a directory exists.
		* @param  file  file's location
		* @return  true if exists, false if doesn't
		*/
		public static boolean exists(String file)
		{  
			File f = new File(file);
			return f.exists();
		}
		/**
		* Opens a file or program.
		* @param  file  file's location
		*/
		public static void open(String file)
		{
			try{
				java.awt.Desktop.getDesktop().open( new File( file ) );
			} 
			catch(Exception e) { arky.println("ERRO: "+e.getMessage()); }
		}
	}//classe files
   
	static class arrays
	{
		/**
		* Sorts and int array with selectionsort. Use: array=selection(array).
		* @param  v  int array that you want to sort.
		* @return  the ordered array
		*/
		public static int[] selection(int[] v)
		{
			int[] newArr;//= new int[v.length];
			newArr=v;
			int smaller, temp;
			if(newArr.length>0)
			{
				for(int i=0; i<newArr.length-1; i++)
				{
					smaller=i;
					for(int j=(i+1); j<newArr.length; j++)
					{
						if(newArr[j]<newArr[smaller])
						smaller=j;
					}
					temp=newArr[smaller];
					newArr[smaller]=newArr[i];
					newArr[i]=temp;
				}
			}
			return newArr;
		}
		/**
		* Sorts and int array with insertionsort. Use: array=insertion(array).
		* @param  v  int array that you want to sort.
		* @return  the ordered array
		*/
		public static int[] insertion(int[]v)
		{
			int[] newArr;//= new int[v.length];
			if(newArr.length>0)
			{
            
         
         
			}
         
         
			return newArr;
		}
		/*
			Metodo para mostrar os itens de um array de inteiros.
		*/
		/**
		* Shows array's items.
		* @param  arr  int array that you want to show.
		*/
		public static void show(int[]arr)
		{
			for(int i=0; i<arr.length; i++)
			{
				print(arr[i]+"\t");
			}
			println("");
		}
		/**
		* Shows array's items.
		* @param  arr  int array that you want to show.
		*/
		public static void show(String[]arr)
		{
			for(int i=0; i<arr.length; i++)
			{
				print(arr[i]+"\t");
			}
			println("");
		}
		/**
		* Shows array's items.
		* @param  arr  int array that you want to show.
		*/
		public static void show(boolean[]arr)
		{
			for(int i=0; i<arr.length; i++)
			{
				print(arr[i]+"\t");
			}
			println("");
		}
		/**
		* Shows array's items.
		* @param  arr  int array that you want to show.
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


	/**
	* Gets system's date and time. Format: dd/MM/yyyy HH:mm:ss
	* @param  s  the format to show the date and time
	* @return  the formatted date and time
	*/
	public static String datetime(String s)
	{ 
		DateFormat dateFormat = new SimpleDateFormat(s); 
		Date date = new Date(); 
		return dateFormat.format(date); 
	}
	/**
	* Print a line with determined text.
	* @param  s  the text to show
	*/
	public static void println(String s)
	{
		System.out.println(s);
	}
	/**
	* Print determined text.
	* @param  s  the text to show
	*/
	public static void print(String s)
	{
		System.out.print(s);
	}
	/**
	* Gets user's answer and returns it.
	* @param  s  the question to make
	* @return  the user's answer
	*/
	public static String read_String(String s)
	{
		Scanner value= new Scanner(System.in);
		System.out.print(s);
		return value.nextLine();
	}
	/**
	* Gets user's answer and returns it.
	* @param  s  the question to make
	* @return  the user's answer
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
	/**
	* Gets user's answer and returns it.
	* @param  s  the question to make
	* @return  the user's answer
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
	/**
	* Gets user's answer and returns it.
	* @param  s  the question to make
	* @return  the user's answer
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
	/**
	* Pauses the execution.
	*/
	public static void pause()
	{
		Scanner value= new Scanner(System.in);
		println("Tecle ENTER para continuar...");
		value.nextLine();
	}

}
// ---------------------------------------------- history
//
//	Version		Date 		Modifications
//	0.1   		22/01/17	class creation with "files" and "array" subclasses.
//	0.2   		24/05/17	external class "ArkyGUI" was integrated to "arky" class;
//							changed code's and comments' language to english;
//							some functions were moved to "arkyTools". 




