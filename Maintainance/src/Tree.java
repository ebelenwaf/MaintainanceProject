import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.gaurav.tree.ArrayListTree;
import com.gaurav.tree.NodeNotFoundException;


public class Tree {
	
	
	static ArrayList<ArrayListTree<String>> tree = new ArrayList<ArrayListTree<String>>();
	
	static ArrayList<String> content =  new ArrayList<String>();
	
	static ArrayList<String> contentLine =  new ArrayList<String>();
	
	static ArrayList<String> transactions =  new ArrayList<String>();
	
	static LinkedHashMap<Integer,String> contents = new LinkedHashMap<Integer,String>();
	
	static LinkedHashSet<String> transactionRepeat = null;
	
	static LinkedHashSet<String> numberOfModules = new LinkedHashSet<String>();
	
	static ArrayList<ArrayList<String>> uniqueTransaction = new ArrayList<ArrayList<String>>();
	
	static ArrayList<String> path = new ArrayList<String>();
	
	static ArrayList<String> contentCopy = new ArrayList<String>();
	
	static List<ArrayListTree> transversal =null;
	
	static int i =0; 
	
	static int v=0;
	
	static String k, j;
	
	
	public static void evaluate() throws IOException, NodeNotFoundException
	{
		
		
		
		File file = new File("../output.txt");
		
		PrintWriter out = new PrintWriter(new FileWriter(file));
		

		
		try {
		      file.createNewFile();
		 }
		 catch (IOException e) {
		 e.printStackTrace();
		 }
		
		//Reads file from user input and parses text file. Also adds content to arrayList.
		
		readFile();
		
		
		for( i=0; i< content.size(); i++ )
		{
			if(!contents.containsValue(content.get(i)))
				transactions.add(content.get(i));
			
			//contentCopy.add(content.get(i));
			
				
		}
		
		if(!transactions.isEmpty()){
			//for(String s:transactions){
				transactionRepeat = new LinkedHashSet<String>(transactions);	
				
			}
		
		
		System.out.println("******Transactions********");
		out.println("******Transactions********");
	
		
		for(String s: transactionRepeat){
			System.out.println(s);
			out.println(s);
			//bw.write("Iterator"+s);
			
		}
		
		System.out.println();
		out.println();
		//transactionRepeat.
		
		System.out.println("******Explosion for each transactions********");
		out.println("******Explosion for all transactions********\n");
		
		
		generteExposion(out);
		
		
		
		System.out.println("*********************Unique Model for each Transactions******************");
		out.println("*********************Unique Model for each Transactions******************");
		
		
	
		for(int l =0; l < tree.size(); l++)
		{
			for(int p =0; p < tree.get(l).preOrderTraversal().size(); p++ ){
			
		    if(!tree.get(l).preOrderTraversal().get(p).endsWith("@")){
			System.out.print(tree.get(l).preOrderTraversal().get(p)+"\t");
			
			out.print(tree.get(l).preOrderTraversal().get(p)+"\t");}
		    
			}
			
			System.out.println();
			
			out.println();
		}
		
		 k = JOptionPane.showInputDialog("Enter Transaction");
		 j = JOptionPane.showInputDialog("Enter Failure Module");
		
		System.out.println("\n*********************Path From failure Module to Transaction******************");
		out.println("\n*********************Path from failure Module to Transaction******************");
		
		
		printPath(out);
		
		
		out.flush();
		out.close();
		//System.out.print(transversal);
			
	}
	
public static String openFile(String input){
		
		String fileName = null;
		
		try{
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle(input);
			int reply = chooser.showOpenDialog(null);
			
			if(reply == JFileChooser.APPROVE_OPTION){
				fileName = chooser.getSelectedFile().getAbsolutePath();
			}
		}
		catch (Exception e){
			System.out.println("exception occurred ==>"+e);
		}
		//readRules();
		return fileName;
	}


public static void readFile()
{
	
	try (BufferedReader br = new BufferedReader(new FileReader(openFile("Select Text File"))))
	{

		String sCurrentLine;

		while ((sCurrentLine = br.readLine()) != null) {
			//System.out.println(sCurrentLine);
			
			//contentLine.add(e)
			
			contentLine.add(sCurrentLine.substring(0, 2));
			
			contents.put(i, sCurrentLine.substring(1,2));
			
			content.add(sCurrentLine.substring(0,1));
			
			i++;
			
		}
		
		br.close();
	} catch (IOException e) {
		e.printStackTrace();
	} 
}

public static void generteExposion(PrintWriter out) throws NodeNotFoundException
{
	
	for(String r: transactionRepeat)
	{
		tree.add(new ArrayListTree<String>());
		
		tree.get(v).add(r);
		
		System.out.println("\nTransaction:"+r+"\n");
			   out.println("\nTransaction:"+r+"\n");
		System.out.println(r);
			   out.println(r);
	
		for(int b = 0; b < content.size(); b++){
		if(r.equals(content.get(b))){
			
			if( tree.get(v).contains(contents.get(b)) || tree.get(v).contains(contents.get(b)+'@') ){
				//if(tree.get(v).parent(contentLine.get(z).substring(1,2)+"@").equals(contents.get(b)) || tree.get(v).parent(contentLine.get(z).substring(1,2)).equals(contents.get(b))){
			// if(tree.get(v).parent(contentLine.get(z).substring(1,2)).equals(contents.get(b)) ){
				System.out.println("\t"+contents.get(b)+"*");
				   out.println("\t"+contents.get(b)+"*");}
			//}
			else
			{
				System.out.println("\t"+contents.get(b));
				   out.println("\t"+contents.get(b));
			}
		
		
		if(tree.get(v).contains(contents.get(b)))
				tree.get(v).add(r, contents.get(b)+"@");
		else
			tree.get(v).add(r, contents.get(b));
				
			/*
				System.out.println("\t"+contents.get(b));
					   out.println("\t"+contents.get(b));
			*/
				for(int l= 0; l < contents.size(); l++){
					
					if(contents.get(b).equals(content.get(l))){
						
						
						if( tree.get(v).contains(contentLine.get(l).substring(1,2)) || tree.get(v).contains(contentLine.get(l).substring(1,2)+'@') ){
							//if(tree.get(v).parent(contentLine.get(z).substring(1,2)+"@").equals(contents.get(b)) || tree.get(v).parent(contentLine.get(z).substring(1,2)).equals(contents.get(b))){
						 //if(tree.get(v).parent(contentLine.get(l).substring(1,2)).equals(contents.get(b)) ){
							System.out.println("\t\t"+contentLine.get(l).substring(1,2)+"*");
							   out.println("\t\t"+contentLine.get(l).substring(1,2)+"*");
							   
						 //}
						}
						else
						{
							System.out.println("\t\t"+contentLine.get(l).substring(1,2));
							   out.println("\t\t"+contentLine.get(l).substring(1,2));
						}
						
						/*
						if(tree.get(v).contains(contentLine.get(l).substring(1,2))){
						System.out.println("\t\t"+contentLine.get(l).substring(1,2)+"*");
						out.println("\t\t"+contentLine.get(l).substring(1,2)+"*");}
						*/
						//else{
						/*
							System.out.println("\t\t"+contentLine.get(l).substring(1,2));
							out.println("\t\t"+contentLine.get(l).substring(1,2));
						//}*/
							
					if(tree.get(v).contains(contentLine.get(l).substring(1,2)))	
						tree.get(v).add(contents.get(b), contentLine.get(l).substring(1,2)+"@");
					else
						tree.get(v).add(contents.get(b), contentLine.get(l).substring(1,2));
						
						
							for(int z = 0; z < contents.size(); z++)
							{
								if(contents.get(l).equals(content.get(z))){
									
									if( tree.get(v).contains(contentLine.get(z).substring(1,2)) || tree.get(v).contains(contentLine.get(z).substring(1,2)+'@') ){
										//if(tree.get(v).parent(contentLine.get(z).substring(1,2)+"@").equals(contents.get(b)) || tree.get(v).parent(contentLine.get(z).substring(1,2)).equals(contents.get(b))){
									 if(tree.get(v).parent(contentLine.get(z).substring(1,2)).equals(contents.get(b)) ){
										System.out.println("\t\t\t"+contentLine.get(z).substring(1,2)+"*");
										   out.println("\t\t\t"+contentLine.get(z).substring(1,2)+"*");}
									}
									else
									{
										System.out.println("\t\t\t"+contentLine.get(z).substring(1,2));
										   out.println("\t\t\t"+contentLine.get(z).substring(1,2));
									}
								
									
								if(tree.get(v).contains(contentLine.get(z).substring(1,2)))
									tree.get(v).add(contents.get(l), contentLine.get(z).substring(1,2)+"@");
								else
									tree.get(v).add(contents.get(l), contentLine.get(z).substring(1,2));
									
									
								}
								
									
							}
						
					}
				}
			}
		
		
		
		}
		
		v++;
	}
}


public static void printPath(PrintWriter out) throws NodeNotFoundException
{
	for(i = 0; i < tree.size(); i++)
	{
		
		if(tree.get(i).root().equals(k))
		{
			//String k = JOptionPane.showInputDialog("Enter Transaction");
			
			if(!tree.get(i).contains(j)){
				
				JOptionPane.showMessageDialog(null, "No Module Labeled:"+j,"ATTENTION!",
		                JOptionPane.ERROR_MESSAGE);
				}
			
			
			System.out.print("\n"+j);
			out.print("\n"+j);
			//System.out.print("Q");
			Iterator<String> it = tree.get(i).iterator();
			
			while(it.hasNext())
			{
				
				
				
				
				
				String currentNode = it.next();
				
				if( tree.get(i).isDescendant(currentNode, j) ||tree.get(i).isDescendant(currentNode, j+"@") ){
					System.out.print("\t"+currentNode);
					out.print("\t"+currentNode);
					
					
					//System.out.println(tree.get(i).parent(currentNode));
				
				}
				
			}
			
			System.out.print("\t"+j);
			//System.exit(0);
			
			//System.out.println("\t");
		}
	
		/*
		else if(i== (tree.size()-1) && !(tree.get(i).root().equals(k))){
			JOptionPane.showMessageDialog(null, "No Transaction Labeled:"+k,"ATTENTION!",
	                JOptionPane.ERROR_MESSAGE);
		
		}
		
		*/
		
	}
}

}
