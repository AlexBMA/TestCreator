package xmlpack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Intrebare;
import model.Raspuns;
import model.Test;

public class XML {

	
	public static void saveXMLToateTestele(File xml,LinkedHashMap<String, Test> toateTestele)
	{
		Document doc = new Document();
		Element theRoot = new Element("toate_testele");
		
		doc.setRootElement(theRoot);
		
		int size =toateTestele.size();
		theRoot.setAttribute("numar_teste", Integer.toString(size));
		
		Element teste = new Element("teste");
		
		Set<String> Keys = toateTestele.keySet();
		
		for( String i: Keys)
		{
			
		}
	}
	
	public static void saveXMLTest(File xmlFile,Test test)
	{
		Document doc = new Document();
		Element theRoot = new Element("test_simplu");
		doc.setRootElement(theRoot);
		
		Element t = saveXMLHelperTest(test);
		theRoot.addContent(t);
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		
		
		try {
			xmlOutput.output(doc, new FileOutputStream(xmlFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Element saveXMLHelperTest(Test t)
	{
		Element test = new Element("test");
		
		Element idTest = new Element("id_test");
		idTest.addContent(t.getIdTest()+"");
		
		Element numeTest = new Element("nume_test");
		numeTest.addContent(t.getNumeTest());
		
		Element autorTest = new Element("autor_test");
		autorTest.addContent(t.getNumeCreator());
		
		Element nrIntrebari = new Element("numar_intrebari");
		nrIntrebari.addContent(t.getNrIntrebari()+"");
		
		Element  intrebari = new Element("intrebari");
		
		
		ArrayList<Intrebare> listaIntrebare = t.getListaIntrebari();
		int size = listaIntrebare.size();
		for( int j=0;j<size;j++)
		{
			Intrebare i= listaIntrebare.get(j);
			intrebari.addContent(saveXMLHelperIntrebari(i));
		}
		
		test.addContent(idTest);
		test.addContent(numeTest);
		test.addContent(autorTest);
		test.addContent(nrIntrebari);
		test.addContent(intrebari);
		
		System.out.println("S-a adaugat testul \t" );
		
		return test;
				
	}
	
	
	
	public static Element saveXMLHelperIntrebari(Intrebare i)
	{
		Element intreabre = new Element("intrebare");
		
		Element idIntrebare = new Element("id_Intreabre");
		idIntrebare.addContent(i.getIdIntrebare()+"");
		
		Element nrRaspunsuriCorecte = new Element("nr_Raspunsuri_Corecte");
		nrRaspunsuriCorecte.addContent(i.getNrRaspunsuriCorecte()+"");
		
		Element nrRaspunsuri = new Element("nr_Raspunsuri");
		nrRaspunsuri.addContent(i.getNrRaspunsuri()+"");
		
		Element raspunsuri = new Element("raspunsuri");
		
		
		ArrayList<Raspuns> listaRaspunsuri = i.getListaRapunsuri();
		int size = listaRaspunsuri.size();
		
		for(int j=0;j<size;j++)
		{
			Raspuns r = listaRaspunsuri.get(j);
			raspunsuri.addContent(saveXMLHelperRaspunsuri(r));
		}
		
		
		return intreabre;
	}
	
	public static Element saveXMLHelperRaspunsuri(Raspuns r)
	{
		Element raspuns = new Element("raspuns");
		
		Element idRaspuns = new Element("id_Raspuns");
		idRaspuns.addContent(r.getIdRaspuns()+"");
		
		Element textRaspuns = new Element("text_Raspuns");
		textRaspuns.addContent(r.getTextRaspuns());
		
		Element tipRaspuns = new Element("tip_Raspuns");
		tipRaspuns.addContent(r.getAdvFals()+"");
		
		raspuns.addContent(idRaspuns);
		raspuns.addContent(textRaspuns);
		raspuns.addContent(tipRaspuns);
		
		return raspuns;
	}
	
	public ArrayList<Test> loadXML()
	{
		
		return null;
	}
}
