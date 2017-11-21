public class OrderedSuperArray extends SuperArray{

  public OrderedSuperArray(){
      super(0);
  }
  
  public OrderedSuperArray(int capacity){
	  super(capacity);
  }
  
  public OrderedSuperArray(String[] ary){
	  super(ary.length);
	  for( int stepper = 0; stepper < ary.length; stepper++){
		  this.add(ary[stepper]);
	  }
  }
  
 
  public void add(int index, String value){
      super.add(index, value);
  }

  public boolean add(String val){
	  for(int stepper = 0; stepper < size(); stepper++){
		  if( val.compareTo(get(stepper)) < 1){
			  this.add(stepper, val);
			  return true;
		  }
		  if( stepper == size() - 1){
			  this.add(stepper + 1, val);
			  return true;
		  }
	  }
	  return false;
  }
  
			  


}
