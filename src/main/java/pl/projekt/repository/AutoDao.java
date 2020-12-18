package pl.projekt.repository;

import pl.projekt.model.Auto;

import java.util.List;

public interface AutoDao {
    List<Auto> findAllAuta();

    Auto findAutoByName(String name);
    void updateAuto(Auto auto);
}
