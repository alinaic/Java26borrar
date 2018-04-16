package paneles;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import daos.ClientesDAOImpl;
import modelo.Cliente;

public class PanelRegistroCliente extends JPanel implements ActionListener {

	JTextField campoNombre = new JTextField(30);
	JTextField campoDomicilio = new JTextField(30);
	JTextField campoPoblacion = new JTextField(30);
	JTextField campoCodigoPostal = new JTextField(30);
	JTextField campoTelefono = new JTextField(30);

	public PanelRegistroCliente() {
		// asi asigno un gestor de diseño que me permite
		// colocar las cosas en forma de filas y celdas
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();

		// primer elemento:

		gbc.gridy = 0;
		gbc.gridx = 0;
		gbc.weightx = 2;
		this.add(new JLabel("Introduce los datos del clientes"), gbc);

		// voy a decir que cada elemento solo ocupe un elemento

		gbc.weightx = 1;

		// segunda fila
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(new JLabel("Nombre: "), gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(campoNombre, gbc);

		// tercera fila
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(new JLabel("Domicilio: "), gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(campoDomicilio, gbc);

		// cuarta fila
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(new JLabel("Población: "), gbc);
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(campoPoblacion, gbc);

		// quinta fila
		gbc.gridy = 4;
		gbc.gridx = 0;
		this.add(new JLabel("CodigoPostal: "), gbc);
		gbc.gridy = 4;
		gbc.gridx = 1;
		this.add(campoCodigoPostal, gbc);

		// sexta fila
		gbc.gridy = 5;
		gbc.gridx = 0;
		this.add(new JLabel("Telefono: "), gbc);
		gbc.gridy = 5;
		gbc.gridx = 1;
		this.add(campoTelefono, gbc);

		// septima fila:
		JButton botonRegistroCliente = new JButton("Registrar");
		botonRegistroCliente.addActionListener(this);
		gbc.gridy = 6;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(botonRegistroCliente, gbc);

	}// end PanelRegistroCliebtes()

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("actionPerformed del PanelRegistroCliente");
		String nombre = campoNombre.getText();
		String domicilio = campoDomicilio.getText();
		String poblacion = campoPoblacion.getText();
		String codigoPostal = campoCodigoPostal.getText();
		String telefono = campoTelefono.getText();

		// ahora habría que validar estos datos
		// ... TODO

		// una vez validados todos los datos registramos en base de datos:
		Cliente clienteAregistrar = new Cliente(nombre, domicilio, poblacion,
				codigoPostal, telefono);

		System.out.println("voy a registrar: " + clienteAregistrar.toString());
		// invoco a lo necesario de la capa de datos, para registrar el cliente
		// en base de datos
		
		ClientesDAOImpl clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(clienteAregistrar);
	}
}// end class
