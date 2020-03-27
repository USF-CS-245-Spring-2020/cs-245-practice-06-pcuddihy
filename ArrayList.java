import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList<T> implements List<T> //from class notes
{
	protected int size;
	private T[] arr;

	public ArrayList() //constructor
	{
		size = 0;
		arr = (T[]) new Object[10];
	}

	private void double_array()
	{
		T[] new_arr = (T[]) new Object[arr.length * 2]; //create array twice the size of original
		System.arraycopy(arr, 0, new_arr, 0, arr.length); //from https://www.geeksforgeeks.org/system-arraycopy-in-java/
		arr = new_arr;
	}

	public void add(T item)
	{	
		if (arr.length == size) //if the array is full, double it
		{
			double_array();
		}
		arr[size++] = item; //add item to end of array
	}

	public void add(int pos, T item)
	{
		if (pos >= arr.length) //if pos is higher than the length of array, double the array
		{
			double_array();
		}
		size++; //increment size
		arr[pos] = item; //add item at pos
	}

	public T get(int pos)
	{
		if (pos < 0 || pos >= size)
		{
			throw new IndexOutOfBoundsException(); //throw exception, resourced used: https://www.geeksforgeeks.org/understanding-array-indexoutofbounds-exception-in-java/
		}
		else
		{
			return arr[pos];
		}
	}

	public T remove(int pos)
	{
		T temp = arr[pos];
		for (int i = pos; i < size - 1; i++)
		{
			arr[i] = arr[i + 1];
		}
		--size;
		return temp;
	}

	public int size()
	{
		return size;
	}
}