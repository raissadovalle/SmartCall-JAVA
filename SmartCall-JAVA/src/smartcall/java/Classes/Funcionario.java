package smartcall.java.Classes;

public class Funcionario {

    private String cargo;
    private String usuario;
    private String senha;
    private String setor;
    
    public String getSenha() {return senha;}
    
    public String getCargo() {return cargo;}
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getSetor() { return setor;}
    public void setSetor(String setor) {this.setor = setor;}      
}
