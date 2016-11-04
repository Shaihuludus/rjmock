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

package pl.madshai.rjmock.controllers.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.madshai.rjmock.configuration.ApplicationConfiguration;
import pl.madshai.rjmock.exceptions.MocksException;
import pl.madshai.rjmock.mocks.MockReader;
import pl.madshai.rjmock.mocks.MocksResponseFileReader;
import pl.madshai.rjmock.mocks.mocks.ResponseModel;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller responsible for mock calls
 */
@RestController
public class MockController {

	private static final String RESPONSES_DIR = "responses/";

	@Autowired
	private MockReader mockReader;

	@Autowired
	private MocksResponseFileReader mocksResponseFileReader;

	@Autowired
	private ApplicationConfiguration applicationConfiguration;

	@RequestMapping(value = "/rjmock/**")
	public ResponseEntity mockResponse(HttpServletRequest request) {
		try {
			ResponseModel responseModel = mockReader.readResponse(request.getRequestURI(), request.getParameterMap());
			String response = null;
			if (responseModel.getType().equals("json")) {
				response = mocksResponseFileReader.readMockFile(
						applicationConfiguration.retrieveDataDirectory() + RESPONSES_DIR + responseModel
								.getResponse());
			}
			if (responseModel.getType().equals("text")) {
				response = responseModel.getResponse();
			}
			return ResponseEntity.status(responseModel.getCode()).body(response);
		} catch (MocksException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
