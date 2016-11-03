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

package pl.madshai.rjmock.configuration;

import org.junit.Test;
import pl.madshai.rjmock.mocks.mocks.PackageModel;
import pl.madshai.rjmock.exceptions.MocksException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Shai on 2016-10-09.
 */

public class MocksConfigurationReaderTest {

	private MocksConfigurationReader tested = new MocksConfigurationReader();

	@Test
	public void readPackageTest() throws MocksException {
		String path = this.getClass().getResource("/test.json").getPath();
		PackageModel packageModel = tested.readPackageModel(path);
		assertThat(packageModel.getResponses().size(),is(2));
		assertThat(packageModel.getResponses().get(0).getConditions().size(), is(1));
	}

}
