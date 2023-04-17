Feature: Validar Saldo

  @tag1
  Scenario: Transferencia
    Given que esteja na home do site "https://bugbank.netlify.app"
    When criar duas contas com saldo
    When Validar saldo da primeira conta
    When validar saldo da segunda conta
    Then Fazer transferencia
    Then Validar o saldo da conta transferida
    Then Validar o saldo na conta transferida
