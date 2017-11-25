import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Client {
	
	public static void main(String args[]) {
		try {
			testLocalToUpper();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public static void testLocalToUpper() throws NamingException {
    	// prepare client context
        final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
        jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.NamingContextFactory");;
        jndiProperties.put(Context.PROVIDER_URL, "127.0.0.1:4447");//${jboss.bind.address:127.0.0.1}
        jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        
        Properties prop = new Properties();
        
        prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.NamingContextFactory");
        prop.put(Context.PROVIDER_URL, "127.0.0.1:8080");
        prop.put(Context.SECURITY_PRINCIPAL, "Elphedia");
        prop.put(Context.SECURITY_CREDENTIALS, "devilmaycry2");
                  
        prop.put("jboss.naming.client.ejb.context", true);

        System.out.println("before calling context");
        Context context = new InitialContext(prop);
       
        ConnectionItf tb = (ConnectionItf)context.lookup("java:module/TestBean/ConnectionBean");;
        System.out.println("After calling connect");
        tb.connectToDB();
    }

}