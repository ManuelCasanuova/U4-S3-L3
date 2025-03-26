package it.epicode.classi.persona;

import jakarta.persistence.EntityManager;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public Persona findById(Long id) {
        return em.find(Persona.class, id);
    }

    public void save (Persona a) {
        em.persist(a);
    }

    public void getById(Persona a) {
        em.merge(a);
    }

    public void delete (Long id) {
        Persona a = findById(id);
        em.remove(id);
    }
}
