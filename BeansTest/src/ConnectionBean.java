import java.util.Hashtable;

import javax.ejb.Stateless;
import javax.naming.*;
import javax.sql.DataSource;

@Stateless
public class ConnectionBean implements ConnectionItf {
	
	public void connectToDB() {
		Context context;
		System.out.println("IN  !!!!!!!!");
			Hashtable<String, String> ht = new Hashtable<String,String>();
	    	ht.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.NamingContextFactory");
	        ht.put(Context.PROVIDER_URL, "127.0.0.1:8080");
			//context = new InitialCoBEANntext(ht);
			System.out.println("before datasource");
			/*DataSource dataSource = (DataSource) context.lookup("jdbc:mysql://localhost:3306/testdb");
			if(dataSource != null) {
				System.out.println("it works !");
			}*/
    }
	
}
