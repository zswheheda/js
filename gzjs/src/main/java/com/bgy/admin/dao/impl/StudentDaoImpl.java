package com.bgy.admin.dao.impl;

import com.bgy.admin.entity.Student;
import com.bgy.admin.dao.StudentDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	
	public void add(Student student) {
		this.getHibernateTemplate().save(student);
	}

	public void delete(Student student) {
		this.getHibernateTemplate().delete(student);
	}

	public void update(Student student) {
		this.getHibernateTemplate().update(student);
	}

	@SuppressWarnings("unchecked")
	public List<Student> findAll() {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(Student.class);
		return crit.list();
	}
	
	@Autowired  
	public void setMySessionFactory(SessionFactory sessionFactory) {
		  super.setSessionFactory(sessionFactory);  
	}

	public Student findbyId(String id) {
		//this.getHibernateTemplate().load(Student.class, id);
		return this.getHibernateTemplate().get(Student.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> findByName(String name) {
		Session session = this.getSessionFactory().getCurrentSession();
		Criteria crit = session.createCriteria(Student.class);
		crit.add(Restrictions.like("name", name, MatchMode.ANYWHERE));
		return crit.list();
	}

	

}
