package springconfiguration;


public class Trainee {
private int tid;
String name;
public Trainee(int tid, String name) {
	super();
	this.tid = tid;
	this.name = name;
}
void show() {
	System.out.println("id:"+tid+"name"+name);
}
}
