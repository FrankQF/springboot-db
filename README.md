#SpringBoot 核心 #

## 基本配置 ##
@SpringBootApplication为入口类，入口类有一个main方法，在main方法中使用SpringApplication.run启动项目。  
Spring boot默认会扫描main方法所在包及下属的包，放在其它包中的注解不会被扫描。若想修改，添加@ComponentScan注解

@SpringBootApplication是一个组合注解，@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

@Documented

@Inherited

@Configuration

@EnableAutoConfiguration

@ComponentScan


若想关闭特定的自动配置应使用exclude参数，  如@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})


##Banner##


1. 定制Banner,在src/main/resources下新建一个banner.txt
2. 关闭banner，main里修改（不常用，现用现查）


##SpringBoot配置文件##


- Spring Boot使用全局配置文件application.properties或者application.yml，放置在src/main/resources目录下或者类路径的/config下
- starter pom  
Spring Boot为我们提供了减缓企业级开发绝大多数场景的starter pom，只要使用了应用尝尽所需要的starter pom 相关的技术配置将会消除，现用先查，以及可以使用第三番starter pom

###外部配置###
- 命令行参数配置
  - 打成jar报的程序可以直接通过下面命令运行  
  java -jar xx.jar
  - 可以通过下面命令修改端口号
  java -jar xx.jar --server.port=9090

###常规属性配置###
通过@Value注入值，在application.yml里定义属性，直接用@Value注入即可  
eg：
配置文件

    frank:
      hello: Hello,World
使用：

	//声明
	@Component
	public class HelloConfig {
		@Value("${frank.hello}")
		private String word;
		
		public String getWord() {
			return word;
		}
		
		public void setWord(String word) {
			this.word = word;
		}
	}

	//调用1
	@Autowired
	private HelloConfig helloConfig;
	

或者直接在类中

	@Value("${frank.hello}")
	private String word;


###类型安全的配置###
通过@ConfigurationProperties将配置文件属性和一个Bean及其属性关联，从而实现类型安全的配置，通过pefix属性指定配置文件中配置信息的前缀，通过locations指定配置文件的位置（不写默认为application.yml）
配置文件

	frank:
	  word: Hello,World

使用：

	@Component
	@ConfigurationProperties(prefix = "frank")
	public class HelloConfig {
		private String word;
		
		public String getWord() {
			return word;
		}
		
		public void setWord(String word) {
			this.word = word;
		}
	}

引用：

	@Autowired
	private HelloConfig helloConfig;

###日志配置###
默认情况下，Spring Boot使用Logback作为日志框架

配置日志级别：

	logging.file=D:/mylog/log.log

配置日志文件，格式为logging.level.包名=级别

	logging.level.org.springframework.web = DEBUG

##Profile配置##
Profile是Spring用来针对不同的环境对不同的配置提供支持的，全局Profile配置使用application-{profile}.yml

通过在application.properties中设置spring.profiles.active={profile}来指定活动的Profile  
可以创建多个application-{profile}.yml（如application-prod.yml）,然后在application.yml中 通过

	spring:
	  profiles:
	    active: dev
指定启动默认的profile，spring会从这个profile中的配置文件和application.yml中读取配置文件，若配置有重复，以前者为准。

##自定义jar包，自己写starter pom ##
待补充
	
	

