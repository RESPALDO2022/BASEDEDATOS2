package Formularios;

import Datos.vfactura;
import Datos.vhabitacion;
import Datos.vreserva;
import java.util.Calendar;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.fconsumo;
import logica.ffactura;
import logica.fhabitacion;
import logica.freserva;

public class fmfactura extends javax.swing.JInternalFrame {

    public fmfactura() {
        initComponents();
        mostrar(idreserva);
        inhabilitar();
        txtidreserva.setText(idreserva);
        txtcliente.setText(cliente);
        txthabitacion.setText(habitacion);
        txtidhabitacion.setText(idhabitacion);
        txttotalreserva.setText(Double.toString(totalreserva));

        fconsumo func = new fconsumo();
        func.mostrar(idreserva);

        txttotalpago.setText(Double.toString(totalreserva + func.totalconsumo));

    }

    private String accion = "guardar"; // determina si la accion es guardar o editar
    public static String idreserva;
    public static String cliente;
    public static String idhabitacion;
    public static String habitacion;
    public static Double totalreserva;

    void ocultar_columnas() { //Oculta las columnas que estan de mas en la tabla
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(1).setPreferredWidth(0);

    }

    void ocultar_columnasconsumo() { //Oculta las columnas que estan de mas en la tabla
        tablalistadoconsumo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistadoconsumo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistadoconsumo.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistadoconsumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void inhabilitar() { // Desabilita los botones para algunas operaciones
        txtidreserva.setEnabled(false);
        txtidfactura.setVisible(false);
        txtcliente.setVisible(false);
        txtnumerofactura.setEnabled(false);
        txttotalreserva.setEnabled(false);
        txttotalpago.setEnabled(false);
        dcfechapago.setEnabled(false);
        txtidhabitacion.setEnabled(false);
        txthabitacion.setEnabled(false);

        btnguardar.setEnabled(false);
        btncancelar.setEnabled(false);
        btneliminar.setEnabled(false);

        txtidfactura.setText("");
        txttotalpago.setText("");
        txtnumerofactura.setText("");

    }

    void habilitar() {// Habilita los botones para algunas operaciones
        txtidreserva.setVisible(true);
        txtidfactura.setVisible(false);
        txtcliente.setVisible(false);
        txtnumerofactura.setEnabled(true);
        txttotalreserva.setEnabled(false);
        txttotalpago.setEnabled(true);
        dcfechapago.setEnabled(true);
        txtidhabitacion.setVisible(true);
        txthabitacion.setEnabled(true);

        btnguardar.setEnabled(true);
        btncancelar.setEnabled(true);
        btneliminar.setEnabled(true);

        txtidfactura.setText("");
        //txttotalpago.setText("");
        txtnumerofactura.setText("");

    }

    void mostrar(String buscar) { // Realizar la busqueda
        try {
            DefaultTableModel modelo;
            ffactura func = new ffactura(); //llama a la clase ffactura
            modelo = func.mostrar(buscar);// Instancia la funcion mostrar de ffactura

            tablalistado.setModel(modelo);//Asigna a la tabla los valores guardados en modelo
            ocultar_columnas(); //llama al metodo ocultar
            lbltotalregistros.setText("Total facturas" + Integer.toString(func.totalregistros)); //Muestra en la etiqueta el total de facturas registrados

            //mostrar los datos de los consumos
            fconsumo func2 = new fconsumo();
            modelo = func2.mostrar(buscar);
            tablalistadoconsumo.setModel(modelo);
            ocultar_columnasconsumo();

            lbltotalregistrosconsumo.setText("Total consumos: " + func2.totalregistros);
            lbltotalconsumo.setText("Consumo total: Q. " + func2.totalconsumo);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtidfactura = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtidreserva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnnuevo = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        txtcliente = new javax.swing.JTextField();
        txttotalreserva = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtidhabitacion = new javax.swing.JTextField();
        txthabitacion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtnumerofactura = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txttotalpago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        dcfechapago = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbltotalregistros = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablalistadoconsumo = new javax.swing.JTable();
        lbltotalregistrosconsumo = new javax.swing.JLabel();
        lbltotalconsumo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximizable(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(249, 246, 232));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Reserva");

        txtidreserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidreservaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Total Reserva");

        btnnuevo.setBackground(new java.awt.Color(235, 191, 145));
        btnnuevo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnnuevo.setText("NUEVO");
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        btnguardar.setBackground(new java.awt.Color(235, 191, 145));
        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnguardar.setText("GUARDAR");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(235, 191, 145));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setText("CANCELAR");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        txtcliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtclienteActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("No. Habitacion");

        txtidhabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidhabitacionActionPerformed(evt);
            }
        });

        txthabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthabitacionActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Numero Factura");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Total Pago");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fecha Pago");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttotalpago, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnumerofactura, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(198, 198, 198))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(dcfechapago, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(95, 95, 95))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtidfactura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnguardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelar))
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(txtidfactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttotalreserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txthabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtidhabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnumerofactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txttotalpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnnuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dcfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 330, 360));

        jPanel3.setBackground(new java.awt.Color(249, 246, 232));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("RegistroFactura"));

        tablalistado.setBackground(new java.awt.Color(251, 232, 217));
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado);

        btneliminar.setBackground(new java.awt.Color(235, 191, 145));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setBackground(new java.awt.Color(235, 191, 145));
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbltotalregistros.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistros.setText("Registros");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btneliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnsalir)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalregistros)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsalir)
                    .addComponent(btneliminar))
                .addGap(18, 18, 18)
                .addComponent(lbltotalregistros)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 400, 220));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setText("Factura");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 190, 40));

        jPanel4.setBackground(new java.awt.Color(249, 246, 232));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado Consumo"));

        tablalistadoconsumo.setBackground(new java.awt.Color(251, 232, 217));
        tablalistadoconsumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistadoconsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoconsumoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablalistadoconsumo);

        lbltotalregistrosconsumo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalregistrosconsumo.setText("Registros");

        lbltotalconsumo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbltotalconsumo.setText("Total Consumo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltotalconsumo)
                .addGap(32, 32, 32)
                .addComponent(lbltotalregistrosconsumo)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltotalregistrosconsumo)
                    .addComponent(lbltotalconsumo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, 400, 180));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/factura.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 500));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidreservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidreservaActionPerformed
        txtidreserva.transferFocus();//Pasa automaticamente al siguiente campo
    }//GEN-LAST:event_txtidreservaActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed
        habilitar(); // habilita todas las cajas de texto
        btnguardar.setText("GUARDAR");
        accion = "guardar";
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

        if (txtnumerofactura.getText().length() == 0) { //Valida que caracteristicas contenga datos
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar un numero de factura");
            txtnumerofactura.requestFocus();
            return;
        }

        if (txttotalpago.getText().length() == 0) { //Valida que precio contenga datos
            JOptionPane.showConfirmDialog(rootPane, "Debe ingresar un total de pago de la factura");
            txttotalpago.requestFocus();
            return;
        }

        vfactura dts = new vfactura();//Crea un nuevo objeto de la clase vfactura
        ffactura func = new ffactura();//Llama a todas las funciones de ffactura

        //Se asigna los datos de las cajas de texto a las variables
        dts.setIdh_reserva(Integer.parseInt(txtidreserva.getText()));
        dts.setNumero(txtnumerofactura.getText());
        dts.setTotal(Double.parseDouble(txttotalpago.getText()));

        Calendar cal;
        int d, m, a;
        cal = dcfechapago.getCalendar();
        d = cal.get(Calendar.DAY_OF_MONTH);
        m = cal.get(Calendar.MONTH);
        a = cal.get(Calendar.YEAR) - 1990;

        dts.setFecha(new Date(a, m, d));

        if (accion.equals("guardar")) {//Condicion para verificar si se va a guardar o modificar
            if (func.insertar(dts)) {//Verifica que los datos se esten insertando correctamente
                JOptionPane.showMessageDialog(rootPane, "El pago por Q." + txttotalpago.getText()
                        + " del cliente " + txtcliente.getText() + "ha sido realizado con exito");
                mostrar(idreserva);//Muestra todos los registros
                inhabilitar();
                //Desocupar la habitación

                fhabitacion func2 = new fhabitacion();
                vhabitacion dts2 = new vhabitacion();

                dts2.setIdh_habitacion(Integer.parseInt(txtidhabitacion.getText()));
                func2.desocupar(dts2);

                //Cancelar o pagar la reserva
                freserva func3 = new freserva();
                vreserva dts3 = new vreserva();

                dts3.setIdh_reserva(Integer.parseInt(txtidreserva.getText()));
                func3.pagar(dts3);
            }

        } else if (accion.equals("editar")) {//Condicion para editar
            dts.setIdh_factura(Integer.parseInt(txtidfactura.getText()));//Convierte lo del getText a un Integer

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El pago del cliente. "
                        + txtcliente.getText() + "ha sido modificado correctamente");
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        btnguardar.setText("EDITAR");
        habilitar();
        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.rowAtPoint(evt.getPoint());//Almacena los registros donde se haya hecho click

        txtidfactura.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnumerofactura.setText(tablalistado.getValueAt(fila, 2).toString());
        txttotalpago.setText(tablalistado.getValueAt(fila, 3).toString());
        dcfechapago.setDate(Date.valueOf(tablalistado.getValueAt(fila, 4).toString()));
    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        if (!txtidfactura.getText().equals("")) {//Verifica que no este vacia la fcatura que se va a eliminar
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "¿Está seguro de eliminar la factura?", "Confirmar", 2);//Pregunta para confirmar la eliminacion

            if (confirmacion == 0) {//Procede a la eliminacion
                ffactura func = new ffactura();
                vfactura dts = new vfactura();

                dts.setIdh_factura(Integer.parseInt(txtidfactura.getText()));

                func.eliminar(dts);
                mostrar(idreserva);
                inhabilitar();
            }
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txtclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtclienteActionPerformed

    private void txtidhabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidhabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidhabitacionActionPerformed

    private void txthabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthabitacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthabitacionActionPerformed

    private void tablalistadoconsumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoconsumoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistadoconsumoMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fmfactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fmfactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fmfactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fmfactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fmfactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JButton btnsalir;
    private com.toedter.calendar.JDateChooser dcfechapago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbltotalconsumo;
    private javax.swing.JLabel lbltotalregistros;
    private javax.swing.JLabel lbltotalregistrosconsumo;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTable tablalistadoconsumo;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txthabitacion;
    private javax.swing.JTextField txtidfactura;
    private javax.swing.JTextField txtidhabitacion;
    private javax.swing.JTextField txtidreserva;
    private javax.swing.JTextField txtnumerofactura;
    private javax.swing.JTextField txttotalpago;
    private javax.swing.JTextField txttotalreserva;
    // End of variables declaration//GEN-END:variables
}
