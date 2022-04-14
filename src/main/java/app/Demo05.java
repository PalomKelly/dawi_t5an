package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo05 {
public static void main(String[] args) {
	//version mejorada de eliminar 
	//fabrica DAO
	//fabrica -->Dao
	   EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	   //Manejador de entidades
	    EntityManager em = fabrica.createEntityManager();
	  //proceso
	    Usuario u= new Usuario();
	    u.setCodigo(10);
	    
	    if(em.find(Usuario.class, u.getCodigo()) == null)
			   System.err.println("Usuario No existe");
		 else {
			   em.getTransaction().begin();  //empieza el proceso-->reg, act o elim
			   em.remove(em.find(Usuario.class, u.getCodigo()));//!ojo --Necesita un objeto q se debe devolver	   
	           //confirmación
	           em.getTransaction().commit();
	           System.out.println("Usuario eliminado correctamente");
		   }
	    //cierre
	    em.close();
}
}
