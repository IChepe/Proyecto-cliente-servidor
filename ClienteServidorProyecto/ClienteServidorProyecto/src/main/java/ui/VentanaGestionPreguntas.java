/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 * Banco de preguntas: categorías y preguntas (HU-04).
 * Solo interfaz: la lógica de cada botón la conecta el equipo de back.
 *
 * @author Los chambeadores
 */
public class VentanaGestionPreguntas extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaGestionPreguntas.class.getName());

    /**
     * Creates new form VentanaGestionPreguntas
     */
    public VentanaGestionPreguntas() {
        initComponents();

        lstCategorias.setModel(new javax.swing.DefaultListModel<>());
        lstCategorias.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList<?> list, Object value,
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, false);
                setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 12, 0, 12));
                return this;
            }
        });

        tblPreguntas.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"#", "Pregunta", "Respuesta correcta"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });
        estilizarTabla();
        columna(0, 40, new java.awt.Color(196, 181, 253));
        columna(1, 416, java.awt.Color.WHITE);
        columna(2, 200, new java.awt.Color(233, 213, 255));

        ponerPlaceholder(txtCategoria, "Nombre de la categoría");
        ponerPlaceholder(txtBuscar, "Buscar pregunta…");
        efectoHover(btnVolver, btnAgregarCategoria, btnEliminarCategoria, btnNuevaPregunta, btnEditar, btnEliminar);
        setLocationRelativeTo(null);
    }

    /** Encabezado morado, filas altas y sin líneas verticales, como en el diseño. */
    private void estilizarTabla() {
        tblPreguntas.setRowHeight(40);
        tblPreguntas.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tblPreguntas.setSelectionForeground(java.awt.Color.WHITE);
        tblPreguntas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        javax.swing.table.JTableHeader encabezado = tblPreguntas.getTableHeader();
        encabezado.setReorderingAllowed(false);
        encabezado.setPreferredSize(new java.awt.Dimension(0, 36));
        encabezado.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable t, Object v,
                    boolean sel, boolean foco, int fila, int col) {
                super.getTableCellRendererComponent(t, v, false, false, fila, col);
                setOpaque(true);
                setBackground(new java.awt.Color(63, 36, 102));
                setForeground(new java.awt.Color(233, 213, 255));
                setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
                setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 14, 0, 14));
                return this;
            }
        });
        scrPreguntas.getViewport().setBackground(tblPreguntas.getBackground());
    }

    /** Ancho y color de una columna. */
    private void columna(int indice, int ancho, java.awt.Color color) {
        javax.swing.table.TableColumn col = tblPreguntas.getColumnModel().getColumn(indice);
        col.setPreferredWidth(ancho);
        java.awt.Font fuente = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13);
        col.setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable t, Object v,
                    boolean sel, boolean foco, int fila, int c) {
                super.getTableCellRendererComponent(t, v, sel, false, fila, c);
                setFont(fuente);
                setForeground(sel ? java.awt.Color.WHITE : color);
                setBackground(sel ? t.getSelectionBackground() : t.getBackground());
                setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 14, 0, 14));
                return this;
            }
        });
    }

    /** Texto gris de ayuda que se muestra mientras el campo está vacío. */
    private void ponerPlaceholder(javax.swing.JTextField campo, String texto) {
        javax.swing.JLabel ayuda = new javax.swing.JLabel(texto);
        ayuda.setFont(campo.getFont());
        ayuda.setForeground(new java.awt.Color(113, 113, 122));
        campo.setLayout(new java.awt.BorderLayout());
        campo.add(ayuda);
        campo.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                ayuda.setVisible(campo.getText().isEmpty());
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                ayuda.setVisible(campo.getText().isEmpty());
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                ayuda.setVisible(campo.getText().isEmpty());
            }
        });
    }

    /** Aclara un poco el botón al pasar el mouse. */
    private void efectoHover(javax.swing.AbstractButton... botones) {
        for (javax.swing.AbstractButton boton : botones) {
            boton.addMouseListener(new java.awt.event.MouseAdapter() {
                private java.awt.Color base;

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    if (boton.isEnabled()) {
                        base = boton.getBackground();
                        boton.setBackground(new java.awt.Color(
                                base.getRed() + (255 - base.getRed()) * 15 / 100,
                                base.getGreen() + (255 - base.getGreen()) * 15 / 100,
                                base.getBlue() + (255 - base.getBlue()) * 15 / 100));
                    }
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    if (base != null) {
                        boton.setBackground(base);
                        base = null;
                    }
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        pnlEncabezado = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        pnlCategorias = new javax.swing.JPanel();
        lblCategorias = new javax.swing.JLabel();
        scrCategorias = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        lblNuevaCategoria = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        btnAgregarCategoria = new javax.swing.JButton();
        btnEliminarCategoria = new javax.swing.JButton();
        pnlPreguntas = new javax.swing.JPanel();
        lblTituloPreguntas = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        scrPreguntas = new javax.swing.JScrollPane();
        tblPreguntas = new javax.swing.JTable();
        btnNuevaPregunta = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Banco de preguntas");
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(26, 11, 46));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1024, 650));
        pnlFondo.setLayout(null);

        pnlEncabezado.setBackground(new java.awt.Color(42, 21, 70));
        pnlEncabezado.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("Banco de preguntas");
        pnlEncabezado.add(lblTitulo);
        lblTitulo.setBounds(24, 0, 400, 64);

        btnVolver.setBackground(new java.awt.Color(42, 21, 70));
        btnVolver.setForeground(new java.awt.Color(233, 213, 255));
        btnVolver.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 139, 250), 2));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVolver.setText("← Volver");
        btnVolver.setContentAreaFilled(false);
        btnVolver.setFocusPainted(false);
        btnVolver.setOpaque(true);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(this::btnVolverActionPerformed);
        pnlEncabezado.add(btnVolver);
        btnVolver.setBounds(880, 12, 120, 40);

        pnlFondo.add(pnlEncabezado);
        pnlEncabezado.setBounds(0, 0, 1024, 64);

        pnlCategorias.setBackground(new java.awt.Color(42, 21, 70));
        pnlCategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        pnlCategorias.setLayout(null);

        lblCategorias.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblCategorias.setForeground(new java.awt.Color(255, 255, 255));
        lblCategorias.setText("Categorías");
        pnlCategorias.add(lblCategorias);
        lblCategorias.setBounds(20, 16, 220, 22);

        scrCategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        lstCategorias.setBackground(new java.awt.Color(36, 18, 61));
        lstCategorias.setForeground(new java.awt.Color(233, 213, 255));
        lstCategorias.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lstCategorias.setSelectionBackground(new java.awt.Color(124, 58, 237));
        lstCategorias.setSelectionForeground(new java.awt.Color(255, 255, 255));
        lstCategorias.setFixedCellHeight(36);
        lstCategorias.setSelectionMode(0);
        scrCategorias.setViewportView(lstCategorias);
        pnlCategorias.add(scrCategorias);
        scrCategorias.setBounds(20, 52, 220, 300);

        lblNuevaCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNuevaCategoria.setForeground(new java.awt.Color(233, 213, 255));
        lblNuevaCategoria.setText("Nueva categoría");
        pnlCategorias.add(lblNuevaCategoria);
        lblNuevaCategoria.setBounds(20, 370, 220, 18);

        txtCategoria.setBackground(new java.awt.Color(255, 255, 255));
        txtCategoria.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtCategoria.setForeground(new java.awt.Color(24, 24, 27));
        txtCategoria.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(212, 212, 216), 1), javax.swing.BorderFactory.createEmptyBorder(0, 11, 0, 11)));
        pnlCategorias.add(txtCategoria);
        txtCategoria.setBounds(20, 392, 220, 38);

        btnAgregarCategoria.setBackground(new java.awt.Color(124, 58, 237));
        btnAgregarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCategoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnAgregarCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarCategoria.setText("Agregar categoría");
        btnAgregarCategoria.setContentAreaFilled(false);
        btnAgregarCategoria.setFocusPainted(false);
        btnAgregarCategoria.setOpaque(true);
        btnAgregarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregarCategoria.addActionListener(this::btnAgregarCategoriaActionPerformed);
        pnlCategorias.add(btnAgregarCategoria);
        btnAgregarCategoria.setBounds(20, 442, 220, 40);

        btnEliminarCategoria.setBackground(new java.awt.Color(220, 38, 38));
        btnEliminarCategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarCategoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnEliminarCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminarCategoria.setText("Eliminar categoría");
        btnEliminarCategoria.setContentAreaFilled(false);
        btnEliminarCategoria.setFocusPainted(false);
        btnEliminarCategoria.setOpaque(true);
        btnEliminarCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminarCategoria.addActionListener(this::btnEliminarCategoriaActionPerformed);
        pnlCategorias.add(btnEliminarCategoria);
        btnEliminarCategoria.setBounds(20, 492, 220, 36);

        pnlFondo.add(pnlCategorias);
        pnlCategorias.setBounds(24, 84, 260, 546);

        pnlPreguntas.setBackground(new java.awt.Color(42, 21, 70));
        pnlPreguntas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        pnlPreguntas.setLayout(null);

        lblTituloPreguntas.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblTituloPreguntas.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloPreguntas.setText("Preguntas");
        pnlPreguntas.add(lblTituloPreguntas);
        lblTituloPreguntas.setBounds(20, 20, 390, 22);

        txtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtBuscar.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(24, 24, 27));
        txtBuscar.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(212, 212, 216), 1), javax.swing.BorderFactory.createEmptyBorder(0, 11, 0, 11)));
        pnlPreguntas.add(txtBuscar);
        txtBuscar.setBounds(416, 14, 260, 36);

        scrPreguntas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        tblPreguntas.setBackground(new java.awt.Color(36, 18, 61));
        tblPreguntas.setForeground(new java.awt.Color(255, 255, 255));
        tblPreguntas.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblPreguntas.setGridColor(new java.awt.Color(63, 36, 102));
        tblPreguntas.setSelectionBackground(new java.awt.Color(76, 36, 140));
        tblPreguntas.setShowVerticalLines(false);
        tblPreguntas.setFillsViewportHeight(true);
        scrPreguntas.setViewportView(tblPreguntas);
        pnlPreguntas.add(scrPreguntas);
        scrPreguntas.setBounds(20, 64, 656, 400);

        btnNuevaPregunta.setBackground(new java.awt.Color(124, 58, 237));
        btnNuevaPregunta.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaPregunta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnNuevaPregunta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNuevaPregunta.setText("+ Nueva pregunta");
        btnNuevaPregunta.setContentAreaFilled(false);
        btnNuevaPregunta.setFocusPainted(false);
        btnNuevaPregunta.setOpaque(true);
        btnNuevaPregunta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevaPregunta.addActionListener(this::btnNuevaPreguntaActionPerformed);
        pnlPreguntas.add(btnNuevaPregunta);
        btnNuevaPregunta.setBounds(20, 484, 180, 44);

        btnEditar.setBackground(new java.awt.Color(42, 21, 70));
        btnEditar.setForeground(new java.awt.Color(233, 213, 255));
        btnEditar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 139, 250), 2));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setContentAreaFilled(false);
        btnEditar.setFocusPainted(false);
        btnEditar.setOpaque(true);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(this::btnEditarActionPerformed);
        pnlPreguntas.add(btnEditar);
        btnEditar.setBounds(212, 484, 130, 44);

        btnEliminar.setBackground(new java.awt.Color(220, 38, 38));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setOpaque(true);
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addActionListener(this::btnEliminarActionPerformed);
        pnlPreguntas.add(btnEliminar);
        btnEliminar.setBounds(354, 484, 130, 44);

        pnlFondo.add(pnlPreguntas);
        pnlPreguntas.setBounds(304, 84, 696, 546);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO back: volver a VentanaInicio
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCategoriaActionPerformed
        // TODO back: agregar la categoría escrita en txtCategoria
    }//GEN-LAST:event_btnAgregarCategoriaActionPerformed

    private void btnEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCategoriaActionPerformed
        // TODO back: eliminar la categoría seleccionada en lstCategorias
    }//GEN-LAST:event_btnEliminarCategoriaActionPerformed

    private void btnNuevaPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPreguntaActionPerformed
        // TODO back: abrir DialogPregunta para crear una pregunta
    }//GEN-LAST:event_btnNuevaPreguntaActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO back: abrir DialogPregunta con la pregunta seleccionada
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO back: eliminar la pregunta seleccionada en tblPreguntas
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCategoria;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarCategoria;
    private javax.swing.JButton btnNuevaPregunta;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel lblCategorias;
    private javax.swing.JLabel lblNuevaCategoria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloPreguntas;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JPanel pnlCategorias;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlPreguntas;
    private javax.swing.JScrollPane scrCategorias;
    private javax.swing.JScrollPane scrPreguntas;
    private javax.swing.JTable tblPreguntas;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}
