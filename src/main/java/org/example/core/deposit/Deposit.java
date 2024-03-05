package org.example.core.deposit;

import java.math.BigDecimal;

public interface Deposit {
    boolean execute(BigDecimal value, Long accountNumber);
}
