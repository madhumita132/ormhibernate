package springconfiguration;

public class Addresscon {

	private String address1;
	private String address2;

	public Addresscon() {
		System.out.println("constructor address");
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		System.out.println("setter address class1");
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		System.out.println("setter address class2");
		this.address2 = address2;
	}
}
