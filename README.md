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

### ⚙️ Compilando e Executando o Programa

1. **Navegue até o diretório do projeto**:

```bash
cd graph_coloring
```

2. **Compilar os arquivos Java**:

```bash
javac graphcoloring/*.java
```

3. **Executar o programa**:

```bash
java graphcoloring.Main
```

O programa solicitará que você forneça o número de vértices e arestas, e em seguida pedirá que insira os pares de vértices conectados pelas arestas. Após isso, o algoritmo de coloração será executado e o resultado será exibido no terminal.

### 📋 Exemplo de Entrada:

```text
Enter the number of vertices in the graph:
5
Enter the number of edges in the graph:
6
Enter the edges (pair of vertices u v) in the graph:
0 1
0 2
1 2
1 3
2 3
3 4
```

### 🖥️ Exemplo de Saída:

```text
Graph coloring using greedy algorithm:
Vertex 0 ---> Color 0
Vertex 1 ---> Color 1
Vertex 2 ---> Color 2
Vertex 3 ---> Color 0
Vertex 4 ---> Color 1
Number of colors used: 3
```

## 🧪 Testes

Para avaliar o desempenho do algoritmo, foram utilizados diversos grafos com diferentes números de vértices e arestas. Os testes foram realizados com grafos de pequena, média e grande escala para verificar a correção e a eficiência do algoritmo.

### ✅ Testes Realizados:

1. **Grafo com 5 vértices e 6 arestas**:
   - Verificação da correta coloração dos vértices.
   - O algoritmo utilizou 3 cores no resultado.

2. **Grafo com 10 vértices e 15 arestas**:
   - Acolhimento de grafos maiores para testar a eficiência.

3. **Grafo com 50 vértices e 100 arestas**:
   - Teste com grafos maiores para verificar o comportamento do algoritmo com entradas de maior escala.

O algoritmo mostrou-se eficiente para grafos pequenos e médios, mas pode não ser tão otimizado para grafos muito grandes devido à natureza do algoritmo guloso.

## 🏁 Conclusão

O algoritmo de coloração de grafos implementado neste trabalho usa uma abordagem simples e eficiente para colorir vértices, utilizando a estratégia gulosa. Embora não garanta a solução ótima em termos de número de cores, oferece uma solução prática para muitos cenários em que a eficiência é importante.