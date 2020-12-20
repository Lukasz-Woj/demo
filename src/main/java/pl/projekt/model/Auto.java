package pl.projekt.model;

public class Auto {
    private Long id;
    private String name;
    private String marka;
    private String silnik;
    private String rodzajPaliwa;
    private String przebieg;
    private Integer rocznik;
    private Boolean czyUzywany;
    private Integer cena;
    private String dodatkoweInformacje;
    private Boolean czyObserwowany;
    private Long category;



    public Auto(Long id, String name, String marka, String silnik, String rodzajPaliwa, String przebieg, Integer rocznik, Boolean czyUzywany, Integer cena, String dodatkoweInformacje, Boolean czyObserwowany, Long category) {
        this.id = id;
        this.name = name;
        this.marka = marka;
        this.silnik = silnik;
        this.rodzajPaliwa = rodzajPaliwa;
        this.przebieg = przebieg;
        this.rocznik = rocznik;
        this.czyUzywany = czyUzywany;
        this.cena = cena;
        this.dodatkoweInformacje = dodatkoweInformacje;
        this.czyObserwowany = czyObserwowany;
        this.category = category;
    }

    public String getUrl(){return "/auta/" + name + ".jpg";}

    public String getDetailsUrl(){
        return "/auto/" + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getSilnik() {
        return silnik;
    }

    public void setSilnik(String silnik) {
        this.silnik = silnik;
    }

    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    public void setRodzajPaliwa(String rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public String getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(String przebieg) {
        this.przebieg = przebieg;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public String isCzyUzywany() {
        if(czyUzywany==true){
            return "Używany";
        }
        else{
            return "Nowy";
        }
    }

    public void setCzyUzywany(boolean czyUzywany) {
        this.czyUzywany = czyUzywany;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getDodatkoweInformacje() {
        return dodatkoweInformacje;
    }

    public void setDodatkoweInformacje(String dodatkoweInformacje) {
        this.dodatkoweInformacje = dodatkoweInformacje;
    }

    public Boolean getCzyObserwowany() {
        return czyObserwowany;
    }

    public void setCzyObserwowany(Boolean czyObserwowany) {
        this.czyObserwowany = czyObserwowany;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}


