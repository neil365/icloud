package com.usersauth;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.apache.catalina.connector.Connector;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.client.RestTemplate;

import com.spring4all.swagger.EnableSwagger2Doc;
import com.zaxxer.hikari.HikariDataSource;

import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringCloudApplication
@EnableSwagger2Doc	//访问地址 http://IP:端口/swagger-ui.html
@ComponentScan(basePackages = { "com.usersauth" })
@MapperScan("com.usersauth.mapper")
@EnableFeignClients
public class SprUsersauthSystemApplication {

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
	
	public static void main(String[] args) {
		SpringApplication.run(SprUsersauthSystemApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
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
		sessionFactory.setTypeAliasesPackage("com.usersauth");
		sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
		
		return sessionFactory.getObject();
	}
	
	//Tomcat 优雅停机
	/**
	 *	 用于接受 shutdown 事件
     */
    @Bean
    public GracefulShutdown gracefulShutdown() {
        return new GracefulShutdown();
    }
 
    @Bean
    public ServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addConnectorCustomizers(gracefulShutdown());
        return tomcat;
    }
 
    /**
     * 	优雅关闭 Spring Boot
     */
    private class GracefulShutdown implements TomcatConnectorCustomizer, ApplicationListener<ContextClosedEvent> {
        private volatile Connector connector;
        private final int waitTime = 30;
        
        @Override
        public void customize(Connector connector) {
            this.connector = connector;
        }
        
        @Override
        public void onApplicationEvent(ContextClosedEvent contextClosedEvent) {
        	System.out.println("Shutting down, bye...");
            this.connector.pause();
            Executor executor = this.connector.getProtocolHandler().getExecutor();
            if (executor instanceof ThreadPoolExecutor) {
                try {
                    ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
                    threadPoolExecutor.shutdown();
                    if (!threadPoolExecutor.awaitTermination(waitTime, TimeUnit.SECONDS)) {
                        System.err.println("Tomcat thread pool did not shut down gracefully within " + waitTime + " seconds. Proceeding with forceful shutdown");
                    }
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

}
