import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ClientFrame extends Client {

    private JFrame frame;

    private JPanel pnlView = new JPanel();

    private JPanel pnlHome = new JPanel();
    private JLabel lblTitle = new JLabel();
    private JTextField txtEmail;
    private JTextField txtPassword1;
    private JTextField txtPassword2;
    private JTextField txtPasswordLogin;
    private JLabel lblMessage = new JLabel("");
    private JTextField txtTargaUser;
    private JTextField txtModello;
    private JTextField txtCilindrata;
    private JTextField txtScadenza;
    private JTextArea textArea = new JTextArea();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ClientFrame window = new ClientFrame();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ClientFrame() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame("Agenzia polizze");
        frame.setBounds(100, 100, 551, 356);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        pnlView.setBounds(0, 0, 535, 317);
        frame.getContentPane().add(pnlView);
        pnlView.setLayout(new BorderLayout(0, 0));

        // At the start the login or register page is loaded
        loginOrRegisterPage();
    }

    // All pages - call this to visualize the page

    private void loginOrRegisterPage() {
        resetPage();
        pnlView.add(pnlHome);
        pnlHome.setLayout(new GridLayout(1, 0, 0, 0));

        lblTitle.setText("Benvenuto in agenzia polizze!");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(186, 231, 248));
        pnlHome.add(panel);
        SpringLayout sl_panel = new SpringLayout();
        panel.setLayout(sl_panel);

        JLabel lblAccedi = new JLabel("Hai già un account registrato?");
        lblAccedi.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccedi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(lblAccedi);

        JButton btnAccedi = new JButton("Accedi");
        sl_panel.putConstraint(SpringLayout.WEST, btnAccedi, 10, SpringLayout.WEST, panel);
        sl_panel.putConstraint(SpringLayout.SOUTH, btnAccedi, -109, SpringLayout.SOUTH, panel);
        sl_panel.putConstraint(SpringLayout.EAST, btnAccedi, -10, SpringLayout.EAST, panel);
        sl_panel.putConstraint(SpringLayout.WEST, lblAccedi, 0, SpringLayout.WEST, btnAccedi);
        sl_panel.putConstraint(SpringLayout.SOUTH, lblAccedi, -6, SpringLayout.NORTH, btnAccedi);
        sl_panel.putConstraint(SpringLayout.EAST, lblAccedi, 0, SpringLayout.EAST, btnAccedi);
        btnAccedi.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        panel.add(btnAccedi);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(213, 245, 192));
        pnlHome.add(panel_1);
        SpringLayout sl_panel_1 = new SpringLayout();
        panel_1.setLayout(sl_panel_1);

        JLabel lblRegistrati = new JLabel("Non hai ancora un account?");
        sl_panel_1.putConstraint(SpringLayout.WEST, lblRegistrati, 10, SpringLayout.WEST, panel_1);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, lblRegistrati, -148, SpringLayout.SOUTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, lblRegistrati, -10, SpringLayout.EAST, panel_1);
        lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel_1.add(lblRegistrati);

        JButton btnRegistrati = new JButton("Registrati");
        sl_panel_1.putConstraint(SpringLayout.WEST, btnRegistrati, 0, SpringLayout.WEST, lblRegistrati);
        sl_panel_1.putConstraint(SpringLayout.SOUTH, btnRegistrati, -110, SpringLayout.SOUTH, panel_1);
        sl_panel_1.putConstraint(SpringLayout.EAST, btnRegistrati, 0, SpringLayout.EAST, lblRegistrati);
        panel_1.add(btnRegistrati);
        btnRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 17));

        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setForeground(Color.BLACK);
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        lblTitle.setBackground(new Color(202, 230, 189));
        pnlView.add(lblTitle, BorderLayout.NORTH);

        btnRegistrati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                registrationFormPage();
            }
        });
        btnAccedi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginFormPage("");
            }
        });
    }

    private void registrationFormPage() {
        resetPage();
        lblTitle.setText("Registrati!");
        pnlView.add(pnlHome);
        SpringLayout sl_pnlHome = new SpringLayout();
        pnlHome.setLayout(sl_pnlHome);

        JLabel lblEmail = new JLabel("Email");
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblEmail, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblEmail, -226, SpringLayout.SOUTH, pnlHome);
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblEmail);

        txtEmail = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblEmail, -6, SpringLayout.WEST, txtEmail);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtEmail, 176, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtEmail, -10, SpringLayout.EAST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtEmail, 33, SpringLayout.NORTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtEmail, 57, SpringLayout.NORTH, pnlHome);
        pnlHome.add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblPassword, 10, SpringLayout.WEST, pnlHome);
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblPassword);

        txtPassword1 = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblPassword, -6, SpringLayout.WEST, txtPassword1);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtPassword1, 26, SpringLayout.SOUTH, txtEmail);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtPassword1, 176, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtPassword1, -10, SpringLayout.EAST, pnlHome);
        txtPassword1.setColumns(10);
        pnlHome.add(txtPassword1);

        JLabel lblPassword_2 = new JLabel("Repeat password");
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblPassword, -24, SpringLayout.NORTH, lblPassword_2);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblPassword_2, 131, SpringLayout.NORTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblPassword_2, 10, SpringLayout.WEST, pnlHome);
        lblPassword_2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblPassword_2);

        txtPassword2 = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblPassword_2, -6, SpringLayout.WEST, txtPassword2);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtPassword1, -24, SpringLayout.NORTH, txtPassword2);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtPassword2, 0, SpringLayout.WEST, txtEmail);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtPassword2, 131, SpringLayout.NORTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtPassword2, -128, SpringLayout.SOUTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtPassword2, -10, SpringLayout.EAST, pnlHome);
        pnlHome.add(txtPassword2);
        txtPassword2.setColumns(10);

        JButton btnRegistrati = new JButton("Registrati");
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnRegistrati, -195, SpringLayout.EAST, txtEmail);
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnRegistrati, 0, SpringLayout.EAST, txtEmail);
        btnRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnRegistrati);
        btnRegistrati.setForeground(new Color(255, 255, 255));
        btnRegistrati.setBackground(new Color(43, 198, 54));

        JButton btnTornaAllaHome = new JButton("Torna alla home");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, btnRegistrati, 0, SpringLayout.NORTH, btnTornaAllaHome);
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnTornaAllaHome, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, btnTornaAllaHome, -34, SpringLayout.SOUTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnTornaAllaHome, -340, SpringLayout.EAST, pnlHome);
        btnTornaAllaHome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnTornaAllaHome);

        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblMessage, -85, SpringLayout.NORTH, btnRegistrati);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblMessage, 0, SpringLayout.WEST, lblEmail);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblMessage, -6, SpringLayout.NORTH, btnRegistrati);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblMessage, 0, SpringLayout.EAST, txtEmail);
        lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        pnlHome.add(lblMessage);

        btnTornaAllaHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginOrRegisterPage();
            }
        });

        btnRegistrati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
    }

    private void loginFormPage(String message) {
        resetPage();
        lblTitle.setText("Accedi!");
        pnlView.add(pnlHome);
        SpringLayout sl_pnlHome = new SpringLayout();
        pnlHome.setLayout(sl_pnlHome);

        JLabel lblEmail = new JLabel("Email");
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblEmail, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblEmail, -226, SpringLayout.SOUTH, pnlHome);
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblEmail);

        txtEmail = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblEmail, -6, SpringLayout.WEST, txtEmail);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtEmail, 176, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtEmail, -10, SpringLayout.EAST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtEmail, 33, SpringLayout.NORTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtEmail, 57, SpringLayout.NORTH, pnlHome);
        pnlHome.add(txtEmail);
        txtEmail.setColumns(10);

        JLabel lblPassword = new JLabel("Password");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblPassword, 26, SpringLayout.SOUTH, lblEmail);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblPassword, 10, SpringLayout.WEST, pnlHome);
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblPassword);

        txtPasswordLogin = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtPasswordLogin, 26, SpringLayout.SOUTH, txtEmail);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblPassword, -6, SpringLayout.WEST, txtPasswordLogin);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtPasswordLogin, 176, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtPasswordLogin, -10, SpringLayout.EAST, pnlHome);
        txtPasswordLogin.setColumns(10);
        pnlHome.add(txtPasswordLogin);

        JButton btnAccedi = new JButton("Accedi");
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtPasswordLogin, -109, SpringLayout.NORTH, btnAccedi);
        btnAccedi.setForeground(new Color(255, 255, 255));
        btnAccedi.setBackground(new Color(43, 198, 54));
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnAccedi, -195, SpringLayout.EAST, txtEmail);
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnAccedi, 0, SpringLayout.EAST, txtEmail);
        btnAccedi.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnAccedi);

        JButton btnTornaAllaHome = new JButton("Torna alla home");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, btnAccedi, 0, SpringLayout.NORTH, btnTornaAllaHome);
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnTornaAllaHome, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, btnTornaAllaHome, -34, SpringLayout.SOUTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnTornaAllaHome, -340, SpringLayout.EAST, pnlHome);
        btnTornaAllaHome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnTornaAllaHome);

        lblMessage.setText(message);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblMessage, -85, SpringLayout.NORTH, btnAccedi);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblMessage, 0, SpringLayout.WEST, lblEmail);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblMessage, -6, SpringLayout.NORTH, btnAccedi);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblMessage, 0, SpringLayout.EAST, txtEmail);
        lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        pnlHome.add(lblMessage);
        btnTornaAllaHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginOrRegisterPage();
            }
        });

        btnAccedi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
    }

    private void userView() {
        resetPage();
        lblTitle.setText("Controllo scadenza polizza");
        pnlView.add(pnlHome);
        SpringLayout sl_pnlHome = new SpringLayout();
        pnlHome.setLayout(sl_pnlHome);

        JLabel lblTarga = new JLabel("Targa");
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblTarga, 10, SpringLayout.WEST, pnlHome);
        lblTarga.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblTarga);

        txtTargaUser = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtTargaUser, 176, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblTarga, -6, SpringLayout.WEST, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtTargaUser, -10, SpringLayout.EAST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblTarga, 0, SpringLayout.SOUTH, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtTargaUser, 10, SpringLayout.NORTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtTargaUser, 34, SpringLayout.NORTH, pnlHome);
        pnlHome.add(txtTargaUser);
        txtTargaUser.setColumns(10);

        JButton btnCerca = new JButton("Cerca auto");
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnCerca, -10, SpringLayout.EAST, pnlHome);
        btnCerca.setForeground(new Color(255, 255, 255));
        btnCerca.setBackground(new Color(43, 198, 54));
        btnCerca.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnCerca);

        JButton btnTornaAllaHome = new JButton("Torna alla home");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, btnCerca, 0, SpringLayout.NORTH, btnTornaAllaHome);
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnCerca, 135, SpringLayout.EAST, btnTornaAllaHome);
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnTornaAllaHome, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, btnTornaAllaHome, -34, SpringLayout.SOUTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnTornaAllaHome, -340, SpringLayout.EAST, pnlHome);
        btnTornaAllaHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginOrRegisterPage();
            }
        });
        btnTornaAllaHome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnTornaAllaHome);

        sl_pnlHome.putConstraint(SpringLayout.NORTH, textArea, 21, SpringLayout.SOUTH, lblTarga);
        sl_pnlHome.putConstraint(SpringLayout.WEST, textArea, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, textArea, -21, SpringLayout.NORTH, btnCerca);
        sl_pnlHome.putConstraint(SpringLayout.EAST, textArea, 0, SpringLayout.EAST, txtTargaUser);
        pnlHome.add(textArea);

        btnCerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchVehicle();
            }
        });
    }

    private void adminView() {
        resetPage();
        lblTitle.setText("Dashboard veicoli");
        pnlView.add(pnlHome);
        SpringLayout sl_pnlHome = new SpringLayout();
        pnlHome.setLayout(sl_pnlHome);

        JLabel lblTarga = new JLabel("Targa");
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblTarga, 10, SpringLayout.WEST, pnlHome);
        lblTarga.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblTarga);

        txtTargaUser = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtTargaUser, 176, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblTarga, -6, SpringLayout.WEST, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtTargaUser, -10, SpringLayout.EAST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblTarga, 0, SpringLayout.SOUTH, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtTargaUser, 10, SpringLayout.NORTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtTargaUser, 34, SpringLayout.NORTH, pnlHome);
        pnlHome.add(txtTargaUser);
        txtTargaUser.setColumns(10);

        JLabel lblModello = new JLabel("Modello");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblModello, 6, SpringLayout.SOUTH, lblTarga);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblModello, 10, SpringLayout.WEST, pnlHome);
        lblModello.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblModello);

        txtModello = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblModello, -6, SpringLayout.WEST, txtModello);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtModello, 6, SpringLayout.SOUTH, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtModello, 0, SpringLayout.WEST, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtModello, -10, SpringLayout.EAST, pnlHome);
        txtModello.setColumns(10);
        pnlHome.add(txtModello);

        JButton btnAggiungi = new JButton("Aggiungi auto");
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnAggiungi, -10, SpringLayout.EAST, pnlHome);
        btnAggiungi.setForeground(new Color(255, 255, 255));
        btnAggiungi.setBackground(new Color(43, 198, 54));
        btnAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnAggiungi);

        JButton btnTornaAllaHome = new JButton("Torna alla home");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, btnAggiungi, 0, SpringLayout.NORTH, btnTornaAllaHome);
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnAggiungi, 135, SpringLayout.EAST, btnTornaAllaHome);
        sl_pnlHome.putConstraint(SpringLayout.WEST, btnTornaAllaHome, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, btnTornaAllaHome, -34, SpringLayout.SOUTH, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, btnTornaAllaHome, -340, SpringLayout.EAST, pnlHome);

        btnTornaAllaHome.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(btnTornaAllaHome);

        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtModello, -95, SpringLayout.NORTH, lblMessage);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblMessage, 10, SpringLayout.WEST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblMessage, -10, SpringLayout.EAST, pnlHome);
        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblMessage, -57, SpringLayout.NORTH, btnAggiungi);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, lblMessage, -6, SpringLayout.NORTH, btnAggiungi);
        lblMessage.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
        pnlHome.add(lblMessage);

        JLabel lblCilindrata = new JLabel("Cilindrata");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblCilindrata, 6, SpringLayout.SOUTH, lblModello);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblCilindrata, 0, SpringLayout.WEST, lblTarga);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblCilindrata, 0, SpringLayout.EAST, lblTarga);
        lblCilindrata.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblCilindrata);

        txtCilindrata = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtCilindrata, 6, SpringLayout.SOUTH, txtModello);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtCilindrata, 0, SpringLayout.WEST, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtCilindrata, 0, SpringLayout.SOUTH, lblCilindrata);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtCilindrata, 0, SpringLayout.EAST, txtTargaUser);
        txtCilindrata.setColumns(10);
        pnlHome.add(txtCilindrata);

        JLabel lblScadenza = new JLabel("Scadenza");
        sl_pnlHome.putConstraint(SpringLayout.NORTH, lblScadenza, 6, SpringLayout.SOUTH, lblCilindrata);
        sl_pnlHome.putConstraint(SpringLayout.WEST, lblScadenza, 0, SpringLayout.WEST, lblTarga);
        sl_pnlHome.putConstraint(SpringLayout.EAST, lblScadenza, 0, SpringLayout.EAST, lblTarga);
        lblScadenza.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        pnlHome.add(lblScadenza);

        txtScadenza = new JTextField();
        sl_pnlHome.putConstraint(SpringLayout.NORTH, txtScadenza, 6, SpringLayout.SOUTH, txtCilindrata);
        sl_pnlHome.putConstraint(SpringLayout.WEST, txtScadenza, -349, SpringLayout.EAST, txtTargaUser);
        sl_pnlHome.putConstraint(SpringLayout.SOUTH, txtScadenza, 0, SpringLayout.SOUTH, lblScadenza);
        sl_pnlHome.putConstraint(SpringLayout.EAST, txtScadenza, 0, SpringLayout.EAST, txtTargaUser);
        txtScadenza.setColumns(10);
        pnlHome.add(txtScadenza);

        btnTornaAllaHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginOrRegisterPage();
            }
        });

        btnAggiungi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addVehicle();
            }
        });
    }

    private void resetPage() {
        pnlHome.removeAll();
        pnlHome.revalidate();
        pnlHome.repaint();
    }

    private void register() {
        Client c = new Client();
        c.connectToServer("localhost");

        c.sendString("register");

        c.sendString(txtEmail.getText());
        c.sendString(txtPassword1.getText());
        c.sendString(txtPassword2.getText());

        String message = c.readString();

        if (message.compareTo("accedi") == 0) {
            loginFormPage("Account registrato!");
        } else {
            lblMessage.setText(message);
        }
    }

    private void login() {
        Client c = new Client();
        c.connectToServer("localhost");

        c.sendString("login");
        c.sendString(txtEmail.getText());
        c.sendString(txtPasswordLogin.getText());

        String status = c.readString();

        switch (status) {
            case "2": {
                adminView();
                break;
            }
            case "1": {
                userView();
                break;
            }

            default:
                lblMessage.setText(status);
                break;
        }
        c.closeConnection();
    }

    private void addVehicle() {
        Client c = new Client();
        c.connectToServer("localhost");

        c.sendString("addVehicle");

        c.sendString(txtTargaUser.getText());
        c.sendString(txtModello.getText());
        c.sendObj(Integer.parseInt(txtCilindrata.getText()));
        c.sendObj(Integer.parseInt(txtCilindrata.getText()));

        lblMessage.setText(c.readString());
    }

    private void searchVehicle() {
        Client c = new Client();
        c.connectToServer("localhost");

        c.sendString("search");

        c.sendString(txtTargaUser.getText());

        String scadenza = c.readString();

        textArea.setText("L' auto scade nell'anno: " + scadenza);
    }
}