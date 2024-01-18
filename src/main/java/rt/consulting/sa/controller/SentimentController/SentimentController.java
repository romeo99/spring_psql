package rt.consulting.sa.controller.SentimentController;
import org.springframework.http.HttpStatus;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;
import rt.consulting.sa.Repository.SentimentRepository;
import rt.consulting.sa.Service.SentimentService;
import rt.consulting.sa.entites.Client;
import rt.consulting.sa.entites.Sentiment;
import rt.consulting.sa.enums.TypeSentim;
import java.util.List;


import java.awt.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {
    private SentimentService sentimentServ;

    public SentimentController(SentimentService sentimentServ) {
        this.sentimentServ = sentimentServ;
    }
    @ResponseStatus(value= HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void creer(@RequestBody Sentiment sentiment){
        this.sentimentServ.creer(sentiment);
    }

    @GetMapping
    public @ResponseBody List<Sentiment> rechercher(@RequestParam(required = false) TypeSentim type){
        return this.sentimentServ.rechercher(type);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void supprimer(@PathVariable int id){
        this.sentimentServ.supprimer(id);

    }


}
