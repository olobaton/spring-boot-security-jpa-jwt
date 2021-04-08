/**
 * 
 */
package com.example.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.dataaccess.DataAccessPersona;
import com.example.model.dataaccess.DataPersonaPO;

/**
 * @author loboo
 *
 */
@Repository
@Transactional(readOnly = true)
public class DataAccessPersonaImpl{

	@PersistenceContext
	private EntityManager em;

	public List<DataPersonaPO> findCustom(Integer id) {
		System.out.print("HOLAAAAA");
		return em.createQuery("select p from DataPersonaPO p where p.id =:id", DataPersonaPO.class).getResultList();

		/*
		 * query.setFirstResult(1 * 1); query.setMaxResults(1);
		 */
	}

}
