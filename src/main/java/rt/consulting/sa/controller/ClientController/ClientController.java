package rt.consulting.sa.controller.ClientController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import rt.consulting.sa.Service.ClientService;
import rt.consulting.sa.entites.Client;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
public class ClientController {
    private ClientService clientServ;

    public ClientController(ClientService clientServices) {
        this.clientServ = clientServices;
    }

    @ResponseStatus(value= HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Client client){

        this.clientServ.creer(client);

    }
    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> rechercher(){
        return this.clientServ.rechercher();
    }

    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Client GetUserByParam(@PathVariable int id){
       return this.clientServ.lire(id);
    }

}
