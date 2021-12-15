package com.bilgeadam.main;



import org.hibernate.Session;



import com.bilgeadam.controller.CityController;
import com.bilgeadam.entity.LoginEntity;
import com.bilgeadam.util.HibernateUtil;



public class PrePostLoginMainTest {

public static void main(String[] args) {

LoginEntity loginEntity = new LoginEntity("hamit.mizrak@bilgeadam.com", "");

Session session = HibernateUtil.getSessionfactory().openSession();
session.getTransaction().begin();
session.persist(loginEntity);
session.getTransaction().commit();
System.out.println("ekleme tamamdır" + CityController.class);

}

}