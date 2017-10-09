package set;

public class BinarySearchTree extends BinaryTree
{


	public BinarySearchTree(Object data)
	{
		super(data);
		// TODO Auto-generated constructor stub
	}

	public boolean contains(IComparable element)
	{
		Object current = this.getData();
		if (current.equals(element))
			return true;
		else if (this.getLeftChild() != null && element.compareTo(current) == - 1)//element inférieur au noeud courrant
			return ((BinarySearchTree) this.getLeftChild()).contains(element);
		else if (this.getRightChild() != null && element.compareTo(current) == 1)//élément supérieur au noeud courrant
			return ((BinarySearchTree) this.getRightChild()).contains(element);
		return false;
	}

	public void add(IComparable element)
	{
		if (element.compareTo(this.getData()) == -1)
			if(this.getLeftChild() == null)
				this.leftChild = new BinarySearchTree(element);
			else
				((BinarySearchTree) this.getLeftChild()).add(element);
		else if (element.compareTo(this.getData()) == 1)
			if (this.getRightChild() == null)
				this.rightChild = new BinarySearchTree(element);
			else	
				((BinarySearchTree) this.getRightChild()).add(element);
	}
	
	public void setData(Object data)
	{
		System.out.print("Erreur cette opération n'est pas disponible");
	}

	public void setLeftChild(IBinaryTree leftChild)
	{
		System.out.print("Erreur cette opération n'est pas disponible");
	}
	
	public void setRightChild(IBinaryTree leftChild)
	{
		System.out.print("Erreur cette opération n'est pas disponible");
	}
	
}
