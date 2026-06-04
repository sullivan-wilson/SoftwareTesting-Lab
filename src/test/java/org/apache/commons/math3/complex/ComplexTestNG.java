package org.apache.commons.math3.complex;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ComplexTestNG {

    @Test
    // 接收来自 XML 配置文件的参数
    @Parameters({"r1", "i1", "r2", "i2", "expReal", "expImaginary"})
    public void testMultiplyParameterized(double r1, double i1, double r2, double i2, double expReal, double expImaginary) {

        // 使用传入的参数构造复数
        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);

        // 执行乘法（依然会触发我们埋好的那个 Bug）
        Complex result = c1.multiply(c2);

        // TestNG 的断言顺序是 (实际值, 预期值, 误差范围, 错误信息)
        Assert.assertEquals(result.getReal(), expReal, 0.0001, "实部计算错误");
        Assert.assertEquals(result.getImaginary(), expImaginary, 0.0001, "虚部计算错误");
    }
}