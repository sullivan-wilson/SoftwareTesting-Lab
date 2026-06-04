package org.apache.commons.math3.complex;

public class ManualTestComplex {
    public static void main(String[] args) {
        System.out.println("开始执行无框架的手工测试...");
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(3, 4);

        // 测试 1：加法（正常）
        Complex addResult = c1.add(c2);
        if (addResult.getReal() != 4.0 || addResult.getImaginary() != 6.0) {
            System.err.println("Error: 加法逻辑错误！");
        } else {
            System.out.println("加法测试通过。");
        }

        // 测试 2：乘法（我们在源码里注入了 Bug，这里会捕捉到）
        Complex mulResult = c1.multiply(c2);
        // 正确结果应该是 -5 + 10i
        if (mulResult.getReal() != -5.0 || mulResult.getImaginary() != 10.0) {
            System.err.println("Error: 乘法逻辑错误！");
            System.err.println("预期虚部为 10.0，实际输出为: " + mulResult.getImaginary());
        }
        // 测试 3：减法（凑齐指导书要求的“至少3个关键方法”）
        Complex subResult = c1.subtract(c2);
        // (1+2i) - (3+4i) = -2 - 2i
        if (subResult.getReal() != -2.0 || subResult.getImaginary() != -2.0) {
            System.err.println("Error: 减法逻辑错误！");
        } else {
            System.out.println("减法测试通过。");
        }
    }
}