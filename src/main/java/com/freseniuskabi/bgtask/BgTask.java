package com.freseniuskabi.bgtask;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BgTask {

	private static final Logger log = LoggerFactory.getLogger(BgTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	public void sayHi() {
		log.info("{}: hiiiiiiiii!!!!!!!!!!!!", dateFormat.format(new Date()));
	}

}
