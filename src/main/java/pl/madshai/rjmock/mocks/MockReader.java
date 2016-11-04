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

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;
import pl.madshai.rjmock.configuration.MocksConfiguration;
import pl.madshai.rjmock.exceptions.MocksException;
import pl.madshai.rjmock.mocks.mocks.ConditionModel;
import pl.madshai.rjmock.mocks.mocks.PackageModel;
import pl.madshai.rjmock.mocks.mocks.ResponseModel;

import java.util.List;
import java.util.Map;

/**
 * Created by daniel.madejek on 2016-11-03.
 */
public final class MockReader {

	@Autowired
	private MocksConfiguration mocksConfiguration;

	public ResponseModel readResponse(String requestURI, Map<String, String[]> parameters) throws MocksException {

		String category = MocksHelper.getCategoryFromUrl(requestURI);
		PackageModel packageModel = mocksConfiguration.retrieveMocksConfiguration(category);

		ResponseModel anyResponse = null;
		String subpathFromUrl = MocksHelper.getSubpathFromUrl(requestURI);
		List<ResponseModel> responses = packageModel.getResponses();
		for (ResponseModel response : responses) {
			if (response.getSubpath().equals(subpathFromUrl) && validConditions(parameters, response.getConditions())) {

				return response;
			}
			if (response.getSubpath().equals("_any_") && validConditions(parameters, response.getConditions())) {
				anyResponse = response;
			}
		}
		return anyResponse;
	}

	private boolean validConditions(Map<String, String[]> parameters, List<ConditionModel> conditions) {
		boolean toReturn;
		if (conditions == null || conditions.isEmpty()) {
			toReturn = true;
		} else {
			toReturn = compareParameters(parameters, conditions);
		}
		return toReturn;
	}

	private boolean compareParameters(Map<String, String[]> parameters, List<ConditionModel> conditions) {
		boolean toReturn = true;
		if (parameters.keySet().size() == conditions.size()) {
			for (ConditionModel condition : conditions) {
				String[] parametersArray = parameters.get(condition.getParam());
				if (ArrayUtils.isEmpty(parametersArray) || !parametersArray[0].equals(condition.getValue())) {
					toReturn = false;
					break;
				}
			}
		} else {
			toReturn = false;
		}
		return toReturn;
	}

}
