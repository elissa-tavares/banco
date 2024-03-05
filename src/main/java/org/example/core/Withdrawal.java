package org.example.core;

import java.math.BigDecimal;

public interface Withdrawal {
    boolean execute(BigDecimal value, Integer accountNumber);
}
