package com.github.spb.tget.test;

import com.github.spb.tget.ParenthesisBalance;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParenthesisBalanceTest {

    @DataProvider
    public static Object[][] getTestCasesSingleType() {
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

    @Test(dataProvider = "getTestCasesSingleType")
    public void parenthesisBalance_isBalanced_ShouldReturnTrue_forBalancedTexts(String textToValidate, boolean expectedResult) {
        boolean actualResult = ParenthesisBalance.isBalanced(textToValidate);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect isBalanced result");
    }

    @DataProvider
    public static Object[][] getTestCasesMultiTypes() {
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
                {"()[]", true},
                {"([])", true},
                {"(dd[dsfd]sds(sd)lld{4})", true},
                {"(dd[ds{234}fd]sds(sd)lld{4})", true},
                {"(dd[ds{234}f(d)d]sds(sd)lld{4})", true},
                {"(dd[d[]d]sds)", true},
                {"sss(dd[d[](){s(s)}d]sds)ss", true},
                {"vvv{}vv{v{v{}vv{vv}vvvv}v{s}v}vv", true},
                {"vv{[vvvv{[vvvvvv]}vvvvvvv]}vvvv", true},
                {"ddddd{d()ddd{d[ddd()ddddddd]d}d}dddd", true},
                {"[[]]", true},
                {"([", false},
                {"([)]", false},
                {"1(hhs[s)lll)", false},
                {"sss(dd[d[](){ss)}d]sds)ss", false},
                {"vvv{}vv{v{v{}vv{vv}vvvv}v{s}vvv", false},
                {"vv{[vvvv{vvvvvv]}vvvvvvv]}vvvv", false},
                {"ddddd{d()ddd{d[ddd(ddddddd]d}d}dddd", false},
        };
    }

    @Test(dataProvider = "getTestCasesMultiTypes")
    public void parenthesisBalance_isBalancedComplex_ShouldReturnTrue_forBalancedTexts(String textToValidate, boolean expectedResult) {
        boolean actualResult = ParenthesisBalance.isBalancedMultiple(textToValidate);
        Assert.assertEquals(actualResult, expectedResult, "Incorrect isBalancedComplex result");
    }
}
