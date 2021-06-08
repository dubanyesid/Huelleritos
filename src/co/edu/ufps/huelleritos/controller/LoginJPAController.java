package co.edu.ufps.huelleritos.controller;

import java.io.Serializable;

import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class LoginJPAController implements Serializable {

	private UserTransaction utx = null;
	private EntityManagerFactory emf = null;
	
	public void create()
}
