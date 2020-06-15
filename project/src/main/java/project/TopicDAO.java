package project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicDAO extends JpaRepository<Topic, String> {

}
