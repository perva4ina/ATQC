package com.gmail.perva4ina.unitTests;

import com.gmail.perva4ina.PrimeNumberChecker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by perva on 08.07.2017.
 */
public class PrimeNumberTest {
    private PrimeNumberChecker primeNumberChecker;

    @DataProvider(name = "numbers")
    Object[][] primeNumbers() {
        return new Object[][] {{2, true}, {13, true}, {8, true}, {16, false}};
    }

    @BeforeClass
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    @Test(dataProvider = "numbers")
    public void testPrimeNumberChecker(Integer inputNumber, Boolean expected) {
        boolean passed = true;
        System.out.print(inputNumber + " " + expected);
        Boolean actual = primeNumberChecker.validate(inputNumber);
        try {
            Assert.assertEquals(actual, expected);
        }
        catch (AssertionError e) {
            passed = false;
        }
    }
}
