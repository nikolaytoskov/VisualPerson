import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class MainVisual extends JFrame{

	private static final long serialVersionUID = 1L;
	
	PersonHashMaps myMap = new PersonHashMaps();
	JTextField fNameField = new JTextField("Import First Name",20);
	JTextField lNameField = new JTextField("Import Last Name",20);
	JTextField ageNameField = new JTextField("Set Age",20);
	JTextField mailField = new JTextField("Add Mail",20);
	String[] comboContentGender = {" ","Mail", "Female"};
	JComboBox genderCombo = new JComboBox(comboContentGender);
	JButton addButton = new JButton("ADD");
	JButton printButton = new JButton("Print");
	JButton printAllButton = new JButton("Print All");
	
	
	public MainVisual(){
		super();
		init();
	}// End Constructor
	
	public void init(){
		this.setSize(300, 300); // ukazwam razmera na prozoreca
		this.setLayout(new FlowLayout()); //ukazvam kak da formatira poletata
		this.setResizable(false); // da ne promenq avtomati4no razmera na prozoreca
		this.add(fNameField); //vizualiziram poletata
		this.add(lNameField); //vizualiziram poletata
		this.add(ageNameField); //vizualiziram poletata
		this.add(mailField);
		this.add(genderCombo); //padashto menu za pol
		this.add(addButton);
		this.add(printButton);
		this.add(printAllButton);
		addButton.addActionListener(new AddAction());	// dobawqne na action na butona
		printButton.addActionListener(new PrintAction()); // dobavqm slushatel na sabitie
		printAllButton.addActionListener(new PrintAllAction()); // dobavqm slushane za sabitie pri natiskane na butona
	}// End Initilozation
	
	public void clearForm(){
		fNameField.setText("");
		lNameField.setText("");
		mailField.setText("");
		ageNameField.setText("");
		genderCombo.setSelectedIndex(0);
	}// SYZDAVAME KLAS za iz4istvane na formata, sled dobawqne na chovwek
	
	class AddAction implements ActionListener{  // direktno implementirame class, koito ni e za ekshana na butona otgore
    
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String fName = fNameField.getText(); // vziamme texta ot poletata s tozi action, toest iz4itame kakwo e vavel potrebitelq
			String lName = lNameField.getText(); // vziamme texta ot poletata s tozi action, toest iz4itame kakwo e vavel potrebitelq
			String mail = mailField.getText();   // vziamme texta ot poletata s tozi action, toest iz4itame kakwo e vavel potrebitelq
		    int age = Integer.parseInt(ageNameField.getText()); //preobrazuvame stringa ot poleto za goditi w chislo
		    
		    char gender;
		    int index = genderCombo.getSelectedIndex(); // vzimame indexa, koito potrebitelq e izbral za pol
		       if(index == 1){ // ako e izbral pyrvi index, toest "man"
		    	   gender = 'm';
		       }
		       else{
		    	   gender = 'f';
		       }
		      
		     Person temp = new Person(fName, lName, gender, age, mail);
		     myMap.addPerson(temp);
		     myMap.printPersonInfo(mail);
		     clearForm();// dobavqme ekshan za izchistwane na formata
			
		}
		
	}
	
	class PrintAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String mail = mailField.getText();  // chetem kljuchovoto pole
			myMap.printPersonInfo(mail);
			
		}
		
	}
	
	class PrintAllAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			myMap.printAllPerson(); 
			
		}// vikame ot PersonHashMaps metoda, kojto obhojda zapisite i gi pe4ata
		
	}
	
	public static void main(String[] args) {
		
		MainVisual myFrame = new MainVisual();
		myFrame.setVisible(true);
		myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
}
