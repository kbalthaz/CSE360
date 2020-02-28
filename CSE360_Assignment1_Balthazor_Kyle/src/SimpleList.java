import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * @author Kyle Balthazor
 * Class Id: 186
 * Assignment 2: Simple Changes to test Push and Pull for Git 
 */

public class SimpleList
{
	private ArrayList<Integer> List; 
	private int count;
	private int capacity;
	
	/**
	 * Constructor for the SimpleList Class, creates an array of size 10 and sets the integer 
	 * count to 0.  
	 */
	
	public SimpleList() 
	{
		this.List = new ArrayList<Integer>(10);
		this.count = 0;
		this.capacity = 10;
	}
	
	/**
	 * Add the parameter to the list at the beginning, move all other integers in the list over. If the list is full,
	 * then the last element is removed from the list. Also increments the count by 1, unless the count is already at 10. 
	 * If the count is greater than the size of the list then increase the size by 50%.
	 * @param newInteger Specifies the integer that is to be added to the array.
	 */
	
	public void add(int newInteger) 
	{
		if (this.count <= 10) 
		{
			if (this.count == 0) 
			{  // If it is the first Number in the array just add the number.
				this.List.add(newInteger);
				this.count++;
			}
			else 
			{					// If is is the not the first number then add to the beginning and keep track of other numbers. 
				int holderArray[] = new int[count +1];
				holderArray[0] = newInteger;
				this.count++;
				for (int index = 1; index < count; index++) 
				{
					holderArray[index] = this.List.get(index-1);
				}
				for(int position = 0; position < holderArray.length; position++)
				{
					if (position+1 < this.count)
					{
						this.List.set(position, holderArray[position]);
					}
					else
					{
						this.List.add(position, holderArray[position]);
					}
				}
			}
		}
		else 
		{
			this.count++;
			this.List.ensureCapacity((this.List.size()/2)+this.List.size());
			this.capacity = this.List.size()/2+this.List.size();
			
			int holderArray[] = new int[count];
			holderArray[0] = newInteger;
			
			for (int index = 1; index < count; index++) 
			{
				holderArray[index] = this.List.get(index-1);
			}
			
			for(int position = 0; position < holderArray.length; position++)
			{
				if (position+1 < this.count)
				{
					this.List.set(position, holderArray[position]);
				}
				else
				{
					this.List.add(position, holderArray[position]);
				}
			}
		}
	}
	
	/**
	 * This function finds if a certain value is in the list, and if found it is removed and the rest of the 
	 * list is shifted down. Also decreases the count by 1 if the value is found. If the list has more than 25% 
	 * null index's then remove the null indexs.
	 * @param removeValue
	 */
	
	public void remove(int removeValue) 
	{
		int returnIndex = -1;
		if (this.count != 0) 
		{
			for (int index = 0; index < this.count; index++) 
			{
				if (this.List.get(index) == removeValue) 
					returnIndex = index;
			}
			if (returnIndex != -1) 
			{
				if(this.count == 1) 
				{
					this.List = new ArrayList<Integer>(10);
					this.count--;
				}
				else 
				{
					this.List.remove(returnIndex);
					this.count--;
				}
			}
			
			
			if(this.capacity >= this.List.size()*.25 && this.capacity != this.count)
			{
				this.List.trimToSize();
			}
			else if (this.capacity >= this.List.size()*.25 && this.capacity == this.count)
			{
				this.List = new ArrayList<Integer>(1);
			}
		}
	}
	
	/**
	 * Simple function to return the number of elements in the array.
	 * @return returns an integer between 0 and 10
	 */
	public int count() 
	{
		return this.count;
	}
	
	
	/**
	 * Function to determine if and where a value is in the array. If the value is found in the list, then the index that it was found in
	 * is returned otherwise the the value of -1 is returned.
	 * @param searchValue the value that is to be searched for in the list
	 * @return returns the index of the value if found, otherwise returns -1
	 */
	
	public int search(int searchValue) 
	{
		int returnIndex = -1;
		for (int index = 0; index < this.count; index++) 
		{
			if (this.List.get(index) == searchValue) 
				returnIndex = index;
		}
	return returnIndex;		
	}
	/**
	 * Function to add a new integer to the last index of the list. If the List is full then increase the size by 50%.
	 * @param newInteger The new value that is to be placed at the last index of the list.
	 */
	
	public void append(int newInteger)
	{
		if(this.List.size() == this.count)
		{
			this.List.ensureCapacity((this.List.size()/2)+this.List.size());
			this.List.add(newInteger);
			this.count++;
		}
		else
		{
			this.List.add(newInteger);
			this.count++;
		}
		
	}
	/**
	 * Function to return the first element in the List, else returns -1.
	 * @return Returns as -1 if there is nothing in the list, else returns the integer.
	 */
	public int first()
	{
		int returnValue = -1;
		if(this.count > 0)
		{
			returnValue = this.List.get(0);
		}
		
		return returnValue;
	}
	/**
	 * Function to return the last element in the List, else returns -1.
	 * @return Returns as -1 if there is nothing in the list, else returns the integer.
	 */
	
	public int last()
	{
		int returnValue = -1;
		if(this.count > 0)
		{
			returnValue = this.List.get(this.count);
		}
		return returnValue;
	}
	
	/**
	 * Function to determine how many elements could be in the List, i.e. the capacity.
	 * @return	Returns the capacity of the List 
	 * @throws NoSuchFieldException Exception if the field does not exist, no list.
	 * @throws SecurityException Exception for if the security denies it.
	 * @throws IllegalArgumentException Exception for the argument not being there.
	 * @throws IllegalAccessException Exception for if you are unable to access the data.
	 */
	
	public int size() 
	{
		return this.capacity;
	}
	
	/**
	 * Returns the list as a string, each element is separated by a space with no space after the last value.
	 * @return The string of the array with a space between each array Item.
	 */
	
	public String toString() 
	{
		String returnString = "";
		if (this.count != 0) 
		{
			returnString = "" + this.List.get(0);
			for (int index = 1; index < this.count; index++) 
			{
				returnString += " " + this.List.get(index);
			}
		}
		
		return returnString;
	}
	
	public static void main(String[] args) 
	{
		SimpleList newList = new SimpleList();
		
		
		newList.add(4);
		newList.add(4);
		newList.remove(4);
		newList.add(7);
		
		System.out.println(newList.toString());

	}
}
