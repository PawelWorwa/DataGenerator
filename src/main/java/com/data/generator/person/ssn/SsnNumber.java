package com.data.generator.person.ssn;

import com.data.generator.person.Gender;

public interface SsnNumber {
    String generate(Gender gender, int age);
}