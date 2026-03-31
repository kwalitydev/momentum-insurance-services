package dao.repositories;


import dao.entities.Status;
import dao.entities.SubProduct;
import dao.entities.Term;
import dao.interfaces.TermInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface TermRepository extends JpaRepository<Term, String>, TermInterface {

    @Query("SELECT t from Term t WHERE t.term=?1 AND t.maxAge>=?2 AND t.minAge<=?2 AND t.status=?3 AND t.subProduct=?4")
    Optional<Term> findByTermAndAge(int term, int age, Status status, SubProduct subProduct);

    @Query("SELECT DISTINCT(t.term) from Term t WHERE t.status=?1 ORDER by t.term")
    List<Integer> findDistinctByTerm(Status status);



}
