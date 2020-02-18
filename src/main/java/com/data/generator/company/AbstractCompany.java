package com.data.generator.company;

import com.data.generator.ResourceList;

public abstract class AbstractCompany implements Company {
    private static ResourceList adjectivesList = new ResourceList("companyAdjectives.txt");
    private static ResourceList nounsList = new ResourceList("companyNouns.txt");

    @Override
    public String name() {
        return String.format("%s %s", adjectivesList.randomResource(), nounsList.randomResource());
    }
}