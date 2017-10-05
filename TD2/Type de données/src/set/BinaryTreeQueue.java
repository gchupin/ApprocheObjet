package set;

public class BinaryTreeQueue implements IQueue 
{
	
	//===Données membres===
	private BinaryTree [] table;
	private int size;//taille maximale du tableau
	
	//===Constructeur===
	public BinaryTreeQueue (int size)
	{
		this.size = size;
		this.table = new BinaryTree [size];
	}
	
	public void allocate ()
	{
		this.size = size << 1;
		BinaryTree [] newTable = new BinaryTree [this.size];
		System.arraycopy(table, 0, newTable, 0, size);
		table = newTable;
	}
	
	@Override
	public void push_front(Object o) 
	{
		if (this.table[this.size] != null)
			this.allocate();
		System.arraycopy(table, 0, table, 1, size - 1);
		table[0] = (BinaryTree) o;
	}
	
	@Override
	public Object pop_back() 
	{
		Object pop = (BinaryTree) table[this.size()];
		//c'est pour l'exo 6
		BinaryTree LeftChild = (BinaryTree) table[this.size()].getLeftChild();
		BinaryTree RightChild = (BinaryTree) table[this.size()].getRightChild();
		if(LeftChild != null)
			this.push_front(LeftChild);
		if(RightChild != null)
			this.push_front(LeftChild);
		table[this.size()] = null;
		return pop;
	}

	@Override
	public boolean empty() 
	{
		if(this.table[0] == null)
			return true;
		return false;
	}

	@Override
	public void clear() 
	{
		int size = this.size();
		for (int i = 0; i < size; ++i)
			this.table[i] = null;
	}

	//Nombre d'élément dans le tableau
	@Override
	public int size() 
	{
		int size = 0;
		while (table[size] != null && size < this.size)
			++size;
		return size;
	}

}
