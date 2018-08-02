package com.TimeTrackerApp.core.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.TimeTrackerApp.core.dao.AttendanceDao;
import com.TimeTrackerApp.core.domain.Attendance;
import com.TimeTrackerApp.core.domain.AttendanceRequest;
import com.TimeTrackerApp.core.domain.Employee;

@Repository
public class AttendanceDaoImpl implements AttendanceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Attendance> getAll() {

		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Attendance.class);
		
		@SuppressWarnings("unchecked")
		List<Attendance> attendanceList = criteria.list();
		
		return attendanceList;
	}


	@Override
	public void save(AttendanceRequest attendanceReq) {

		
		Session session = sessionFactory.getCurrentSession();

		Attendance attendance=new Attendance();
		Employee employee=new Employee();
		
		attendance.setEndTime(attendanceReq.getEndTime());
		attendance.setStartTime(attendanceReq.getStartTime());
		
		employee.setId(attendanceReq.getEmp_id());
		attendance.setEmployee(employee);
		
		session.save(attendance);
	}

	@Override
	public List<Attendance> getByQuantity(Integer quantity, String emailId) {

		Session session = sessionFactory.getCurrentSession();
		
		Criteria criteria = session.createCriteria(Attendance.class);
		
		criteria.createAlias("employee", "employee", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.eq("employee.emailId", emailId));
		criteria.setFirstResult(1);
		criteria.setMaxResults(quantity);
		
		@SuppressWarnings("unchecked")
		List<Attendance> attendanceList = criteria.list();
		
		return attendanceList;
	}
}
