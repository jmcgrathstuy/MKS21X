import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch{
	
	//VARIABLES//
    private char[][]data;
	private char[][]answers;
	private ArrayList<String> wordsToAdd;
	private ArrayList<String> wordsAdded;
	private Random randgen;
	private String listWords;
    //-----//
	
	

	
	//-CONSTRUCTORS-//
    public WordSearch(int rows,int cols){//Super basic constructor, just makes an empty grid.
		data = new char[rows][cols];
		for( int stepper = 0; stepper < rows; stepper++){
			for( int stepperToo = 0; stepperToo < cols; stepperToo++){
				data[stepper][stepperToo] = '_';
			}
		}
    }
	
	
	public WordSearch(int rows,int cols, String fileName){
		data = new char[rows][cols];
		wordsToAdd = new ArrayList<String>();
		wordsAdded = new ArrayList<String>();
		randgen = new Random();
		listWords = "";
		for( int stepper = 0; stepper < rows; stepper++){
			for( int stepperToo = 0; stepperToo < cols; stepperToo++){
				data[stepper][stepperToo] = '_';
			}
		}
		try{
			File f = new File(fileName);
			Scanner in = new Scanner(f);
			while(in.hasNext()){
			    String word = in.next();
			    wordsToAdd.add(word.toUpperCase());
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found:" + fileName);
			//e.printStackTrace();
			System.exit(1);
		}
		addAllWords();
		for( int stepper = 0; stepper < rows; stepper++){
			for( int stepperToo = 0; stepperToo < cols; stepperToo++){
				if(data[stepper][stepperToo] == '_'){
					data[stepper][stepperToo] = Character.toUpperCase((char)(randgen.nextInt(26) + 'a'));
				}
			}
		}
		for( int stepper = 0; stepper < wordsAdded.size() ; stepper++){
			listWords += wordsAdded.get(stepper) + " ";
			if( stepper % 3 == 2){
				listWords += "\n";
			}
		}
    }
	
	
	public WordSearch(int rows,int cols, String fileName, int randSeed){//Functionally the same as the previous constructor, except using a given seed instead of a random one. Also allows for accessing the answer key.
		data = new char[rows][cols];
		wordsToAdd = new ArrayList<String>();
		wordsAdded = new ArrayList<String>();
		randgen = new Random(randSeed);
		listWords = "";
		
		for( int stepper = 0; stepper < rows; stepper++){
			for( int stepperToo = 0; stepperToo < cols; stepperToo++){
				data[stepper][stepperToo] = '_';
			}
		}
		try{
			File f = new File(fileName);
			Scanner in = new Scanner(f);
			while(in.hasNext()){
			    String word = in.next();
			    wordsToAdd.add(word.toUpperCase());
			}
		}catch(FileNotFoundException e){
			System.out.println("File not found:" + fileName);
			//e.printStackTrace();
			System.exit(1);
		}
		addAllWords();
		answers = makeNewData();
		for( int stepper = 0; stepper < rows; stepper++){
			for( int stepperToo = 0; stepperToo < cols; stepperToo++){//Adds the trick letters
				if(data[stepper][stepperToo] == '_'){
					data[stepper][stepperToo] = Character.toUpperCase((char)(randgen.nextInt(26) + 'a'));
				}
			}
		}
		for( int stepper = 0; stepper < wordsAdded.size() ; stepper++){//Constructs list of words
			listWords += wordsAdded.get(stepper) + " ";
			if( stepper % 3 == 2){
				listWords += "\n";
			}
		}
    }
	//-----//
	
	
	
	
	//HELPER FUNCTIONS AND ACCESSOR METHODS//
	private char[][] makeNewData(){//Helper function utilized by our AddWord methods. Ensures that failed attempts to add words don't make any changes to data.
		char[][] newData = new char[data.length][data[0].length];
		for( int stepper = 0; stepper < data.length; stepper++){
			for( int stepperToo = 0; stepperToo < data[0].length; stepperToo++){
				newData[stepper][stepperToo] = data[stepper][stepperToo];
			}
		}
		return newData;
	}
	
	
	public String getList(){
		return listWords;
	}
	
	
	public String getAnswers(){
		String toReturn = "";
		for( int stepper = 0; stepper < answers.length; stepper++){
			for( int stepperToo = 0; stepperToo < answers[0].length; stepperToo++){
				toReturn += " " + answers[stepper][stepperToo];
			}
			toReturn += "\n";
		}
		return toReturn;
	}
	
	
    private void clear(){
		for( int stepper = 0; stepper < data.length; stepper++){
			for( int stepperToo = 0; stepperToo < data[0].length; stepperToo++){
				data[stepper][stepperToo] = '_';
			}
		}
    }
    //-----//
	
	
	
	
    //toString//
    public String toString(){
		String toReturn = "";
		for( int stepper = 0; stepper < data.length; stepper++){
			for( int stepperToo = 0; stepperToo < data[0].length; stepperToo++){
				toReturn += " " + data[stepper][stepperToo];
			}
			toReturn += "\n";
		}
		return toReturn;
    }
    //-----//
	
	

	
    //ADD WORD METHODS//
    public boolean addWordHorizontal(String word,int row, int col){
		char[][] newData = makeNewData();
		if( word.length() > data[0].length - col){
			return false;
		}
		for( int stepperRow = col, stepperWord = 0; stepperWord < word.length(); stepperRow++, stepperWord++){
			if( newData[row][stepperRow] != '_' &&  newData[row][stepperRow] != word.charAt(stepperWord)){
				return false;
			}
			newData[row][stepperRow] = word.charAt(stepperWord);
		}
		data = newData;
		return true;
    }
	
	
    public boolean addWordVertical(String word,int row, int col){
		char[][] newData = data;
		if( word.length() > data.length - row){
			return false;
		}
		for( int stepperCol = row, stepperWord = 0; stepperWord < word.length(); stepperCol++, stepperWord++){
			if( newData[stepperCol][col] != '_' &&  newData[stepperCol][col] != word.charAt(stepperWord)){
				return false;
			}
			newData[stepperCol][col] = word.charAt(stepperWord);
		}
		data = newData;
		return true;
    }
	
	
    public boolean addWordDiagonal(String word,int row, int col){
		char[][] newData = makeNewData();
		if( word.length() > data.length - row || word.length() > data[0].length - col){
			return false;
		}
		for( int stepperDown = row, stepperRight = col, stepperWord = 0; stepperWord < word.length() && stepperDown < word.length(); stepperDown++, stepperRight++, stepperWord++){
			if( newData[stepperDown][stepperRight] != '_' && newData[stepperDown][stepperRight] != word.charAt(stepperWord)){
				return false;
			}
			newData[stepperDown][stepperRight] = word.charAt(stepperWord);
		}
		data = newData;
		return true;
    }
	
	
	public boolean addWord( int row, int col, String word, int rowIncrement, int colIncrement){
		char[][] newData = makeNewData();
		if((rowIncrement > 1 || rowIncrement < -1) || (colIncrement > 1 || colIncrement < -1)){
			return false;
		}
		if( (rowIncrement == 1 && word.length() > data.length - row)){
			return false;
		}
		if( (colIncrement == 1 && word.length() > data[0].length - col)){
			return false;
		}
		if( (colIncrement == -1 && word.length() > col + 1)){
			return false;
		}
		if( (rowIncrement == -1 && word.length() > row + 1)){
			return false;
		}
		if( (rowIncrement == 0 && colIncrement == 0)){
			return false;
		}
		for( int stepperDown = row, stepperRight = col, stepperWord = 0; stepperWord < word.length(); stepperDown += rowIncrement, stepperRight += colIncrement, stepperWord++){
			if( newData[stepperDown][stepperRight] != '_' && newData[stepperDown][stepperRight] != word.charAt(stepperWord)){
				return false;
			}
			newData[stepperDown][stepperRight] = word.charAt(stepperWord);
		}
		data = newData;
		return true;
	}
	
	
	private boolean addAllWords(){
		int[] ourInts = {-1, 0, 1};
		for( int numTries = 0; numTries < 5000; numTries++){
			for( int wordTries = 0; wordTries < 500; wordTries++){
				if( wordsToAdd.size() == 0){
				return true;
			    }
			    if( addWord( randgen.nextInt(data.length), randgen.nextInt(data[0].length), wordsToAdd.get(0), ourInts[randgen.nextInt(3)], ourInts[randgen.nextInt(3)])){
				    wordsAdded.add(wordsToAdd.get(0));
				    wordsToAdd.remove(0);
			    }
			    else if( wordTries == 499){
				    wordsToAdd.remove(0);
			    }
			}
	    }
		return true;
	}
	//-----//
	
	
	
	
	//MAIN//
	public static void main(String[] args){
		boolean badArgs = false;
		if( args.length < 3){
			System.out.println("\nWoah there, pal. You're gonna need to give me some more info!\nParameters are as follows: Row Size, Column Size, Filename, Seed, Answer Key\nRow Size, Column Size, and Seed must be integers.\nAnswer Key takes only the word 'key', in which case the answers will also be shown.\nRow Size, Column Size, and Filename are all mandatory.");
		}
		if(args.length >= 3){
			try{
			    Integer.parseInt(args[0]);
			    Integer.parseInt(args[1]);
				if(args.length > 3){
					Integer.parseInt(args[3]);
				}
		    }catch(NumberFormatException e){
			    System.out.println("\nThe first, second, and fourth arguments MUST be integers.\nFor more instructions regarding the parameters, enter 'java WordSearch'.");
			    badArgs = true;
		    }
		}
		if( args.length == 3 && badArgs == false){
			WordSearch newPuz = new WordSearch(Integer.parseInt(args[0]) ,Integer.parseInt(args[1]) , args[2]);
			System.out.println(newPuz);
			System.out.println("\nWords to Find:");
			System.out.println(newPuz.getList());
		}
		if( args.length == 4 && badArgs == false){
			WordSearch newPuz = new WordSearch(Integer.parseInt(args[0]) ,Integer.parseInt(args[1]) , args[2], Integer.parseInt(args[3]));
			System.out.println(newPuz);
			System.out.println(newPuz.getList());
		}
		if( args.length == 5 && badArgs == false){
			WordSearch newPuz = new WordSearch(Integer.parseInt(args[0]) ,Integer.parseInt(args[1]) , args[2], Integer.parseInt(args[3]));
			System.out.println(newPuz);
			System.out.println("\nWords to Find:");
			System.out.println(newPuz.getList());
			if( args[4].compareTo("key") == 0){
				System.out.println("\nAnswer Key:");
			    System.out.println(newPuz.getAnswers());
			}
		}
	}
	//-----//
	
}