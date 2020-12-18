package pl.projekt.model;

public class Comment {
    private Long id;
    private String userName;
    private String tekst;
    private Long autoId;

    public Comment(Long id, String userName, String tekst, Long autoId) {
        this.id = id;
        this.userName = userName;
        this.tekst = tekst;
        this.autoId = autoId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
    }
}
