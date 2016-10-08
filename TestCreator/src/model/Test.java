package model;

import java.util.ArrayList;

public class Test {

	private int idTest;
	private String numeTest;
	private String numeCreator;
	private int nrIntrebari;
	private ArrayList<Intrebare> listaIntrebari;

	public Test(String numeTest, String numeCreator, int nrIntrebari) {
		this.numeTest = numeTest;
		this.numeCreator = numeCreator;
		this.nrIntrebari = nrIntrebari;
		this.idTest=0;
		listaIntrebari = new ArrayList<>();
	}

	public String getNumeCreator() {
		return numeCreator;
	}

	public void setNumeCreator(String numeCreator) {
		this.numeCreator = numeCreator;
	}

	public String getNumeTest() {
		return numeTest;
	}

	public void setNumeTest(String numeTest) {
		this.numeTest = numeTest;
	}

	public ArrayList<Intrebare> getListaIntrebari() {
		return listaIntrebari;
	}

	public void setListaIntrebari(ArrayList<Intrebare> listaIntrebari) {
		this.listaIntrebari = listaIntrebari;
	}

	public int getNrIntrebari() {
		return nrIntrebari;
	}

	public void setNrIntrebari(int nrIntrebari) {
		this.nrIntrebari = nrIntrebari;
	}

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}
	

}
