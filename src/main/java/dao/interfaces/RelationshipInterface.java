package dao.interfaces;


import dao.entities.Product;
import dao.entities.RelationShip;
import dao.entities.Status;

import java.util.List;
import java.util.Optional;

public interface RelationshipInterface {
    <S extends RelationShip> S save(S r);
    List<RelationShip> findByStatusAndProductOrderByDescription(Status status, Product product);
    Optional<RelationShip> findByRelationShipId(Long relationShipId);
    List<Long> findInDescription(List<String> description);

}
