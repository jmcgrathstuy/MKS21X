public class ReversedCharSeq implements CharSequence{
	
	private String curStr;

    public ReversedCharSeq(String str){
		curStr = reverseThisPlease(str);
    }


    public static String reverseThisPlease(String str){
	    String newWord = "";
	    for( int stepper = str.length() - 1; stepper >= 0; stepper--){
			newWord += str.charAt(stepper);
	    }
		return newWord;
	}
	
	private String getCurStr(){
		return curStr;
	}
	

    public char charAt(int index){
		return curStr.charAt(index);
    }
	
	public int length(){
		return curStr.length();
	}
	
	public ReversedCharSeq subSequence(int start, int end){
		ReversedCharSeq mid = new ReversedCharSeq(this.toString().substring(start, end));
		ReversedCharSeq toReturn = new ReversedCharSeq(mid.toString());
		return toReturn;
	}
	
	public String toString(){
		return this.getCurStr();
	}

	
	public static void main(String[] args){
		ReversedCharSeq a = new ReversedCharSeq("32zel");
		System.out.println(a.charAt(0));
		System.out.println(a.toString());
		System.out.println(a.length());
		System.out.println(a.subSequence(1, 3));
		ReversedCharSeq b = new ReversedCharSeq("voidreaver");
		System.out.println(b.charAt(3));
		System.out.println(b.toString());
		System.out.println(b.length());
		System.out.println(b.subSequence(2, 6));
		
	}
	
	
	
}


