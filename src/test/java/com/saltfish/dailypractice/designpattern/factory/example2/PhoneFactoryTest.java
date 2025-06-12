package com.saltfish.dailypractice.designpattern.factory.example2;

import org.junit.jupiter.api.Test;

class PhoneFactoryTest {

    @Test
    void testCreatePhone() {
        // Setup
        // Run the test
        final Phone phone = PhoneFactory.createPhone("Huawei");

        // Verify the results
        System.out.println(phone.brand());
    }
}
