package set;

public class Employee implements IComparable
{
	private String Nom;
	private double Salaire;
	
	
	public int compareToName(Object other)
	{
		if (this.Nom == ((Employee)other).Nom)
			return 0;
		else if (this.Nom.compareTo(((Employee)other).Nom) < 0)
			return -1;
		return 1;
			
	}
	
	@Override
	public int compareTo(Object other)
	{
		if (this.Salaire == ((Employee)other).Salaire)
			return 0;
		else if (this.Salaire > ((Employee)other).Salaire)
			return 1;
		else
			return -1;	
	}
}
