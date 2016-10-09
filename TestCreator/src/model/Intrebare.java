package model;

import java.util.ArrayList;

public class Intrebare {

	private int idIntrebare;
	private String textIntrebare;
	private int nrRaspunsuriCorecte;
	private int nrRaspunsuri;

	private ArrayList<Raspuns> listaRapunsuri;

	public Intrebare() {
		this.idIntrebare=0;
		this.textIntrebare = "";
		this.nrRaspunsuriCorecte = 0;
		this.nrRaspunsuri = 0;
		listaRapunsuri = new ArrayList<>();
	}

	public Intrebare(String textIntrebare, int nrRaspunsuriCorecte, int nrRaspunsuri,
			ArrayList<Raspuns> listaRaspunsuri) {
		super();
		this.textIntrebare = textIntrebare;
		this.nrRaspunsuriCorecte = nrRaspunsuriCorecte;
		this.nrRaspunsuri = nrRaspunsuri;
		this.listaRapunsuri = listaRaspunsuri;
	}

	public String getTextIntrebare() {
		return textIntrebare;
	}

	public void setTextIntrebare(String textIntrebare) {
		this.textIntrebare = textIntrebare;
	}

	public int getNrRaspunsuriCorecte() {
		return nrRaspunsuriCorecte;
	}

	public void setNrRaspunsuriCorecte(int nrRaspunsuriCorecte) {
		this.nrRaspunsuriCorecte = nrRaspunsuriCorecte;
	}

	public ArrayList<Raspuns> getListaRapunsuri() {
		return listaRapunsuri;
	}

	public void setListaRapunsuri(ArrayList<Raspuns> listaRapunsuri) {
		this.listaRapunsuri = listaRapunsuri;
	}

	public int getNrRaspunsuri() {
		return nrRaspunsuri;
	}

	public void setNrRaspunsuri(int nrRaspunsuri) {
		this.nrRaspunsuri = nrRaspunsuri;
	}

	public int getIdIntrebare() {
		return idIntrebare;
	}

	public void setIdIntrebare(int idIntrebare) {
		this.idIntrebare = idIntrebare;
	}

	
	
}
