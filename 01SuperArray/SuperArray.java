public class SuperArray{

/*New and Improved edition w/ fixed size functionality and throwing actual errors*/

    private String[] data;
    private int size;

    public SuperArray(int inSize){
	size = 0;
	data = new String[inSize];
    }


    public void clear(){
	data = new String[data.length];
    }

    public int size(){
        return size;
    }
	
	public String[] getData(){
		return data;
	}

    public boolean add(String element){
	boolean stopIf = false;
	if( data[data.length - 1] != null){
		this.resize();
	}
    for( int stepper = 0; stepper < data.length && stopIf == false; stepper++){
		if (data[stepper] == null){
			data[stepper] = element;
			stopIf = true;
		}
	}
	size += 1;
	return true;
    }
	
	public String toString(){
    String stringVer = "[";
	for(int stepper = 0; stepper < data.length; stepper++){
		if( stepper < data.length - 1){
		    stringVer += data[stepper] + ", ";
		}
		else{
			stringVer += data[stepper];
		}
	}
	stringVer += "]";
	return stringVer;
	}
	
	public String get(int index){
		if( index < 0 || index >= data.length){
			System.out.println("Error, index out of range, returning null");
			return null;
		}
		else{
			return data[index];
		}
	}
	
	public String set(int index, String element){
		if( index < 0 || index >= data.length){
			throw new UnsupportedOperationException();
		}
		else{
			String oldElem = data[index];
			data[index] = element;
			return oldElem;
		}
	}

	/* PHASE II - RESIZE */
	
	public void resize(){
	String[] newData = new String[(data.length + 1) * 2];
	for( int stepper = 0; stepper < data.length; stepper++){
	    newData[stepper] = data[stepper];
	}
	data = newData;
    }
	
	/*------------------*/
	
	
	/*PHASE III*/
	
	public boolean contains( String element){
		boolean isPresent = false;
		for( int stepper = 0; stepper < data.length && isPresent == false; stepper++){
			if (data[stepper] == element){
				isPresent = true;
			}
		}
		return isPresent;
	}
	
	public int indexOf(String element){
		int isAt = -1;
		for( int stepper = data.length - 1; stepper >= 0; stepper--){
			if( data[stepper] == element){
				isAt = stepper;
			}
		}
		return isAt;
	}
	/* I realize that looping through the entire array for indexOf is unnessecary, however
	   I originally coded indexOf the way lastIndexOf is currently coded, and vice versa,
	   before realizing my mistake, and so it made more sense to simply switch them.*/
	
	public int lastIndexOf(String element){
		int isAt = -1;
		for( int stepper = 0; stepper < data.length; stepper++){
			if( data[stepper] == element){
				isAt = stepper;
			}
		}
		return isAt;
	}
	
	public void add(int index, String element){
		if( index < 0 || index >= data.length){
			this.add(element);
		}
		else{
	    if( data[data.length - 1] != null){
		    this.resize();
	    }
		String[] newData = new String[data.length];
	    for( int stepper = 0; stepper < index; stepper++){
	        newData[stepper] = data[stepper];
	    }
		for( int stepper = index; stepper < data.length - 1; stepper++){
			newData[stepper + 1] = data[stepper];
		}
		newData[index] = element;
	    data = newData;
		size += 1;
		}
	}
	public String remove(int index){
		if( index < 0 || index >= data.length){
			System.out.println("Error, index out of range, returning null");
			return null;
		}
		else{
			String[] newData = new String [data.length - 1];
			for( int stepper = 0; stepper < index; stepper++){
	            newData[stepper] = data[stepper];
	        }
			for( int stepper = index; stepper < data.length - 2; stepper++){
			    newData[stepper] = data[stepper + 1];
			}
			String oldElem = data[index];
			data = newData;
			size -= 1;
			return oldElem;
		}
	}
	
	public boolean remove(String element){
		if( this.contains(element)){
			int isAt = this.indexOf(element);
			this.remove(isAt);
			return true;
		}
		else{
			return false;
		}
	}
		
	
}
