package com.codingdojo.countries.repositories;

import java.util.List;
import com.codingdojo.countries.models.Language;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;

public interface LanguageRepository extends CrudRepository<Language, Long>{

}
