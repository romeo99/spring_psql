package rt.consulting.sa.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.*;
import rt.consulting.sa.Repository.ClientRepository;
import rt.consulting.sa.entites.Client;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {

        this.clientRepository = clientRepository;
    }

    public void creer(Client client){
        Client clientInBdd = this.clientRepository.findByEmail(client.getEmail());
        if(clientInBdd == null){
            this.clientRepository.save(client);
        }


    }

    public List<Client> rechercher(){
        return  this.clientRepository.findAll();
    }

    public Client lire(int id){
        //optional parce que le client peut exister ou non
         Optional<Client> optionalClient =  this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client lireOuCreer(Client clientAcreer){
        Client clientInBdd = this.clientRepository.findByEmail(clientAcreer.getEmail());
        if(clientInBdd == null){
            clientInBdd =  this.clientRepository.save(clientAcreer);
        }
        return clientInBdd;


    }


}
