# Strategy

```mermaid
classDiagram
    %% Interface Estratégia
    class PaymentStrategy {
        <<interface>>
        +execute(double amount) void
    }

    %% Estratégias Concretas
    class CreditCardPayment {
        -number: String
        +CreditCardPayment(String number)
        +execute(double amount) void
    }

    class DebitCardPayment {
        -number: String
        +DebitCardPayment(String number)
        +execute(double amount) void
    }

    class PixPayment {
        -keyPix: String
        +PixPayment(String keyPix)
        +execute(double amount) void
    }

    %% Contexto
    class PaymentContext {
        -paymentStrategy: PaymentStrategy
        +PaymentContext(PaymentStrategy strategy)
        +execute(double amount) void
        +setPaymentStrategy(PaymentStrategy strategy) void
    }

    %% Relacionamentos
    PaymentContext o--> PaymentStrategy : Usa
    CreditCardPayment ..|> PaymentStrategy : Implementa
    DebitCardPayment ..|> PaymentStrategy : Implementa
    PixPayment ..|> PaymentStrategy : Implementa
```
