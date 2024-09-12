public class Proveedor {
    String nombreEmpresa;
    String razonSocial;
    int nit;
    String direccion;
    String zona;
    String departamento;
    String municipio; 
    int telefono;
    String correo;

    
    //Constructores
    public Proveedor(){};
    
    
    public Proveedor(String nombreEmpresa, String razonSocial, int nit, String direccion, String zona, String departamento, String municipio, int telefono, String correo) {
        this.nombreEmpresa = nombreEmpresa;
        this.razonSocial = razonSocial;
        this.nit = nit;
        this.direccion = direccion;
        this.zona = zona;
        this.departamento = departamento;
        this.municipio = municipio;
        this.telefono = telefono;
        this.correo = correo;
    }

    //Getters
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public int getNit() {
        return nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getZona() {
        return zona;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }


    //Setters
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
