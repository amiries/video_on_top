package mainform;

import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import java.awt.Window.Type;
import java.awt.image.ImageObserver;
import java.io.IOException;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JTextField;

import org.omg.CORBA.portable.InputStream;

import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class maincanvas {

	private JFrame frmMainCanvas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maincanvas window = new maincanvas();
					window.frmMainCanvas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public maincanvas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMainCanvas = new JFrame();
		frmMainCanvas.setTitle("main canvas");
		frmMainCanvas.setBounds(100, 100, 1014, 765);
		frmMainCanvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMainCanvas.getContentPane().setLayout(null);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(48, 208, 243, 105);
		frmMainCanvas.getContentPane().add(editorPane);
		
		JLabel lblText = new JLabel("text 1");
		lblText.setBounds(48, 167, 46, 14);
		frmMainCanvas.getContentPane().add(lblText);
		
		JLabel lblText_1 = new JLabel("text 2");
		lblText_1.setBounds(48, 376, 46, 14);
		frmMainCanvas.getContentPane().add(lblText_1);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(48, 417, 243, 123);
		frmMainCanvas.getContentPane().add(editorPane_1);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Process proc = Runtime.getRuntime().exec("java -jar A.jar");
				try {
					Process proc = Runtime.getRuntime().exec("java -jar c:\\proj\\eclipse\\video\\exe\\video.jar top=10 left=10 width=200 hight=200");
					InputStream in = (InputStream) proc.getInputStream();
					InputStream err = (InputStream) proc.getErrorStream();					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		button.setBounds(46, 582, 89, 23);
		frmMainCanvas.getContentPane().add(button);
	}
}
