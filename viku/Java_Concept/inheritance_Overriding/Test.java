package inheritance_Overriding;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Animal a=new Animal();
		a.show();
		Dog d=new Dog();
		d.show();
		d.nshow();
		Animal c=new Dog();
		c.show();
		// c.nshow(); this show error bcz nshow is not override
		
		
		

	}

}
