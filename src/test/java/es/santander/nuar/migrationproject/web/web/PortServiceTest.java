package es.santander.nuar.migrationproject.web.web;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import es.santander.nuar.migrationproject.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@AutoConfigureWireMock
public class PortServiceTest {

	@Rule
	public WireMockRule solicitudes = new WireMockRule(8082);

	@Autowired
	private Environment environment;

	@Test
	public void shouldReturnWireMockPort() {
		assertNotNull(environment.getProperty("wiremock.server.port"));
	}

	@Test(expected = Test.None.class /* no exception expected */)
	public void noExceptionExpectedTest() {
		Application.printLine("line");
	}

}
