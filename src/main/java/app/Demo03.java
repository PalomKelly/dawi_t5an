package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
public static void main(String[] args) {
	//eliminar un usuario
	
	//fabrica -->Dao
	   EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	   //Manejador de entidades
	    EntityManager em = fabrica.createEntityManager();
	    //empieza el proceso-->reg, act o elim
	    em.getTransaction().begin();
	   //proceso
	    //for 1.eliminacion logica-->actualizaci�n de estados
	    //for 2 eliminaci�n fisica-->delete
	    Usuario u= new Usuario();
	    u.setCodigo(13);
	  
	    em.remove(u);//!ojo --Necesita un objeto q se debe devolver
	    //confirmaci�n
	    em.getTransaction().commit();
	    //cierre
	    em.close();
}
}
