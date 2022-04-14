package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
public static void main(String[] args) {
	//Obj>>> encontrar y devolver los datos de un Usuario, segun su codigo
	//fabrica -->Dao
	   EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	   //Manejador de entidades
	    EntityManager em = fabrica.createEntityManager();
	    //empieza el proceso-->En busqueda no es necesario--> em.getTransaction().begin();
	    
	 //select  -- where  id---
	   Usuario u = em.find(Usuario.class, 13);
	   
	   //devuelve un obj de Entidad , si encuentra el Id, sino devuelve null
	   if(u == null)
		   System.err.println("Usuario No existe !!!");
	   else 
	   System.out.println(u);
	   
	    //cierre
	    em.close();
}
}
