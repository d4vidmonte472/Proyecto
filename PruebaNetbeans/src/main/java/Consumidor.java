/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author david
 */
public class Consumidor {
    
        String nacionalidad;
        String tipoConsumidor;
        int nit;
        int dpi;
        String nombre1;
        String nombre2;
        String apellido1;
        String apellido2;
        String apellidoCasada;
        String direccion;
        String zona;
        String departamento;
        String municipio;
        String sedeDiaco;
        int telDom;
        int tel;
        int telRef;
        String correo;
        String autorizacion;
        String sexo;
        
        //Constructores
public Consumidor(){};

public Consumidor(String nacionalidad, String tipoConsumidor, int nit, int dpi, String nombre1, String nombre2, String apellido1, String apellido2, String apellidoCasada, String direccion, String zona, String departamento, String municipio, String sedeDiaco, int telDom, int tel, int telRef, String correo, String autorizacion, String sexo) {
    this.nacionalidad = nacionalidad;
    this.tipoConsumidor = tipoConsumidor;
    this.nit = nit;
    this.dpi = dpi;
    this.nombre1 = nombre1;
    this.nombre2 = nombre2;
    this.apellido1 = apellido1;
    this.apellido2 = apellido2;
    this.apellidoCasada = apellidoCasada;
    this.direccion = direccion;
    this.zona = zona;
    this.departamento = departamento;
    this.municipio = municipio;
    this.sedeDiaco = sedeDiaco;
    this.telDom = telDom;
    this.tel = tel;
    this.telRef = telRef;
    this.correo = correo;
    this.autorizacion = autorizacion;
    this.sexo = sexo;
}
//Getters
public String getNacionalidad() {
    return nacionalidad;
}

public String getTipoConsumidor() {
    return tipoConsumidor;
}

public int getNit() {
    return nit;
}

public int getDpi() {
    return dpi;
}

public String getNombre1() {
    return nombre1;
}

public String getNombre2(){
    return nombre2;
}

public String getApellido1() {
    return apellido1;
}

public String getApellido2(){
    return apellido2;
}

public String getApellidoCasada() {
    return apellidoCasada;
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

public String getSedeDiaco() {
    return sedeDiaco;
}

public int getTelDom() {
    return telDom;
}

public int getTel() {
    return tel;
}

public int getTelRef() {
    return telRef;
}

public String getCorreo() {
    return correo;
}

public String getAutorizacion() {
    return autorizacion;
}

public String getSexo(){
    return sexo;
}

//Setters
public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
}

public void setTipoConsumidor(String tipoConsumidor) {
    this.tipoConsumidor = tipoConsumidor;
}

public void setNit(int nit) {
    this.nit = nit;
}

public void setDpi(int dpi) {
    this.dpi = dpi;
}

public void setNombre1(String nombre1) {
    this.nombre1 = nombre1;
}

public void setNombre2(String nombre2){
    this.nombre2 = nombre2;
}

public void setApellido1(String apellido1) {
    this.apellido1 = apellido1;
}

public void setApellido2(String apellido2){
    this.apellido2 = apellido1;
}

public void setApellidoCasada(String apellidoCasada) {
    this.apellidoCasada = apellidoCasada;
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

public void setSedeDiaco(String sedeDiaco) {
    this.sedeDiaco = sedeDiaco;
}

public void setTelDom(int telDom) {
    this.telDom = telDom;
}

public void setTel(int tel) {
    this.tel = tel;
}

public void setTelRef(int telRef) {
    this.telRef = telRef;
}

public void setCorreo(String correo) {
    this.correo = correo;
}

public void setAutorizacion(String autorizacion) {
    this.autorizacion = autorizacion;
}

public void setSexo(String sexo){
    this.sexo = sexo;
}
}
