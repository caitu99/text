package com.thinking;

import java.util.concurrent.Callable;

/** 
 * @Description: (类职责详细描述,可空) 
 * @ClassName: TaskWithResult 
 * @author xiongbin
 * @date 2016年3月14日 下午6:12:39 
 * @Copyright (c) 2015-2020 by caitu99 
 */
public class TaskWithResult implements Callable<String> {

	private Integer id;
	
	public TaskWithResult(Integer id){
		this.id = id;
	}
	
	public String call() throws Exception {
		return "TaskWithResult:" + id;
	}
}
