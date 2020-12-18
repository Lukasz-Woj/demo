package pl.projekt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.projekt.model.Auto;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AutoDaoImpl implements AutoDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AutoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /*@EventListener(ApplicationReadyEvent.class)
    public void createAllAuta(){
        List<Auto> allAuta = new ArrayList<>();
        allAuta.add(new Auto("6", "Mazda", "2.2", "Diesel", "95 000", 2015, true, 23500,"",false,2l));
        allAuta.add(new Auto("Yaris", "Toyota", "1.3", "Benzyna", "76 621", 2012, true, 33500, "",false,2l));
        allAuta.add(new Auto("Q7", "Audi", "3.0", "Diesel", "31 7568", 2006, true, 44000, "",false,2l));
        allAuta.add(new Auto("Qashqai", "Nissan", "2.0", "Diesel", "207 000", 2011, true, 33200, "",false,2l));
        allAuta.add(new Auto("Ateca", "Seat", "1.4", "Benzyna", "48 000", 2016, true, 78900, "",false,2l));
        allAuta.add(new Auto("Corolla", "Toyota ", "1.6", "Benzyna", "1", 2020, false, 84000, "",false,2l));
        allAuta.add(new Auto("T-Roc", "Volkswagen", "1.5", "Benzyna", "5", 2020, false, 99300, "",false,2l));
        allAuta.add(new Auto("T-Cross", "Volkswagen", "1.0", "Benzyna", "5", 2020, false, 88400, "",false,2l));
        allAuta.add(new Auto("Pajero III", "Mitsubishi", "3.0", "Benzyna", "10 9000", 2003, true, 34900, "",false,2l));
        allAuta.add(new Auto("Superb", "Skoda", "2.0", "Diesel", "145 100", 2016, true, 99900, "",false,2l));
        allAuta.add(new Auto("GLC 200", "Mercedes-Benz", "2.0", "Diesel", "1", 2020, false, 205097, "",false,1l));
        allAuta.add(new Auto("S-Max", "Ford", "1.6", "Benzyna", "135 600", 2013, true, 49800, "",false,2l));
        allAuta.add(new Auto("Land Cruiser", "Toyota", "4.5", "Diesel", "292 000", 2008, true, 135300, "",false,2l));
        allAuta.add(new Auto("C4 Grand Picasso", "Citroen", "2.0", "Diesel", "240 000", 2008, true, 17900, "",false,2l));
        allAuta.add(new Auto("Mustang", "Ford", "5.0", "Benzyna", "70 000", 2013, true, 145000, "",false,1l));
        allAuta.add(new Auto("ASX", "Mitsubishi", "1.6", "Benzyna", "28 489", 2015, true, 51900, "",false,2l));
        allAuta.add(new Auto("A1", "Audi", "1.6", "Diesel", "150 000", 2011, true, 27200, "",false,2l));
        allAuta.add(new Auto("Ceed", "Kia", "1.6", "Diesel", "162 000", 2016, true, 39999, "",false,2l));
        allAuta.add(new Auto("S7", "Audi", "3.0", "Diesel", "5", 2020, false, 416600, "",false,1l));
        allAuta.add(new Auto("308 SW", "Peugeot", "1.5", "Diesel", "90 000", 2014, true, 34400, "",false,2l));

        for (Auto auto : allAuta) {
            String sql = "INSERT INTO auta VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, auto.getName(), auto.getMarka(), auto.getSilnik(), auto.getRodzajPaliwa(), auto.getPrzebieg(), auto.getRocznik(), auto.isCzyUzywany(), auto.getCena(), auto.getDodatkoweInformacje(), auto.getCzyObserwowany(), auto.getCategory());
        }
    }*/

    @Override
    public List<Auto> findAllAuta() {
        String sql = "SELECT * FROM auta";

        List<Auto> allAuta = jdbcTemplate.query(sql, (rs, rowNum) ->
                new Auto(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("marka"),
                        rs.getString("silnik"),
                        rs.getString("rodzajPaliwa"),
                        rs.getString("przebieg"),
                        rs.getInt("rocznik"),
                        rs.getBoolean("czyUzywany"),
                        rs.getInt("cena"),
                        rs.getString("dodatkoweInformacje"),
                        rs.getBoolean("czyObserwowany"),
                        rs.getLong("category"))
        );
        return allAuta;
    }

    @Override
    public Auto findAutoByName(String name) {
        String sql = "SELECT * FROM auta g WHERE g.NAME = '" + name + "' LIMIT 1";

        Auto auto = jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Auto(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("marka"),
                        rs.getString("silnik"),
                        rs.getString("rodzajPaliwa"),
                        rs.getString("przebieg"),
                        rs.getInt("rocznik"),
                        rs.getBoolean("czyUzywany"),
                        rs.getInt("cena"),
                        rs.getString("dodatkoweInformacje"),
                        rs.getBoolean("czyObserwowany"),
                        rs.getLong("category"))
        );
        return auto;
    }

    @Override
    public void updateAuto(Auto auto) {
        if (auto.getDodatkoweInformacje() != null) {
            String sql = "UPDATE auta a SET a.DODATKOWEINFORMACJE = '" + auto.getDodatkoweInformacje() + "' WHERE a.ID = ?";
            jdbcTemplate.update(sql, auto.getId());
        }
        if (auto.getCzyObserwowany() != null) {
            String sql = "UPDATE auta a SET a.CZYOBSERWOWANY = " + auto.getCzyObserwowany() + " WHERE a.ID = ?";
            jdbcTemplate.update(sql, auto.getId());
        }
    }
}
