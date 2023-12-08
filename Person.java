package de.unistuttgart.iste.sqa.pse.sheet07.homework.immutable;

import de.unistuttgart.iste.sqa.pse.sheet07.homework.painter.PainterPauleHamsterGame;

import java.util.Calendar;
import java.util.Date;

/**
 * Represents a person with a name and birthdate.
 *
 * @author your name
 */
public final class Person { //final added
	// @ private instance invariant name != null && name.length() > 0;
	// @ private instance invariant birthDate != null;

	private final String name;  //final added, priavte machen
	private final Date birthDate; //final added

	/*@
	@ requires name != null && name.length() > 0;
	@ requires birthDate != null;
	@ ensures this.name == name;
	@ ensures this.birthDate == birthDate;
	@*/


	/**
	 * Creates a new person with the given name and birthdate.
	 *
	 * @param name      Name of the person.
	 * @param birthDate Birth date of the person.
	 */
	public Person(final String name, final Date birthDate) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("A person may not have a null or empty name");
		}
		if (birthDate == null) {
			throw new IllegalArgumentException("A person's birth date must not be null.");
		}
		final Date birthDateCopy = new Date(birthDate.getYear(),birthDate.getMonth(),birthDate.getDate()); // soll auf birthDate zugreifen, weiß noch nicht ganz wie
		this.name = name;
		this.birthDate = birthDateCopy;
	}

	/**
	 * @return This person's name.
	 */
	public /*@ pure @*/ String getName() { //Strings are already immutable

		return name;
	}

	/**
	 * @return This person's birth date.
	 */
	public /*@ pure @*/ Date getBirthDate() {
		final Date birthDateCopy = new Date(birthDate.getYear(),birthDate.getMonth(),birthDate.getDate());
		return birthDateCopy;
	}
	public static void main(final String[] args) {
	Date birthDate = new Date(2004 - 1900, Calendar.MARCH, 26) ;
	Person jonas = new Person("Jonas", birthDate);
	System.out.println(jonas.getName());
	System.out.println(jonas.getBirthDate());
	}
}

