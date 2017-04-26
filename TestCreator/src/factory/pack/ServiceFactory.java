package factory.pack;

import services.BasicService;
import services.impl.AnswerServiceImpl;
import services.impl.QuestionServiceImpl;
import services.impl.TestServiceImpl;

public class ServiceFactory {
	
	
	public static BasicService  getService(String serviceName)
	{
		if(serviceName==null)
		{
			return null;	
		}
		if(serviceName.equalsIgnoreCase("Answer"))
		{
			return new AnswerServiceImpl();
		}
		if(serviceName.equalsIgnoreCase("Question"))
		{
			return new QuestionServiceImpl();
		}
		if(serviceName.equalsIgnoreCase("Test"))
		{
			return new TestServiceImpl();
		}
		
		
		return null;
		
		
	}

}
