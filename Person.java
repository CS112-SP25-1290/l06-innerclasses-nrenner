public class Person implements Comparable<Person>
{
	/***** TODO: (Part 2) create helper inner class for Identity*****/

	// CONSTANT VARIABLES
	public static final String DEFAULT_NAME = "Jamie Doe";
	public static final String DEFAULT_PRONOUNS = "Jamie/Doe";
	public static final String DEFAULT_BACKGROUND = "Narnia";
	public static final int DEFAULT_PRIVILEGE = 100;

	// INSTANCE VARIABLES
	private String name;
	private Identity id;
	private int privilege;

	// CONSTRUCTORS	
	public Person(String name, Identity id, int privilege) {
		this.setAll(name, id, privilege);
	}
		
	public Person() {
		this(DEFAULT_NAME, new Identity(DEFAULT_PRONOUNS, DEFAULT_BACKGROUND), DEFAULT_PRIVILEGE);
	}
	
	public Person(Person original) {
		if(original == null) {
			throw new IllegalArgumentException("Cannot copy null obect in Person copy constructor");
		} else {
			this.setAll(original.name, original.getId(), original.privilege);
		}
	}

	// MUTATORS/SETTERS
	public void setName(String name) {
		this.name = name;
	}
	
	public Identity getId() {
		return this.id;
	}
	public void setId(Identity id){
		this.id = id;
	}

	public void setPronouns(String pronouns) {
		this.getId().setPronouns(pronouns);
	}

	public void setBackground(String background) {
		this.getId().setBackground(background);
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public void setAll(String name, Identity id, int privilege) {
		this.setPrivilege(privilege);
		this.setId(id);
		this.setName(name);
	}

	// ACCESSORS / GETTERS
	public String getName() {
		return this.name;
	}

	public int getPrivilege() {
		return this.privilege;
	}

	// OTHER REQUIRED METHODS
	@Override
	public String toString()
	{
		return "My name is "+ this.name + " ("+ this.getId().getPronouns() + ") and " + this.getId().getBackground() + "\n"
				+ "According to this calculator I ended up with "+ this.privilege + " estimated privilege points";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if(other == null || (!(other instanceof Person otherPerson))) {
		      return false;
		}

        return this.name.equals(otherPerson.name) && this.getId().getBackground().equals(otherPerson.getId().getBackground()) && this.getId().getPronouns().equals(otherPerson.getId().getPronouns())
			&& this.privilege == otherPerson.privilege;
	}


	// INTERFACE METHODS
	/***** TODO: (Part 1) override compareTo method to implement Comparable interface*****/

	@Override
	public int compareTo(Person otherPerson) {
		return Integer.compare(this.privilege, otherPerson.privilege);
	}


	public static class Identity {

		private String pronouns;
		private String background;

		public Identity() {}

		public Identity(String pronouns, String background) {
			this.pronouns = pronouns;
			this.background = background;
		}

		public String getPronouns() {
			return pronouns;
		}

		public void setPronouns(String pronouns) {
			this.pronouns = pronouns;
		}

		public String getBackground() {
			return background;
		}

		public void setBackground(String background) {
			this.background = background;
		}

		public String toString() {
			return "Identity: " + pronouns + ", " + background;
		}
	}
}

