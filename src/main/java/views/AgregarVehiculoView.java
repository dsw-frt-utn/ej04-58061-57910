package views;

import data.Persistencia;
import domain.*;
import java.awt.*;
import javax.swing.*;

public class AgregarVehiculoView extends javax.swing.JFrame {

    public AgregarVehiculoView() {
        initComponents();
        configurarCamposTipo();
    }

    // Muestra/oculta campos según tipo seleccionado
    private void configurarCamposTipo() {
        boolean esCombustible = rbCombustible.isSelected();

        lblKwhBase.setVisible(!esCombustible);
        txtKwhBase.setVisible(!esCombustible);

        lblKmPorLitro.setVisible(esCombustible);
        txtKmPorLitro.setVisible(esCombustible);
        lblLitrosExtra.setVisible(esCombustible);
        txtLitrosExtra.setVisible(esCombustible);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        grupoTipo = new javax.swing.ButtonGroup();

        JLabel lblTitulo = new JLabel("Agregar Vehículo");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        // --- Tipo ---
        JLabel lblTipo = new JLabel("Tipo de vehículo:");
        rbElectrico = new JRadioButton("Eléctrico", true);
        rbCombustible = new JRadioButton("Combustible");
        grupoTipo.add(rbElectrico);
        grupoTipo.add(rbCombustible);

        rbElectrico.addActionListener(e -> configurarCamposTipo());
        rbCombustible.addActionListener(e -> configurarCamposTipo());

        // --- Campos comunes ---
        JLabel lblPatente = new JLabel("Patente:");
        txtPatente = new JTextField(15);

        JLabel lblMarca = new JLabel("Marca:");
        txtMarca = new JTextField(15);

        JLabel lblPais = new JLabel("País de origen:");
        txtPais = new JTextField(15);

        JLabel lblModelo = new JLabel("Modelo:");
        txtModelo = new JTextField(15);

        JLabel lblAnio = new JLabel("Año:");
        txtAnio = new JTextField(15);

        JLabel lblCapacidad = new JLabel("Capacidad de carga (kg):");
        txtCapacidad = new JTextField(15);

        JLabel lblSucursal = new JLabel("Sucursal:");
        cmbSucursal = new JComboBox<>();
        for (String cod : Persistencia.getCodigosSucursales()) {
            cmbSucursal.addItem(cod);
        }

        // --- Campos eléctrico ---
        lblKwhBase = new JLabel("kWh base (por 100 km):");
        txtKwhBase = new JTextField(15);

        // --- Campos combustible ---
        lblKmPorLitro = new JLabel("Km por litro:");
        txtKmPorLitro = new JTextField(15);
        lblLitrosExtra = new JLabel("Litros extra:");
        txtLitrosExtra = new JTextField(15);

        // --- Botones ---
        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        lblMensaje = new JLabel(" ");
        lblMensaje.setForeground(Color.RED);

        btnGuardar.addActionListener(e -> guardarVehiculo());
        btnCancelar.addActionListener(e -> dispose());

        // --- Layout ---
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int fila = 0;

        // Tipo
        gbc.gridx = 0; gbc.gridy = fila;
        panelCentral.add(lblTipo, gbc);
        JPanel panelTipo = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelTipo.add(rbElectrico);
        panelTipo.add(rbCombustible);
        gbc.gridx = 1; panelCentral.add(panelTipo, gbc);
        fila++;

        // Patente
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblPatente, gbc);
        gbc.gridx = 1; panelCentral.add(txtPatente, gbc); fila++;

        // Marca
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblMarca, gbc);
        gbc.gridx = 1; panelCentral.add(txtMarca, gbc); fila++;

        // País
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblPais, gbc);
        gbc.gridx = 1; panelCentral.add(txtPais, gbc); fila++;

        // Modelo
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblModelo, gbc);
        gbc.gridx = 1; panelCentral.add(txtModelo, gbc); fila++;

        // Año
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblAnio, gbc);
        gbc.gridx = 1; panelCentral.add(txtAnio, gbc); fila++;

        // Capacidad
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblCapacidad, gbc);
        gbc.gridx = 1; panelCentral.add(txtCapacidad, gbc); fila++;

        // Sucursal
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblSucursal, gbc);
        gbc.gridx = 1; panelCentral.add(cmbSucursal, gbc); fila++;

        // kWh Base (eléctrico)
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblKwhBase, gbc);
        gbc.gridx = 1; panelCentral.add(txtKwhBase, gbc); fila++;

        // Km/litro (combustible)
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblKmPorLitro, gbc);
        gbc.gridx = 1; panelCentral.add(txtKmPorLitro, gbc); fila++;

        // Litros extra (combustible)
        gbc.gridx = 0; gbc.gridy = fila; panelCentral.add(lblLitrosExtra, gbc);
        gbc.gridx = 1; panelCentral.add(txtLitrosExtra, gbc); fila++;

        // Mensaje de error
        gbc.gridx = 0; gbc.gridy = fila; gbc.gridwidth = 2;
        panelCentral.add(lblMensaje, gbc); fila++;

        // Botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        panelBotones.add(btnGuardar);
        panelBotones.add(btnCancelar);
        gbc.gridx = 0; gbc.gridy = fila; gbc.gridwidth = 2;
        panelCentral.add(panelBotones, gbc);

        // Panel título
        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setBackground(new Color(0, 153, 153));
        panelTitulo.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        lblTitulo.setForeground(Color.WHITE);
        panelTitulo.add(lblTitulo, BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(panelTitulo, BorderLayout.NORTH);
        add(new JScrollPane(panelCentral), BorderLayout.CENTER);

        setTitle("Logística - Agregar Vehículo");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(420, 520));
        pack();
        setLocationRelativeTo(null);
    }

    private void guardarVehiculo() {
        try {
            // Validaciones y lectura de campos comunes
            String patente = txtPatente.getText().trim();
            String marcaNombre = txtMarca.getText().trim();
            String pais = txtPais.getText().trim();
            String modelo = txtModelo.getText().trim();
            String anioStr = txtAnio.getText().trim();
            String capacidadStr = txtCapacidad.getText().trim();
            String codigoSucursal = (String) cmbSucursal.getSelectedItem();

            if (patente.isEmpty() || marcaNombre.isEmpty() || pais.isEmpty()
                    || modelo.isEmpty() || anioStr.isEmpty() || capacidadStr.isEmpty()) {
                lblMensaje.setText("Completá todos los campos obligatorios.");
                return;
            }

            int anio = Integer.parseInt(anioStr);
            double capacidad = Double.parseDouble(capacidadStr);
            Marca marca = new Marca(marcaNombre, pais);
            Sucursal sucursal = Persistencia.getSucursal(codigoSucursal);

            Vehiculo nuevo;

            if (rbElectrico.isSelected()) {
                String kwhStr = txtKwhBase.getText().trim();
                if (kwhStr.isEmpty()) {
                    lblMensaje.setText("Ingresá los kWh base.");
                    return;
                }
                double kwh = Double.parseDouble(kwhStr);
                nuevo = new VehiculoElectrico(patente, marca, modelo, anio, capacidad, sucursal, kwh);
            } else {
                String kmStr = txtKmPorLitro.getText().trim();
                String litStr = txtLitrosExtra.getText().trim();
                if (kmStr.isEmpty() || litStr.isEmpty()) {
                    lblMensaje.setText("Ingresá km/litro y litros extra.");
                    return;
                }
                double km = Double.parseDouble(kmStr);
                double lit = Double.parseDouble(litStr);
                nuevo = new VehiculoCombustible(patente, marca, modelo, anio, capacidad, sucursal, km, lit);
            }

            Persistencia.agregarVehiculo(nuevo);
            JOptionPane.showMessageDialog(this, "Vehículo agregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose();

        } catch (NumberFormatException e) {
            lblMensaje.setText("Verificá que los campos numéricos sean válidos.");
        }
    }

    // Variables declaration
    private javax.swing.ButtonGroup grupoTipo;
    private javax.swing.JRadioButton rbElectrico;
    private javax.swing.JRadioButton rbCombustible;
    private javax.swing.JTextField txtPatente;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtCapacidad;
    private javax.swing.JComboBox<String> cmbSucursal;
    private javax.swing.JLabel lblKwhBase;
    private javax.swing.JTextField txtKwhBase;
    private javax.swing.JLabel lblKmPorLitro;
    private javax.swing.JTextField txtKmPorLitro;
    private javax.swing.JLabel lblLitrosExtra;
    private javax.swing.JTextField txtLitrosExtra;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel lblMensaje;
}
