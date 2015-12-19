import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*; 

// Unicodes 	First	Second	Third	Fourth
// a 			0101	00E1	01CE	00E0
// e			0113	00E9	011B	00E8
// i			012B 	00CE	101CF	206A 
// o			00ed	00D3	01D2	00F2
// u 			016B	00FA	01D4	00F9
public class TextEditor extends JFrame {
	private JTextArea textArea = new JTextArea(); 
	private JFileChooser filechooser = new JFileChooser(); 
	private Action open = new openAction(); 
	private Action save = new saveAction();	
	private Map<Integer, String> map; 

	public TextEditor() {
		map = new HashMap<Integer, String>(); 
		map.put('a' + '1', "\u0101"); 
		map.put('a' + '2', "\u00E1"); 
		map.put('a' + '3', "\u01CE"); 
		map.put('a' + '4', "\u00E0"); 

		map.put('e' + '1', "\u0113"); 
		map.put('e' + '2', "\u00E9"); 
		map.put('e' + '3', "\u011B"); 
		map.put('e' + '4', "\u00E8");
		
		map.put('i' + '1', "\u012B"); 
		map.put('i' + '2', "\u00ED"); 
		map.put('i' + '3', "\u01D0"); 
		map.put('i' + '4', "\u00EC");
		
		map.put('o' + '1', "\u014D"); 
		map.put('o' + '2', "\u00F3"); 
		map.put('o' + '3', "\u01D2"); 
		map.put('o' + '4', "\u00F2");
		
		map.put('u' + '1', "\u016B"); 
		map.put('u' + '2', "\u00FA"); 
		map.put('u' + '3', "\u01D4"); 
		map.put('u' + '4', "\u00F9");
		map.put('u' + '5', "\u01DA");
		
		textArea = new JTextArea(15, 60);
		textArea.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		// Sets font style & size 
		textArea.setFont(new Font("Calibri", Font.PLAIN, 20));
		// Sets background color 
		textArea.setBackground(Color.BLACK);
		// Sets font color 
		textArea.setForeground(Color.WHITE);
		JScrollPane scrolltext = new JScrollPane(textArea); 
		
		JPanel content = new JPanel(); 
		content.setLayout(new BorderLayout()); 
		content.add(scrolltext, BorderLayout.CENTER); 
		JMenuBar menubar = new JMenuBar(); 
		
		JButton button = new JButton("Open");
		menubar.add(button); 
		button.addActionListener(open);
		
		JButton button2 = new JButton("Save");
		menubar.add(button2); 
		button2.addActionListener(save);
		
		setContentPane(content); 
		setJMenuBar(menubar); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// setTitle("Pinyin Text Editor"); 
		pack(); 
		setLocationRelativeTo(null); 
		setVisible(true); 
		
		textArea.addKeyListener(new AL());
	}
	
	public static void main(String[] args) {
		new TextEditor(); 
	}
	
	class openAction extends AbstractAction {
		public openAction() {
			super("Open..."); 
			putValue(MNEMONIC_KEY, new Integer('0')); 
		}
		
		public void actionPerformed(ActionEvent arg0) {
			int retval = filechooser.showOpenDialog(TextEditor.this);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File f = filechooser.getSelectedFile(); 
				try {
					FileReader reader = new FileReader(f); 
					textArea.read(reader, ""); 
				} catch (IOException e) {
					System.out.println(e); 
					System.exit(1); 
				}
			}
		}
	}
	
	class saveAction extends AbstractAction {
		public saveAction() {
			super("Save"); 
			putValue(MNEMONIC_KEY, new Integer('S')); 
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			int retval = filechooser.showOpenDialog(TextEditor.this);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File f = filechooser.getSelectedFile(); 
				try {
					FileWriter writer = new FileWriter(f); 
					textArea.write(writer);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(TextEditor.this, e);
					System.exit(1);
				}
			}
		}
	}
	
	// extends KeyAdapter ?? 
	class AL implements KeyListener {
		public void keyPressed(KeyEvent e) {

		}
		
		public void keyReleased(KeyEvent e) {

		}

		public void keyTyped(KeyEvent e) {
			if (e.getKeyChar() >= '1' && e.getKeyChar() <= '4' && textArea.getText().length() != 0) {
				char letter = textArea.getText().charAt(textArea.getText().length() - 1);
				if (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u') {
					textArea.setText("" + textArea.getText().substring(0, textArea.getText().length() - 1));
					textArea.append(map.get(letter + e.getKeyChar())); 
					e.consume();
				}
			}
		}
	}

}