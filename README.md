# Composite Design Pattern – Pokémon Team Optimizer

## 🧠 Purpose of the Project

This project aims to **implement and demonstrate the Composite Design Pattern** through a concrete and fun use case: optimizing Pokémon teams.

## 🧩 About the Composite Design Pattern

The **Composite Design Pattern** is used to treat individual objects and compositions of objects uniformly. It is particularly useful when working with tree-like structures.

### ✅ Pattern Requirements

- The application should be structured like a **tree hierarchy**.
- An **interface** must define the business logic, shared by both **composite** (complex objects) and **leaf** (simple objects) components.
- The interface should **not differentiate** between a component and a sub-component — both should be processed in the same way.

## 🕹️ Business Use Case

The application serves as an assistant for **Pokémon trainers** to **optimize their Pokémon teams**.

### 🐾 Pokémon Data Model

In the Pokémon universe:

- A **Pokémon** has a **name**, a **type**, and can undergo one or more **evolutions**.
- A Pokémon has a set of **four combat capacities** (moves).
- During training:
  - A Pokémon may **evolve** into another Pokémon.
  - It may also **learn new capacities**.
  - If it already knows 4 moves, it must either:
    - **Forget** one to learn the new one, or
    - **Give up** on the new move.

### 📈 Application Behavior

Users provide their **Pokémon list** to the application.

The application returns:

- **All possible types** each Pokémon could have (including past evolutions).
- **All capacities** the Pokémon can use or could have learned throughout its evolutionary line.

This logic forms a **composite structure** where:
- Each **evolution stage** is a node in the tree.
- The application traverses the tree to gather the full set of **types** and **capacities**.

### Local testing

curl --location 'http://localhost:8080/optimizePokemonTeam' \
--header 'Content-Type: application/json' \
--data '["pikachu", "raichu", "aquali"]'