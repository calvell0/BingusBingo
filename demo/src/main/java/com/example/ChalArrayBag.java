package com.example;

public class ChalArrayBag
{
	private final int INITIAL_CAPACITY = 50;
	private int manyItems;
	private String[] data;
	
	/*
	 * Creates an ArrayBag.
	 */
	public ChalArrayBag()
	{
		manyItems = 0;
		data = new String[INITIAL_CAPACITY];
	}
	
	/*
	 * Creates an ArrayBag with a specified starting capacity.
	 */
	public ChalArrayBag(int initialCapacity)
	{
		if (initialCapacity < 0)
		{
			throw new IllegalArgumentException("Initial capacity is negative: "
												+ initialCapacity);
		}
		manyItems = 0;
		data = new String[initialCapacity];
	}
	
//penis > balls
//FACTS 100 

	/*
	 * Adds an element to the bag.
	 */
	public void add(String element)
	{
		if (	manyItems == data.length)
		{
			ensureCapacity(manyItems*2 + 1);
		}
		data[manyItems] = element;
		manyItems++;
	}
	
	/*
	 * Adds an entire array bag to an existing array bag.
	 */
	public void addAll(ChalArrayBag addend)
	{
		ensureCapacity(manyItems + addend.manyItems);
		System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
		manyItems += addend.manyItems;
	}
	
	/*
	 * Adds multiple elements to an array bag simultaneously.
	 */
	public void addMany(String... elements)
	{
		if (manyItems + elements.length > data.length)
		{
			ensureCapacity((manyItems + elements.length)*2);
		}
		System.arraycopy(elements, 0, data, manyItems, elements.length);
		manyItems += elements.length;
	}
	
	/*
	 * Clones an array bag. I think it's a shallow copy.
	 */
	public ChalArrayBag clone()
	{
		ChalArrayBag answer;
		try
		{
			answer = (ChalArrayBag) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new RuntimeException("This class doesn't implement cloneable.");
		}
		answer.data = data.clone();
		return answer;
	}
	
	/*
	 * Counts how many times an item appears in an array bag.
	 */
	public int countOccurences(String target)
	{
		int answer;
		int index;
		answer = 0;
		for (index = 0; index < manyItems; index++)
		{
			if (target == data[index])
			{
				answer++;
			}
		}
		return answer;
	}
	
	/*
	 * Adds room to an array bag by increasing its capacity.
	 */
	private void ensureCapacity(int minimumCapacity) 
	{
		String[] biggerArray;
		if (data.length < minimumCapacity)
		{
			biggerArray = new String[minimumCapacity];
			System.arraycopy(data, 0, biggerArray, 0, manyItems);
			data = biggerArray;
		}
	}
	
	/*
	 * Returns the maximum capacity of an array bag.
	 */
	public int getCapacity()
	{
		return data.length;
	}
	
	/*
	 * Removes an element from an array bag. Searches by the data, not index.
	 */
	public boolean remove(String target)
	{
		int index;
		index = 0;
		while ((index < manyItems) && (target != data[index]))
		{
			index++;
		}
		if (index == manyItems)
		{
			return false;
		}
		else
		{
			manyItems--;
			data[index] = data[manyItems];
			return true;
		}
	}
	
	/*
	 * MY OWN METHOD
	 * Removes all emements of an array bag.
	 */
	public void removeAll()
	{
		manyItems = 0;
		data = new String[INITIAL_CAPACITY];
	}

	/*
	 * Returns how many items are in an array bag.
	 */
	public int size()
	{
		return manyItems;
	}
	
	/*
	 * Reduces array bag capacity to number of elements, removing empty space.
	 */
	public void trimToSize()
	{
		String[] trimmedArray;
		if (data.length != manyItems)
		{
			trimmedArray = new String[manyItems];
			System.arraycopy(data, 0, trimmedArray, 0, manyItems);
			data = trimmedArray;
		}
	}
	
	/*
	 * Combines two array bags into a new larger one, then returns it.
	 */
	public static ChalArrayBag union(ChalArrayBag b1, ChalArrayBag b2)
	{
		ChalArrayBag answer = new ChalArrayBag(b1.getCapacity() + b2.getCapacity());
		System.arraycopy(b1.data, 0, answer.data, 0, b1.manyItems);
		System.arraycopy(b2.data,  0, answer.data, b1.manyItems, b2.manyItems);
		answer.manyItems = b1.manyItems + b2.manyItems;
		return answer;
	}
	
	/*
	 * Returns an array bag element, searched by location, not content.
	 */
	public String getData(int index)
	{
		return data[index];
	}
}
