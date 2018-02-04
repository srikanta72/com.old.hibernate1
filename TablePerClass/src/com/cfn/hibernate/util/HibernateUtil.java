package com.cfn.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory factory;
	private HibernateUtil()
	{}
	public synchronized static  SessionFactory getSessionFactory()
	{
		if (factory==null)
		{
			Configuration conf= new Configuration();
			conf.configure("com/cfn/hibernate/cfg/hibernate.cfg.xml");
			ServiceRegistry registry=new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
			factory=conf.buildSessionFactory(registry);
		}
		return factory;
	}

}
