package sv.edu.utec.parcial2etps1;

public class Personal {
    private String nombre;
    private String cargo;
    private String compania;
    private char genero;
    public Personal(String nombre, String cargo,String compania) {
        this.nombre=nombre;
        this.cargo=cargo;
        this.compania=compania;
    }
    public String getNombre() {
        return nombre;
    }
    public String getCargo() {
        return cargo;
    }
    public String getCompania() {
        return compania;
    }

}
