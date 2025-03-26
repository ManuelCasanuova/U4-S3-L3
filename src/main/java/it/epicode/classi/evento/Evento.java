package it.epicode.classi.evento;

import it.epicode.classi.enums.TipoEvento;
import it.epicode.classi.location.Location;
import it.epicode.classi.partecipazione.Partecipazione;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eventi")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 250, nullable = false, unique = true)
    private String titolo;


    private LocalDate dataEvento;


    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoEvento TipoEvento;

    private int numeroMassimoPartecipanti;

    @ManyToOne
    private Location location;

    @OneToMany(mappedBy = "evento")
    private List<Partecipazione> partecipazioni= new ArrayList<>();


    /*
    * 1 evento ha 1 location
    * 1 location è in molti eventi
     */

    public Evento(Long id, String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, List<Partecipazione> partecipazioni) {
        this.id = id;
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        TipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        this.location = location;
        this.partecipazioni = partecipazioni;
    }

    public Evento() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public TipoEvento getTipoEvento() {
        return TipoEvento;
    }

    public void setTipoEvento(TipoEvento TipoEvento) {
        this.TipoEvento = TipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }
}
