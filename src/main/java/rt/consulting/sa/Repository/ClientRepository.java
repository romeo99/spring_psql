package rt.consulting.sa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rt.consulting.sa.entites.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findByEmail(String email);

}
