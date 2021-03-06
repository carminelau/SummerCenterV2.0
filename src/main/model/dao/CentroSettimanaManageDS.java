package main.model.dao;

import static main.model.entity.CentroSettimana.FIND_CENTERS_AVAILABLES_BY_WEEK;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import main.listener.LocalEntityManagerFactory;
import main.model.entity.Centro;
import main.model.entity.CentroSettimana;
import main.model.entity.Settimana;

public class CentroSettimanaManageDS implements CentroSettimanaManage{
	
	
private EntityManager em;
	
	public CentroSettimanaManageDS() {
		try{
			em = LocalEntityManagerFactory.getEntityManager();
		} catch( RuntimeException ex){
			ex.printStackTrace(System.err);
			throw ex;
		}
	}
	public CentroSettimanaManageDS(EntityManager entityManager) {
		this.em = entityManager;
	}

	@Override
	public int getDisponibilita(int s, int c) {
		try {
			TypedQuery<CentroSettimana> query = em.createNamedQuery(CentroSettimana.GET_AVAILABLE_BY_WEEK_AND_CENTER, CentroSettimana.class);
			query.setParameter("idsett", s);
			query.setParameter("idcent", c);
			
			CentroSettimana re = query.getSingleResult();
			return re.getDisponibilita();
		} finally {
				em.close();
				}
	}

	@Override
	public List<Settimana> getSettimaneDisponibilibyCentro(int c) {
		try {
			TypedQuery<Settimana> query = em.createNamedQuery(CentroSettimana.FIND_WEEKS_AVAILABLE_BY_CENTER, Settimana.class);
			query.setParameter("idcent", c);
			
			List<Settimana> re = query.getResultList();
			return re;
		} finally {
				em.close();
				}
	}

	@Override
	public List<Centro> getCentriDisponibilibySettimana(int s) {
		try {
			TypedQuery<Centro> query = em.createNamedQuery(CentroSettimana.FIND_CENTERS_AVAILABLES_BY_WEEK, Centro.class);
			query.setParameter("idsett", s);
			
			List<Centro> re = query.getResultList();
			return re;
		} finally {
				em.close();
				}
	}
	@Override
	public List<CentroSettimana> getCentriSettimana() {
		try {
			TypedQuery<CentroSettimana> query = em.createNamedQuery(CentroSettimana.FIND_ALL_CENTRISETTIMANA, CentroSettimana.class);
			
			List<CentroSettimana> re = query.getResultList();
			return re;
		} finally {
				em.close();
				}
	}

}
