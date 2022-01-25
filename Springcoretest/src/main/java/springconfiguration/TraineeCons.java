package springconfiguration;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TraineeCons {

	public static void main(String[] args) {
		Resource r1=new ClassPathResource("applicationContext.xml");
		BeanFactory f=new XmlBeanFactory(r1);
		Trainee t=(Trainee)f.getBean("traincons");
		t.show();
		Trainee t2=(Trainee)f.getBean("traincons2");
		t2.show();
		Trainee t3=(Trainee)f.getBean("traincons3");
		t3.show();
	}

}
