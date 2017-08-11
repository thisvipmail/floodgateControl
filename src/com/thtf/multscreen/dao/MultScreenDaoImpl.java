package com.thtf.multscreen.dao;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.thtf.multscreen.entity.FloodPumpCam;

@Repository(value = "multScreenDao")
public class MultScreenDaoImpl extends HibernateDaoSupport implements MultScreenDao {

	@Resource(name = "sessionFactory")
	public void setSessionFactoryOverride(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Override
	public FloodPumpCam getFloodPumpID(String id) {

		FloodPumpCam floodPumpCam = (FloodPumpCam) getHibernateTemplate().get(FloodPumpCam.class.getName(), id);

		return floodPumpCam;
	}
}
