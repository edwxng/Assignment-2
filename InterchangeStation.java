
public class InterchangeStation extends Station{
	
	private Station[] prevs;
	private Station[] nexts;
	
	
	public InterchangeStation(int stnNo, String stnName, int x, int y) {
		super(stnNo, stnName, x, y);
		this.prevs = new Station[1];
		this.nexts = new Station[1];
	}

	public Station getPrev(){
		throw new StationException("InterchangeStation cannot use getPrev()");
		//return prev;
	}
	
	public Station getNext() {
		throw new StationException("InterchangeStation cannot use getNext()");
		//return next;
	}
	
	public void setPrev(Station stn) {
		throw new StationException("InterchangeStation cannot use setPrev()");
		//prev = stn;
	}
	
	public void setNext(Station stn) {
		throw new StationException("InterchangeStation cannot use setNext()");
		//next = stn;
	}
	
	
}
