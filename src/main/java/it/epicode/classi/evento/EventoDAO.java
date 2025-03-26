package it.epicode.classi.evento;

import jakarta.persistence.EntityManager;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento evento) {
        em.persist(evento);
        System.out.println("Evento salvato correttamente");
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }

    public void delete(Long id) {
        Evento evento = getById(id);
        em.remove(evento);
        System.out.println("Evento eliminato correttamente");
    }
}
