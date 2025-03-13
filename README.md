# 🎨 Graph Coloring - Solução Greedy em Java

Este repositório contém a implementação de uma solução para o problema de **coloração de vértices de um grafo**. A implementação é feita em Java, utilizando uma abordagem **gulosa (greedy)** para determinar o menor número de cores necessárias para colorir um grafo de maneira que vértices adjacentes não compartilhem a mesma cor.

## 📚 Problema a ser solucionado

O problema consiste em determinar o **menor número de cores** necessário para colorir os vértices de um grafo \( G = (V, E) \) de forma que **nenhum vértice adjacente tenha a mesma cor**. Esse tipo de problema é conhecido como **problema de coloração de vértices** e é importante em várias áreas da ciência da computação, como otimização de recursos, design de circuitos e agendamento de tarefas.

### 🔍 Definição Formal

Dado um grafo \( G = (V, E) \) onde:
- \( V \) é o conjunto de vértices,
- \( E \) é o conjunto de arestas,

o objetivo é atribuir uma cor a cada vértice de forma que:
- Nenhuma aresta conecte dois vértices com a mesma cor.

O desafio é **minimizar o número de cores usadas**.

## 🛠️ Solução Implementada

A solução implementada utiliza um algoritmo **guloso** para colorir o grafo. A abordagem gulosa consiste em iterar sobre os vértices do grafo, atribuindo a cada vértice a menor cor disponível que não tenha sido atribuída a nenhum de seus vizinhos.

### 🧑‍💻 Lógica do Algoritmo

1. **Inicialização**:
   - Começamos atribuindo a primeira cor ao primeiro vértice (vértice 0).
   
2. **Iteração**:
   - Para cada vértice subsequente:
     - Identificamos as cores já atribuídas aos seus vizinhos.
     - Atribuímos ao vértice a menor cor disponível que não foi usada por seus vizinhos.

3. **Resultado**:
   - Após percorrer todos os vértices, a solução é impressa, mostrando a cor atribuída a cada vértice e o número total de cores utilizadas.

O algoritmo é eficiente para grafos grandes, mas não garante o número mínimo de cores, pois trata-se de uma abordagem gulosa, o que significa que ele toma decisões localmente ótimas sem explorar todas as possibilidades globais.

### 🚀 Fluxo do Programa
- O grafo é representado usando uma **lista de adjacências**.
- O algoritmo recebe a entrada do usuário, incluindo o número de vértices e arestas, e imprime a cor atribuída a cada vértice.

## 📝 Instruções para Uso

### 🧑‍💻 Clonando o Repositório

Para clonar o repositório, use o comando abaixo:

```bash
git clone https://github.com/kevin504-max/graph_coloring.git
```

### ⚙️ Compilando e Executando o Programa - Ambiente Linux

1. **Navegue até o diretório do projeto**:

```bash
cd graph_coloring/lib
```

2. **Compilar e executar os arquivos Java com Makefile**:

```bash
make
make run
```

### ⚙️ Compilando e Executando o Programa - Ambiente Windows

1. **Navegue até o diretório do projeto**:

```bash
cd lib
```

2. **Compilar os arquivos Java**:

```bash
javac -d out src/graphcoloring/*.java
```

3. **Executar o programa**:

```bash
java -cp out graphcoloring.Main
```

### 📋 Exemplo de Entrada:

```text
Enter the number of instances to generate:
4
Enter the minimum number of vertices:
1000
Enter the maximum number of vertices:
1000
Enter the density percentage (1-100):
50
```

### 🖥️ Exemplo de Saída:

```text
Vertex 987 ---> Color 1
Vertex 988 ---> Color 17
Vertex 989 ---> Color 110
Vertex 990 ---> Color 121
Vertex 991 ---> Color 108
Vertex 992 ---> Color 106
Vertex 993 ---> Color 64
Vertex 994 ---> Color 112
Vertex 995 ---> Color 62
Vertex 996 ---> Color 62
Vertex 997 ---> Color 113
Vertex 998 ---> Color 120
Vertex 999 ---> Color 16

Total number of colors used: 124
Execution time for instance 4: 36 ms
```

## 🧪 Testes

Para avaliar o desempenho do algoritmo, foram utilizados diversos grafos com diferentes números de vértices. Os testes foram realizados com grafos de pequena, média e grande escala para verificar a correção e a eficiência do algoritmo.

### ✅ Testes Realizados:

| Número de Vértices | Número Médio de Cores |
|--------------------|----------------------|
| 10   | (3 + 4 + 10) / 3 = 5.66    |
| 50   | (10 + 13 + 50) / 3 = 24.33   |
| 100  | (14 + 20 + 100) / 3 = 44.66  |
| 500  | (46 + 74 + 500) / 3 = 206.66 |
| 1000 | (77 + 108 + 1000) / 3 = 401.66 |

O algoritmo mostrou-se eficiente para grafos pequenos e médios, mas pode não ser tão otimizado para grafos muito grandes devido à natureza do algoritmo guloso.

## 🏁 Conclusão

O algoritmo de coloração de grafos implementado neste trabalho usa uma abordagem simples e eficiente para colorir vértices, utilizando a estratégia gulosa. Embora não garanta a solução ótima em termos de número de cores, oferece uma solução prática para muitos cenários em que a eficiência é importante.