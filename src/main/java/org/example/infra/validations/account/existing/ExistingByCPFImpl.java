package org.example.infra.validations.account.existing;

import org.example.infra.validations.account.Existing;

public class ExistingByCPFImpl implements Existing<String> {
    @Override
    public boolean existing(String keyValue) {
        return false;
    }
}
