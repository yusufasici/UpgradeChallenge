package com.upgrade.utulities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class APITestBase {

    protected RequestSpecification spec01;

    @Before
    public void setUp() {
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://credapi.credify.tech/api/brportorch/v2/login").
                build();
    }

}
