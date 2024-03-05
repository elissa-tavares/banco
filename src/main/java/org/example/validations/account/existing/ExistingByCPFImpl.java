package org.example.validations.account.existing;

import org.example.validations.account.Existing;

public class ExistingByCPFImpl implements Existing<String> {
    @Override
    public boolean existing(String keyValue) {
        return false;
    }
}
