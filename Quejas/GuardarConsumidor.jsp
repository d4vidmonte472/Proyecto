<%@ page import="java.io.*, org.apache.poi.xssf.usermodel.*, org.apache.poi.ss.usermodel.*" %>
<%@ page import = "model.Consumidor" %>



<%
String nacionalidad = formularioQueja.get("nacionalidad");
String tipoConsumidor = formularioQueja.get("contribuyente");
int nit = Integer.parseInt(formularioQueja.get("NIT"));
int dpi = Integer.parseInt(formularioQueja.get("dpi"));
String nombre1 = formularioQueja.get("PrimerNombre");
String nombre2 = formularioQueja.get("SegundoNombre");
String apellido1 = formularioQueja.get("PrimerApellido");
String apellido2 = formularioQueja.get("SegundoApellido");
String apellidoCasada = formularioQueja.get("ApellidoCasada");
String sexo = formularioQueja.get("sexo");
String direccion = formularioQueja.get("direccion");
String zona = formularioQueja.get("zona");
String departamento = formularioQueja.get("departamento");
String municipio = formularioQueja.get("municipio");
String sede = formularioQueja.get("SedeD");
int telDom = Integer.parseInt(formularioQueja.get("TelefonoD"));
int tel = Integer.parseInt(formularioQueja.get("Celular"));
int telRef = Integer.parseInt(formularioQueja.get("Telr"));
String correo = formularioQueja.get("email");
String autorizacion = formularioQueja.get("comI");

Consumidor consumidor = new Consumidor(nacionalidad, tipoConsumidor, nit, dpi, nombre1, nombre2, apellido1, apellido2, apellidoCasada, direccion, zona, departamento, municipio, sede, telDom, tel, telRef, correo, autorizacion, sexo);




%>