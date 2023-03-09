package org.quera.bime;

import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;

public class BaseTestProperties {
    @LocalServerPort
    protected int serverPort;
    @Autowired
    protected TestRestTemplate restTemplate;
    @Autowired
    EntityManager entityManager;
    @Autowired
    JdbcTemplate jdbcTemplate;

    protected String url(String path) {
        return "http://localhost:" + serverPort + path;
    }

    protected String readJsonPath(String json, String path) {
        Object result = JsonPath.read(json, path);
        return result instanceof String ? result.toString() : String.valueOf(result);
    }
}
