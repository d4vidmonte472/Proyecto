<%@ page import="java.io.*, org.apache.poi.xssf.usermodel.*, org.apache.poi.ss.usermodel.*" %>
<%@ page import="com.example.model.Consumidor" %>

<%
    String nacionalidad = request.getParameter("nacionalidad");
    String tipoConsumidor = request.getParameter("contribuyente");
    int nit = Integer.parseInt(request.getParameter("NIT"));
    int dpi = Integer.parseInt(request.getParameter("dpi"));
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
    int telDom = Integer.parseInt(request.getParameter("TelefonoD"));
    int tel = Integer.parseInt(request.getParameter("Celular"));
    int telRef = Integer.parseInt(request.getParameter("Telr"));
    String correo = request.getParameter("email");
    String autorizacion = request.getParameter("comI");

    Consumidor consumidor = new Consumidor(nacionalidad, tipoConsumidor, nit, dpi, nombre1, nombre2, apellido1, apellido2, apellidoCasada, direccion, zona, departamento, municipio, sede, telDom, tel, telRef, correo, autorizacion, sexo);

    String rutaArchivo = application.getRealPath("/") + "consumidores.xlsx";
    File archivoExcel = new File(rutaArchivo);
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    if (archivoExcel.exists()) {
        FileInputStream file = new FileInputStream(archivoExcel);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheetAt(0); // Usa la primera hoja
    } else {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Consumidores");
        // Crear encabezados si es necesario
        XSSFRow headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Nacionalidad");
        headerRow.createCell(1).setCellValue("Tipo Consumidor");
        headerRow.createCell(2).setCellValue("NIT");
        headerRow.createCell(3).setCellValue("DPI");
        headerRow.createCell(4).setCellValue("Primer Nombre");
        headerRow.createCell(5).setCellValue("Segundo Nombre");
        headerRow.createCell(6).setCellValue("Primer Apellido");
        headerRow.createCell(7).setCellValue("Segundo Apellido");
        headerRow.createCell(8).setCellValue("Apellido Casada");
        headerRow.createCell(9).setCellValue("Direccion");
        headerRow.createCell(10).setCellValue("Zona");
        headerRow.createCell(11).setCellValue("Departamento");
        headerRow.createCell(12).setCellValue("Municipio");
        headerRow.createCell(13).setCellValue("Sede DIACO cercana");
        headerRow.createCell(14).setCellValue("Telefono Domicilio");
        headerRow.createCell(15).setCellValue("Telefono");
        headerRow.createCell(16).setCellValue("Telefono de Referencia");
        headerRow.createCell(17).setCellValue("Correo");
        headerRow.createCell(18).setCellValue("Autorizado");
        headerRow.createCell(19).setCellValue("Sexo");
    }

    int fila = sheet.getLastRowNum() + 1;
    XSSFRow row = sheet.createRow(fila);
    row.createCell(0).setCellValue(consumidor.getNacionalidad());
    row.createCell(1).setCellValue(consumidor.getTipoConsumidor());
    row.createCell(2).setCellValue(consumidor.getNit());
    row.createCell(3).setCellValue(consumidor.getDpi());
    row.createCell(4).setCellValue(consumidor.getNombre1());
    row.createCell(5).setCellValue(consumidor.getNombre2());
    row.createCell(6).setCellValue(consumidor.getApellido1());
    row.createCell(7).setCellValue(consumidor.getApellido2());
    row.createCell(8).setCellValue(consumidor.getApellidoCasada());
    row.createCell(9).setCellValue(consumidor.getDireccion());
    row.createCell(10).setCellValue(consumidor.getZona());
    row.createCell(11).setCellValue(consumidor.getDepartamento());
    row.createCell(12).setCellValue(consumidor.getMunicipio());
    row.createCell(13).setCellValue(consumidor.getSedeDiaco());
    row.createCell(14).setCellValue(consumidor.getTelDom());
    row.createCell(15).setCellValue(consumidor.getTel());
    row.createCell(16).setCellValue(consumidor.getTelRef());
    row.createCell(17).setCellValue(consumidor.getCorreo());
    row.createCell(18).setCellValue(consumidor.getAutorizacion());
    row.createCell(19).setCellValue(consumidor.getSexo());

    FileOutputStream outputStream = new FileOutputStream(archivoExcel);
    workbook.write(outputStream);
    outputStream.close();
    workbook.close();
%>
