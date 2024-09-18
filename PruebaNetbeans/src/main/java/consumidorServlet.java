/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/consumidorServlet")
public class consumidorServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Recibir los parámetros del formulario
        String nacionalidad = request.getParameter("nacionalidad");
        String tipoConsumidor = request.getParameter("contribuyente");
        String nitStr = request.getParameter("NIT");
        String dpiStr = request.getParameter("DPI");
        String nombre1 = request.getParameter("PrimerNombre");
        String nombre2 = request.getParameter("SegundoNombre");
        String apellido1 = request.getParameter("PrimerApellido");
        String apellido2 = request.getParameter("SegundoApellido");
        String apellidoCasada = request.getParameter("ApellidoCasada");
        String sexo = request.getParameter("sexo");
        String direccion = request.getParameter("direccion");
        String zona = request.getParameter("zona");
        String departamento = request.getParameter("departamento");
        String municipio = request.getParameter("municipio");
        String sede = request.getParameter("SedeD");
        String telDomStr = request.getParameter("TelefonoD");
        String telStr = request.getParameter("Celular");
        String telRefStr = request.getParameter("Telr");
        String correo = request.getParameter("email");
        String autorizacion = request.getParameter("comI");

        // Validar y convertir valores numéricos (evitar excepciones)
        int nit = 0, dpi = 0, telDom = 0, tel = 0, telRef = 0;
        try {
            nit = Integer.parseInt(nitStr);
            dpi = Integer.parseInt(dpiStr);
            telDom = Integer.parseInt(telDomStr);
            tel = Integer.parseInt(telStr);
            telRef = Integer.parseInt(telRefStr);
        } catch (NumberFormatException e) {
            // Manejo de error si hay un problema con los datos numéricos
            response.getWriter().println("Error: Datos numéricos inválidos.");
            return;  // Detener el procesamiento si los datos son inválidos
        }

        // Crear el objeto Consumidor con los datos del formulario
        Consumidor consumidor = new Consumidor(nacionalidad, tipoConsumidor, nit, dpi, nombre1, nombre2, apellido1, apellido2, apellidoCasada, direccion, zona, departamento, municipio, sede, telDom, tel, telRef, correo, autorizacion, sexo);

        // Definir la ruta del archivo CSV
        String archivoCSV = getServletContext().getRealPath("/") + "consumidores.csv";
        File file = new File(archivoCSV);

        // Guardar los datos en el archivo CSV
        try (FileWriter fileWriter = new FileWriter(archivoCSV, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            // Si el archivo es nuevo, escribir los encabezados
            if (file.length() == 0) {
                bufferedWriter.write("Nacionalidad,TipoConsumidor,NIT,DPI,PrimerNombre,SegundoNombre,PrimerApellido,SegundoApellido,ApellidoCasada,Direccion,Zona,Departamento,Municipio,SedeD,TelefonoD,Celular,TelRef,Correo,Autorizacion,Sexo");
                bufferedWriter.newLine();
            }

            // Escribir los datos en formato CSV
            bufferedWriter.write(nacionalidad + "," + tipoConsumidor + "," + nit + "," + dpi + "," + nombre1 + "," + nombre2 + "," + apellido1 + "," + apellido2 + "," + apellidoCasada + "," + direccion + "," + zona + "," + departamento + "," + municipio + "," + sede + "," + telDom + "," + tel + "," + telRef + "," + correo + "," + autorizacion + "," + sexo);
            bufferedWriter.newLine(); // Salto de línea para la siguiente fila
        } catch (IOException e) {
            e.printStackTrace();
            response.getWriter().println("Error al guardar los datos.");
            return;
        }

        // Respuesta de éxito
        response.getWriter().println("Datos guardados correctamente.");
    }

    
}