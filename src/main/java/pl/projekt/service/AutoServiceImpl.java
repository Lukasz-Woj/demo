package pl.projekt.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.projekt.model.Auto;
import pl.projekt.repository.AutoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoServiceImpl implements AutoService{
    private List<Auto> auta;
    private List<Auto> oferAuto;
    private List<Auto> allAuta;
    private AutoDao autoDao;

    public AutoServiceImpl(AutoDao autoDao){
        createAuta();
        createOfertaDnia();
        //createAllAuta();
        this.autoDao = autoDao;
    }

    @Override
    public List<Auto> getAuta() {
        return auta;

    }

    @Override
    public List<Auto> getOfertaDnia() {
        return oferAuto;
    }

    @Override
    public List<Auto> getAllAuta() {

        return autoDao.findAllAuta();
    }

    @Override
    public Auto findAutoByName(String name) {
        return autoDao.findAutoByName(name);
    }

    @Override
    public List<Auto> findAuto(String name) {
        return getAllAuta().stream().filter(auto -> auto.getName().equals(name) ||  auto.getMarka().equals(name)).collect(Collectors.toList());
    }

    @Override
    public void toggleObserwowane(Auto auto) {
        auto.setCzyObserwowany(!auto.getCzyObserwowany());
        auto.setDodatkoweInformacje(null);

        autoDao.updateAuto(auto);
    }

    @Override
    public List<Auto> findObserwowane() {
        return getAllAuta().stream().filter(Auto::getCzyObserwowany).collect(Collectors.toList());
    }

    @Override
    public List<Auto> findAutoInObserwowane(String name) {
        return getAllAuta().stream().filter(auto -> (auto.getName().equals(name) ||  auto.getMarka().equals(name))&&(auto.getCzyObserwowany()==true)).collect(Collectors.toList());
    }

    @Override
    public List<Auto> findSport(Long q) {
        return getAllAuta().stream().filter(auto -> auto.getCategory() == q).collect(Collectors.toList());
    }

    @Override
    public List<Auto> findNormal(Long q) {
        return getAllAuta().stream().filter(auto -> auto.getCategory() == q).collect(Collectors.toList());
    }

    @Override
    public void updateAuto(Auto auto) {
        auto.setCzyObserwowany(null);

        autoDao.updateAuto(auto);
    }


    private void createAuta(){
        auta = new ArrayList<>();
        auta.add(new Auto(1l,"a4", "audi", "1.4", "benzyna", "90 000", 1998, true, 20000, "",false,1l));
        auta.add(new Auto(1l,"a5", "audi", "1.4", "benzyna", "90 000", 1998, true, 20000, "",false,1l));
        auta.add(new Auto(1l,"a4", "audi", "1.4", "benzyna", "90 000", 1998, true, 20000, "",false,1l));
        auta.add(new Auto(1l,"a5", "audi", "1.4", "benzyna", "90 000", 1998, true, 20000, "",false,1l));
        auta.add(new Auto(1l,"a4", "audi", "1.4", "benzyna", "90 000", 1998, true, 20000, "",false,1l));
        auta.add(new Auto(1l,"a5", "audi", "1.4", "benzyna", "90 000", 1998, true, 20000, "",false,1l));
    }
    private void createOfertaDnia(){
        oferAuto = new ArrayList<>();
        oferAuto.add(new Auto(1l,"a6", "audi", "1.4", "benzyna", "90 000", 1998, true, 20000, "",false,1l));
    }
    /*private void createAllAuta(){
        allAuta = new ArrayList<>();
        allAuta.add(new Auto("6", "Mazda", "2.2", "Diesel", "95 000", 2015, true, 23500,"",false));
        allAuta.add(new Auto("Yaris", "Toyota", "1.3", "Benzyna", "76 621", 2012, true, 33500, "",false));
        allAuta.add(new Auto("Q7", "Audi", "3.0", "Diesel", "31 7568", 2006, true, 44000, "",false));
        allAuta.add(new Auto("Qashqai", "Nissan", "2.0", "Diesel", "207 000", 2011, true, 33200, "",false));
        allAuta.add(new Auto("Ateca", "Seat", "1.4", "Benzyna", "48 000", 2016, true, 78900, "",false));
        allAuta.add(new Auto("Corolla", "Toyota ", "1.6", "Benzyna", "1", 2020, false, 84000, "",false));
        allAuta.add(new Auto("T-Roc", "Volkswagen", "1.5", "Benzyna", "5", 2020, false, 99300, "",false));
        allAuta.add(new Auto("T-Cross", "Volkswagen", "1.0", "Benzyna", "5", 2020, false, 88400, "",false));
        allAuta.add(new Auto("Pajero III", "Mitsubishi", "3.0", "Benzyna", "10 9000", 2003, true, 34900, "",false));
        allAuta.add(new Auto("Superb", "Skoda", "2.0", "Diesel", "145 100", 2016, true, 99900, "",false));
        allAuta.add(new Auto("GLC 200", "Mercedes-Benz", "2.0", "Diesel", "1", 2020, false, 205097, "",false));
        allAuta.add(new Auto("S-Max", "Ford", "1.6", "Benzyna", "135 600", 2013, true, 49800, "",false));
        allAuta.add(new Auto("Land Cruiser", "Toyota", "4.5", "Diesel", "292 000", 2008, true, 135300, "",false));
        allAuta.add(new Auto("C4 Grand Picasso", "Citroen", "2.0", "Diesel", "240 000", 2008, true, 17900, "",false));
        allAuta.add(new Auto("Mustang", "Ford", "5.0", "Benzyna", "70 000", 2013, true, 145000, "",false));
        allAuta.add(new Auto("ASX", "Mitsubishi", "1.6", "Benzyna", "28 489", 2015, true, 51900, "",false));
        allAuta.add(new Auto("A1", "Audi", "1.6", "Diesel", "150 000", 2011, true, 27200, "",false));
        allAuta.add(new Auto("Ceed", "Kia", "1.6", "Diesel", "162 000", 2016, true, 39999, "",false));
        allAuta.add(new Auto("S7", "Audi", "3.0", "Diesel", "5", 2020, false, 416600, "",false));
        allAuta.add(new Auto("308 SW", "Peugeot", "1.5", "Diesel", "90 000", 2014, true, 34400, "",false));
    }*/


}
