# DESAFIO POO

## Desafio: Corretora Imobiliária

### 🎯 Objetivo
Desenvolver um sistema simples de aluguel de casas e apartamentos no console, aplicando os três pilares da POO e raciocínio lógico.

---

## 💡 Requisitos

### Classe Abstrata `Imovel`
**Atributos:**
- Endereço
- Número
- Alugado
- Proprietário  

**Métodos:**
- `boolean estaAlugado()`
- `String contatoProprietário()`
- `int calcularAluguel(int)`

### Encapsulamento
- Endereço, número e alugado devem ser `protected`.  
- Criar métodos públicos para obter e alterar valores de forma controlada.

### Herança
- Criar classes:
  - `Casa` (herda de `Imovel`)  
  - `Apartamento` (herda de `Imovel`)  

### Composição
- Criar classe `Proprietário` com atributos:
  - Nome
  - Telefone
  - CPF

### Polimorfismo
- Sobrescrever o método `estaAlugado()` nas subclasses:
  - **Casa:** retornar `"A casa está disponível"` ou `"A casa está alugada"`.  
  - **Apartamento:** retornar `"O apartamento de número (número do apartamento) está disponível"` ou `"O apartamento de número (número do apartamento) está alugado"`.

### Lógica
- Permitir ao usuário cadastrar e deletar casas ou apartamentos.  
- Permitir o cálculo do valor total do aluguel em um determinado período.  
- Permitir que o usuário alugar ou disponibilizar o imóvel para aluguel.  
- Exibir no console os resultados de todas as ações do usuário.

---

## 🧩 Dicas para ampliar o desafio
- Adicionar uma classe `Inquilino` com informações da pessoa que está alugando o imóvel.  
- Criar uma lista de imóveis alugados puxando todos os imóveis que estão alugados e suas informações.  
- Adicionar descontos no caso de aluguel de longa data, por exemplo 1, 2 ou 3 anos.

---

## ✅ O que avaliar nesse desafio

| Conceito       | O que observar |
|----------------|----------------|
| **Herança**    | Classes filhas estendendo `Imovel` corretamente |
| **Polimorfismo** | Sobrescrita dos métodos `estaAlugado` |
| **Encapsulamento** | Uso de modificadores (`protected`, `private`) e métodos públicos controlados |
| **Lógica**     | Estrutura das ações (criação/deleção de objetos, retornos para o usuário) |
| **Organização** | Estrutura do código, clareza e boas práticas |
| **Criatividade** | Incrementos ou variações além do mínimo |
