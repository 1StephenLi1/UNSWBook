import unswbook.methods.CheckSameWords;
public class test {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub
		String bullyBWords = "Beat up " + "Behavior " + "Belittle " + "Bias " + "Blase " + "Blindside " + "Boorish "+  "Bother " + "Braggart " + "Bully " + "Burden "  + "Bystander ";
		String post = "I dont want to bully him, that?s not bullying!";
		
		CheckSameWords checker = new CheckSameWords();
		System.out.println(bullyBWords);
		System.out.println(checker.SameWordsCheck(bullyBWords, post));
	}

}
