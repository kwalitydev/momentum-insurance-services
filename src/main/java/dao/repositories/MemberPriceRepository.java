package dao.repositories;

import dao.entities.MemberProductPrice;
import dao.interfaces.MemberPriceInterface;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberPriceRepository extends JpaRepository<MemberProductPrice, String>, MemberPriceInterface {



}
