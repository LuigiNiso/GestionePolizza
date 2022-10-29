import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminView {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminView window = new AdminView();
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
    public AdminView() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel pnlView = new JPanel();
        pnlView.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(pnlView);
        pnlView.setLayout(new BorderLayout(0, 0));

        JLabel lblAdminView = new JLabel("Admin View");
        lblAdminView.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdminView.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        pnlView.add(lblAdminView, BorderLayout.NORTH);

        JPanel pnlBody = new JPanel();
        pnlView.add(pnlBody, BorderLayout.CENTER);
        pnlBody.setLayout(null);

        JLabel lblModello = new JLabel("Modello");
        lblModello.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblModello.setBounds(41, 53, 144, 28);
        pnlBody.add(lblModello);

        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(195, 53, 167, 28);
        pnlBody.add(textField);

        JLabel lblAggiungiAuto = new JLabel("Aggiungi auto");
        lblAggiungiAuto.setHorizontalAlignment(SwingConstants.LEFT);
        lblAggiungiAuto.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblAggiungiAuto.setBounds(41, 11, 301, 31);
        pnlBody.add(lblAggiungiAuto);

        JLabel lblCilindrata = new JLabel("Cilindrata");
        lblCilindrata.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblCilindrata.setBounds(41, 90, 144, 28);
        pnlBody.add(lblCilindrata);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(195, 90, 167, 28);
        pnlBody.add(textField_1);

        JLabel lblScadenzaPolizza = new JLabel("Scadenza Polizza");
        lblScadenzaPolizza.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblScadenzaPolizza.setBounds(41, 129, 144, 28);
        pnlBody.add(lblScadenzaPolizza);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(195, 129, 167, 28);
        pnlBody.add(textField_2);

        JButton btnAggiungi = new JButton("Aggiungi");
        btnAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 19));
        btnAggiungi.setBounds(124, 169, 144, 36);
        pnlBody.add(btnAggiungi);
        btnAggiungi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}