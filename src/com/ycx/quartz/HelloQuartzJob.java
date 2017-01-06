package com.ycx.quartz;

import java.util.Date;

public class HelloQuartzJob {
	public void run() {
		System.out.println("quartz ===="+new Date());
	}
}
