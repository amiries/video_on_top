package mainform;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.omg.CORBA.portable.InputStream;
import javax.swing.JTextField;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinUser;
import com.sun.jna.platform.win32.WinUser.WNDENUMPROC;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.platform.win32.WinDef.RECT;

public class maincanvas {

	private JFrame frmMainCanvas;
	private JTextField textTop;
	private JTextField textLeft;
	private JTextField textWidth;
	private JTextField textHeight;

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
		editorPane.setBounds(660, 208, 243, 105);
		frmMainCanvas.getContentPane().add(editorPane);
		
		JLabel lblText = new JLabel("text 1");
		lblText.setBounds(660, 167, 46, 14);
		frmMainCanvas.getContentPane().add(lblText);
		
		JLabel lblText_1 = new JLabel("text 2");
		lblText_1.setBounds(660, 376, 46, 14);
		frmMainCanvas.getContentPane().add(lblText_1);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(660, 417, 243, 123);
		frmMainCanvas.getContentPane().add(editorPane_1);
		
		JButton btnLaunchVideo = new JButton("Launch video");
		btnLaunchVideo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Process proc = Runtime.getRuntime().exec("java -jar A.jar");
				try {
					Process proc = Runtime.getRuntime().exec("java -jar c:\\proj\\eclipse\\video\\exe\\video.jar top=" + textTop.getText() + " left=" + textLeft.getText() + " width=" + textWidth.getText() + " hight=" + textHeight.getText());
					InputStream in = (InputStream) proc.getInputStream();
					InputStream err = (InputStream) proc.getErrorStream();					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnLaunchVideo.setBounds(46, 582, 167, 23);
		frmMainCanvas.getContentPane().add(btnLaunchVideo);
		
		textTop = new JTextField();
		textTop.setText("100");
		textTop.setBounds(10, 22, 86, 20);
		frmMainCanvas.getContentPane().add(textTop);
		textTop.setColumns(10);
		
		textLeft = new JTextField();
		textLeft.setText("100");
		textLeft.setBounds(8, 53, 86, 20);
		frmMainCanvas.getContentPane().add(textLeft);
		textLeft.setColumns(10);
		
		textWidth = new JTextField();
		textWidth.setText("1000");
		textWidth.setBounds(8, 84, 86, 20);
		frmMainCanvas.getContentPane().add(textWidth);
		textWidth.setColumns(10);
		
		textHeight = new JTextField();
		textHeight.setText("1000");
		textHeight.setBounds(8, 115, 86, 20);
		frmMainCanvas.getContentPane().add(textHeight);
		textHeight.setColumns(10);
		
		JButton btnChangeLoc = new JButton("Change Location");
		btnChangeLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				final User32 user32 = User32.INSTANCE;
		        user32.EnumWindows(new WNDENUMPROC() {
		            int count = 0;
		            public boolean callback(HWND hWnd, Pointer arg1) {
		                char[] windowText = new char[512];
		                user32.GetWindowText(hWnd, windowText, 512);
		                String wText = Native.toString(windowText);
		                RECT rectangle = new RECT();
		                user32.GetWindowRect(hWnd, rectangle);
		                // get rid of this if block if you want all windows regardless
		                // of whether
		                // or not they have text
		                // second condition is for visible and non minimised windows
		                if (wText.isEmpty() || !(User32.INSTANCE.IsWindowVisible(hWnd)
		                        && rectangle.left > -32000)) {
		                    return true;
		                }
		                if (wText.contains("Patient video")) {
		                	user32.MoveWindow(hWnd, 100, 100, 500, 500, true);
		                	//JOptionPane.showMessageDialog(null, "Found window with text " + hWnd + ", total " + ++count + " Text: " + wText);
		                }
		                return true;
		            }
		        }, null);				
		
			}
		});
		btnChangeLoc.setBounds(10, 146, 140, 23);
		frmMainCanvas.getContentPane().add(btnChangeLoc);
	}
}
