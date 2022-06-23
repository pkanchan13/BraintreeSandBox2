@charge_transaction
Feature: Charge Transaction

  Scenario Outline: Charge Transaction Success Flow

    Given a charge request
    And set "<customer_id>" as customer id
    And set "<settlement>" as settlement
    And set "<amount>" as amount
    And set "<token_id>" as token_id
    When charge api is called
    Then a non-empty transaction_id should be generated
    And "<message>" returned as  response message

    Examples:
      | amount  | token_id | customer_id | settlement |message                |
      | 4000.10 | dnwrjqr  | 849385032   | false      |Transaction successful |

