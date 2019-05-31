package smartcall.java.Classes;

public class PessoaJuridica extends Cliente{

    private String ie;
    private String representante;

    public String getIe() {return ie; }
    public void setIe(String ie) {
        this.ie = ie;
    }

    public String getRepresentante() {return representante;}
    public void setRepresentante(String representante) {
        this.representante = representante;
    } 
}
