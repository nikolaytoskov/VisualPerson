import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


public class PersonHashMaps {
	
	private HashMap<String, Person> myMap = new HashMap<String, Person>();
	
	public void addPerson(Person p){   
		myMap.put(p.getMail(), p);
	}// dobavqne na chovek
	
	public void removePerson(String key){ 
		myMap.remove(key);
	} //iztrivane po kluch
	
	public void printPersonInfo(String key){
		Person temp = myMap.get(key);       // sazdavame vremenen obekt, w koito da sybirame infoto, koeto ni trqbwa za pechat
		if(temp != null){                  // ako temp e razlichno ot null, pechatai
			System.out.println(temp.getFirstName());
			System.out.println(temp.getLastName());
			System.out.println(temp.getSex());
			System.out.println(temp.getAge());
		}
		else{
			System.out.println("Try with deferent e-mail!"); // AKO NE SA6TESTWUWA TAKAW MAIL
		}
	}
	
	public void printAllPerson(){
		Collection<Person> col = myMap.values();  //sazdavam kolekciaq za obhojdane za izvejdane na vsi4ki zapisi
		Iterator<Person> it = col.iterator();
		Person temp;
		while(it.hasNext()){ // pro4eti sledva6toto
			temp = it.next();  // vzimame poredniq element
			printPersonInfo(temp.getMail());
			System.out.println(".............................");
		}
	}

}// end Person HeshMap
