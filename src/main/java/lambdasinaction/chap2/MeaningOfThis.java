package lambdasinaction.chap2;

public class MeaningOfThis
{
	public final int value = 4;
	public void doIt()
	{
		int value = 6;
		Runnable r = new Runnable(){
			public final int value = 5;
			public void run(){
				int value = 10;
				System.out.println(this.value);
			}
		};
		r.run(); 
	}
	public static void main(String...args)
	{       
		MeaningOfThis m = new MeaningOfThis();
		m.doIt();
		// output is 5
		// Because the result of println which is comes from Runnable class
		// Not MeaningOfThis class
		// It is in different Level class
	}
}
