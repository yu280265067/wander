package com.ycx.test;

public class SpringHibernate {
	/*@Test
	 // 通过spring的api获取sessionFactory
	public void test() throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");  
        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class); 
        Session session = sessionFactory.openSession();
        Transaction transation = session.beginTransaction();
		User user2=session.get(User.class, 2);
		user2.setName("12321");
		System.out.println(user2.getName());
		//session.save(user);
		transation.commit();
		session.close();
		sessionFactory.close();
        
	}
	
	@Test
	 // hibernate5获取sessionfactory 不需要seviceregister
	public void test2(){
		Configuration config=new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		// hibernate5 不能用serviceRegister 或者用test3的方法
		SessionFactory sessionFactory=config.buildSessionFactory();
		//SessionFactory sessionFactory=config.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		Transaction transation = session.beginTransaction();
		//hibernate数据库乱码 Incorrect string value 错误，排除代码端问题，最终问题发生在数据库编码，两种方法：一种使改数据库配置文件，二，配置hibernate.hbm2ddl.auto＝create
		//hibernate 会自动建表，配置编码信息，但是会删除数据 见：http://www.cnblogs.com/codeplus/archive/2011/08/02/2125546.html
		//User user = new User("梅西","111222333");
		//session.save(user);
		User user2=session.get(User.class, 1);
		user2.setName("罗纳尔多");
		//flush 会提交sql语句update，但是数据库不会发生变化，commit之后才会变化
		//refresh  会法select语句，使缓存的数据与数据库保持一致，注意数据库的事务隔离级别
		session.flush();
		System.out.println(user2.getName());
		//conmmit 之前hibernate会调用flush方法，发送update语句使缓存与数据库保持一致
		//当进行查询的时候 也会自动调用flush方法。
		//当id使用数据库底层的自增的时候，在save方法时，立即执行insert语句，不用等commit ，查询条件不用等到事务提交应该
		transation.commit();
		session.close();
		sessionFactory.close();
	
	}
	//hibernate4获取session需通过serviceregister 即可 5的话 需要configuration.addClass(User.class) 否则报unknown entity错误
	@Test
	public void test3(){
		  Configuration configuration = null;
	       SessionFactory sessionFactory = null;
	       ServiceRegistry serviceRegistry = null;
	         try {
	             configuration = new Configuration().configure();
	             serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	            // hibernate5 必须加下面这行
	             configuration.addClass(User.class);
	             sessionFactory = configuration.buildSessionFactory();
	             Session session =sessionFactory.openSession();
	             Transaction tx = session.beginTransaction();
	             User user2=session.get(User.class, 1);
	             User user3=session.get(User.class, 2);
	     		tx.commit();
	         } catch (HibernateException e) {
	             e.printStackTrace();
	         }
	     
	}
	@Test
	public void hibernateSavePersist(){
		Configuration config=new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transation = session.beginTransaction();
		User user2=new User(1,"内马尔","13213213","123");
		user2.setId(222);
		//save 调用之前可以setid 但是如果用的数据库层算法或者hibernate算法的话setid是无效的 ，但是persist之前setid直接抛出异常。
		//session.save(user2);
		session.persist(user2);
		transation.commit();
		session.close();
		sessionFactory.close();
	}
	@Test
	//说说游离对象和持久化对象自己的理解，session。get的对象是持久化对象，因为session获取的。用户自定义的new User是游离对象，不被session管理。
	//所以 游离对象setname（）不管与数据库是否一致都发sql语句，但是持久化对象就不发，flush的时候会和缓存中的比对一下。
	//顺便说updat方法 ，setname（）之后不需要调用session。update方法 因为在conmmit的时候会flush会调
	//在配置文件里selected－before－update＝true之后就会不重复查询了，但是一般不这么用，select语句换update语句 效率更低了
	//但是session。close了 就得调update方法。
	
	//在session缓存中不能有两个相同的oid对象
	//预留问题merge方法？
	public void getAndLoad(){
		Configuration config=new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transation = session.beginTransaction();
		//1.get立即发送sql语句，load在调用user。get 的时候才发送sql语句。 
		//2.若数据库中没有对应的纪录get返回null load抛出异常。load已经返回代理对象，所以必须由该对象。
		//3.如果在代理对象初始化之前已经把session。close（）了，就会发生懒加载异常。
		//session.get(User.class,1);
		session.load(User.class, 1);
		transation.commit();
		session.close();
		sessionFactory.close();
		
	}
	
	
	*/
}
