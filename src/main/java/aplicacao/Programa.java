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
        // Comentando para não duplicar registros na tabela
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);

        // Consultando um registro
        Pessoa pessoa = new Pessoa();
        pessoa = em.find(Pessoa.class,2);
        System.out.println("Pessoa encontrada: " + pessoa);

        // Atualizando um registro
        pessoa.setEmail("pmiyazaki@deloitte.com");
        em.persist(pessoa);
        System.out.println("Pessoa atualizada: " + pessoa);

        // Excluindo um registro
        em.remove(pessoa);
        System.out.println("Pessoa excluída: " + pessoa);

        // Comitando as transações
        em.getTransaction().commit();

        // Fechando as conexões
        em.close();
        emf.close();

    }
}
