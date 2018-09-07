package base.bill;

import javax.sql.DataSource;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.client.RestTemplate;

import com.zaxxer.hikari.HikariDataSource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudApplication
@EnableSwagger2Doc
@EnableFeignClients
@EnableSwagger2
@ComponentScan(basePackages = { "base.bill" })
@MapperScan("base.bill.mapper")
public class BaseBillApplication {

	@Bean
	@LoadBalanced
	RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}
	
	@Value("${spring.datasource.hikari.data-source-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.hikari.jdbc-url}")
	private String url;
	@Value("${spring.datasource.hikari.username}")
	private String username;
	@Value("${spring.datasource.hikari.password}")
	private String password;
	@Value("${spring.datasource.hikari.maximum-pool-size}")
	private String maximumPoolSize;
	
//	@Bean
//	@LoadBalanced
//	public RestTemplate getRestTemplate() {
//		return new RestTemplate();
//	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
	    return new RestTemplate();
	}
	
	@Bean(destroyMethod = "close")
	@Primary
	public DataSource primaryDataSource() {

		HikariDataSource hikariDataSource = new HikariDataSource();
		hikariDataSource.setPoolName("springHikariCP");
		hikariDataSource.setDriverClassName(this.driverClassName);
		hikariDataSource.setJdbcUrl(this.url);
		hikariDataSource.setUsername(this.username);
		hikariDataSource.setPassword(this.password);
		hikariDataSource.setMaximumPoolSize(Integer.valueOf(this.maximumPoolSize));

		return hikariDataSource;
	}

	@Bean
	public DataSourceTransactionManager makeDataSourceTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}

	@Bean
	public SqlSessionFactory makeSqlSessionFactoryBean(DataSource dataSource) throws Exception {
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setTypeAliasesPackage("base.bill.mapper");
		sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
		
		return sessionFactory.getObject();
	}
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BaseBillApplication.class, args);
	}
}
