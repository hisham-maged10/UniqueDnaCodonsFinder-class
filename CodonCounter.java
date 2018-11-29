/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.Collections;
import java.util.HashMap;
import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
public class CodonCounter
{
	private HashMap<String,Integer> codonMap;
	private String dnaStrand;
	private String mostCommonCodon;
	private int mostCommonCodonCount;
	private int start;
	public CodonCounter()
	{
		this(0,null,null);
	}
	public CodonCounter(File file)
	{
		this(0,null,file);
	}
	public CodonCounter(int start,File file)
	{
		this(start,null,file);
	}
	public CodonCounter(int start,String string)
	{
		this(start,string,null);
	}
	private CodonCounter(int start,String str,File file)
	{
		this.dnaStrand=(file==null && str==null)?getContent(getFile()):(str==null)?getContent(file):str;
		this.start=start;
		buildMap();
		this.mostCommonCodon=findMostCommonCodon();
	}
	public void setDNAStrand(int start,File file)
	{
		if(!isDNAFile(file)){System.out.println("Incorrect File!, returning");return;}	
		this.dnaStrand=getContent(file);
		this.start=start;
		buildMap();
		this.mostCommonCodon=findMostCommonCodon();	
	}
	//overload
	public void setDNAStrand(int start,String dnaStrand)
	{
		this.dnaStrand=dnaStrand;
		this.start=start;
		buildMap();
		this.mostCommonCodon=findMostCommonCodon();	
	}
	//overloaded
	public void setDNAStrand(File file)
	{
		if(!isDNAFile(file)){System.out.println("Incorrect File!, returning");return;}	
		this.dnaStrand=getContent(file);
		this.start=0;
		buildMap();
		this.mostCommonCodon=findMostCommonCodon();	
	}
	//overload
	public void setDNAStrand(String dnaStrand)
	{
		this.dnaStrand=dnaStrand;
		this.start=0;
		buildMap();
		this.mostCommonCodon=findMostCommonCodon();	
	}
	public void setStart(int start)
	{
		this.start=start;
		buildMap();
		this.mostCommonCodon=findMostCommonCodon();
	}
	public int getStart()
	{
		return this.start;
	}
	public String getDNAStrand()
	{
		return this.dnaStrand;
	}
	public String getMostCommonCodon()
	{
		return this.mostCommonCodon;
	}
	public int getMostCommonCodonCount()
	{
		return this.mostCommonCodonCount;
	}
	private String getContent(File source)
	{
		String dna="";
		int keyCode=-1;
		try(BufferedReader input=new BufferedReader(new FileReader(source));)
		{
			if((keyCode=input.read())!=-1)
				dna=(char)(keyCode)+input.readLine();
					
		}catch(IOException ex){ex.printStackTrace();}
		return dna;
	}
	private File getFile()
	{
		JFileChooser chooser=new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		try{
		do
		{
			System.out.println("Please choose a file of format .txt or .fa only!");
			chooser.showOpenDialog(null);
		}while(!isDNAFile(chooser.getSelectedFile()));
		}catch(NullPointerException ex){System.out.println("Incorrect Response!"); return getFile();}
		return chooser.getSelectedFile();
	}
	private boolean isDNAFile(File file)
	{
		/*return (file==null || 
			!file.isFile() || 
			(!file.getPath().endsWith(".txt") 
			&& !file.getPath().endsWith(".fa") 
			&& !file.getPath().endsWith(".TXT") 
			&& !file.getPath().endsWith(".FA")))?false:true;*/
		return true;
	}
	private void buildMap()
	{
		if(start != 0 && start != 1 && start != 2){return;}
		codonMap=new HashMap<String,Integer>();	
		String codon=null;
		for(int i=start,n=dnaStrand.length();i<n;i+=3)
		{
			if((i+3)>n)break;
			codon=dnaStrand.toUpperCase().substring(i,i+3);
			if(!codonMap.containsKey(codon))
				codonMap.put(codon,1);
			else
				codonMap.put(codon,(codonMap.get(codon)+1));
		}
	}
	public String findMostCommonCodon()
	{
		int max=Collections.max(codonMap.values());
		for(String e: codonMap.keySet())
			if(codonMap.get(e)==max){
				this.mostCommonCodonCount=codonMap.get(e);
				return e;}
		return "NOT FOUND!";
	}
	public int getUniqueCodonCount()
	{
		return this.codonMap.size();
	}
	public HashMap<String,Integer> getCodonAndCountsRange(int minCount,int maxCount)
	{
		HashMap<String,Integer> map=new HashMap<String,Integer>();
		for(String e:codonMap.keySet())
			if(codonMap.get(e)>=minCount && codonMap.get(e)<=maxCount)
				map.put(e,codonMap.get(e));
			else
				continue;
		return map;
	}
	
}