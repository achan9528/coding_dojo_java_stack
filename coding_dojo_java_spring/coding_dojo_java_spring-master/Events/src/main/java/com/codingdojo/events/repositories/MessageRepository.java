package com.codingdojo.events.repositories;

import java.util.List;
import com.codingdojo.events.models.Message;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>{
}
