import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFormFrame {

    private JFrame frame;
    private JTextField txtEmail;
    private JTextField txtPassword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginFormFrame window = new LoginFormFrame();
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
    public LoginFormFrame() {
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

        JLabel lblLogin = new JLabel("Accedi");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        pnlView.add(lblLogin, BorderLayout.NORTH);

        JPanel pnlBody = new JPanel();
        pnlView.add(pnlBody, BorderLayout.CENTER);
        pnlBody.setLayout(null);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblEmail.setBounds(70, 40, 97, 37);
        pnlBody.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(177, 40, 194, 37);
        pnlBody.add(txtEmail);
        txtEmail.setColumns(10);

        txtPassword = new JTextField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(177, 88, 194, 37);
        pnlBody.add(txtPassword);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        lblPassword.setBounds(70, 88, 97, 37);
        pnlBody.add(lblPassword);

        JButton btnAccedi = new JButton("Accedi");
        btnAccedi.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnAccedi.setBounds(159, 146, 124, 37);
        pnlBody.add(btnAccedi);

        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}