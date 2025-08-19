# Anti Pattern Strategy

```mermaid
classDiagram
    %% Diagrama do Anti-Pattern (Herança rígida)
    class Payment {
        <<abstract>>
        +execute(double amount)*
    }

    class CreditCardPayment {
        -number: String
        +execute(double amount)
    }

    class DebitCardPayment {
        -number: String
        +execute(double amount)
    }

    class PixPayment {
        -keyPix: String
        +execute(double amount)
    }

    %% Relacionamentos Problemáticos
    CreditCardPayment --|> Payment 
    DebitCardPayment --|> Payment 
    PixPayment --|> Payment 

```