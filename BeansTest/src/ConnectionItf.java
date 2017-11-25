import javax.ejb.Remote;

@Remote
public interface ConnectionItf {
	public void connectToDB();
}
