package service;

import domain.Personne;
import jpa.EntityManagerHelper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersonneDAO implements GenericDAO<Personne, Long> {


  @Override
  public Personne create(Personne personne) {
    EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
    t.begin();
    EntityManagerHelper.getEntityManager().persist(personne);
    t.commit();
    return personne;
  }

  @Override
  public Personne read(Long id) {

    EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
    EntityManager manager = factory.createEntityManager();
    Personne personne = manager.find(Personne.class,id);
    manager.close();
    factory.close();
    return personne;
  }

  @Override
  public Personne update(Personne personne) {
    EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
    t.begin();
    EntityManagerHelper.getEntityManager().merge(personne);
    t.commit();
    return personne;
  }


  @Override
  public void delete(Personne personne) {
    EntityTransaction t = EntityManagerHelper.getEntityManager().getTransaction();
    t.begin();
    EntityManagerHelper.getEntityManager().remove(personne);
    t.commit();

  }
}
