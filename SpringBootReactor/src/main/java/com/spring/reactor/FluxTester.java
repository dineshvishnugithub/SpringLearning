package com.spring.reactor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class FluxTester {
	
	FluxTester() {
		
		//source is the number array
		Integer[] numArray = {1,2,3,4,5};
		
		//numflux is the publisher that pulls the collection objects from the source
		Flux<Integer> numflux = Flux.fromArray(numArray);
		
		//test the publisher objects after subscribing it.
		//publisher has the subscriber attached on it, only then after the publisher pushes , the subscriber will be able to pull it
		//subscriber calls the onSubscribe method to pull the object and then the onNext() is called for the each object
		//onComplete() is called after the job is finished, if any error is thrown, then the onError() is called.
//		numflux.map((num) -> num + " numbers")
//		       .subscribe((str) -> System.out.println(str));
		
		//we will move the code to seperate method and print the thread
		//we see the same thread being used always.
//		numflux.map(FluxTester::printThreadOne)
//	       .subscribe((str) -> System.out.println(str));
		
		//also we will have another map to show different process.
//		numflux.map(FluxTester::printThreadOne)
//		   .map(FluxTester::printThreadTwo)
//	       .subscribe((str) -> System.out.println(str));
		
		Executor objExecutor = Executors.newFixedThreadPool(10);
		
		//now we make the first method to use different thread from thread pool
//		numflux.map(FluxTester::printThreadOne)
//		   .publishOn(Schedulers.fromExecutor(objExecutor))
//		   .map(FluxTester::printThreadTwo)
//	       .subscribe((str) -> System.out.println(str));
		
		//now the second map uses the different pool but the same thread.
		//Still true parallelism is not achieved.
//		numflux.map(FluxTester::printThreadOne)
//		   .publishOn(Schedulers.fromExecutor(objExecutor))
//		   .map(FluxTester::printThreadTwo)
//	       .subscribe((str) -> System.out.println(str));
		
		//for achieving true parallelism, we are going to introduce scheduler for second map.
		//also we are going to replace map to flat map as we are not going to have terminary method and return the object.
		//if we are subscribing on the second map, then we can use map itself
		numflux.map(FluxTester::printThreadOne)
		   .publishOn(Schedulers.fromExecutor(objExecutor))
		   .flatMap( (str) -> {
			   return Mono.just(str)
					      .publishOn(Schedulers.fromExecutor(objExecutor))
					      .map(FluxTester::printThreadTwo);
		   })
	       .subscribe((str) -> System.out.println(str));
		
	}
	
	private static String printThreadOne(Integer num) {
		System.out.println("First Map Thread in printThreadOne" + Thread.currentThread());
		return num + " numbers";
	}

	private static String printThreadTwo(String str) {
		System.out.println("Second map Thread in printThreadTwo" + Thread.currentThread());
		return str;
	}
	
	public static void main(String[] args) {
		FluxTester objFluxTester = new FluxTester();

	}

}
