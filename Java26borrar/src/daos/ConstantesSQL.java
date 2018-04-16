package daos;

public class ConstantesSQL {

	final static String sqlInsercionCliente = "insert into tabla_clientes"
			+ "(nombre, domicilio, poblacion, codigo_postal, telefono)"
			+ "value(?, ?, ?, ?, ?)";

	final static String sqlSeleccionClientes = "select * from tabla_clientes";

	

	public static String sqlBorradoCliente;

}
