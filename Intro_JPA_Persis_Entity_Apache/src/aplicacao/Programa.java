package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
//Usando XAMPP para gerenciar o MYSQL no LOCALHOST.
//Usando tambem PHPMyAdmin para gerenciar as bases. 
//http://localhost/phpmyadmin/sql.php?db=aula7&table=pessoa&pos=0
		
//		Pessoa p1  = new Pessoa(null, "Bruno Shiroma", "bruno@hotmail.com");
//		Pessoa p2  = new Pessoa(null, "Pessoa 2", "testepessoa2@hotmail.com");
//		Pessoa p3  = new Pessoa(null, "Spring boot pessoa 3", "sprinbootpesso3@hotmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
//Teste -  inserindo essas pessoas na base de dados MYSQL
//		em.getTransaction().begin();
//		em.persist(p1);
//		em.persist(p2);
//		em.persist(p3);
//		em.getTransaction().commit();
		

//Teste -  de busca pelo ID (apos ter inserido)
//      Find (qual eh o dominio classe, ID [chave] da pessoa buscada)
//		Pessoa p = em.find(Pessoa.class, 2);
//	    System.out.println(p);
		
//Teste - Removendo um registro da tabela
//Precisa reinserir o ID 2 da tabela, eh deletadono teste		
		
// do jeito abaixo da erro: Removing a detached instance dominio.Pessoa#2
// pois tentou remover um registro "DESTACADO" e deveria ser "MONITORADO"	
// Montirado = Eh um objeto q vc acabou de inserir OOOUUU objeto q vc buscou do banco de dados e ainda nao fechou EntityManager
		
//		Pessoa p = new Pessoa(2, null, null);  // ---> esse aqui eh destacado
        Pessoa p = em.find(Pessoa.class, 2);   // ---> agora esta monitorado;   
        
        em.getTransaction().begin();
	    em.remove(p);
		em.getTransaction().commit();
	    
		System.out.println("Teste JPA finalizado");
		em.close();
		emf.close();
	}

}
