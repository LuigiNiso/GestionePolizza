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

public class AdminView {

	private JFrame frame;
	private JTextField txtModello;
	private JTextField txtCilindrata;
	private JTextField txtScadenza;
	private JTextField txtTarga;

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
		lblModello.setBounds(41, 42, 144, 28);
		pnlBody.add(lblModello);
		
		txtModello = new JTextField();
		txtModello.setColumns(10);
		txtModello.setBounds(195, 42, 167, 28);
		pnlBody.add(txtModello);
		
		JLabel lblAggiungiVeicolo = new JLabel("Aggiungi veicolo");
		lblAggiungiVeicolo.setHorizontalAlignment(SwingConstants.LEFT);
		lblAggiungiVeicolo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblAggiungiVeicolo.setBounds(41, 0, 301, 31);
		pnlBody.add(lblAggiungiVeicolo);
		
		JLabel lblCilindrata = new JLabel("Cilindrata");
		lblCilindrata.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblCilindrata.setBounds(41, 79, 144, 28);
		pnlBody.add(lblCilindrata);
		
		txtCilindrata = new JTextField();
		txtCilindrata.setColumns(10);
		txtCilindrata.setBounds(195, 79, 167, 28);
		pnlBody.add(txtCilindrata);
		
		JLabel lblScadenzaPolizza = new JLabel("Scadenza Polizza");
		lblScadenzaPolizza.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblScadenzaPolizza.setBounds(41, 118, 144, 28);
		pnlBody.add(lblScadenzaPolizza);
		
		txtScadenza = new JTextField();
		txtScadenza.setColumns(10);
		txtScadenza.setBounds(195, 118, 167, 28);
		pnlBody.add(txtScadenza);
		
		JButton btnAggiungi = new JButton("Aggiungi");
		btnAggiungi.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnAggiungi.setBounds(117, 196, 144, 28);
		pnlBody.add(btnAggiungi);
		
		JLabel lblTarga = new JLabel("Targa");
		lblTarga.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblTarga.setBounds(41, 157, 144, 28);
		pnlBody.add(lblTarga);
		
		txtTarga = new JTextField();
		txtTarga.setColumns(10);
		txtTarga.setBounds(195, 157, 167, 28);
		pnlBody.add(txtTarga);
		btnAggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
}
