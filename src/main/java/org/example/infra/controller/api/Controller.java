/**
 * This interface defines a basic contract for a controller in the application.
 * Controllers handle incoming requests and perform actions based on them.
 */
package org.example.infra.controller.api;

public interface Controller {

    /**
     * This method is the main entry point for the controller.
     * Implementations should define the logic to handle incoming requests and perform the desired actions.
     */
    void execute();
}
