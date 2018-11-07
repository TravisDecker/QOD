package edu.cnm.deepdive.qod.model.dao;

import edu.cnm.deepdive.qod.model.entity.Quote;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

  List<Quote> findAllByTextContainingOrderByText(String fragment);

  List<Quote> findAllByTextContainingAndSourceContainingOrderBySource(String text, String source);

  List<Quote> findAllByOrderByText();

  List<Quote> findAllBySourceContainingOrderBySourceAscTextAsc(String fragment);

  @Query(value = "SELECT * FROM Quote ORDER By RANDOM() FETCH FIRST 1 ROW ONLY", nativeQuery = true)
  Optional<Quote> findRandom();

}
