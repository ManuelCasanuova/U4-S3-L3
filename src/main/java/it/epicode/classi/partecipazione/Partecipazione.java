package it.epicode.classi.partecipazione;

import it.epicode.classi.evento.Evento;
import it.epicode.classi.persona.Persona;
import it.epicode.classi.enums.Stato;
import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @ManyToMany(mappedBy = "partecipazioni", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Persona persona;

    @ManyToMany (mappedBy = "partecipazioni", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(Long id, Stato stato, Evento evento, Persona persona) {
        this.id = id;
        this.stato = stato;
        this.evento = evento;
        this.persona = persona;
    }

    public Partecipazione() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }
}
