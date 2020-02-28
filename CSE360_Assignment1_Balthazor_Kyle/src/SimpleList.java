/**
 * @author Kyle Balthazor
 * Class Id: 186
 * Assignment 1: Simple List and introduction to Javadoc and Junit Tests
 */

public class SimpleList
{
	private int[] List; 
	private int count;
	
	/**
	 * Constructor for the SimpleList Class, creates an array of size 10 and sets the integer 
	 * count to 0.  
	 */
	
	public SimpleList() 
	{
		this.List = new int[10];
		this.count = 0;
	}
	
	/**
	 * Add the parameter to the list at the beginning, move all other integers in the list over. If the list is full,
	 * then the last element is removed from the list. Also increments the count by 1, unless the count is already at 10.
	 * @param newInteger Specifies the integer that is to be added to the array.
	 */
	
	public void add(int newInteger) 
	{
		if (this.count < 10) 
		{
			if (this.count == 0) 
			{  // If it is the first Number in the array just add the number.
				this.List[0] = newInteger;
				this.count++;
			}
			else 
			{					// If is is the not the first number then add to the beginning and keep track of other numbers. 
				int holderArray[] = new int[count +1];
				holderArray[0] = newInteger;
				this.count++;
				for (int index = 1; index < count; index++) 
				{
					holderArray[index] = this.List[index-1];
				}
				this.List = holderArray;
			}
		}
		else 
		{
			int holderArray[] = new int[count];
			holderArray[0] = newInteger;
			for (int index = 1; index < count; index++) 
			{
				if (index == 10) 
				{
					//Do Nothing
				}
				else 
				{
				holderArray[index] = this.List[index-1];
				}
			}
			this.List = holderArray;
		}
	}
	
	/**
	 * This function finds if a certain value is in the list, and if found it is removed and the rest of the 
	 * list is shifted down. Also decreases the count by 1 if the value is found.
	 * @param removeValue
	 */
	
	public void remove(int removeValue) 
	{
		int returnIndex = -1;
		if (this.count != 0) 
		{
			
			for (int index = 0; index < this.count; index++) 
			{
				if (this.List[index] == removeValue) 
					returnIndex = index;
			}
			if (returnIndex != -1) 
			{
				if(this.count == 1) 
				{
					this.List = new int[10];
					this.count--;
				}
				else 
				{
					int holderArray[] = new int[this.count -1];
					System.arraycopy(List, 0, holderArray, 0, returnIndex);
					System.arraycopy(List, returnIndex+1 , holderArray, returnIndex, this.count-returnIndex-1);
					this.count--;
					this.List = holderArray;
				}
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
			if (this.List[index] == searchValue) 
				returnIndex = index;
		}
	return returnIndex;		
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
			returnString = "" + this.List[0];
			for (int index = 1; index < this.count; index++) 
			{
				returnString += " " + this.List[index];
			}
		}
		
		return returnString;
	}
	
	public static void main(String[] args) 
	{
		SimpleList newList = new SimpleList();
		
		newList.add(4);
		newList.remove(4);
		newList.add(7);
		
		
		System.out.println(newList.toString());
		

	}
}
