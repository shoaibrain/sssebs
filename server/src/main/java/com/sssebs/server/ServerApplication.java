package com.sssebs.server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ServerApplication {
	private static Logger logger = LogManager.getRootLogger();
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}


}
