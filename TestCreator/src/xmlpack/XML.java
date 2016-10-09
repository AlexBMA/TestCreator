package xmlpack;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import model.Intrebare;
import model.Raspuns;
import model.Test;

public class XML {

	
	public static void saveXMLToateTestele(File xmlFile,LinkedHashMap<String, Test> toateTestele)
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
			
			Test testTemp = toateTestele.get(i);
			Element t = saveXMLHelperTest(testTemp);
			teste.addContent(t);
		}
		theRoot.addContent(teste);
		
		XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
		
		
		try {
			xmlOutput.output(doc, new FileOutputStream(xmlFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		Element intrebare = new Element("intrebare");
		
		Element idIntrebare = new Element("id_Intrebare");
		idIntrebare.addContent(i.getIdIntrebare()+"");
		
		Element textIntrebare = new Element("text_Intrebare");
		textIntrebare.addContent(i.getTextIntrebare());
		
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
		
		intrebare.addContent(idIntrebare);
		intrebare.addContent(textIntrebare);
		intrebare.addContent(nrRaspunsuri);
		intrebare.addContent(nrRaspunsuriCorecte);
		intrebare.addContent(raspunsuri);
		
		
		return intrebare;
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
	
	public static LinkedHashMap<String, Test> incarcaToateTesteleDinXml(String filePath)
	{
		File fisier = new File(filePath);
		
		SAXBuilder builder = new SAXBuilder();
		
		Document readDoc;
		try {
			readDoc = builder.build(fisier);
			
			System.out.println("The root element: \t" + readDoc.getRootElement() + "\n");
			
			Element root = readDoc.getRootElement();

			System.out.println("Nr total de teste \t" + root.getAttributeValue("nr_teste") + "\n");
			
			LinkedHashMap<String, Test> toateTestele = new LinkedHashMap<>();
			
			
			for(Element currrentElem : root.getChildren())
			{
				
			}
			
			
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	public static void loadTestDinXML(Element currrentTest)
	{
		String numeTest = currrentTest.getChildText("nume_test");
		String numeCreator = currrentTest.getChildText("autor_test");
		int nrIntrebari = Integer.parseInt(currrentTest.getChildText("numar_intrebari"));
		int idTest = Integer.parseInt(currrentTest.getChildText("nid_test"));
		
		Test testTemp = new Test(numeTest, numeCreator, nrIntrebari);
		testTemp.setIdTest(idTest);
		
		Element listIntrebariElementXml=currrentTest.getChild("intrebari");
		
		ArrayList<Intrebare> listaIntrebari = new ArrayList<>();
		Intrebare intrabreTemp;
		
		for(Element currrentIntrebare : listIntrebariElementXml.getChildren())
		{
			loadIntreabreDinXML(currrentIntrebare);
		
		}
		
		
		
		testTemp.setListaIntrebari(listaIntrebari);
	}
	
	public static void loadIntreabreDinXML(Element currentIntreabre)
	{
		String textIntrebare=currentIntreabre.getChildText("text_Intrebare");
		int nrRaspunsuriCorecte=Integer.parseInt(currentIntreabre.getChildText("nr_Raspunsuri_Corecte"));
		int nrRaspunsuri=Integer.parseInt(currentIntreabre.getChildText("nr_Raspunsuri"));
		int idIntrebare = Integer.parseInt(currentIntreabre.getChildText("id_Intrebare"));
		
		
		ArrayList<Raspuns> listaRaspunsuri = new ArrayList<>();
		Raspuns raspunsTemp;
		
		Element listaCuRaspunsuriXML = currentIntreabre.getChild("raspunsuri");
		
		for(Element raspuns : listaCuRaspunsuriXML.getChildren())
		{
			
		}
		
		Intrebare intrebare = new Intrebare(textIntrebare, nrRaspunsuriCorecte, nrRaspunsuri, listaRaspunsuri);
		intrebare.setIdIntrebare(idIntrebare);
		
	}
	
	public static Raspuns loadRaspunsDinXML(Element currentRaspuns)
	{
		String textRaspuns="";
		int advFals=0;
		int idRaspuns=0;
		
		Raspuns raspuns = new Raspuns(textRaspuns, advFals);
		
		return raspuns;
		
	}
}
