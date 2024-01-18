package rt.consulting.sa.Service;

import org.springframework.stereotype.Service;
import rt.consulting.sa.Repository.SentimentRepository;
import rt.consulting.sa.entites.Client;
import rt.consulting.sa.entites.Sentiment;
import rt.consulting.sa.enums.TypeSentim;

import java.util.List;

@Service
public class SentimentService {
    private ClientService clientService;
    private SentimentRepository sentimentRepo ;


    public SentimentService(ClientService clientService, SentimentRepository sentimentRepo) {
        this.clientService = clientService;
        this.sentimentRepo = sentimentRepo;
    }

    public void creer(Sentiment sentiment){
        Client client = this.clientService.lireOuCreer(sentiment.getClient());
        sentiment.setClient(client);
        //Analyse
        sentiment.setType(TypeSentim.POSTIF);
        if(sentiment.getText().contains("pas")){
            sentiment.setType(TypeSentim.NEGATIF);
        }
        this.sentimentRepo.save(sentiment);
    }

    public List<Sentiment> rechercher(TypeSentim type){
        if(type ==  null){
            return  this.sentimentRepo.findAll();
        }else {
          return   this.sentimentRepo.findByType(type);

        }
    }

    public void supprimer(int id) {
        this.sentimentRepo.deleteById(id);
    }
}
