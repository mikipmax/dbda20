
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
	public static final String SAMPLE_XLSX_FILE_PATH = "C:\\test\\resultados_foxpro.xls";
	// public static final String SAMPLE_XLSX_FILE_PATH =
	// "C:\\test\\resultados_foxpro_mod.xlsx";
	static int contador = 0;
	static List<Cliente> lista = new ArrayList<>();
	static Cliente c;
	static List<String> listaAux = new ArrayList<>();

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

		// Getting the Sheet at index zero
		Sheet sheet = workbook.getSheetAt(0);

		// Create a DataFormatter to format and get each cell's value as String
		DataFormatter dataFormatter = new DataFormatter();
		dataFormatter.addFormat("m/d/yy", new java.text.SimpleDateFormat("dd/MM/yyyy"));

		sheet.forEach(row -> {

			if (contador > 0) {
				row.forEach(cell -> {

					String cellValue = dataFormatter.formatCellValue(cell);

					listaAux.add(cellValue);

				});

				c = new Cliente();
				c.setCodigo(listaAux.get(0));
				c.setNombres(listaAux.get(1));
				c.setSexo(listaAux.get(2).equals(1));
				c.setFechanac(convertirString2Fecha(listaAux.get(3)));
				c.setFechaing(convertirString2Fecha(listaAux.get(4)));
				c.setFechadesah(convertirString2Fecha(listaAux.get(5)));
				c.setSueldomen(Double.valueOf(listaAux.get(6).replace(',', '.')));
				lista.add(c);

			}
			contador++;
			listaAux = new ArrayList<>();

		});

		// Closing the workbook
		workbook.close();

		lista.forEach(ss -> {
			System.out.println(ss);
		});

	}

	public static Date convertirString2Fecha(String s) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		try {
			date = formatter.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// NO OLVIDAR QUE PARA IMPRIMIR EN CONSOLA SE USA .FORMAT PARA VER CON EL
		// FORMATO
		// System.out.println(formatter.format(date));
		return date;
	}

	public static LocalDate convertirString2LocalDate(String s) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(s, formatter);
		return localDate;
	}

}
