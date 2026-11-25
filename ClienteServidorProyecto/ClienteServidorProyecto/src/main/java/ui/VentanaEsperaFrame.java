/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Jugador;
import model.Sala;

/**
 * Sala de espera: PIN de la sala y jugadores conectados (HU-01, HU-03).
 *
 * @author gabri
 */
public class VentanaEsperaFrame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaEsperaFrame.class.getName());

    private final VentanaInicio ventanaInicio;
    private final Sala sala;
    private final DefaultTableModel tableModel;

    /**
     * Creates new form VentanaEsperaFrame
     */
    public VentanaEsperaFrame(VentanaInicio ventanaInicio, Sala sala, int tiempoPorPregunta) {
        initComponents();
        this.ventanaInicio = ventanaInicio;
        this.sala = sala;

        String[] cols = {"Jugador", "Rol", "Estado"};
        tableModel = new DefaultTableModel(cols, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tblListaConectados.setModel(tableModel);
        estilizarTabla(tblListaConectados, scrJugadores, 52, 40);
        columna(tblListaConectados, 0, 184, java.awt.Color.WHITE, "Segoe UI", java.awt.Font.BOLD, 14);
        columna(tblListaConectados, 1, 130, new java.awt.Color(196, 181, 253), "Segoe UI", java.awt.Font.PLAIN, 13);
        // "Segoe UI Symbol" tiene el símbolo ✔ para "✔ Listo"
        columna(tblListaConectados, 2, 130, new java.awt.Color(233, 213, 255), "Segoe UI Symbol", java.awt.Font.BOLD, 12);
        efectoHover(btnCopiarPin, btnSalirSala, btnEstado, btnIniciarP);

        // Datos de la sala creada
        setTitle("Sala de espera - " + sala.getNombre());
        lblNombreSala.setText(sala.getNombre());
        lblDetalleSala.setText(sala.getCategoria() + " · " + sala.getCantidadPreguntas()
                + " preguntas · " + tiempoPorPregunta + " s");
        SetCodigo.setText(sala.getCodigo());
        barraProgreso.setMaximum(sala.getCapacidad());
        refrescarTabla();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void refrescarTabla() {
        tableModel.setRowCount(0);

        int posicion = 0;
        for (Jugador j : sala.getJugadores()) {
            String rol = "Jugador";
            if (posicion == 0) {
                rol = "Anfitrión";
            }
            String estado = "… Esperando";
            if (j.isListo()) {
                estado = "✔ Listo";
            }
            tableModel.addRow(new Object[]{j.getNombre(), rol, estado});
            posicion++;
        }

        lblConectados.setText(sala.getJugadores().size() + " / " + sala.getCapacidad());
        barraProgreso.setValue(sala.getJugadores().size());
    }

    /** Encabezado morado, filas altas y sin líneas verticales, como en el diseño. */
    private void estilizarTabla(javax.swing.JTable tabla, javax.swing.JScrollPane scroll, int altoFila, int altoEncabezado) {
        tabla.setRowHeight(altoFila);
        tabla.setIntercellSpacing(new java.awt.Dimension(0, 1));
        tabla.setSelectionForeground(java.awt.Color.WHITE);
        javax.swing.table.JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setReorderingAllowed(false);
        encabezado.setResizingAllowed(false);
        encabezado.setPreferredSize(new java.awt.Dimension(0, altoEncabezado));
        encabezado.setDefaultRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable t, Object v,
                    boolean sel, boolean foco, int fila, int col) {
                super.getTableCellRendererComponent(t, v, false, false, fila, col);
                setOpaque(true);
                setBackground(new java.awt.Color(63, 36, 102));
                setForeground(new java.awt.Color(233, 213, 255));
                setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 12));
                setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
                return this;
            }
        });
        scroll.getViewport().setBackground(tabla.getBackground());
    }

   
    private void columna(javax.swing.JTable tabla, int indice, int ancho, java.awt.Color color,
            String familia, int estilo, int tamano) {
        javax.swing.table.TableColumn col = tabla.getColumnModel().getColumn(indice);
        col.setPreferredWidth(ancho);
        java.awt.Font fuente = new java.awt.Font(familia, estilo, tamano);
        col.setCellRenderer(new javax.swing.table.DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(javax.swing.JTable t, Object v,
                    boolean sel, boolean foco, int fila, int c) {
                super.getTableCellRendererComponent(t, v, sel, false, fila, c);
                setFont(fuente);
                setForeground(sel ? java.awt.Color.WHITE : color);
                setBackground(sel ? t.getSelectionBackground() : t.getBackground());
                setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 16, 0, 16));
                return this;
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
        lblNombreSala = new javax.swing.JLabel();
        lblDetalleSala = new javax.swing.JLabel();
        pnlPin = new javax.swing.JPanel();
        lblPinTitulo = new javax.swing.JLabel();
        SetCodigo = new javax.swing.JLabel();
        lblPinAyuda = new javax.swing.JLabel();
        btnCopiarPin = new javax.swing.JButton();
        pnlProgreso = new javax.swing.JPanel();
        lblEsperando = new javax.swing.JLabel();
        lblConectados = new javax.swing.JLabel();
        barraProgreso = new javax.swing.JProgressBar();
        lblMinimo = new javax.swing.JLabel();
        pnlJugadores = new javax.swing.JPanel();
        lblJugadoresTitulo = new javax.swing.JLabel();
        scrJugadores = new javax.swing.JScrollPane();
        tblListaConectados = new javax.swing.JTable();
        sepInferior = new javax.swing.JPanel();
        btnSalirSala = new javax.swing.JButton();
        lblAviso = new javax.swing.JLabel();
        btnEstado = new javax.swing.JButton();
        btnIniciarP = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sala de espera");
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(26, 11, 46));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1024, 650));
        pnlFondo.setLayout(null);

        pnlEncabezado.setBackground(new java.awt.Color(42, 21, 70));
        pnlEncabezado.setLayout(null);

        lblNombreSala.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lblNombreSala.setForeground(new java.awt.Color(255, 255, 255));
        lblNombreSala.setText("Partida con amigos");
        pnlEncabezado.add(lblNombreSala);
        lblNombreSala.setBounds(32, 0, 520, 64);

        lblDetalleSala.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblDetalleSala.setForeground(new java.awt.Color(196, 181, 253));
        lblDetalleSala.setText("Cultura general · 10 preguntas · 20 s");
        lblDetalleSala.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlEncabezado.add(lblDetalleSala);
        lblDetalleSala.setBounds(552, 0, 440, 64);

        pnlFondo.add(pnlEncabezado);
        pnlEncabezado.setBounds(0, 0, 1024, 64);

        pnlPin.setBackground(new java.awt.Color(42, 21, 70));
        pnlPin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        pnlPin.setLayout(null);

        lblPinTitulo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblPinTitulo.setForeground(new java.awt.Color(167, 139, 250));
        lblPinTitulo.setText("PIN DE LA SALA");
        lblPinTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPin.add(lblPinTitulo);
        lblPinTitulo.setBounds(0, 46, 420, 18);

        SetCodigo.setFont(new java.awt.Font("Segoe UI", 1, 64)); // NOI18N
        SetCodigo.setForeground(new java.awt.Color(255, 255, 255));
        SetCodigo.setText("452 686");
        SetCodigo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPin.add(SetCodigo);
        SetCodigo.setBounds(0, 70, 420, 86);

        lblPinAyuda.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        lblPinAyuda.setForeground(new java.awt.Color(196, 181, 253));
        lblPinAyuda.setText("Comparte este PIN para que tus amigos se unan");
        lblPinAyuda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlPin.add(lblPinAyuda);
        lblPinAyuda.setBounds(0, 168, 420, 20);

        btnCopiarPin.setBackground(new java.awt.Color(42, 21, 70));
        btnCopiarPin.setForeground(new java.awt.Color(233, 213, 255));
        btnCopiarPin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 139, 250), 2));
        btnCopiarPin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCopiarPin.setText("Copiar PIN");
        btnCopiarPin.setContentAreaFilled(false);
        btnCopiarPin.setFocusPainted(false);
        btnCopiarPin.setOpaque(true);
        btnCopiarPin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCopiarPin.addActionListener(this::btnCopiarPinActionPerformed);
        pnlPin.add(btnCopiarPin);
        btnCopiarPin.setBounds(130, 216, 160, 40);

        pnlFondo.add(pnlPin);
        pnlPin.setBounds(32, 88, 420, 300);

        pnlProgreso.setBackground(new java.awt.Color(42, 21, 70));
        pnlProgreso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        pnlProgreso.setLayout(null);

        lblEsperando.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblEsperando.setForeground(new java.awt.Color(255, 255, 255));
        lblEsperando.setText("Esperando jugadores…");
        pnlProgreso.add(lblEsperando);
        lblEsperando.setBounds(24, 22, 260, 22);

        lblConectados.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lblConectados.setForeground(new java.awt.Color(196, 181, 253));
        lblConectados.setText("0 / 8");
        lblConectados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlProgreso.add(lblConectados);
        lblConectados.setBounds(296, 22, 100, 22);

        barraProgreso.setBackground(new java.awt.Color(63, 36, 102));
        barraProgreso.setForeground(new java.awt.Color(139, 92, 246));
        barraProgreso.setBorderPainted(false);
        barraProgreso.setMaximum(8);
        pnlProgreso.add(barraProgreso);
        barraProgreso.setBounds(24, 64, 372, 10);

        lblMinimo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblMinimo.setForeground(new java.awt.Color(161, 161, 170));
        lblMinimo.setText("Mínimo 2 jugadores para iniciar");
        pnlProgreso.add(lblMinimo);
        lblMinimo.setBounds(24, 86, 360, 18);

        pnlFondo.add(pnlProgreso);
        pnlProgreso.setBounds(32, 408, 420, 128);

        pnlJugadores.setBackground(new java.awt.Color(42, 21, 70));
        pnlJugadores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        pnlJugadores.setLayout(null);

        lblJugadoresTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblJugadoresTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblJugadoresTitulo.setText("Jugadores conectados");
        pnlJugadores.add(lblJugadoresTitulo);
        lblJugadoresTitulo.setBounds(24, 20, 400, 22);

        scrJugadores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        tblListaConectados.setBackground(new java.awt.Color(36, 18, 61));
        tblListaConectados.setForeground(new java.awt.Color(255, 255, 255));
        tblListaConectados.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        tblListaConectados.setGridColor(new java.awt.Color(63, 36, 102));
        tblListaConectados.setSelectionBackground(new java.awt.Color(76, 36, 140));
        tblListaConectados.setShowVerticalLines(false);
        tblListaConectados.setFillsViewportHeight(true);
        scrJugadores.setViewportView(tblListaConectados);
        pnlJugadores.add(scrJugadores);
        scrJugadores.setBounds(24, 60, 460, 364);

        pnlFondo.add(pnlJugadores);
        pnlJugadores.setBounds(484, 88, 508, 448);

        sepInferior.setBackground(new java.awt.Color(63, 36, 102));
        sepInferior.setLayout(null);

        pnlFondo.add(sepInferior);
        sepInferior.setBounds(0, 560, 1024, 1);

        btnSalirSala.setBackground(new java.awt.Color(220, 38, 38));
        btnSalirSala.setForeground(new java.awt.Color(255, 255, 255));
        btnSalirSala.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnSalirSala.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalirSala.setText("Salir de la sala");
        btnSalirSala.setContentAreaFilled(false);
        btnSalirSala.setFocusPainted(false);
        btnSalirSala.setOpaque(true);
        btnSalirSala.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalirSala.addActionListener(this::btnSalirSalaActionPerformed);
        pnlFondo.add(btnSalirSala);
        btnSalirSala.setBounds(32, 582, 180, 44);

        lblAviso.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblAviso.setForeground(new java.awt.Color(161, 161, 170));
        lblAviso.setText("Solo el anfitrión puede iniciar la partida");
        pnlFondo.add(lblAviso);
        lblAviso.setBounds(236, 582, 340, 44);

        btnEstado.setBackground(new java.awt.Color(26, 11, 46));
        btnEstado.setForeground(new java.awt.Color(233, 213, 255));
        btnEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 139, 250), 2));
        btnEstado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEstado.setText("Estoy listo");
        btnEstado.setContentAreaFilled(false);
        btnEstado.setFocusPainted(false);
        btnEstado.setOpaque(true);
        btnEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEstado.addActionListener(this::btnEstadoActionPerformed);
        pnlFondo.add(btnEstado);
        btnEstado.setBounds(586, 582, 180, 44);

        btnIniciarP.setBackground(new java.awt.Color(22, 163, 74));
        btnIniciarP.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarP.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnIniciarP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnIniciarP.setText("Iniciar partida");
        btnIniciarP.setContentAreaFilled(false);
        btnIniciarP.setFocusPainted(false);
        btnIniciarP.setOpaque(true);
        btnIniciarP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIniciarP.addActionListener(this::btnIniciarPActionPerformed);
        pnlFondo.add(btnIniciarP);
        btnIniciarP.setBounds(782, 582, 210, 44);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCopiarPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarPinActionPerformed
        // TODO back: copiar el PIN de la sala
    }//GEN-LAST:event_btnCopiarPinActionPerformed

    private void btnSalirSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirSalaActionPerformed
        int opt = JOptionPane.showConfirmDialog(
                this,
                "¿Desea salir de la sala?",
                "Salir",
                JOptionPane.YES_NO_OPTION
        );
        if (opt == JOptionPane.YES_OPTION) {
            ventanaInicio.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_btnSalirSalaActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        // TODO back: marcar al jugador como listo
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnIniciarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPActionPerformed
        // TODO back: iniciar la partida (solo el anfitrión)
    }//GEN-LAST:event_btnIniciarPActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SetCodigo;
    private javax.swing.JProgressBar barraProgreso;
    private javax.swing.JButton btnCopiarPin;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnIniciarP;
    private javax.swing.JButton btnSalirSala;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JLabel lblConectados;
    private javax.swing.JLabel lblDetalleSala;
    private javax.swing.JLabel lblEsperando;
    private javax.swing.JLabel lblJugadoresTitulo;
    private javax.swing.JLabel lblMinimo;
    private javax.swing.JLabel lblNombreSala;
    private javax.swing.JLabel lblPinAyuda;
    private javax.swing.JLabel lblPinTitulo;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlJugadores;
    private javax.swing.JPanel pnlPin;
    private javax.swing.JPanel pnlProgreso;
    private javax.swing.JScrollPane scrJugadores;
    private javax.swing.JPanel sepInferior;
    private javax.swing.JTable tblListaConectados;
    // End of variables declaration//GEN-END:variables
}
