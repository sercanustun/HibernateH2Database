package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.MsiEntity;
import com.bilgeadam.util.IDatabaseCrud;

public class MsiController implements IDatabaseCrud<MsiEntity>, Serializable {
	
	private static final long serialVersionUID = 8041934546611921393L;
	
	private static final Logger logger = LogManager.getLogger(MsiController.class);
	
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
	public void create(MsiEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + MsiController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + MsiController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(MsiEntity entity) {
		try {
			MsiEntity findEntity = find(entity.getComputerId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + MsiEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + MsiController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(MsiEntity entity) {
		try {
			MsiEntity findEntity = find(entity.getComputerId());
			if (findEntity != null) {
				findEntity.setCpu(entity.getCpu());
				findEntity.setRam(entity.getRam());
				findEntity.setMsiSupport(entity.getMsiSupport());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + MsiEntity.class);
			}
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + MsiController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<MsiEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		String hql = "select str from MsiEntity as str where str.id>=:key";
		TypedQuery<MsiEntity> typedQuery = session.createQuery(hql, MsiEntity.class);
		int id = 1;
		typedQuery.setParameter("key", id);
		ArrayList<MsiEntity> arrayList = (ArrayList<MsiEntity>) typedQuery.getResultList();
		logger.info("listelendi " + MsiEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public MsiEntity find(int id) {
		Session session = databaseConnectionHibernate();
		MsiEntity cityEntity;
		try {
			cityEntity = session.find(MsiEntity.class, id);
			
			if (cityEntity != null) {
				System.out.println("bulundu... " + cityEntity);
				return cityEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + MsiController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}
