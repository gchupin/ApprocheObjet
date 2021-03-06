package set;

public class BreadthFirstIterator implements IIterator 
{
	private BinaryTreeQueue tree;

	public BreadthFirstIterator (BinaryTree tree)
	{
		this.tree.push_front(tree);	
	}
	
	@Override
	public boolean hasNext() 
	{
		return !tree.empty();
	}

	@Override
	public Object next() 
	{
		return tree.pop_back();	
	}

}
