package services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import model.Intrebare;
import model.Test;
import xmlpack.XMLXervices;

public class TestServices {

	private static LinkedHashMap<String, Test> toateTestele;

	public static void createTest(String numeTest, String numeCreator, int nrIntrebari) {

		Test t = new Test(numeTest, numeCreator, nrIntrebari);
		if (toateTestele == null)
			toateTestele = new LinkedHashMap<>();

		toateTestele.put(numeTest, t);
	}

	public static void addIntrebariLaTest(ArrayList<Intrebare> listaIntrebari, String numeTest) {
		toateTestele.get(numeTest).setListaIntrebari(listaIntrebari);

	}

	public static LinkedHashMap<String, Test> getToateTestele() {
		return  toateTestele;
	}

	private static Test getTestCurent(String numeTest) {
		Test temp = toateTestele.get(numeTest);
		return temp;
	}

	public static String getNumeAutor(String numeTest) {

		return getTestCurent(numeTest).getNumeCreator();
	}

	public static int getNumarIntrebari(String numeTest) {
		return getTestCurent(numeTest).getNrIntrebari();
	}

	public void deleteTest() {

	}

	public void editTest() {

	}

	public static void salvezaTesteInXml(String filePath) {
		String fileName = "Test.xml";

		File xmlFile = new File(filePath + "\\" + fileName.substring(fileName.lastIndexOf("\\") + 1));
		System.out.println(xmlFile.getAbsolutePath());

		if (toateTestele == null)
			System.out.println(" toate teste null");
		else
			XMLXervices.saveXMLToateTestele(xmlFile, toateTestele);

	}

	public static void incarcaTestDinXml(String filePath) {
		
		toateTestele = XMLXervices.incarcaToateTesteleDinXml(filePath);

	}

	public static void afis() {
		Set<String> keys = toateTestele.keySet();

		for (String k : keys) {
			Test t = toateTestele.get(k);
			System.out.println(k + "  key");
			System.out.println(t.getNumeTest());
			System.out.println(t.getIdTest() + "  $$$$");
			System.out.println(t.getNumeCreator());

			
		}

	}
}
