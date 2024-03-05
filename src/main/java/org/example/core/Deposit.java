package org.example.core;

import java.math.BigDecimal;

public interface Deposit {
    boolean execute(BigDecimal value, Integer accountNumber);
}
