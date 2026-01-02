Feature: SIM Card Activation

  Scenario: Successful SIM card activation
    Given the SIM card ICCID "1255789453849037777"
    When I submit an activation request
    Then the activation should be successful
    And the SIM status should be "ACTIVE"

  Scenario: Failed SIM card activation
    Given the SIM card ICCID "8944500202198304826"
    When I submit an activation request
    Then the activation should fail
    And the SIM status should be "INACTIVE"
