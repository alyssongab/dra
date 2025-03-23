package testes;

import model.Pessoa;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TestaPessoa {

    private static void inserirPessoa(){
        Pessoa pessoa = new Pessoa("Rogerio", "Rogerio@gmail.com","92984535");

        EntityManager entityManager = JPAUtil.getEntityManager();

        entityManager.getTransaction().begin(); //Abrir a transação

        entityManager.persist(pessoa); // Salvar ou persistir

        entityManager.getTransaction().commit(); //Salvar a transação
    }

    private static void listarPessoa(){

        EntityManager entityManager = JPAUtil.getEntityManager();
        // JPQL
        Query consulta = entityManager.createQuery("SELECT p FROM Pessoa p");
        List<Pessoa> pessoas = consulta.getResultList();

        for(Pessoa p : pessoas){
            System.out.println(p);
        }
    }

    private static void consultarPessoa(){
        EntityManager entityManager = JPAUtil.getEntityManager();

        // JPQL
        Pessoa pessoa = entityManager.find(Pessoa.class, 1L);
        System.out.println(pessoa);
    }

    public static void alterarPessoa(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco02PU");

        EntityManager entityManager = factory.createEntityManager();

        // JPQL
        Pessoa pessoa = entityManager.find(Pessoa.class, 1L);

        entityManager.getTransaction().begin();

            pessoa.setNome("Rogerio Alterado");
            pessoa.setEmail("Rogerio@alteracao.com");
            pessoa.setTelefone("11111111");

        entityManager.getTransaction().commit();

        System.out.println(pessoa);
    }

    public static void removerPessoa(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Banco02PU");

        EntityManager entityManager = factory.createEntityManager();

        // JPQL
        Pessoa pessoa = entityManager.find(Pessoa.class, 1L);

        entityManager.getTransaction().begin();

        entityManager.remove(pessoa);

        entityManager.getTransaction().commit();

        System.out.println(pessoa);
    }

    public static void main(String[] args) {
        // inserirPessoa();
        // listarPessoa();
        // consultarPessoa();
        // alterarPessoa();
        // removerPessoa()
    }
}
