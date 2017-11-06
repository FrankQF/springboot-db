# 缓存 #

1. Spring缓存支持：Spring定义了CacheManager和Cache接口用来统一不同的缓存技术，其中，CacheManager是SPring提供的各种缓存技术抽象接口，Cache接口包含缓存的各种操作。  
	- 使用任意一个实现的CacheManager的时候，需注册实现的CacheManager的Bean，例如  
     
    	@Bean
		Public EhCacheCacheManager cacheManager(CacheManager e){
			reutrn new EhCacheCacheManager（e）
		}
	- 声明式缓存注解  
	提供了四个注解来声明缓存规则
		- @Cacheable 在方法执行前Spring先查看缓存是否有数据，有则直接返回，没有则调用方法并返回值放进缓存  
		@Cacheable(value = "people", key = "#person.id")//缓存key为person的id数据到缓存people中  
         <br/>
		- @CachePut 无论怎样，都会将方法的返回值放到混村中。@Cacheut的属性与@Cacheable保持一致  
		@CachePut(value = "people", key = "#person.id")//缓存新增或者更新数据到缓存，名称为people，数据的key是person的id
         <br/>
		- @CacheEvict 将一条或多条数据从缓存中清除
		@CacheEvict(value = "people")//2从缓存people中删除key为id的数据
         <br/>
		- @Caching 通过@Caching注解组合多个注解策略在一个方法上
	- 开启声明式缓存支持：在配置类上使用@EnableCaching注解

2. 切换缓存技术  
除了移入相关依赖包或者配置以外，使用方式保持一致，  
EhCache在pom.xml中添加EhCache的依赖，EhCache所需的配置文件放在类路径下即可。  
Guava：添加pom依赖即可
Redis:添加依赖即可
