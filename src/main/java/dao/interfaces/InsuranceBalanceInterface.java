package dao.interfaces;


import dao.entities.*;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface InsuranceBalanceInterface {
    InsuranceBalance save(InsuranceBalance ib);
}
