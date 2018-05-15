package com.joshua.easypass.config.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.joshua.easypass.encap.CurrentUserSessionStorage;
import com.joshua.easypass.holder.SessionContextHolder;

@WebListener
public class SessionAttributeListener implements HttpSessionAttributeListener {    
    /** 
     * 添加Session 
     */  
    public void attributeAdded(HttpSessionBindingEvent event) {    
        if (CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY.equals(event.getName())) {    
        	SessionContextHolder.setCurrentUserSessionStorage((CurrentUserSessionStorage)event.getValue());    
        }    
    }    
    
    /** 
     * 替代Session 
     */  
    public void attributeReplaced(HttpSessionBindingEvent event) {    
        if (CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY.equals(event.getName())) {    
        	SessionContextHolder.setCurrentUserSessionStorage((CurrentUserSessionStorage)event.getValue());    
        }    
    }  
  
    /** 
     * 销毁Session 
     */  
    public void attributeRemoved(HttpSessionBindingEvent event) {  
        if(CurrentUserSessionStorage.CURRENT_USER_SESSION_STORE_KEY.equals(event.getName())){  
        	SessionContextHolder.resetCurrentUserSessionStorage();    
        }    
    }       
}    