package org.example.core.withdrawal;

import java.math.BigDecimal;

public interface Withdrawal {
    boolean execute(BigDecimal value, Long accountNumber);
}
