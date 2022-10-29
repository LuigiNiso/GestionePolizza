import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeFrame {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeFrame window = new HomeFrame();
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
    public HomeFrame() {
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

        JLabel lblTitle = new JLabel("Home");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.PLAIN, 23));
        pnlView.add(lblTitle, BorderLayout.NORTH);

        JPanel pnlBody = new JPanel();
        pnlView.add(pnlBody, BorderLayout.CENTER);
        pnlBody.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnRegistrati = new JButton("REGISTRATI");
        btnRegistrati.setFont(new Font("Segoe UI", Font.BOLD, 17));
        pnlBody.add(btnRegistrati);
        JButton btnAccedi = new JButton("ACCEDI");
        pnlBody.add(btnAccedi);

        btnAccedi.setFont(new Font("Segoe UI", Font.BOLD, 17));
        btnAccedi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnRegistrati.setFont(new Font("Segoe UI", Font.BOLD, 17));
        btnRegistrati.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}