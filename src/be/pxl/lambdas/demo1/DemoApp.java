package be.pxl.lambdas.demo1;

import java.util.function.Predicate;

public class DemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person dali = new Person("Salvator", "Dali");

		PersonNameFormatter myFormatter = new PersonNameFormatter() {

			@Override
			public String formatName(Person person) {
				return person.getFirstName().substring(0, 1) + ". " + person.getLastName().toUpperCase();
			}
		};

		/*
		 * PersonNameFormatter otherFormatter = (Person p) -> {return
		 * p.getLastName().toLowerCase(); };
		 */
		PersonNameFormatter otherFormatter = p -> p.getLastName().toLowerCase();
		//PersonNameFormatter otherFormatter = Person::getLastName; //nog kortere lambda expressie

		printName(myFormatter, dali);
		printName(otherFormatter, dali);
		
		Predicate<Person> myTest = t -> t.getFirstName().length() > 5;
		
		printNameSometimes(myTest, otherFormatter, dali);

	}

	private static void printName(PersonNameFormatter pnf, Person person){
		System.out.println(pnf.formatName(person));
	}

	private static void printNameSometimes(Predicate<Person> personTest, PersonNameFormatter pnf, Person person){
		if (personTest.test(person) ){
			System.out.println(pnf.formatName(person));
		}else{
			System.out.println("Persoon voldoet neit aan de voorwaarden");
		}
	}
}
