# Java Stream Mastery

This repository contains hands-on Java Stream API exercises focused on real backend scenarios such as users, orders, wallet accounts, merchants, cards, invoices, and permissions.

## Topics Covered

- filter
- map
- flatMap
- anyMatch
- allMatch
- noneMatch
- groupingBy
- counting
- summingLong
- toMap
- Set-based lookup optimization

## Project Structure

```text
src/main/java/com/streammastery
├── model
├── data
├── exercise01_filter
├── exercise02_anymatch
├── exercise03_map
├── exercise04_grouping
├── exercise05_flatmap
├── exercise06_set_lookup
└── exercise07_to_map



| Package                      | Exercise                                  | Main Concept                            | Description                                                               | Expected Output                                               |
| ---------------------------- | ----------------------------------------- | --------------------------------------- | ------------------------------------------------------------------------- | ------------------------------------------------------------- |
| `exercise01_filter`          | `ActiveUsersExercise`                     | `filter`                                | Finds active users from the user list.                                    | `Ali`, `Sara`, `Mina`                                         |
| `exercise01_filter`          | `SuccessOrdersExercise`                   | `filter`                                | Filters orders with `SUCCESS` status.                                     | Successful orders only                                        |
| `exercise01_filter`          | `ValidAmountOrdersExercise`               | `filter`                                | Keeps orders with non-null amount.                                        | Orders with valid amount                                      |
| `exercise02_anymatch`        | `UsersWithSuccessOrdersExercise`          | `anyMatch`                              | Finds active users who have at least one successful order.                | `Ali`, `Mina`                                                 |
| `exercise03_map`             | `UserNamesExercise`                       | `map`                                   | Extracts user names from user objects.                                    | List of names                                                 |
| `exercise03_map`             | `UserOrderSummaryExercise`                | `map`, `sum`                            | Creates summary DTOs for active users and their successful order amounts. | `Ali -> 800000`, `Mina -> 700000`                             |
| `exercise04_grouping`        | `CountOrdersByStatusExercise`             | `groupingBy`, `counting`                | Counts orders by status.                                                  | `SUCCESS -> 5`, `FAILED -> 1`, `PENDING -> 1`                 |
| `exercise04_grouping`        | `TotalAmountByStatusExercise`             | `groupingBy`, `summingLong`             | Calculates total amount by order status.                                  | `SUCCESS -> 2500000`, `FAILED -> 200000`, `PENDING -> 300000` |
| `exercise04_grouping`        | `TotalAmountByUserIdExercise`             | `groupingBy`, `summingLong`, `anyMatch` | Calculates total successful amount for active users.                      | `1 -> 800000`, `4 -> 700000`                                  |
| `exercise05_flatmap`         | `ActiveCardsExercise`                     | `flatMap`                               | Extracts active cards from active users and filters by balance.           | `1111 -> 500000`, `4444 -> 300000`                            |
| `exercise05_flatmap`         | `TotalCardBalanceExercise`                | `flatMap`, `mapToLong`, `sum`           | Calculates total balance of enabled cards for active users.               | `Total balance: 800000`                                       |
| `exercise06_set_lookup`      | `ActiveUserIdsExercise`                   | `map`, `toSet`                          | Creates a set of active user IDs.                                         | `1`, `3`, `4`                                                 |
| `exercise06_set_lookup`      | `ActiveUserSuccessOrdersExercise`         | `Set.contains`                          | Filters successful orders that belong to active users.                    | Orders for user `1` and `4`                                   |
| `exercise06_set_lookup`      | `UserNameLookupExercise`                  | `toMap`, lookup                         | Prints successful active-user orders with user names.                     | `Ali`, `Mina` with order data                                 |
| `exercise07_wallet_merchant` | `WalletAccountsByMerchantStreamExercise`  | `anyMatch`                              | Filters wallet accounts by merchant and group code using nested stream.   | `00 -> 500000`                                                |
| `exercise07_wallet_merchant` | `WalletAccountsByMerchantForEachExercise` | `for-each`                              | Solves the wallet and merchant filtering problem using classic loops.     | `00 -> 500000`                                                |
| `exercise07_wallet_merchant` | `AllowedGroupCodesByMerchantExercise`     | `toSet`, `contains`                     | Builds allowed group codes first, then filters wallet accounts.           | `00 -> 500000`                                                |


---

## Why This Repository Exists

Java Stream API is powerful, but it can easily become unreadable if used carelessly.

This repository focuses on learning Stream API through realistic backend examples instead of abstract examples like simple number lists.

The exercises are designed around common backend scenarios:

- Filtering users and orders
- Matching records between two lists
- Creating DTO summaries
- Grouping and aggregating data
- Flattening nested collections
- Optimizing nested lookup logic with `Set`
- Solving wallet and merchant access scenarios

---

## How to Run

Each exercise has its own `main` method.

To compile the project:

```bash
mvn clean compile
```

To run a specific exercise from the IDE, open the class and run its `main` method.

Example classes:

```text
CountOrdersByStatusExercise
TotalAmountByStatusExercise
ActiveCardsExercise
AllowedGroupCodesByMerchantExercise
```

---

## Example Outputs

### Count orders by status

```text
SUCCESS -> 5
FAILED -> 1
PENDING -> 1
```

### Total amount by status

```text
SUCCESS -> 2500000
FAILED -> 200000
PENDING -> 300000
```

### Active cards

```text
1111 -> 500000
4444 -> 300000
```

### Wallet accounts allowed for merchant

```text
00 -> 500000
```

---

## Learning Path

Recommended order:

1. `exercise01_filter`
2. `exercise02_anymatch`
3. `exercise03_map`
4. `exercise04_grouping`
5. `exercise05_flatmap`
6. `exercise06_set_lookup`
7. `exercise07_wallet_merchant`

This order starts with simple filtering and gradually moves toward more practical backend patterns such as lookup optimization and merchant-wallet filtering.

---

## Future Improvements

Planned improvements:


- Extract stream logic from `main` methods into reusable methods
- Add more `toMap` exercises
- Add performance comparison examples
- Add invoice and invoice-item exercises using `flatMap`
- Add role and permission exercises for authorization scenarios
- Add GitHub Actions for Maven build validation

---

## Repository Goal

The goal of this repository is to become a practical Java Stream API learning lab for backend developers.

It focuses on writing code that is:

- readable
- null-safe
- practical
- explainable in technical discussions