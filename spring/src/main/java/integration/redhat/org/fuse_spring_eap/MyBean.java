/*
 * #%L
 * Wildfly Camel
 * %%
 * Copyright (C) 2013 - 2015 RedHat
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package integration.redhat.org.fuse_spring_eap;

import javax.annotation.Resource;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyBean implements org.apache.camel.Processor{

	private static final Logger LOG = LoggerFactory.getLogger(MyBean.class);

	@Resource(name = "java:jboss/camel/context/spring-context")
	private CamelContext camelContext;	

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		LOG.info("the message content is :" + (String)exchange.getIn().getBody());
		
	}
}
