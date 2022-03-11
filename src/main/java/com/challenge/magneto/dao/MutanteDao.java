package com.challenge.magneto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.challenge.magneto.models.Mutante;

@Repository
@Transactional

public class MutanteDao {

	@PersistenceContext
	private EntityManager entityManager;
	

	public List<Mutante> estadisticas() {
		
		String query = "FROM mutantes";
		return entityManager.createQuery(query).getResultList();
		 
		 
	}
}
