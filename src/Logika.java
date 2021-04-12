
import java.util.ArrayList;
import java.util.Random;

public class Logika {

	public int polja[][] = new int[4][4];
	
	public Logika()
	{
		postaviPolja();
		otvoriPrviPut();
	}

	private void otvoriPrviPut() 
	{
		
		int stepeni[] = new int[2];
		stepeni[0] = 1;
		stepeni[1] = 2;
		
		Random r = new Random();
		int p = r.nextInt(2);
		int stepen1 = stepeni[p];
		p = r.nextInt(2);
		int stepen2 = stepeni[p];
		
		
		
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for (int i = 0,  br = 0; i < polja.length; i++) 
		{
			for (int j = 0; j <	polja.length; j++, br++)
			{	
				if(polja[i][j] == 0)
				{
					lista.add(br);
				}
			}
		}
		
		int poz1, poz2;
		
		poz1 = r.nextInt(lista.size());
		int br1 = lista.get(poz1);
		lista.remove(poz1);
		
		poz2 = r.nextInt(lista.size());
		int br2 = lista.get(poz2);
		lista.remove(poz2);
		
		
		for (int i = 0,  br = 0; i < polja.length; i++) 
		{
			for (int j = 0; j <	polja.length; j++, br++)
			{	
				if(br == br1)
				{
					polja[i][j] = (int) Math.pow(2, stepen1);
				}
				if(br == br2)
				{
					polja[i][j] = (int) Math.pow(2, stepen2);
				}
			}
		}
	}

	private void postaviPolja()
	{
		
		for (int i = 0; i < polja.length; i++)
		{
		
			for (int j = 0; j < polja.length; j++) 
			{
				polja[i][j] = 0;
			}
		}
	}
	
	private void potez()
	{
		ArrayList<Integer> lista = new ArrayList<Integer>();
		
		for (int i = 0,  br = 0; i < polja.length; i++) 
		{
			for (int j = 0; j <	polja.length; j++, br++)
			{	
				if(polja[i][j] == 0)
				{
					lista.add(br);
				}
			}
		}
		
		int stepeni[] = new int[2];
		stepeni[0] = 1;
		stepeni[1] = 2;
		
		Random r = new Random();
		int p = r.nextInt(2);
		int stepen = stepeni[p];
		
		int poz = r.nextInt(lista.size());
		int br1 = lista.get(poz);
		lista.remove(poz);
		
		for (int i = 0,  br = 0; i < polja.length; i++) 
		{
			for (int j = 0; j <	polja.length; j++, br++)
			{	
				if(br == br1)
				{
					polja[i][j] = (int) Math.pow(2, stepen);
				}
				
			}
		}
		
	}
	
	public void gore()
	{
		boolean pomerio = false;
		for (int i = 0; i < polja.length; i++) 
		{
			for (int j = 0; j < polja[0].length; j++) 
			{
				int k = i;
				if(polja[i][j] != 0)
				{
					boolean dodavanje = false;
					while(k>0 && (polja[k-1][j] == 0 || (polja[k][j] == polja[k-1][j] && dodavanje == false) ) )
					{
						pomerio = true;
						if( polja[k][j] == polja[k-1][j] )
						{
							polja[k-1][j] *=2;
							polja[k][j] = 0;
							k--;
							dodavanje = true;
							
						}
						else 
						{
							polja[k-1][j] = polja[k][j];
							polja[k][j] = 0;
							k--;
						}
				
					}
					
				}
				
			}
			
		}
		if(pomerio)
			potez();
		
	}
	
	public void dole()
	{
		boolean pomerio = false;
		for (int i = polja.length-1; i >=0; i--) 
		{
			for (int j = 0; j < polja[0].length; j++) 
			{
				int k = i;
				if(polja[i][j] != 0 )
				{
					boolean dodavanje = false;
					while(k<polja.length-1 && (polja[k+1][j] == 0 || (polja[k][j] == polja[k+1][j] && dodavanje == false) ))
					{
						pomerio = true;
						if( polja[k][j] == polja[k+1][j] )
						{
							polja[k+1][j] *=2;
							polja[k][j] = 0;
							k++;
							dodavanje = true;
						}
						else 
						{
							polja[k+1][j] = polja[k][j];
							polja[k][j] = 0;
							k++;
						}
			
					}
					
				}
				
			}
			
		}
		if(pomerio)
			potez();
	}
	
	public void levo()
	{
		boolean pomerio = false;
		for (int i = 0; i < polja.length; i++) 
		{
			for (int j = 0; j < polja[0].length; j++) 
			{
				int k = j;
				if(polja[i][j] != 0)
				{
					boolean dodavanje = false;
					while(k>0 && (polja[i][k-1] == 0 || (polja[i][k] == polja[i][k-1]  && dodavanje == false)) )
					{
						pomerio = true;
						if( polja[i][k] == polja[i][k-1] )
						{
							polja[i][k-1] *=2;
							polja[i][k] = 0;
							k--;
							dodavanje = true;
						}
						else 
						{
							polja[i][k-1] = polja[i][k];
							polja[i][k] = 0;
							k--;
						}
				
					}
					
				}
				
			}
			
		}
		if(pomerio)
			potez();
		
	}
		
	public void desno()
	{
		boolean pomerio = false;
		for (int i = 0; i < polja.length; i++) 
		{
			for (int j = polja[0].length-1; j>=0 ; j--) 
			{
				int k = j;
				if(polja[i][j] != 0)
				{
					boolean dodavanje = false;
					while(k<polja[0].length-1 && (polja[i][k+1] == 0 || (polja[i][k] == polja[i][k+1] && dodavanje == false) ) )
					{
						pomerio = true;
						if( polja[i][k] == polja[i][k+1] )
						{
							polja[i][k+1] *=2;
							polja[i][k] = 0;
							k++;
							dodavanje = true;
						}
						else 
						{
							polja[i][k+1] = polja[i][k];
							polja[i][k] = 0;
							k++;
						}
				
					}
					
				}
				
			}
			
		}
		if(pomerio)
			potez();
		
	}
}
