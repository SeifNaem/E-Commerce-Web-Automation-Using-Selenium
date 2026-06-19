//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.saucelab.utilites;

import org.testng.asserts.SoftAssert;

public class SoftAssertion extends SoftAssert {
    public static SoftAssert softAssertion = new SoftAssert();

    public static void customAssertAll() {
        try {
            softAssertion.assertAll("Soft Assertion");
        } catch (Exception var1) {
            System.out.println("Soft Assertion Failed: ");
        }

    }
}
