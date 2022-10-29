import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrationFormFrame {

    private JFrame frame;
    private JTextField txtEmail;
    private JTextField txtPassword;
    private JTextField txtPassword2;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegistrationFormFrame window = new RegistrationFormFrame();
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
    public RegistrationFormFrame() {
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

        JLabel lblRegistrati = new JLabel("Registrati");
        lblRegistrati.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        pnlView.add(lblRegistrati, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        pnlView.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblEmail.setBounds(60, 11, 125, 37);
        panel.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setColumns(10);
        txtEmail.setBounds(195, 11, 166, 37);
        panel.add(txtEmail);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblPassword.setBounds(60, 59, 125, 37);
        panel.add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setColumns(10);
        txtPassword.setBounds(195, 59, 166, 37);
        panel.add(txtPassword);

        JButton btnRegistrati = new JButton("Registrati");

        btnRegistrati.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnRegistrati.setBounds(151, 158, 124, 37);
        panel.add(btnRegistrati);

        JLabel lblPassword2 = new JLabel("Ripeti password");
        lblPassword2.setFont(new Font("Segoe UI", Font.PLAIN, 17));
        lblPassword2.setBounds(60, 107, 125, 37);
        panel.add(lblPassword2);

        txtPassword2 = new JTextField();
        txtPassword2.setColumns(10);
        txtPassword2.setBounds(195, 107, 166, 37);
        panel.add(txtPassword2);
        btnRegistrati.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
