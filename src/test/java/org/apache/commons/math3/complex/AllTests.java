package org.apache.commons.math3.complex;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ComplexTest.class })
public class AllTests {
    // 这是一个空的类，仅作为运行整个测试集的入口
    // 它的作用是批量运行 @SuiteClasses 括号里列出的所有测试类
}