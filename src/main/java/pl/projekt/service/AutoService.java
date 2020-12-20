package pl.projekt.service;

import pl.projekt.model.Auto;

import java.util.List;

public interface AutoService {
    List<Auto> getAuta();
    List<Auto> getOfertaDnia();
    List<Auto> getAllAuta();
    Auto findAutoByName(String name);
    List<Auto> findAuto(String name);
    void toggleObserwowane(Auto auto);
    List<Auto> findObserwowane();
    List<Auto>findAutoInObserwowane(String name);
    List<Auto> findAutaInCategory(String q);
    void updateAuto(Auto auto);
}
