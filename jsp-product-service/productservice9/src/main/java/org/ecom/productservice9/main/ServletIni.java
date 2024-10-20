package org.ecom.productservice9.main;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.ecom.productservice9.config.Config;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ServletIni implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		// ctx.register(AppConfiguration.class);
	 	ctx.register(Config.class);

		DispatcherServlet servlet = new DispatcherServlet(ctx);
		Dynamic dynamic = servletContext.addServlet("dispatcher", servlet);

		dynamic.addMapping("/");// security layer
		dynamic.setLoadOnStartup(1);// if negative or 0 will give it cannot create objects,,tomcat server loding
									// always +ve num

	}

}
