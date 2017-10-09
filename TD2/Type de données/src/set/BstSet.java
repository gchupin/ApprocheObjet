package set;

public class BstSet extends BinarySearchTree implements ISet
{

	public BstSet(Object data)
	{
		super(data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean contains(Object element)
	{
		return super.contains((IComparable) element);
	}

	@Override
	public ISet union(ISet set)
	{
		ISet res = new BstSet(null);
		BreadthFirstIterator iterator1 = new BreadthFirstIterator(this);
		while (iterator1.hasNext())
		{
			res.add((IComparable) iterator1);
			iterator1.next();
		}
		BreadthFirstIterator iterator2 = new BreadthFirstIterator((BinaryTree) set);
		while (iterator2.hasNext())
		{
			res.add((IComparable) iterator2);
			iterator2.next();
		}
		return res;
	}

	@Override
	public ISet intersect(ISet set)
	{
		ISet res = new BstSet(null);
		BreadthFirstIterator iterator1 = new BreadthFirstIterator(this);
		BreadthFirstIterator iterator2 = new BreadthFirstIterator((BinaryTree) set);
		while (iterator1.hasNext())
		{
			while (iterator2.hasNext())
			{
				if (iterator1.equals(iterator2))
					res.add((IComparable) iterator1);
			}
		}
		return res;
	}

	@Override
	public ISet diff(ISet set)
	{
		ISet res = new BstSet(null);
		BreadthFirstIterator iterator1 = new BreadthFirstIterator(this);
		BreadthFirstIterator iterator2 = new BreadthFirstIterator((BinaryTree) set);
		while (iterator1.hasNext())
		{
			if (!set.contains(iterator1))
				res.add((IComparable) iterator1);
		}
		while (iterator2.hasNext())
		{
			if (!this.contains(iterator2))
				res.add((IComparable) iterator2);
		}
		return res;
	}

	@Override
	public void remove(IComparable element)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public int size()
	{
		BreadthFirstIterator iterator = new BreadthFirstIterator(this);
		int size = 0;
		while (iterator.hasNext())
		{
			++size;
			iterator.next();
		}
		return size;
	}

	@Override
	public boolean isEmpty()
	{
		if (this.size() == 0)
			return true;
		return false;
	}

}
