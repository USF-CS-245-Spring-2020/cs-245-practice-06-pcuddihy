public class LinkedList<T> implements List<T> //from class notes
{
	private Node<T> head;
	private int size;

	public LinkedList() //constructor
	{
		size = 0;
		head = null;
	}

	public void add(T item)
	{
		if (head == null)
		{
			Node curr = new Node(item);
			head = curr;
			++size;
		}
		else
		{
			Node prev = head;
			for (int i = 0; i < size - 1; i++)
			{
				prev = prev.next;
			}
			Node curr = new Node(item);
			prev.next = curr;
			++size;
		}
	}

	public void add(int pos, T item)
	{
		if (pos == 0)
		{
			Node curr = new Node(item);
			curr.next = head;
			head = curr;
			++size;
		}
		else
		{
			Node prev = head;
			for (int i = 0; i < pos - 1; i++)
			{
				prev = prev.next;
			}
			Node curr = new Node(item);
			curr.next = prev.next;
			prev.next = curr;
			++size;
		}
	}

	public T get(int pos)
	{
		Node node = head;
		for (int i = 0; i < pos - 1; i++)
		{
			node = node.next;
		}
		return (T)node.data;
	}

	public T remove(int pos)
	{
		if (pos == 0)
		{
			Node curr = head;
			head = head.next;
			--size;
			return (T)curr.data;
		}
		else
		{
			Node prev = head;
			for (int i = 0; i < pos - 1; i++)
			{
				prev = prev.next;
			}
			Node curr = prev.next;
			prev.next = curr.next;
			--size;
			return (T)curr.data;
		}
	}

	public int size()
	{
		return size;
	}
}