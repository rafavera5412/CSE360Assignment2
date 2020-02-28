package cse360assign2;

/* 
* Rafael Javalera Vera
* Class ID: 408
* Assignment #2: In this assignment, we will use an array that contains 10 elements
* and perform different functions such as appending and returning the array, returning 
* the first and last element, and returning the size of the array
*/

public class SimpleList 
{
	private int[] list; // creating a private variable of a list array
	private int count; // creating a private variable to count


	// This is the constructor method that contains list and count
	public SimpleList() 
	{
		list = new int[10]; // list is now an array that can hold 10 integer
		count = 0; // set count equal 0, it will be updated and used to compare to the index in the adding and removing methods
	}


	// This is a method that is going to add int object into an 
	// array, and adjust the array at an index accordingly using count
	public void add(int object) 
	{	// this if statement makes sure that the index of the array contains 10 elements
		if(count == 10)  
			count--; 

		// this is a for loop that uses count to shift the elements within the array to the right
		for(int startloop = count; startloop > 0; startloop--) 
		{
			list[startloop] = list[startloop - 1]; // the count is used to shift the elements in the array until the loop ends
		}
		
		list[0] = object; // adds int object into the array

		//this if statement checks that the array has 10 elements
		if(count != 10) 
			count++; 
	}


	// This is a method that is going to remove 
	// int object from an array
	public void remove(int object) 
	{
		int trueindex = 9; // set the index of the array to 9 so that an element can be removed at this index

		// this if statement makes sure that the index of the array contains 10 elements
		if (count == -1)  
			count++; 

			// this is a for loop that is going to remove int object at the index after it goes through the if statement
			for (int startloop = 0; startloop < trueindex; startloop++) 
			{
				// if the int object and the index are equal then it is going to remove the element
				if (list[startloop] == object) 
				{
					count--; // updates the value of the count to count - 1

					// this is a for loop that is going to shift the elements to the right
					for (int endloop = startloop; endloop < list.length - 1; endloop++) 
					{
						list[endloop] = list[endloop + 1]; // this shifts the elements to the right
						trueindex = 0; // updates the trueindex to 0
					}
					
					list[count] = 0; // updates the element that did not shift at count
				}
		}
	}
	

	// This is a method that returns the number of elements within the array
	public int count() 
	{
		return count;
	}

	
	// This is the toString method that is going to print 
	// out the array with spaces in between each element
	public String toString() 
	{
		String finalarray = "";
		
		// if statement to check that elements are in the array
		if (count != 0) 
		{
			finalarray = finalarray + list[0]; // finalarray now contains list[0]

			// this is a for loop that creates a space between each element in the array
			for (int startloop = 1; startloop < count; startloop++)  
			{
				finalarray = finalarray + " " + list[startloop]; // the space in between the elements is added here
			}
		}
		return finalarray; // this returns the string finalarray after it is finished
	}


	//Searches for the specified value's index in the array and returns that value
	// This is a method that is going to search for an element within the array and return the index
	public int search(int search) 
	{
		int counter = 0;
		int trueindex = 10;

		// This is a for loop that is going to use the real index and the counter to iterate the array
		for (int startloop = 0; startloop < trueindex; startloop++) 
		{
			// if the beginning of the start loop is equal to the search then the true index and counter are the same
			if (list[startloop] == search) 
			{
				trueindex = counter;
			}
			counter++;
		}
		
		// if the true index + 1 is greater than count then it is going to return -1
		if (trueindex + 1 > count) 
			return -1; // it returns -1 if the element was not within the array
		else 
			return trueindex; // this is returned if the element within the array is found	
	}
}