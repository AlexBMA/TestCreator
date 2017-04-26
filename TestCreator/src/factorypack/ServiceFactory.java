package factorypack;

import services.BasicService;
import servicesimpl.AnswerServiceImpl;
import servicesimpl.QuestionServiceImpl;
import servicesimpl.TestServiceImpl;

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
