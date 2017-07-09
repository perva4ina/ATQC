package com.gmail.perva4ina.unitTests;

import com.gmail.perva4ina.PrimeNumberChecker;
import com.gmail.perva4ina.helper.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrimeNumberTestExcel {
    private PrimeNumberChecker primeNumberChecker;

    @DataProvider(name = "PrimeNumberTestExcel.xlsx")
    Object[][] primeNumbers() throws IOException{
        String filePath = "\\src\\test\\java\\com\\gmail\\perva4ina\\unitTests\\" + this.getClass().getSimpleName() + ".xlsx";
        ExcelReader excelReader = new ExcelReader(filePath, "Sheet1");
        return excelReader.getTableArray();
    }

    @BeforeClass
    public void initialize() {
        primeNumberChecker = new PrimeNumberChecker();
    }

    @Test(dataProvider = "PrimeNumberTestExcel.xlsx")
    public void testPrimeNumberChecker(Double doubleInputNumber, String stringExpected) {
        Integer inputNumber = doubleInputNumber.intValue();
        Boolean expected = Boolean.parseBoolean(stringExpected);

        System.out.print(inputNumber + " " + expected);
        Boolean actual = primeNumberChecker.validate(inputNumber);
        Assert.assertEquals(actual, expected);
    }
}
