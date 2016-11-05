/*
 * Copyright (c) 2016. Daniel Madejek
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

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
 * Bean that reads from selected response file
 */
public class MocksResponseFileReader {

	private Gson gson = new GsonBuilder().create();

	/**
	 * Reads file
	 * @param path path to file
	 * @return file content as String
	 * @throws MocksException
	 */
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
