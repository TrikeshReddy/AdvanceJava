package com.hello;

import org.springframework.boot.autoconfigure.web.ServerProperties.Tomcat.Resource;

public class Test {
public static void main(String[] args) {
	Resource r=new ClassPathResource("applicationContext.xml");
	BeanFactory factory=new XmlBeanFactory(r);
	
	Employee e1=(Employee)factory.getBean("e1");
	e1.show();
	Sample sample=factory.getBean("s1");
	System.out.println(sample);
	
}
}
