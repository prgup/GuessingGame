import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField guessField;
	private JLabel info;
	private int theNumber;
	
	public void checkGuess() {
		String guessText = guessField.getText();
		String message = "";
		int guess = Integer.parseInt(guessText);
		if (guess < theNumber)
		message = guess + " is too low. Try again.";
		else if (guess > theNumber)
		message = guess + " is too high. Try again.";
		else
		message = guess + " is correct. You win!";
		info.setText(message);
		}
	
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
		}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel welcomeScreen = new JLabel("Hi - Lo Game On");
		welcomeScreen.setFont(new Font("TlwgTypewriter", Font.BOLD, 20));
		welcomeScreen.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeScreen.setBounds(17, 28, 413, 42);
		getContentPane().add(welcomeScreen);
		
		JLabel guessNum = new JLabel("Guess Your Number");
		guessNum.setHorizontalAlignment(SwingConstants.RIGHT);
		guessNum.setBounds(35, 98, 227, 37);
		getContentPane().add(guessNum);
		
		guessField = new JTextField();
		guessField.setBounds(297, 102, 114, 30);
		getContentPane().add(guessField);
		guessField.setColumns(10);
		
		JButton submitButton = new JButton("Guess!");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		submitButton.setBounds(160, 163, 117, 25);
		getContentPane().add(submitButton);
		
		info = new JLabel("Enter a number above and click Guess! ");
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setBounds(17, 216, 413, 30);
		getContentPane().add(info);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);

	}
}
