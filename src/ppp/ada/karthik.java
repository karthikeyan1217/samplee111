package ppp.ada;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.Test;

public class karthik  {


		@Override
		public boolean retry(ITestResult result) {
			int maxRetry = 3;
			int retry = 1;

			if (!result.isSuccess()) { //false
				if (retry < maxRetry) {
					retry = retry + 1;
					return true;
				}
			}

			return false;

		}

		@Test(retryAnalyzer = retry.clas.RetryAnalyser.class)
		public void dad() {
			System.out.println("ad");
			Assert.assertEquals(false, true);
		}

	}
		
		
		
		
		
		
		
		
		
		
	

}


