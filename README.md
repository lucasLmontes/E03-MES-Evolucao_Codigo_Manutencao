# ED03 — Evolução de Código e Manutenibilidade

Projeto desenvolvido como atividade prática da disciplina de **Sistemas de Informação**, demonstrando a evolução de um código mal estruturado para uma solução orientada a objetos com boas práticas de manutenibilidade.

---

## 📋 Descrição

O projeto simula um sistema de **processamento de pedidos**, onde um cliente realiza uma compra de produtos e recebe um desconto conforme seu tipo de cadastro. O objetivo é ilustrar, na prática, como refatorar um código monolítico em classes com responsabilidades bem definidas.

---

## 🗂️ Estrutura do Projeto

```
ED03_Evolucao_Codigo_Manutencao/
│
├── antes/
│   └── Pedido.java          # Versão original — código monolítico
│
└── depois/
    ├── Cliente.java          # Dados e tipo do cliente
    ├── TipoCliente.java      # Enum com os tipos e descontos
    ├── Produto.java          # Nome e preço do produto
    ├── Pedido.java           # Lógica do pedido refatorada
    └── Main.java             # Ponto de entrada da aplicação
```

---

## ⚠️ Antes da Refatoração

Arquivo único `Pedido.java` com todos os dados e regras misturados:

- Campos públicos sem encapsulamento (`nomeCliente`, `cpfCliente`, `produto1`, `produto2`, `produto3`, `tipoCliente`)
- Número fixo de produtos — impossível adicionar mais sem alterar o código
- Uso de **números mágicos** (`1`, `2`, `3`) para representar o tipo de cliente
- Cálculo e impressão misturados no mesmo método `processarPedido()`
- Nenhuma separação de responsabilidades

```java
public class Pedido {
    public String nomeCliente;
    public String cpfCliente;
    public double produto1;
    public double produto2;
    public double produto3;
    public int tipoCliente; // o que significa 1, 2 ou 3?

    public void processarPedido() {
        double total = produto1 + produto2 + produto3;
        if (tipoCliente == 1) total = total - (total * 0.05);
        else if (tipoCliente == 2) total = total - (total * 0.10);
        else if (tipoCliente == 3) total = total - (total * 0.15);
        // impressão, cálculo e regras tudo no mesmo lugar...
    }
}
```

---

## ✅ Depois da Refatoração

Cinco classes com responsabilidade única cada:

| Classe | Responsabilidade |
|---|---|
| `TipoCliente` | Enum que define os tipos (COMUM, ESPECIAL, VIP) e seus descontos |
| `Cliente` | Encapsula nome, CPF e tipo do cliente |
| `Produto` | Encapsula nome e preço de cada item |
| `Pedido` | Gerencia a lista de produtos e calcula totais com desconto |
| `Main` | Ponto de entrada — monta e executa o pedido |

```java
// Tipos de cliente legíveis, sem números mágicos
public enum TipoCliente {
    COMUM(0.05), ESPECIAL(0.10), VIP(0.15);
}

// Pedido com lista dinâmica de produtos
Pedido pedido = new Pedido(cliente);
pedido.adicionarProduto(new Produto("Teclado", 150.00));
pedido.adicionarProduto(new Produto("Mouse", 80.00));
pedido.adicionarProduto(new Produto("Monitor", 900.00));
pedido.mostrarResumo();
```

---

## 🔧 Melhorias Aplicadas

- **Encapsulamento** — atributos privados com acesso via getters
- **Eliminação de números mágicos** — enum `TipoCliente` substitui `int tipoCliente`
- **Lista dinâmica** — `List<Produto>` no lugar de campos fixos `produto1`, `produto2`, `produto3`
- **Separação de responsabilidades** — cada classe faz apenas o que é seu
- **Coesão** — métodos `calcularTotal()`, `calcularTotalComDesconto()` e `mostrarResumo()` com propósitos distintos
- **Legibilidade** — código autoexplicativo, sem comentários compensatórios

---

## ▶️ Como Executar

Requisitos: **Java 8+**

```bash
# Compilar e executar a versão refatorada
cd depois
javac *.java
java Main
```

Saída esperada:
```
Cliente: João Silva
CPF: 123.456.789-00
Teclado: R$ 150.0
Mouse: R$ 80.0
Monitor: R$ 900.0
Total final: R$ 961.0
```

---

## 📚 Conceitos Abordados

- Princípio da Responsabilidade Única (SRP)
- Encapsulamento e ocultação de informação
- Uso de `enum` para constantes com comportamento
- Coleções (`List`) no lugar de campos fixos
- Refatoração sem alteração de comportamento

---

## 👤 Autores

- [Bruno Cesar Jesus de Almeida](https://github.com/BrunoJesus6),
- [Felipe Tavares](https://github.com/Felipedrt01),
- [João Victor de Lima Pereira](https://github.com/JvLp2000),
- [Lucas de Paiva Ribeiro](https://github.com/lucasribeiroti),
- [Lucas Leite Montes](https://github.com/lucasLmontes),
- [Murilo Theodoro Fenner Leite](https://github.com/MuriloLeite),
- [Pedro Lucas Atalaia](https://github.com/Pedro2077)
