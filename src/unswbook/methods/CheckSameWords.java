package unswbook.methods;


public class CheckSameWords {
	public boolean SameWordsCheck (String str1, String str2) {
		String[] s1 = str1.toLowerCase().replaceAll("[-+.^:,]","").split(" ");
		String[] s2 = str2.toLowerCase().replaceAll("[-+.^:,]","").split(" ");
		
		for(String s : s1){
		    for(String ss : s2){
		        if(ss.equals(s)){
		            return true;
		        }
		    }
		}
		return false;
 	}
}	
	

