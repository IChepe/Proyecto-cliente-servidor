/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;

/**
 * Pregunta actual, opciones de respuesta y marcador (HU-05, HU-06, HU-07).
 * Solo interfaz: la lógica de cada botón la conecta el equipo de back.
 *
 * @author Los chambeadores
 */
public class VentanaJuego extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaJuego.class.getName());

    /** Solo se puede marcar una opción a la vez. */
    private final ButtonGroup grpOpciones = new ButtonGroup();
    private final JToggleButton[] opciones;

    /**
     * Creates new form VentanaJuego
     */
    public VentanaJuego() {
        initComponents();
        opciones = new JToggleButton[]{btnOpcionA, btnOpcionB, btnOpcionC, btnOpcionD};
        for (JToggleButton op : opciones) {
            grpOpciones.add(op);
            op.addItemListener(e -> marcarSeleccion());
        }
        efectoHover(btnConfirmar);
        setLocationRelativeTo(null);
    }

    /** La opción elegida se marca con borde blanco y un ✔, como en el diseño. */
    private void marcarSeleccion() {
        for (JToggleButton op : opciones) {
            String texto = op.getText().replace("   ✔", "");
            if (op.isSelected()) {
                op.setText(texto + "   ✔");
                op.setBorder(javax.swing.BorderFactory.createCompoundBorder(
                        javax.swing.BorderFactory.createLineBorder(java.awt.Color.WHITE, 4),
                        javax.swing.BorderFactory.createEmptyBorder(0, 20, 0, 10)));
            } else {
                op.setText(texto);
                op.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 24, 4, 14));
            }
        }
    }

    /**
     * Agrega una fila al marcador "Puntuaciones" (dentro de pnlListaPuntos).
     * El back la llama por cada jugador, en orden; antes de redibujar se puede
     * limpiar con pnlListaPuntos.removeAll().
     */
    public void agregarFilaPuntaje(int posicion, String nombre, int puntos, boolean esPropia) {
        javax.swing.JPanel fila = new javax.swing.JPanel(null);
        fila.setBackground(esPropia ? new java.awt.Color(79, 38, 145) : new java.awt.Color(36, 18, 61));
        if (esPropia) {
            fila.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 139, 250)));
        }
        javax.swing.JLabel lblPos = new javax.swing.JLabel(String.valueOf(posicion));
        lblPos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 15));
        lblPos.setForeground(posicion == 1 ? new java.awt.Color(251, 191, 36) : new java.awt.Color(196, 181, 253));
        lblPos.setBounds(12, 0, 24, 50);
        javax.swing.JLabel lblNombre = new javax.swing.JLabel(nombre);
        lblNombre.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        lblNombre.setForeground(java.awt.Color.WHITE);
        lblNombre.setBounds(42, 0, 140, 50);
        javax.swing.JLabel lblPuntos = new javax.swing.JLabel(puntos + " pts");
        lblPuntos.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 13));
        lblPuntos.setForeground(new java.awt.Color(233, 213, 255));
        lblPuntos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPuntos.setBounds(168, 0, 90, 50);
        fila.add(lblPos);
        fila.add(lblNombre);
        fila.add(lblPuntos);

        fila.setBounds(0, pnlListaPuntos.getComponentCount() * 52, 272, 48);
        pnlListaPuntos.add(fila);
        pnlListaPuntos.repaint();
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
        lblRonda = new javax.swing.JLabel();
        lblCategoria = new javax.swing.JLabel();
        lblTiempoTitulo = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        barraRondas = new javax.swing.JProgressBar();
        pnlPregunta = new javax.swing.JPanel();
        lblNumPregunta = new javax.swing.JLabel();
        lblPregunta = new javax.swing.JLabel();
        lblInstruccion = new javax.swing.JLabel();
        btnOpcionA = new javax.swing.JToggleButton();
        btnOpcionB = new javax.swing.JToggleButton();
        btnOpcionC = new javax.swing.JToggleButton();
        btnOpcionD = new javax.swing.JToggleButton();
        btnConfirmar = new javax.swing.JButton();
        lblRecibidas = new javax.swing.JLabel();
        pnlPuntuaciones = new javax.swing.JPanel();
        lblPuntuacionesTitulo = new javax.swing.JLabel();
        lblEnVivo = new javax.swing.JLabel();
        pnlListaPuntos = new javax.swing.JPanel();
        lblNotaPuntos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Partida en curso");
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(26, 11, 46));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1024, 650));
        pnlFondo.setLayout(null);

        pnlEncabezado.setBackground(new java.awt.Color(42, 21, 70));
        pnlEncabezado.setLayout(null);

        lblRonda.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblRonda.setForeground(new java.awt.Color(255, 255, 255));
        lblRonda.setText("Ronda 1 de 10");
        pnlEncabezado.add(lblRonda);
        lblRonda.setBounds(32, 0, 300, 60);

        lblCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCategoria.setForeground(new java.awt.Color(233, 213, 255));
        lblCategoria.setText("Cultura general");
        lblCategoria.setBackground(new java.awt.Color(71, 34, 127));
        lblCategoria.setOpaque(true);
        lblCategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnlEncabezado.add(lblCategoria);
        lblCategoria.setBounds(412, 16, 200, 28);

        lblTiempoTitulo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblTiempoTitulo.setForeground(new java.awt.Color(161, 161, 170));
        lblTiempoTitulo.setText("Tiempo");
        lblTiempoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlEncabezado.add(lblTiempoTitulo);
        lblTiempoTitulo.setBounds(860, 0, 70, 60);

        lblTiempo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblTiempo.setForeground(new java.awt.Color(251, 191, 36));
        lblTiempo.setText("20");
        lblTiempo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTiempo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(251, 191, 36), 2));
        pnlEncabezado.add(lblTiempo);
        lblTiempo.setBounds(940, 8, 44, 44);

        pnlFondo.add(pnlEncabezado);
        pnlEncabezado.setBounds(0, 0, 1024, 60);

        barraRondas.setBackground(new java.awt.Color(63, 36, 102));
        barraRondas.setForeground(new java.awt.Color(139, 92, 246));
        barraRondas.setBorderPainted(false);
        pnlFondo.add(barraRondas);
        barraRondas.setBounds(0, 60, 1024, 6);

        pnlPregunta.setBackground(new java.awt.Color(255, 255, 255));
        pnlPregunta.setLayout(null);

        lblNumPregunta.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblNumPregunta.setForeground(new java.awt.Color(124, 58, 237));
        lblNumPregunta.setText("PREGUNTA 1");
        pnlPregunta.add(lblNumPregunta);
        lblNumPregunta.setBounds(28, 22, 300, 16);

        lblPregunta.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblPregunta.setForeground(new java.awt.Color(24, 24, 27));
        lblPregunta.setText("<html>¿Cuál es el río más largo de Centroamérica?</html>");
        pnlPregunta.add(lblPregunta);
        lblPregunta.setBounds(28, 42, 584, 66);

        lblInstruccion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblInstruccion.setForeground(new java.awt.Color(113, 113, 122));
        lblInstruccion.setText("Selecciona una sola respuesta y confírmala antes de que acabe el tiempo");
        pnlPregunta.add(lblInstruccion);
        lblInstruccion.setBounds(28, 112, 584, 18);

        pnlFondo.add(pnlPregunta);
        pnlPregunta.setBounds(32, 90, 640, 150);

        btnOpcionA.setBackground(new java.awt.Color(225, 29, 72));
        btnOpcionA.setForeground(new java.awt.Color(255, 255, 255));
        btnOpcionA.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        btnOpcionA.setText("A     Opción A");
        btnOpcionA.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOpcionA.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 24, 4, 14));
        btnOpcionA.setContentAreaFilled(false);
        btnOpcionA.setFocusPainted(false);
        btnOpcionA.setOpaque(true);
        btnOpcionA.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlFondo.add(btnOpcionA);
        btnOpcionA.setBounds(32, 264, 310, 90);

        btnOpcionB.setBackground(new java.awt.Color(37, 99, 235));
        btnOpcionB.setForeground(new java.awt.Color(255, 255, 255));
        btnOpcionB.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        btnOpcionB.setText("B     Opción B");
        btnOpcionB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOpcionB.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 24, 4, 14));
        btnOpcionB.setContentAreaFilled(false);
        btnOpcionB.setFocusPainted(false);
        btnOpcionB.setOpaque(true);
        btnOpcionB.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlFondo.add(btnOpcionB);
        btnOpcionB.setBounds(362, 264, 310, 90);

        btnOpcionC.setBackground(new java.awt.Color(217, 119, 6));
        btnOpcionC.setForeground(new java.awt.Color(255, 255, 255));
        btnOpcionC.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        btnOpcionC.setText("C     Opción C");
        btnOpcionC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOpcionC.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 24, 4, 14));
        btnOpcionC.setContentAreaFilled(false);
        btnOpcionC.setFocusPainted(false);
        btnOpcionC.setOpaque(true);
        btnOpcionC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlFondo.add(btnOpcionC);
        btnOpcionC.setBounds(32, 370, 310, 90);

        btnOpcionD.setBackground(new java.awt.Color(22, 163, 74));
        btnOpcionD.setForeground(new java.awt.Color(255, 255, 255));
        btnOpcionD.setFont(new java.awt.Font("Segoe UI Symbol", 1, 16)); // NOI18N
        btnOpcionD.setText("D     Opción D");
        btnOpcionD.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnOpcionD.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 24, 4, 14));
        btnOpcionD.setContentAreaFilled(false);
        btnOpcionD.setFocusPainted(false);
        btnOpcionD.setOpaque(true);
        btnOpcionD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlFondo.add(btnOpcionD);
        btnOpcionD.setBounds(362, 370, 310, 90);

        btnConfirmar.setBackground(new java.awt.Color(124, 58, 237));
        btnConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        btnConfirmar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConfirmar.setText("Confirmar respuesta");
        btnConfirmar.setContentAreaFilled(false);
        btnConfirmar.setFocusPainted(false);
        btnConfirmar.setOpaque(true);
        btnConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfirmar.addActionListener(this::btnConfirmarActionPerformed);
        pnlFondo.add(btnConfirmar);
        btnConfirmar.setBounds(32, 482, 640, 50);

        lblRecibidas.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblRecibidas.setForeground(new java.awt.Color(161, 161, 170));
        lblRecibidas.setText("Respuestas recibidas: 0 / 0");
        pnlFondo.add(lblRecibidas);
        lblRecibidas.setBounds(32, 548, 400, 18);

        pnlPuntuaciones.setBackground(new java.awt.Color(42, 21, 70));
        pnlPuntuaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(63, 36, 102), 1));
        pnlPuntuaciones.setLayout(null);

        lblPuntuacionesTitulo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblPuntuacionesTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblPuntuacionesTitulo.setText("Puntuaciones");
        pnlPuntuaciones.add(lblPuntuacionesTitulo);
        lblPuntuacionesTitulo.setBounds(20, 18, 170, 22);

        lblEnVivo.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblEnVivo.setForeground(new java.awt.Color(74, 222, 128));
        lblEnVivo.setText("En vivo");
        lblEnVivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlPuntuaciones.add(lblEnVivo);
        lblEnVivo.setBounds(200, 20, 76, 18);

        pnlListaPuntos.setBackground(new java.awt.Color(42, 21, 70));
        pnlListaPuntos.setOpaque(false);
        pnlListaPuntos.setLayout(null);

        pnlPuntuaciones.add(pnlListaPuntos);
        pnlListaPuntos.setBounds(12, 58, 272, 410);

        lblNotaPuntos.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblNotaPuntos.setForeground(new java.awt.Color(161, 161, 170));
        lblNotaPuntos.setText("<html>La tabla se actualiza cuando el servidor<br>evalúa cada ronda.</html>");
        pnlPuntuaciones.add(lblNotaPuntos);
        lblNotaPuntos.setBounds(20, 478, 260, 34);

        pnlFondo.add(pnlPuntuaciones);
        pnlPuntuaciones.setBounds(696, 90, 296, 536);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO back: enviar la opción seleccionada (btnOpcionA..D)
    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraRondas;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JToggleButton btnOpcionA;
    private javax.swing.JToggleButton btnOpcionB;
    private javax.swing.JToggleButton btnOpcionC;
    private javax.swing.JToggleButton btnOpcionD;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblEnVivo;
    private javax.swing.JLabel lblInstruccion;
    private javax.swing.JLabel lblNotaPuntos;
    private javax.swing.JLabel lblNumPregunta;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblPuntuacionesTitulo;
    private javax.swing.JLabel lblRecibidas;
    private javax.swing.JLabel lblRonda;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel lblTiempoTitulo;
    private javax.swing.JPanel pnlEncabezado;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlListaPuntos;
    private javax.swing.JPanel pnlPregunta;
    private javax.swing.JPanel pnlPuntuaciones;
    // End of variables declaration//GEN-END:variables
}
