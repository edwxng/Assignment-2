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
		int index = (int)lineLetter;
		return prevs[index];
		
	}
	//overridden getNext
	public Station getNext(char lineLetter) {
		int index = (int)lineLetter;
		return nexts[index];
	}
	//overridden setPrev
	public void setPrev(Station stn, char lineLetter) {
		int index = (int)lineLetter - 65;
		try {
			
			prevs[index] = stn;
		} catch (ArrayIndexOutOfBoundsException e) {
			expandNexts(index);
		}
	}
	//overridden setNext
	public void setNext(Station stn, char lineLetter) {
		int index = (int)lineLetter - 65;
		try {
			
			nexts[index] = stn;
		} catch (ArrayIndexOutOfBoundsException e) {
			expandPrevs(index);
		}
		
	}
	
	// the following two helper methods are used to expand the capacity of the prevs and nexts arrays
	private void expandPrevs(int index) {
		   Station[] temp = new Station[index + 1];
		   
		   for (int i = 0; i < prevs.length; i++){
		      temp[i] = prevs[i];
		   }
		   prevs = temp;
		}
	
	private void expandNexts(int index) {
		   Station[] temp = new Station[index + 1];
		   
		   for (int i = 0; i < nexts.length; i++){
		      temp[i] = nexts[i];
		   }
		   nexts = temp;
		}
	
	public Station[] getPrevArray() {
		return prevs;
	}
	
	public Station[] getNextArray() {
		return nexts;
	}
	
	public String getPrevString() {
		
	}
	
	
}
