package com.helloworldservice.HelloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping(path = "/hello-world")
	public String helloWorld()
	{
		return "Hello World!";
		
	}
	
	/** Hello World using Bean class**/
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("HELLO WORLD..!");
	}
	
	/**Path parameters is variable values in URL's and to capture these value we use annotation @PathVarialbe**/
	/**Path Variable -> To capture data coming from URL**/
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello World, %s",name));
	}
}
