package com.callback.test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ICallbackTest {
	
	static ExecutorService executor = Executors.newFixedThreadPool(10);
	
	public static class MyCall implements Callable<Map<String,Object>> {

		@Override
		public Map<String, Object> call() throws Exception {
			
			System.out.println("Mycall starting...");
			
			Thread.sleep(2000);
			
			HashMap<String, Object> params = new HashMap<String, Object>();
			
			params.put("name", "nana1");
			
			return params;
		}
		
	}
	
	public static void doStm(final ICallback callback) {
		Thread t = new Thread() {
			
			public void run() {
				
				System.out.println("线程id："+Thread.currentThread().getId());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				HashMap<String, Object> params = new HashMap<String, Object>();
				
				params.put("name", "nana1");
				
				callback.callback(params);
			}
		};
		
		executor.execute(t);
		
		executor.shutdown();
	}

	public static void main(String[] args) {
		
//		ICallbackTest.doStm(new ICallback() {
//			
//			@Override
//			public void callback(Map<String, Object> params) {
//				System.out.println(params);
//			}
//		});
//		
////		ICallbackTest.doStm((params)->{
////			System.out.println(params);
////		});
//		
//		System.out.println("主线程id："+Thread.currentThread().getId());
		
		ICallbackTest.MyCall myCall = new ICallbackTest.MyCall();
		
		Future<Map<String, Object>> future = ICallbackTest.executor.submit(myCall);
		
		ICallbackTest.executor.shutdown();
		
		while (!future.isDone()) {
			
			try {
				Map map = future.get();
				
				System.out.println(map);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("主线程id："+Thread.currentThread().getId());
	}

}
