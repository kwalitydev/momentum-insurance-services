package dao.repositories;

import dao.entities.MemberProductPrice;
import dao.entities.Notification;
import dao.entities.NotificationType;
import dao.interfaces.MemberPriceInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MemberPriceRepository extends JpaRepository<MemberProductPrice, String>, MemberPriceInterface {


}
