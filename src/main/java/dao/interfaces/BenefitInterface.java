package dao.interfaces;


import dao.entities.*;

import java.util.Date;
import java.util.Optional;


public interface BenefitInterface {

    Optional<BenefitMap> findBySubProduct(SubProduct subProduct);

}
