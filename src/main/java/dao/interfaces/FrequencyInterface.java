package dao.interfaces;


import dao.entities.Frequency;

import java.util.List;
import java.util.Optional;

public interface FrequencyInterface {

    List<Frequency> findAll();
    Optional<Frequency> findByFrequencyId(String frequencyId);
}
