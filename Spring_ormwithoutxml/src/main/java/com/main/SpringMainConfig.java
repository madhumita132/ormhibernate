package com.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import training.com.config.SpringDBConfig;




@Configuration
@ComponentScan({"training.dao","traing.service"})
@Import(SpringDBConfig.class)
public class SpringMainConfig {

}