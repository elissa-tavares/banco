/**
 * This interface defines a gateway for accessing an account repository.
 * It extends the {@link org.example.infra.repository.Repository} interface, inheriting its generic methods
 * for data access operations on Account objects.
 */
package org.example.gateway;

import org.example.core.model.Account;
import org.example.infra.repository.Repository;

public interface AccountRepositoryGateway extends Repository<Account> {
}
