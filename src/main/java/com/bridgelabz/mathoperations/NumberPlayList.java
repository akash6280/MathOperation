package com.bridgelabz.mathoperations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;


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
	
	}
}
