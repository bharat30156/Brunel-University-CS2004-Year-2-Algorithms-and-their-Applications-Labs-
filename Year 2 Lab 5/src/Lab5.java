import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class Lab5 {
	public static void main(String [] args)
	{
		//Exercise 5.2.1
		System.out.println("Exercise 1 :");
		Data x = new Data("Bharat", 21);
		x.Print();
		
		//Exercise 5.2.1.2
		Exercise5212();
		
		//Exercise 5.2.2.3
		Exercise5223();
		
		//Exercise 5.3.3
		Exercise533();
		
		//Exercise 5.4.4
		Exercise544();
		
	}
	
	public static void PrintCollection(Collection<Data> c)
	{
		for(Iterator<Data> iter = c.iterator(); iter.hasNext();)
		{
			Data x = (Data)iter.next();
			x.Print();
		}
	}
	
	public static void Exercise5212()
	{
		System.out.println("\nExecise 2 : ");
		//create the instance of LinkedList to add Data
		LinkedList<Data> array = new LinkedList<>();
		
		//Creating objects 
		Data fred = new Data("fred", 21);
		Data jo = new Data("jo", 37);
		Data zoe = new Data("Zoe", 37);
		Data harry = new Data("Harry", 78);
		
		//Adding data to array
		
		array.add(fred);
		array.add(jo);
		array.add(zoe);
		array.add(2,harry);
		PrintCollection(array);	
	}
	
	public static void Exercise5223()
	{
		System.out.println("\nExercise 3 : Part 1 ");
		ArrayList<Data> arrayA = new ArrayList<>();
		ArrayList<Data> arrayB = new ArrayList<>();
		ArrayList<Data> arrayC = new ArrayList<>();
		ArrayList<Data> arrayD = new ArrayList<>();
		
		//Creating objects 
		Data fred = new Data("fred", 21);
		Data jo = new Data("jo", 37);
		Data zoe = new Data("Zoe", 37);
		
		//Adding elements to array
		arrayA.add(fred);
		arrayA.add(jo);
		arrayA.add(zoe);
		
		//Adding elements to array
		arrayC.add(fred);
		arrayC.add(jo);
		arrayC.add(zoe);
		
		//Printing arrayA
		PrintCollection(arrayA);
		System.out.println();
		
		
		arrayB = arrayA;
		PrintCollection(arrayB);
		System.out.println();
		
		//Removing elements from arrayA
		arrayA.remove(1); 
		PrintCollection(arrayB);
		
		//2nd part of exercise 3
		System.out.println("\nExercise 3: part 2");
		PrintCollection(arrayC);
		System.out.println();
		
		//Cloning arrayC
		arrayD = (ArrayList<Data>)arrayC.clone();
		
		//REmoving elements from arrayC
		arrayC.remove(1);
		PrintCollection(arrayC);
		System.out.println();
		
		//Printing arrayD
		PrintCollection(arrayD);
		System.out.println();		
	}
	
	public static void Exercise533()
	{
		System.out.println("\nExercise 3: Stacks ");
		Data fred = new Data("Fred", 21);
		Data jo = new Data("Jo", 43);
		Data zoe = new Data("Zoe", 37);
		
		//creating instance of stack
		Stack<Data> stack = new Stack<Data>();
		stack.push(fred);
		stack.push(jo);
		stack.push(zoe);
		
		//Printing
		PrintCollection(stack);
		while(stack.isEmpty() == false)
		{
			stack.pop().Print();// remove items from stack in reverse order as its LIFO structure
		}
		System.out.println("\nSize of Stack" + stack.size());
	}
	
	public static void Exercise544()
	{
		System.out.println("\nExercise 4: Queues");
		Data fred = new Data("Fred", 21);
		Data jo = new Data("Jo", 43);
		Data zoe = new Data("Zoe", 37);
		
		ArrayBlockingQueue<Data> q = new ArrayBlockingQueue<Data>(10);
		
		q.add(fred);
		q.add(jo);
		q.add(zoe);
		
		PrintCollection(q);
		
		while(q.isEmpty() == false)
		{
			q.poll().Print(); // removes items from queue in order as its a FIFO structure 
		}
		System.out.println("\nSize of Queue" + q.size() + "\n");
		
		for(int i = 0; i < 20; i++) //20 cause an error as the defined size of the queue is 10 (0 - 9) which is why we use less that and nor <=
		{
			q.offer(new Data("Test:" + String.valueOf(i), i)); // Using offer will not shoe illegalStatement Exception 
															   // but return false when in fails to add element in a size restricted queue					
		}
	    PrintCollection(q);	
	}
}
