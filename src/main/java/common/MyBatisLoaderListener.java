package common;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.catalina.core.ApplicationContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
@WebListener
public class MyBatisLoaderListener implements ServletContextListener {
    public MyBatisLoaderListener() {
    }
    //WAS가 종료될 때 호출
    public void contextDestroyed(ServletContextEvent sce)  {
    	System.out.println("서버 종료됨");
    }
    // WAS가 시작될 때 호출
    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("서버 시작됨");
		String resouce = "/mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resouce);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		// WAS가 종료되기 전까지 데이터가 살아있는 applicationContext에 sqlsession을 저장하고
		// applicationContext에 저장된 데이터를 원하는 위치에서 사용할 수 있다.
		ServletContext context = sce.getServletContext();
		context.setAttribute("sqlSession", sqlSession);
    }
	
}
