package dao.interfaces;


import dao.entities.Status;
import dao.entities.SubProduct;
import dao.entities.Term;

import java.util.List;
import java.util.Optional;


public interface TermInterface {
    <S extends Term> S save(S a);
    Optional<Term> findByTermAndAge(int term, int age, Status status, SubProduct subProduct);

    List<Integer> findDistinctByTerm(Status status);
}
