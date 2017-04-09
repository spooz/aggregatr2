package pl.balukiewicz.links;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
interface LinkRepository extends MongoRepository<Link, Long>{

    Optional<Link> findById(Long id);

}
