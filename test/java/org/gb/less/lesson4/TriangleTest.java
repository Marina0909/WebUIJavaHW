package org.gb.less.lesson4;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.gb.less.lesson4.FunctionAreaOfTriangle.areaOfTriangle;

public class TriangleTest {

    private static Logger logger = LoggerFactory.getLogger("TriangleTest");

    @BeforeAll
    static void beforeAll() {
        logger.info("Triangle area method check FunctionAreaOfTriangle");
    }

    @ParameterizedTest
    @DisplayName("Triangle area method check FunctionAreaOfTriangle")
    @CsvSource({"0, 0, 0","-4, 2, 2", "1, -1, 4", "2, 1, -3", "0, 1, 1", "1, 0, 1", "1, 1, 0", "1, 1, 2"})
    void triangleSitesIsErrorExceptionTest(double a, double b, double c) {
        Assertions.assertThrows(TriangleSitesIsErrorException.class, () -> FunctionAreaOfTriangle.areaOfTriangle(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({"2, 2, 2, 1.732","7.244, 5.12, 3.12, 6.836", "9999999.9999999, 9999999, 9999999, 43301264415718.85",
        "0.1, 0.1, 0.1, 0.004"})
    void areaOfTriangleeTest(double a, double b, double c, double expected) throws TriangleSitesIsErrorException {
        double s = areaOfTriangle(a, b, c);
        Assertions.assertEquals(expected,Math.round(s*1000.0)/1000.0);
    }
    @AfterAll
    static void afterAll() {
        logger.info("The area of the triangle method verification is finished: FunctionAreaOfTriangle");
    }


}
