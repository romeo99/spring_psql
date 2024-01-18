package rt.consulting.sa.entites;

import jakarta.persistence.*;
import rt.consulting.sa.enums.TypeSentim;

import static jakarta.persistence.CascadeType.*;

@Entity
@Table(name = "sentiment")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private TypeSentim type;
    //Cascade persist pour dire qu'on récupere la clié du client et on l'injecte dans la clé étrangere
    // Merge , sil 'existe le client dans la bd, on va pas le recréer, on va récuperer l'id et l'injecter comme étant la clé dans sentimeent
    @ManyToOne(cascade = {PERSIST, MERGE})
    @JoinColumn(name = "client_ID")
    private Client client;

    public Sentiment() {
    }

    public Sentiment(int id, String text, TypeSentim type, Client client) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeSentim getType() {
        return type;
    }

    public void setType(TypeSentim type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
