import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserView {

    private JFrame frame;
    private JTextField txtTarga;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserView window = new UserView();
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
    public UserView() {
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

        JLabel lblControlloPolizza = new JLabel("Controllo Polizza");
        lblControlloPolizza.setHorizontalAlignment(SwingConstants.CENTER);
        lblControlloPolizza.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        pnlView.add(lblControlloPolizza, BorderLayout.NORTH);

        JPanel pnlBody = new JPanel();
        pnlView.add(pnlBody, BorderLayout.CENTER);
        pnlBody.setLayout(null);

        JLabel lblTarga = new JLabel("Targa");
        lblTarga.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblTarga.setBounds(51, 11, 144, 28);
        pnlBody.add(lblTarga);

        txtTarga = new JTextField();
        txtTarga.setColumns(10);
        txtTarga.setBounds(205, 11, 167, 28);
        pnlBody.add(txtTarga);

        JTextArea txtResult = new JTextArea();
        txtResult.setEditable(false);
        txtResult.setBounds(51, 96, 321, 123);
        pnlBody.add(txtResult);

        JButton btnCerca = new JButton("Cerca");
        btnCerca.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        btnCerca.setBounds(149, 50, 122, 35);
        pnlBody.add(btnCerca);
        btnCerca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
