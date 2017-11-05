# SpringBoot rest访问 #

## 搭建rest直接访问服务 ##
查询用get，查询所有地址为persons，查询一个为persons/1  
更新某一个用put，地址为persons/1 ，入参为json  
删除用delete，地址为persons/1 


-  添加依赖

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-rest</artifactId>
		</dependency>

- 添加dao接口  

		public interface PersonRepository extends JpaRepository<Person, Long> {
  
	如此配置可以在项目访问路径中查到所有访问实体类的方法及入参 page,size,sort等，若实体类名字为Person，则persons可以查询到所有的实体类，persons/1可以查询到实体id为1的对象

- 自定义查询  在PersonRepository中可以自定义查询，添加参数之后可以暴露为REST资源

		@RestResource(path = "nameStartsWith", rel = "nameStartsWith")
		Person findByNameStartsWith(@Param("name")String name);
访问方法：http://localhost:8080/persons/search/nameStartsWith?name=f

- 定制  
在配置文件中添加参数可以定制根节点访问路径  

		data:
		  rest:
		    base-path: /api


    - 定制节点路径：定制实体类访问路径，在实体类的Repository上添加  
    
			@RepositoryRestResource(path = "people")
		注解，绑定实体类内容