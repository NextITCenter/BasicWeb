package common;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent se)  {
    	System.out.println("세션에 데이터가 추가됨");
    }
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    }
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    }
	
}
