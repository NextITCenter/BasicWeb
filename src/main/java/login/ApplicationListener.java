package login;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ApplicationListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("톰캣 서버 종료");
    }

    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("톰캣 서버 시작");
    }
	
}
