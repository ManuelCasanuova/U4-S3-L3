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


        Location location = new Location(null, "Eventi Roma", "Via Roma");
        Persona persona = new Persona(null, "Giovanni", "Rossi", "giovannirossi@gmail.com", LocalDate.of(1990, 5, 5), Sesso.M);
        Evento evento = new Evento(null, "Sotto le stelle di Roma", LocalDate.of(2025, 01, 10), "Evento sotto le stelle presentato da Mario", TipoEvento.PUBBLICO, 150, location );
        Partecipazione partecipazione = new Partecipazione(null, Stato.CONFERMATA, evento, persona);

    }
}
