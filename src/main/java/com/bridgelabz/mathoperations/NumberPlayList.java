package com.bridgelabz.mathoperations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Comparator;

public class NumberPlayList {
	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<Integer>();
		for(int i=0;i<5;i++) {
			myList.add(i);
		}
		Iterator<Integer> itr = myList.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	class MyConsumer implements Consumer<Integer>{
		public void accept(Integer number) {
			System.out.println("Consumer implementation value: "+number);
		}
	}
	MyConsumer action = new MyConsumer();
	myList.forEach(action);
	
	myList.forEach(new Consumer<Integer>() {
		public void accept(Integer number) {
			System.out.println("Anonymous class value: "+number);
		}
	});

	Consumer<Integer> listAction = n->{
		System.out.println("Explicit lambda implementation value:"+n);
	};
	myList.forEach(listAction);
	
	myList.forEach(n->{
		System.out.println("Implicit lambda implementation value: "+n);
	});
	
	Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
	myList.forEach(n->{
		System.out.println("foreach lambda double value : "+ toDoubleFunction.apply(n));
	});
	
	Predicate<Integer> isEvenFunction = n->n>0 && n%2==0;
	myList.forEach(n->{
		System.out.println("foreach lambda check even : "+isEvenFunction.test(n));
	});
	
	myList.stream().forEach(n->{
		System.out.println("stream foreach   value: "+n);
	});
	
	myList.stream()
    .map(toDoubleFunction)
    .forEach(System.out::println);;
	
	List<Double> doubleList = myList.stream()
			                 .map(toDoubleFunction)
			                 .collect(Collectors.toList());
		System.out.println("Double list: "+doubleList);

	List<Integer> evenList = myList.stream()
							.filter(isEvenFunction)
							.collect(Collectors.toList());
		System.out.println("Even Double list: "+evenList);	
	
	Integer firstNumber = myList.stream()
						 .filter(isEvenFunction)
						 .peek(n -> System.out.println("peek even number: "+n))
						 .findFirst()
						 .orElse(null);
		System.out.println("First even number: "+firstNumber);	
		
	Integer minimumNumber = myList.stream()
							.filter(isEvenFunction)
							.min((n1,n2) -> n1-n2).orElse(null);
		System.out.println("Minimum number: "+minimumNumber);

	Integer maximumNumber = myList.stream()
							.filter(isEvenFunction)
							.max(Comparator.comparing(Integer::intValue))
							.orElse(null);
	System.out.println("Maximum number: "+maximumNumber);	
		
	Integer sum = myList.stream()
			 	  .reduce(0,Integer::sum);
	long count = myList.stream().count();
		System.out.println("Sum is "+sum+" Average is: "+(sum/count));
		
	boolean allEven = myList.stream().allMatch(isEvenFunction);
	boolean oneEven = myList.stream().anyMatch(isEvenFunction);
		System.out.println("all even: "+allEven+" ,one even: "+oneEven);	
		
	List<Integer> sortedList = myList.stream()
	    					   .sorted((n1,n2)->n1.compareTo(n2))
	    					   .collect(Collectors.toList());
		System.out.println("Sorted list: "+sortedList);	
	}
}
