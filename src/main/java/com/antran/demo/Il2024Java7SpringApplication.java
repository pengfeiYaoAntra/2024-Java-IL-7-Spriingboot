package com.antran.demo;

import com.antran.demo.Service.JavaDeveloperService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


/**
 * we are using spring mvc pattern
 * Model:This is where your business logic located
 *
 * View: rendering data on your user interface
 * Controller: handles user request and updates the model and view accordingly.
 * View -> controller -> model
 *
 * why do we need mvc pattern
 * separation of concerns:
 * reusability:  -> reducing development time and cost
 *
 *
 * global exception
 * 	1: ControllerAdvice
 * 	2: ExceptionHandler
 *
 * 	//request body will extract data from the body of the http request
 *     //reuqest param is sued to read query paramters from URL -> often use with get and accessing simple values from thr query
 *     //pathvariable extracts data from uri path itself
 *
 *     logger:
 *     trace
 *     debug:
 *     info
 *     warn
 *     error
 *     fatal
 *
 *     getmapping -> http get
 *     postmapping -> http post
 *     putmapping
 *     deletemapping
 *     patchmapping
 *
 *     patch vs put
 *     	patch is used when user/you want update a PART of the resource
 *     	put: can be used when user need to replace an entire resource with new value
 *
 *
 *     ResetController vs controller
 *     controller is a basic annotation used to define a controller class. controller annotatoin will return HTML(like View)
 *     restcontroller: is conbination of controller and responseBody -> it does not return HTML, but will return Json, XML
 *
 *
 *     Spring IOC
 *     it is a contianer that helps us to manage beans
 *     what is a bean?
 *     bean is an object that managed by IOC
 *
 *     ApplicationContext extends beanfactory
 *
 *
 * 	how can you take beans from IOC
 *
 * 	autowired annotation -> find bean by type
 *
 * 	qualifier annotation -> find bean by name
 *
 *
 *
 * filed injection
 *  class customerService{
 * 		@Autowired
 * 		private CustomerRepository customerRepository
 *
 *  }
 *  why do we need it: easy to use ot setup
 *  disadvantages:
 *  	there is not final keyword. other threads can change it
 *  	private -> not easy to use unit test
 *
 * constructor injection!!!!!!
 * 	passing beans/dependencies as parameter to the class constructor
 *  private final CustomerService customerService;
 *     @Autowired
 *     public CustomerController(CustomerService customerService){
 *         this.customerService = customerService;
 *     }
 *     advantages:
 *     	immutability: final keyword is used
 *     	easy to test, since we pass beans/dependences into the constructor
 *     	dis:
 *     		makes code more complex
 *
 *
 * setter injection
 *		private  CustomerService customerService;
 *     @Autowired
 *     public CustomerController(CustomerService customerService){
 *         this.customerService = customerService;
 *     }
 * 		advantage
 * 			more flexibility
 *
 * 		dis
 * 			not immutability
 *
 *
 *
 *
 * spring aop
 *
 * aspect: cross-cutting concern
 *
 * join point is a specific point during the execution of you programming
 *
 * pointcut: it is a predicate that matches one or more join points in your application
 *
 *
 * advice: is an action can be taken by an aspect at a particular join point
 * 		 before, after, afterReturning, afterthrowing , around
 *
 *
 *
 *
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class Il2024Java7SpringApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(Il2024Java7SpringApplication.class, args);
		String[] names = configurableApplicationContext.getBeanDefinitionNames();


	}

}
