/*
 * Copyright (c) 2016, Neotys
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Neotys nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL NEOTYS BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package org.jenkinsci.plugins.neoload.integration;

import hudson.util.Secret;
import junit.framework.TestCase;
import org.jenkinsci.plugins.neoload.integration.supporting.MockObjects;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Secret.class})
public class ProjectSpecificActionTest extends TestCase {

	/** Objects for testing. */
	private MockObjects mo = null;

	@Mock
	private Secret secret;

	/**
	 * @throws java.lang.Exception
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		PowerMockito.when(secret.getEncryptedValue()).thenReturn("123");
		mo = new MockObjects(secret);
	}

	@Test
	public void testProjectSpecificAction() {
		final ProjectSpecificAction projectSpecificAction = new ProjectSpecificAction(mo.getApWithOptions());
		assertNotNull(projectSpecificAction);
	}

	@Test
	public void testGetUrlName() {
		final ProjectSpecificAction psa = new ProjectSpecificAction(mo.getApWithOptions());
		assertTrue(psa.getUrlName() != null);
	}


	@Test
	public void testGraphDataExists() {
		final ProjectSpecificAction psa = new ProjectSpecificAction(mo.getApWithoutOptions());
		System.out.println(psa);
		//psa.graphDataExists();
	}

	@Test
	public void testGetErrGraph() {
		final ProjectSpecificAction psa = new ProjectSpecificAction(mo.getApWithoutOptions());
		/*final NeoLoadGraph g = psa.getErrGraph();
		assertTrue(g != null);*/
	}

	@Test
	public void testGetAvgGraph() {
		final ProjectSpecificAction psa = new ProjectSpecificAction(mo.getApWithoutOptions());
		//final NeoLoadGraph g = psa.getAvgGraph();
		//assertTrue(g != null);
	}





	@Test
	public void testGetIconFileName() {
		final ProjectSpecificAction psa = new ProjectSpecificAction(mo.getApWithoutOptions());
		psa.getIconFileName();
	}

	@Test
	public void testGetDisplayName() {
		final ProjectSpecificAction psa = new ProjectSpecificAction(mo.getApWithoutOptions());
		psa.getDisplayName();
	}

}
