/*
 * Copyright (c) 2015-2020 by caitu99
 * All rights reserved.
 */
package com.thinking;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** 
 * @Description: (类职责详细描述,可空) 
 * @ClassName: CallableDem 
 * @author xiongbin
 * @date 2016年3月14日 下午6:14:47 
 * @Copyright (c) 2015-2020 by caitu99 
 */
public class CallableDem {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i=0;i<10;i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> fs : results){
			try {
				System.out.println(fs.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}finally {
				exec.shutdown();
			}
		}
	}
}
