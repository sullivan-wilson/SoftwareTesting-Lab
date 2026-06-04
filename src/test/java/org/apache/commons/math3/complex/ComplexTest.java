package org.apache.commons.math3.complex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComplexTest {
    private Complex c1;
    private Complex c2;

    @Before
    public void setUp() {
        // 初始化复数: c1 = 1 + 2i, c2 = 3 + 4i
        c1 = new Complex(1, 2);
        c2 = new Complex(3, 4);
    }

    @Test
    public void testAdd() {
        // 验证加法：结果应为 4 + 6i
        Complex result = c1.add(c2);
        Assert.assertEquals(4.0, result.getReal(), 0.0001);
        Assert.assertEquals(6.0, result.getImaginary(), 0.0001);
    }

    @Test
    public void testMultiply() {
        // 验证乘法（由于存在缺陷，此处会报错）
        // 数学正确结果：(1*3 - 2*4) + (1*4 + 2*3)i = -5 + 10i
        Complex result = c1.multiply(c2);

        // 验证实部
        Assert.assertEquals(-5.0, result.getReal(), 0.0001);
        // 验证虚部：由于源码被注入了减法 Bug，实际会得到 -2，导致断言失败
        Assert.assertEquals("复数乘法虚部计算错误！", 10.0, result.getImaginary(), 0.0001);
    }
    @Test
    public void testSubtract() {
        // 验证减法 (1+2i) - (3+4i) = -2 - 2i
        Complex result = c1.subtract(c2);
        Assert.assertEquals(-2.0, result.getReal(), 0.0001);
        Assert.assertEquals(-2.0, result.getImaginary(), 0.0001);
    }
}