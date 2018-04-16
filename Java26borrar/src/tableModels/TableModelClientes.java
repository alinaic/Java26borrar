package tableModels;

import javax.swing.table.AbstractTableModel;

import modelo.Cliente;

public class TableModelClientes extends AbstractTableModel {

	private String[] columnas = { "nombre", "direccion", "poblacion",
			"codigo_postal", "telefono" };
	private String[][] datos = null;

	public TableModelClientes(Cliente[] clientes) {
		// datos va a ser tantos array de string como clientes tenga que listar
		// cada uno de esos array debera tener tantos elementos como
		// queremos monstrar por cada columna
		datos = new String[clientes.length][columnas.length];
		for (int i = 0; i < clientes.length; i++) {
			Cliente c = clientes[i];
			datos[i][0] = c.getNombre();
			datos[i][1] = c.getDomicilio();
			datos[i][2] = c.getPoblacion();
			datos[i][3] = c.getCodigoPostal();
			datos[i][4] = c.getTelefono();
		}
	}// end TableModeloClientes

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		return datos.length;
	}

	@Override
	public Object getValueAt(int IndiceFila, int IndiceColumna) {
		return datos[IndiceFila][IndiceColumna];
	}

}// end class
