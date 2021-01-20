package com.in.nan.common.config;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.springframework.boot.web.server.LocalServerPort;

public class CommonTestConfigBeans {
    @LocalServerPort
    private int port;

    @Before
    public void setAPIPort() {
        // The random port on which this instance of the "services" api is listening
        RestAssured.port = port;
    }
}
