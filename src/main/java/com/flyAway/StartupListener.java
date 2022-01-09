package com.flyAway;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.flyAway.data.IDTypeDAO;
import com.flyAway.data.IDTypeMySQLDAO;
import java.util.List;
import com.flyAway.data.IDType;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
@WebListener
public class StartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	IDTypeDAO idtypes = new IDTypeMySQLDAO();
    	List<IDType> ids = idtypes.findAll();
    	arg0.getServletContext().setAttribute("idtypes", ids);
    }
	
}
