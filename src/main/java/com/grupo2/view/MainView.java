/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grupo2.view;

import com.grupo2.entity.Usuario;
import com.gruṕo2.util.Constantes.Evento;
import static com.gruṕo2.util.Constantes.Rol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author ccolome
 */
@Component
public class MainView extends JFrame {

    private final LoginView loginView;

    private final Rol ADMINISTRADOR = Rol.ADMINISTRADOR;
    private final Rol ALMACEN = Rol.ALMACEN;
    private final Rol VENDEDOR = Rol.VENDEDOR;

    private Usuario usuario;

    private JPanel principalPanel;

    private JMenuBar principalMenuBar;
    private JMenu ventasMenu;
    private JMenu productoMenu;
    private JMenu clientesMenu;
    private JMenu usuarioMenu;

    private JMenuItem productoConsultaMenuItem;
    private JMenuItem productoRegistroMenuItem;
    private JMenuItem ventaConsultaMenuItem;
    private JMenuItem ventaRegistroMenuItem;
    private JMenuItem clienteConsultaMenuItem;
    private JMenuItem clienteRegistroMenuItem;
    private JMenuItem salirMenuItem;

    private JLabel tituloLabel;

    @Autowired
    public MainView(LoginView loginView) {
        this.loginView = loginView;
        initComponents();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        principalPanel = new JPanel();
        tituloLabel = new JLabel();
        principalMenuBar = new JMenuBar();
        productoMenu = new JMenu();
        ventasMenu = new JMenu();
        clientesMenu = new JMenu();
        usuarioMenu = new JMenu();
        productoConsultaMenuItem = new JMenuItem();
        productoRegistroMenuItem = new JMenuItem();
        ventaConsultaMenuItem = new JMenuItem();
        ventaRegistroMenuItem = new JMenuItem();
        clienteConsultaMenuItem = new JMenuItem();
        clienteRegistroMenuItem = new JMenuItem();
        salirMenuItem = new JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principalPanel.setPreferredSize(new java.awt.Dimension(720, 480));

        tituloLabel.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
                principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                                .addContainerGap(183, Short.MAX_VALUE)
                                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(136, 136, 136))
        );
        principalPanelLayout.setVerticalGroup(
                principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                                .addContainerGap(165, Short.MAX_VALUE)
                                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(158, 158, 158))
        );

        principalPanel.setVisible(false);

        loginView.addPropertyChangeListener((PropertyChangeEvent event) -> {
            loginPropertyChangeEvent(event);
        });

        add(loginView);

        pack();
    }

    private void initMenuComponents() {

        String titulo = new StringBuilder()
                .append("<html><body>¡Bienvenido ")
                .append(usuario.getUsername())
                .append(" al sistema de gestión<br>bodega Rosita!</body></html>")
                .toString();

        tituloLabel.setText(titulo);

        setMenuPermitido();

        principalPanel.setVisible(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );
    }

    private void loginPropertyChangeEvent(PropertyChangeEvent event) {
        if (event.getPropertyName().equals(Evento.USUARIO_LOGUEADO.name())) {
            usuario = (Usuario) event.getNewValue();
            System.out.println("Usuraio logueado " + usuario.getUsername());
            loginView.setVisible(false);
            initMenuComponents();
        }
    }

    private void setMenuPermitido() {

        try {
            System.out.println(usuario.getRol());
            Rol usuarioRol = Rol.valueOf(usuario.getRol());

            productoMenu.setText("Productos");
            ventasMenu.setText("Ventas");
            clientesMenu.setText("Clientes");
            usuarioMenu.setText("Usuario");

            productoConsultaMenuItem.setText("Consulta de productos");
            productoRegistroMenuItem.setText("Registro de productos");
            ventaConsultaMenuItem.setText("Consulta de productos");
            ventaRegistroMenuItem.setText("Registro de productos");
            clienteConsultaMenuItem.setText("Consulta de productos");
            clienteRegistroMenuItem.setText("Registro de productos");
            salirMenuItem.setText("Salir");

            productoConsultaMenuItem.addActionListener(e -> this.productoConsultaMenuItemAction(e));
            productoRegistroMenuItem.addActionListener(e -> this.productoRegistroMenuItemAction(e));
            ventaConsultaMenuItem.addActionListener(e -> this.ventaConsultaMenuItemAction(e));
            ventaRegistroMenuItem.addActionListener(e -> this.ventaRegistroMenuItemAction(e));
            clienteConsultaMenuItem.addActionListener(e -> this.clienteConsultaMenuItemAction(e));
            clienteRegistroMenuItem.addActionListener(e -> this.clienteRegistroMenuItem(e));

            productoMenu.add(productoConsultaMenuItem);
            productoMenu.add(productoRegistroMenuItem);
            ventasMenu.add(ventaConsultaMenuItem);
            ventasMenu.add(ventaRegistroMenuItem);
            clientesMenu.add(clienteConsultaMenuItem);
            clientesMenu.add(clienteRegistroMenuItem);
            usuarioMenu.add(salirMenuItem);
            
            switch (usuarioRol) {
                case ADMINISTRADOR:
                    principalMenuBar.add(productoMenu);
                    principalMenuBar.add(ventasMenu);
                    principalMenuBar.add(clientesMenu);
                    principalMenuBar.add(Box.createHorizontalGlue());
                    principalMenuBar.add(usuarioMenu);
                    break;
                case ALMACEN:
                    principalMenuBar.add(productoMenu);
                    principalMenuBar.add(Box.createHorizontalGlue());
                    principalMenuBar.add(usuarioMenu);
                    break;
                case VENDEDOR:
                    principalMenuBar.add(ventasMenu);
                    principalMenuBar.add(clientesMenu);
                    principalMenuBar.add(Box.createHorizontalGlue());
                    principalMenuBar.add(usuarioMenu);
                    break;
                default:
                    throw new Exception("Rol no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error al designar menu: " + e.getMessage());
        }

        setJMenuBar(principalMenuBar);
    }

    private void productoConsultaMenuItemAction(ActionEvent e) {
    }

    private void productoRegistroMenuItemAction(ActionEvent e) {
    }

    private void ventaConsultaMenuItemAction(ActionEvent e) {
    }

    private void ventaRegistroMenuItemAction(ActionEvent e) {
    }

    private void clienteConsultaMenuItemAction(ActionEvent e) {
    }

    private void clienteRegistroMenuItem(ActionEvent e) {
    }

}
