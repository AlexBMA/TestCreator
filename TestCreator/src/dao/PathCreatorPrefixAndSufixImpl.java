package dao;

public class PathCreatorPrefixAndSufixImpl implements PathCreatorPrefixAndSufix{

	@Override
	public String createPath(String pageName) {
		
		//"WEB-INF/view/ProfPage.jsp"
		
		String prefix="WEB-INF/view/";
		String sufix=".jsp";
		String rez =prefix+pageName+sufix;
		return rez;
	}

}
