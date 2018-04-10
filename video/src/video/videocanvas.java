package video;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class videocanvas {

	private JFrame frmPatientVideo;
	private static int top;
	private static int left;
	private static int width;
	private static int hight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					int equal;
					
		            for (String arg : args) {
		            	
		            	equal = arg.indexOf("=");
		            	String command = arg.substring(0, equal);
		            	switch (command) {
		            	case "top": 
		            		top = Integer.parseInt(arg.substring(equal+1, arg.length()));
		            		break;
		            	case "left":
		            		left = Integer.parseInt(arg.substring(equal+1, arg.length()));
		            		break;
		            	case "hight":
		            		hight = Integer.parseInt(arg.substring(equal+1, arg.length()));
		            		break;
		            	case "width":
		            		width = Integer.parseInt(arg.substring(equal+1, arg.length()));
		            		break;
		            	}
		            }

					videocanvas window = new videocanvas();
					window.frmPatientVideo.setBounds(left, top, width, hight);
					window.frmPatientVideo.setVisible(true);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public videocanvas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPatientVideo = new JFrame();
		frmPatientVideo.setTitle("Patient video");
		frmPatientVideo.setAlwaysOnTop(true);
		frmPatientVideo.setBounds(left, top, 219, 193);
		//frame.setBounds(100, 100, 584, 403);
		frmPatientVideo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPatientVideo.getContentPane().setLayout(null);
		
		JLabel lblThisIsThe = new JLabel("This is the video");
		lblThisIsThe.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblThisIsThe.setBounds(20, 11, 384, 229);
		frmPatientVideo.getContentPane().add(lblThisIsThe);
	}

}
