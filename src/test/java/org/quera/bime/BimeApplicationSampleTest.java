package org.quera.bime;

import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.*;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class BimeApplicationSampleTest extends BaseTestProperties {
	@Test
	public void testGetCompany() {
		jdbcTemplate.update("INSERT INTO companies(name) VALUES (?)", "quera");
		String url = url("/companies/get/1");
		ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals("quera", readJsonPath(result.getBody(), "$.name"));
	}
}
