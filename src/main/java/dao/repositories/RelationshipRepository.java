package dao.repositories;


import dao.entities.RelationShip;
import dao.interfaces.RelationshipInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RelationshipRepository extends JpaRepository<RelationShip, String>, RelationshipInterface {


    @Query("SELECT r.relationShipId FROM RelationShip r WHERE r.description IN ?1")
    List<Long> findInDescription(List<String> description);

}
