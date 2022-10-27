/**
 * InterchangeStation is a child class of the station class that defines a station with multiple lines connecting
 * @author Edward Wang 
 */
public class InterchangeStation extends Station{
	
	private Station[] prevs;
	private Station[] nexts;
	
	//constructor
	public InterchangeStation(int stnNo, String stnName, int x, int y) {
		super(stnNo, stnName, x, y);
		this.prevs = new Station[2];
		this.nexts = new Station[2];
	}
	//getPrev from station
	public Station getPrev(){
		throw new StationException("InterchangeStation cannot use getPrev()");
		//return prev;
	}
	//getNext from station
	public Station getNext() {
		throw new StationException("InterchangeStation cannot use getNext()");
		//return next;
	}
	//setPrev from station
	public void setPrev(Station stn) {
		throw new StationException("InterchangeStation cannot use setPrev()");
		//prev = stn;
	}
	//setNext from station
	public void setNext(Station stn) {
		throw new StationException("InterchangeStation cannot use setNext()");
		//next = stn;
	}
	//overridden getPrev
	public Station getPrev(char lineLetter) {
		int index = (int)lineLetter - 65;
		if(index >= prevs.length){
	        prevs = expandStations(prevs, index);
	        return null;
		 } else {
			 return prevs[index];
		 }
		
	}
	//overridden getNext
	public Station getNext(char lineLetter) {
		int index = (int)lineLetter - 65;
		if(index >= nexts.length){
	        nexts = expandStations(nexts, index);
	        return null;
		 } else {
			 return nexts[index];
		 }
	}
	
	//overridden setPrev
    public void setPrev(Station stn, char lineLetter) {
        int index = (int)lineLetter - 65;
        if(index >= prevs.length){
        	prevs = expandStations(prevs, index);
            prevs[index] = stn;
            
        }else{
            prevs[index] = stn;
            
        }
    }
    //overridden setNext
    public void setNext(Station stn, char lineLetter) {
        int index = (int)lineLetter - 65;
            if(index >= nexts.length){
                nexts = expandStations(nexts, index);
                nexts[index] = stn;
                
            }else{
                nexts[index] = stn;
                
            }
    }
	
    // the following helper method is used to expand the capacity of the prevs and nexts arrays

    private Station[] expandStations(Station[] theArray, int toIndex) {
        Station[] temp = new Station[toIndex + 1];
        
        
        for (int i = 0; i < theArray.length; i++){
            temp[i] = theArray[i];
        }

        for(int i = theArray.length; i < temp.length; i++){
            temp[i] = null;
         
        }
        return temp;
    }
	
	public Station[] getPrevArray() {
		return prevs;
	}
	
	public Station[] getNextArray() {
		return nexts;
	}
	
	public String getPrevString() {
		String s = "";
		for(int i = 0; i < prevs.length; i++) {
			if(prevs[i] != null) {
				s += prevs[i].getStnNo() + "  ";
			} else {
				s += "__  ";
			}
		}
		return s;
	}
	
	public String getNextString() {
		String s = "";
		for(int i = 0; i < nexts.length; i++) {
			if(nexts[i] != null) {
				s += nexts[i].getStnNo() + "  ";
			} else {
				s += "__  ";
			}
		}
		return s;
	}
	
	public String toString() {
		String s = "Stn: " + getStnNo() + "(" + getName() + ") on Lines: ";
		for(int i = 0; i < prevs.length; i++) {
			
		}

		
		return s;
	} 
	
}














