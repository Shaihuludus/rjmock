package pl.madshai.rjmock.mocks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import pl.madshai.rjmock.exceptions.MocksException;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by daniel.madejek on 2016-11-03.
 */
public class MocksResponseReader {

	private Gson gson = new GsonBuilder().create();

	public String readMockFile(String path) throws MocksException {
		File mockFile = new File(path);
		if (mockFile.exists()) {
			try {
				return FileUtils.readFileToString(mockFile, Charset.defaultCharset());
			} catch (IOException e) {
				throw new MocksException(e);
			}
		}
		return StringUtils.EMPTY;
	}

}
