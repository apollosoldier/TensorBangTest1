import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Hekki
{
	protected int var1 [];
	protected int var2 [];
	protected int var3 [];
	protected ArrayList list;

	public Hekki(int var1 [],int var2 [],int var3 [])
	{
		this.list  = challenger(var1,var2,var3);	
	}

	public ArrayList<Integer> challenger(int var1 [],int var2 [],int var3 [])
	{
		int [] tableau = concat3(var1, var2, var3);
		ArrayList<Integer> lis  = new ArrayList<>(9);
		melangerTableau(tableau);
		for (int i = 0; i < 6; i++)
		{
			melangerTableau(tableau);
			lis.add(tableau[i]);
		}
		return lis;
	}

	public int myRand(int i_from, int i_to) 
	{
		return (int)(Math.random() * (Math.abs(i_from - i_to) + 1)) + Math.min(i_from, i_to);
	}
	private void melangerTableau(int t[]) 
	{
		for (int i = 0; i < t.length; i++) 
		{
			int r = myRand(1, 8);
			int tmp = t[i];
			t[i] = t[r];
			t[r] = tmp;
		}
	}

	public int [] concat3(int var1 [],int var2 [],int var3 [])
	{
		int tempo [] = new int[var1.length+var2.length+var3.length];
		for (int var = 0; var < var1.length; var++)
		{
			tempo[var] = var1[var];
		}
		for (int var = 0; var < var2.length; var++)
		{
			tempo[var1.length+1] = var2[var];
		}
		for (int var = 0; var < var3.length; var++)
		{
			tempo[var2.length+1] = var3[var];
		}
		return tempo;
	}
	public static String toString(ArrayList<Integer> va)
	{
		String s="";
		int it=0;
		for (int i : va)
		{
			System.out.println("Valeur : "+it+" "+i+"\n");
			s=""+s+i;
			it++;
		}
		return s;
	}


	public static void main(String[] args)
	{
		ArrayList<Hekki> hack = new ArrayList<>();
		try {
			for (int j = 0; j < 10000; j++)
			{
				// Create file
				FileWriter fstream = new FileWriter("data\\tirage"+j+".csv");
				BufferedWriter baby = new BufferedWriter(fstream);
				for (int i = 0; i < 25; i++)
				{
					System.out.println("Bienvenu au Test "+j);
					System.out.println("_______________________________");
					int var1 [] = {5,1,3};
					int var2 [] = {4,8,6};
					int var3 [] = {2,7,9};
					Hekki a = new Hekki(var1, var2, var3);
					hack.add(a);
					System.out.println(toString(a.list));
					baby.write(toString(a.list));
				}
				baby.close();
			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		} 


	}

}
