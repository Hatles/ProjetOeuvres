package projetoeuvres.meserreurs;

public class MyException extends Exception  {
    private String message;
    private String type;

    public MyException() {
    }

    public MyException(String libelle, String type) {
        this.message = libelle;
        this.type = type;
    }

    public MyException(String libelle) {
        this.message = libelle;
       
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(java.lang.String libelle) {
        this.message = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
