package model;

public class Raspuns {

	
	private int idRaspuns;
	private String textRaspuns;
	private int advFals;

	
	
	public Raspuns(String textRaspuns, int advFals) {
		super();
		this.textRaspuns = textRaspuns;
		this.advFals = advFals;
	}

	public String getTextRaspuns() {
		return textRaspuns;
	}

	public void setTextRaspuns(String textRaspuns) {
		this.textRaspuns = textRaspuns;
	}

	public int getAdvFals() {
		return advFals;
	}

	public void setAdvFals(int advFals) {
		this.advFals = advFals;
	}

	public int getIdRaspuns() {
		return idRaspuns;
	}

	public void setIdRaspuns(int idRaspuns) {
		this.idRaspuns = idRaspuns;
	}

}
