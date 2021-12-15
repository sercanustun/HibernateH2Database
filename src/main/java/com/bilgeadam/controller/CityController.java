package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.CityEntity;
import com.bilgeadam.util.IDatabaseCrud;

public class CityController implements IDatabaseCrud<CityEntity>, Serializable {
	
	private static final long serialVersionUID = 8041934546611921393L;
	
	private static final Logger logger = LogManager.getLogger(CityController.class);
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	// DML:Create Delete Update : transaction
	// DQL:select : transaction isteğe bağlı
	// create:persist
	// delete: remove
	// update: merge
	// find : find
	@Override
	public void create(CityEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + CityController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + CityController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(CityEntity entity) {
		try {
			CityEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + CityEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + CityController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(CityEntity entity) {
		try {
			CityEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setCityName(entity.getCityName());
				findEntity.setCityLogo(entity.getCityLogo());
				findEntity.setColor(entity.getColor());
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + CityEntity.class);
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + CityController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<CityEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from CityEntity as str where str.id>=:key";
		TypedQuery<CityEntity> typedQuery = session.createQuery(hql, CityEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<CityEntity> arrayList = (ArrayList<CityEntity>) typedQuery.getResultList();
		logger.info("listelendi " + CityEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public CityEntity find(int id) {
		Session session = databaseConnectionHibernate();
		CityEntity cityEntity;
		try {
			cityEntity = session.find(CityEntity.class, id);
			
			if (cityEntity != null) {
				System.out.println("bulundu... " + cityEntity);
				return cityEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + CityController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}
