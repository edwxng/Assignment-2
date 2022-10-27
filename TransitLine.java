
public class TransitLine {
	private char lineLetter;
	private Station firstStn;
	
	public TransitLine(char letter, Station first) {
		lineLetter = letter;
		firstStn = first;
	}
	
	public char getLineLetter() {
		return lineLetter;
	}
	
	public Station getFirstStn() {
		return firstStn;
	}
	
	public boolean hasNext(Station stn) {
		if(stn instanceof InterchangeStation) {
			if(((InterchangeStation) stn).getNext(getLineLetter()) == null) {
				return false;
			} else {
				return true;
			}
		}else if(stn.getNext() == null) {
			return false;
		} else {
			return true;
		}
	}

	public void addStation(Station stn) {
		Station currStn = getFirstStn();
		while(hasNext(currStn) == true) {
			if(currStn instanceof InterchangeStation) {
				currStn = ((InterchangeStation) currStn).getNext(getLineLetter());
			} else {
				currStn = currStn.getNext();
			}
		}
		
		if(stn instanceof InterchangeStation) {
			if(currStn instanceof InterchangeStation) {
				((InterchangeStation) currStn).setNext(stn, getLineLetter());
			} else {
				currStn.setNext(stn);
			}
			((InterchangeStation) stn).setPrev(currStn, getLineLetter());
			((InterchangeStation) stn).setNext(null, getLineLetter());
		} else {
			if(currStn instanceof InterchangeStation) {
				((InterchangeStation) currStn).setNext(stn, getLineLetter());
			} else {
				currStn.setNext(stn);
			}
			stn.setPrev(currStn);
			stn.setNext(null);
		}
		
	}
	
	public String toString() {
		String s = "Line " + getLineLetter() + ": " + getFirstStn() + " ";
		
		
		
		return s;
	}

}
