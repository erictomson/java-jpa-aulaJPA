package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.stream.events.EntityDeclaration;

public class Programa {

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(null,"Bruno","bruno@deloitte.com");
        Pessoa p2 = new Pessoa(null, "Patricia", "patricia@deloitte.com");
        Pessoa p3 = new Pessoa(null, "Eric", "eric@deloitte.com");

        // Definindo a nova Entidade
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aulaJPA");
        // Gerenciando a Entidade
        EntityManager em = emf.createEntityManager();

        // Iniciando a transação
        em.getTransaction().begin();
        // Inserindo dados do BD
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        // Comitando a transação
        em.getTransaction().commit();

        // Fechando as conexões
        em.close();
        emf.close();

    }
}
