package rt.consulting.sa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rt.consulting.sa.entites.Sentiment;
import rt.consulting.sa.enums.TypeSentim;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {
    List<Sentiment> findByType(TypeSentim type);
}
