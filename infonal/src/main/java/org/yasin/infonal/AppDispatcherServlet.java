package main.java.org.yasin.infonal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@SuppressWarnings("serial")
public class AppDispatcherServlet extends DispatcherServlet {
	// TODO 26 Aug 2015 Write necessary configurations here
	private static final Logger logger = LoggerFactory.getLogger(AppDispatcherServlet.class);

	// TODO 26 Aug 2015 Think about this.
	protected void initStrategies(ApplicationContext context) {
		logger.debug("--- initStrategies calling");

		super.initStrategies(context);
	}

}
