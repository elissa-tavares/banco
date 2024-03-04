package org.example.service.withdrawal;

import java.math.BigDecimal;

public interface Withdrawal {
    boolean execute(BigDecimal value, Long accountNumber);
}
