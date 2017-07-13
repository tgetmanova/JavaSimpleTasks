package com.github.spb.tget.test;

import com.github.spb.tget.ParenthesisBalance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParenthesisBalanceTest {

    @DataProvider
    public static Object[][] getTestCasesData() {
        return new Object[][]{
                {")", false},
                {"(", false},
                {"(a)", true},
                {")der(", false},
                {"d)ss(s(ss", false},
                {"dd)(dsdds", false},
                {"(s)ss)sd", false},
                {"()()()()", true},
                {"(((())))", true},
                {"(d(sds(dsdd))sds)aaa", true},
                {"(((()())))", true},
                {"ss(((s()ss())ss))", true},
                {"(s(s()(ss())ss))", true},
        };
    }

    @Test(dataProvider = "getTestCasesData")
    public void parenthesisBalance_isBalanced_ShouldReturnTrue_forBalancedTexts(String textToValidate, boolean expectedResult) {
        boolean actualResult = ParenthesisBalance.isBalanced(textToValidate);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect isBalanced result");
    }
}
