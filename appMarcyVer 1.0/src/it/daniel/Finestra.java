package it.daniel;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;


public class Finestra {

	private JFrame frame;
	private JTextField textField;
	private JButton btnCliccami;
	/**
	 * @wbp.nonvisual location=27,339
	 */
	private LibroDellaSorte libroDellaSorte = new LibroDellaSorte();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finestra window = new Finestra();
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
	public Finestra() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblInserisciIlPath = new JLabel("Inserisci il path dell'elenco libri");
		springLayout.putConstraint(SpringLayout.NORTH, lblInserisciIlPath, 75, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblInserisciIlPath, 27, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblInserisciIlPath);
		
		textField = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, textField, 35, SpringLayout.SOUTH, lblInserisciIlPath);
		springLayout.putConstraint(SpringLayout.WEST, textField, 0, SpringLayout.WEST, lblInserisciIlPath);
		springLayout.putConstraint(SpringLayout.SOUTH, textField, 58, SpringLayout.SOUTH, lblInserisciIlPath);
		springLayout.putConstraint(SpringLayout.EAST, textField, 266, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnCliccami = new JButton("Cliccami");
		springLayout.putConstraint(SpringLayout.SOUTH, btnCliccami, -118, SpringLayout.SOUTH, frame.getContentPane());
		btnCliccami.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Risposta.risposta(Finestra.this.libroDellaSorte.libroRandom());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		springLayout.putConstraint(SpringLayout.EAST, btnCliccami, -61, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(btnCliccami);
		initDataBindings();
	}
	protected void initDataBindings() {
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		BeanProperty<LibroDellaSorte, String> libroDellaSorteBeanProperty = BeanProperty.create("path");
		AutoBinding<JTextField, String, LibroDellaSorte, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, textField, jTextFieldBeanProperty, libroDellaSorte, libroDellaSorteBeanProperty);
		autoBinding.bind();
	}
}
