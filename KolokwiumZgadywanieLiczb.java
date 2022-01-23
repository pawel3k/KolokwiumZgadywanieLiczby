import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class KolokwiumZgadywanieLiczb extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JTextField liczba;
	JButton zgaduj;
	JTextField wynik;
	public int proby = 0;
    Random losowy = new Random();
	public int minimum = 0;
	public int maksimum = 100;
	public int losowaLiczba = losowy.nextInt(maksimum-minimum) + minimum;
	JLabel liczba_podpis;
	JLabel wynik_podpis;
	

	public static void main(String[] args) {
		
		KolokwiumZgadywanieLiczb frame = new KolokwiumZgadywanieLiczb();
		frame.initUI();

	}

	private void initUI() {
		
		liczba_podpis = new JLabel("Podaj liczbê:", SwingConstants.CENTER);
		liczba = new JTextField();
		zgaduj = new JButton("Zgaduj!");
		zgaduj.addActionListener(this);
		wynik_podpis = new JLabel("Twój wynik:", SwingConstants.CENTER);
		wynik = new JTextField();
		
		this.add(liczba_podpis);
		this.add(liczba);
		this.add(zgaduj);
		this.add(wynik_podpis);
		this.add(wynik);
		
		this.setLayout(new GridLayout(5, 1));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setSize(400, 600);
		this.setVisible(true);
		this.setTitle("Zgadywanie Liczby");
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(zgaduj.equals(e.getSource())) {		
		zgadywanie();
	}

}

	private void zgadywanie() {
		
		String pole_podana_liczba = liczba.getText();
		int podanaLiczba= Integer.parseInt(pole_podana_liczba);
		
		if (podanaLiczba > losowaLiczba) {
			
			proby++;
			wynik.setText("Mniejsza!");
			
		}
		
		else if (podanaLiczba < losowaLiczba) {
			
			proby++;
			wynik.setText("Wiêksza!");
			
		}
		
		else {
			
			wynik.setText("Brawo! Uda³o ci siê zgadn¹æ w: " + proby + " próbach!");
			
		}
		
	}
}
