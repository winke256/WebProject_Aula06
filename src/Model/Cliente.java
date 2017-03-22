package Model;

public class Cliente {

    private int id;

    private String name;

    private String fone;

    private String mail;

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getFone() {
        return this.fone;
    }

    public String getMail() {
        return this.mail;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
