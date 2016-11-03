package pl.madshai.rjmock.mocks;

import org.springframework.beans.factory.annotation.Autowired;
import pl.madshai.rjmock.configuration.MocksConfiguration;
import pl.madshai.rjmock.exceptions.MocksException;
import pl.madshai.rjmock.mocks.mocks.PackageModel;
import pl.madshai.rjmock.mocks.mocks.ResponseModel;

import java.util.List;

/**
 * Created by daniel.madejek on 2016-11-03.
 */
public final class MockReader {

	@Autowired
	private MocksConfiguration mocksConfiguration;

	public ResponseModel readResponse(String requestURI) throws MocksException {

		String category = MocksHelper.getCategoryFromUrl(requestURI);
		PackageModel packageModel = mocksConfiguration.retrieveMocksConfiguration(category);

		ResponseModel anyResponse = null;
		String subpathFromUrl = MocksHelper.getSubpathFromUrl(requestURI);
		List<ResponseModel> responses = packageModel.getResponses();
		for (ResponseModel response : responses) {
			if(response.getSubpath().equals(subpathFromUrl)){
				return response;
			}
			if(response.getSubpath().equals("_any_")){
				anyResponse = response;
			}
		}
		return anyResponse;
	}


}