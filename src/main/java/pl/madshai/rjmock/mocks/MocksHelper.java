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

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.util.UriComponentsBuilder;
import pl.madshai.rjmock.mocks.mocks.ResponseModel;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper class for retrieving information from url
 */
public final class MocksHelper {

	private static final String RJMOCK = "/rjmock/";

	private MocksHelper(){
		//empty for helper class
	}

	/**
	 * Get category
	 * @param url
	 * @return
	 */
	public static String getPackageFromUrl(String url){
		String removeFirstSlash = StringUtils.substringAfter(url, RJMOCK);
		return StringUtils.substringBefore(removeFirstSlash, "/");
	}

	/**
	 * Get subpath
	 * @param url
	 * @return
	 */
	public static String getSubpathFromUrl(String url){
		String removeFirstSlash = StringUtils.substringAfter(url, RJMOCK);
		String subpath = StringUtils.substringAfter(removeFirstSlash, "/");
		if(subpath.contains("?")){
			subpath = StringUtils.substringBefore(subpath,"?");
		}
		return subpath;
	}

	public static ResponseModel createEmptyResponse() {
		ResponseModel toReturn = new ResponseModel();
		toReturn.setCode(404);
		toReturn.setType("text");
		toReturn.setResponse(StringUtils.EMPTY);
		return toReturn;
	}
}
