/**
 * @author ${hisham_maged10}
 *https://github.com/hisham-maged10
 * ${DesktopApps}
 */
import java.util.HashMap;
public class TestCodonCounter
{
	public static void main(String[] args)
	{
		testing();
	}
	public static void testing()
	{
		CodonCounter cc=new CodonCounter();
		for(int i=0;i<3;i++)
		{
			cc.setStart(i);
			System.out.println();
			System.out.println("Reading frame starting with "+i+" results in "+ cc.getUniqueCodonCount()+" unique codons");
			System.out.println();
			System.out.println("and most common codon is "+cc.getMostCommonCodon()+" with count "+cc.getMostCommonCodonCount());
			System.out.println();
			System.out.println("Counts of codons between 1 and 5 inclusive are:");
			HashMap<String,Integer> map=cc.getCodonAndCountsRange(1,5);
			for(String e:map.keySet())
				System.out.println(e+" "+map.get(e));
			
		}
		for(int i=2;i<3;i++)
		{
			cc.setStart(i);
			System.out.println();
			System.out.println("Reading frame starting with "+i+" results in "+ cc.getUniqueCodonCount()+" unique codons");
			System.out.println();
			System.out.println("and most common codon is "+cc.getMostCommonCodon()+" with count "+cc.getMostCommonCodonCount());
			System.out.println();
			System.out.println("Counts of codons exactly 4 are:");
			HashMap<String,Integer> map=cc.getCodonAndCountsRange(4,4);
			for(String e:map.keySet())
				System.out.println(e+" "+map.get(e));
			
		}
		for(int i=0;i<1;i++)
		{
			cc.setStart(i);
			System.out.println();
			System.out.println("Reading frame starting with "+i+" results in "+ cc.getUniqueCodonCount()+" unique codons");
			System.out.println();
			System.out.println("and most common codon is "+cc.getMostCommonCodon()+" with count "+cc.getMostCommonCodonCount());
			System.out.println();
			System.out.println("Counts of codons exactly 4 are:");
			HashMap<String,Integer> map=cc.getCodonAndCountsRange(7,7);
			for(String e:map.keySet())
				System.out.println(e+" "+map.get(e));
			
		}
		for(int i=1;i<2;i++)
		{
			cc.setStart(i);
			System.out.println();
			System.out.println("Reading frame starting with "+i+" results in "+ cc.getUniqueCodonCount()+" unique codons");
			System.out.println();
			System.out.println("and most common codon is "+cc.getMostCommonCodon()+" with count "+cc.getMostCommonCodonCount());
			System.out.println();
			System.out.println("Counts of codons exactly 6 are:");
			HashMap<String,Integer> map=cc.getCodonAndCountsRange(6,6);
			for(String e:map.keySet())
				System.out.println(e+" "+map.get(e));
			
		}
	}	
}