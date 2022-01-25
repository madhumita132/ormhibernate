package training.com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@PropertySource("classpath:training/resources/db_connection.properties")
public class SpringDBConfig {

	//reading value from properties file and giving to the distance
	@Value("${cst_db_driver}")//SPEL
	private String driverName;
	
	@Value("${cst_db_url}")
	private String url;
	
	@Value("${cst_user}")
	private String userName;
	
	
	@Value("${cst_password}")
	private String password;
	
	//To resolve ${} in @value
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	//Data source can have any name
	@Bean(name = "cst_DataSource")
	public DriverManagerDataSource getDataSource() {
		//values which are dynamically set through property file is printed
		System.out.println("driverName");
		System.out.println("url");
		System.out.println("userName");
		System.out.println("password");
		
DriverManagerDataSource dataSource = new DriverManagerDataSource();

//setting DB details to dataSource object

dataSource.setDriverClassName(driverName);
dataSource.setUrl(url);
dataSource.setUsername(userName);
dataSource.setPassword(password);

return dataSource;

	}
	
	//Spring JPA general configurations
	
	public HibernateJpaVendorAdapter getVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(false);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
	return adapter;
	
	}
	@Bean(name = "cst_entityManagerFactory")//can have any name
	public LocalContainerEntityManagerFactoryBean getEntityManagerFactory(DriverManagerDataSource dataSource) {
	LocalContainerEntityManagerFactoryBean factoryBuilder = new LocalContainerEntityManagerFactoryBean();
	factoryBuilder.setDataSource(dataSource);
	factoryBuilder.setJpaVendorAdapter(getVendorAdapter());
	factoryBuilder.setPackagesToScan("com.entity");
	
	return factoryBuilder;
}
}