# 事务 #

√: 可能出现    ×: 不会出现

<table>
<tr>
<td><span></span></td>
<td><span>脏读</span></td>
<td><span>不可重复读</span></td>
<td><span>幻读</span></td>
</tr>
<tr>
<td><span>Read uncommitted</span></td>
<td><span>√</span></td>
<td><span>√</span></td>
<td><span>√</span></td>
</tr>
<tr>
<td><span>Read committed</span></td>
<td><span>×</span></td>
<td><span>√</span></td>
<td><span>√</span></td>
</tr>
<tr>
<td><span>Repeatable read</span></td>
<td><span>×</span></td>
<td><span>×</span></td>
<td><span>√</span></td>
</tr>
<tr>
<td><span>Serializable</span></td>
<td><span>×</span></td>
<td><span>×</span></td>
<td><span>×</span></td>
</tr>
</table>
Oracle，SQL Server是READ COMMIT，MySQL为Repeatable Commit
>   **1.脏读：**
	脏读就是指当一个事务正在访问数据，并且对数据进行了修改，而这种修改还没有提交到数据库中，这时，另外一个事务也访问修改这个数据，然后使用了这个数据。  
	**2.不可重复读：**
	是指在一个事务内，多次读同一数据。在这个事务还没有结束时，另外一个事务也访问修改该同一数据。那么，在第一个事务中的两次读数据之间，由于第二个事务的修改，那么第一个事务两次读到的的数据可能是不一样的。这样就发生了在一个事务内两次读到的数据是不一样的，因此称为是不可重复读。（即不能读到相同的数据内容）
	例如，一个编辑人员两次读取同一文档，但在两次读取之间，作者重写了该文档。当编辑人员第二次读取文档时，文档已更改。原始读取不可重复。如果只有在作者全部完成编写后编辑人员才可以读取文档，则可以避免该问题。  
	**3.幻读:**  
	是指当事务不是独立执行时发生的一种现象，例如第一个事务对一个表中的数据进行了修改，这种修改涉及到表中的全部数据行。同时，第二个事务也修改这个表中的数据，这种修改是向表中插入一行新数据。那么，以后就会发生操作第一个事务的用户发现表中还有没有修改的数据行，就好象发生了幻觉一样。例如，一个编辑人员更改作者提交的文档，但当生产部门将其更改内容合并到该文档的主复本时，发现作者已将未编辑的新材料添加到该文档中。如果在编辑人员和生产部门完成对原始文档的处理之前，任何人都不能将新材料添加到文档中，则可以避免该问题。


所有的数据访问技术都有事务处理机制，这些技术提供了api用来开启事务来完成数据操作，或者在发生错误的时候回滚数据。
spring的事务机制是用同意的技术来处理不同数据访问技术的事务处理。Spring的事务机制提供了一个PlatformTransactionManager接口，不通的数据访问技术的事务使用不同的接口实现。  
如DataSourceTransActionManager是用于JDBC，JpaTransactionManager是用于JPA

- 声明式事务  
Spring支持声明式事务，用注解来选择需要使用的事务的方法，使用@Transactional注解在饭是钢发上表明该方法需要事务支持。基于AOP的实现操作。被注节的方法在调用时，Spring开启一个新的事务，当方法无异常运行结束后，Spring会提交这个事务。  
  Spring提供了一个@EnableTransactionManagement注解在配置类上来开启声明式事务的支持，使用了@EnableTransactionManagement后，Spring容器会自动扫描注解@Transactional的方法和类
- 注解事务行为  
可以使用@Transactional中的属性来添加事务行为  
  - propagationtion定义事务的生命周期，主要操作为方法之间调用是否开启新事务，是否强制在事务中执行等。
  - isolation 格力界定事务的完整性，吃力在多食物对相同数据下的处理机制，控制脏读幻读重复读等。
  - timeout 指定事务过期时间，默认为数据库的事务过期时间
  - readOnly 设定只读事务
  - rollbackFor指定哪个异常可以引起事务回滚
  - noRollbackFor指定哪个异常不可以引起事务回滚
- 使用  
  在方法上添加@Transactional注解，则此方法不报异常，事务会提交。