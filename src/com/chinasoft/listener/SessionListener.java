package com.chinasoft.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.chinasoft.bean.Admin;

public class SessionListener implements HttpSessionListener,HttpSessionAttributeListener{
	
	public static Map<String, HttpSession> loginAdmin=new HashMap<String, HttpSession>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		if(event.getName().equals("admin")){
			Admin a=(Admin) event.getValue();
			HttpSession session=loginAdmin.remove(a.getAdminNumber());
			if(session!=null){
				session.removeAttribute("admin");
			}
			loginAdmin.put(a.getAdminNumber(), event.getSession());
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		if(event.getName().equals("admin")){
			try{
			Admin a=(Admin) event.getSession().getAttribute("admin");
			loginAdmin.remove(a.getAdminNumber());
			}catch(Exception e){
				
			}
			
			
		}
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		if(event.getName().equals("admin")){
			Admin a=(Admin) event.getValue();
			HttpSession session=loginAdmin.remove(a.getAdminNumber());
			if(session!=null){
				
			}
			loginAdmin.put(a.getAdminNumber(), event.getSession());
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		try{
			Admin a=(Admin) se.getSession().getAttribute("admin");
			loginAdmin.remove(a.getAdminNumber());
			System.out.println("xiaohui");
		}catch(Exception e){
			
		}
		
	}

}
