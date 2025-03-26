package it.epicode.classi;

import it.epicode.classi.enums.Sesso;
import it.epicode.classi.enums.Stato;
import it.epicode.classi.enums.TipoEvento;
import it.epicode.classi.evento.Evento;
import it.epicode.classi.evento.EventoDAO;
import it.epicode.classi.location.Location;
import it.epicode.classi.location.LocationDAO;
import it.epicode.classi.partecipazione.Partecipazione;
import it.epicode.classi.partecipazione.PartecipazioneDAO;
import it.epicode.classi.persona.Persona;
import it.epicode.classi.persona.PersonaDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();


        EventoDAO eventoDAO = new EventoDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);

        em.getTransaction().begin();






      Location location = new Location(null,"Roma Eventi", "Roma",null);
      locationDAO.save(location);
      Evento evento = new Evento(null, "Concerto", LocalDate.of(2023, 12, 31), "Un concerto di musica", TipoEvento.PUBBLICO, 100, location, null);
      eventoDAO.save(evento);
      Persona persona = new Persona(null, LocalDate.of(1990, 5, 15), "mariorossi@gmail.com", "Mario", "Rossi", Sesso.M,null);
      personaDAO.save(persona);
      Partecipazione partecipazione = new Partecipazione(null, Stato.CONFERMATA, evento, persona );
      partecipazioneDAO.save(partecipazione);



        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}
