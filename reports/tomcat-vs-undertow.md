
# **Tomcat** vs. **Undertow**

## Introdução

O objetivo deste relatório é comparar o desempenho dos servidores **Tomcat** e **Undertow** na API REST "Payment System", desenvolvida em **Java 17** com **Spring Boot**. Para isso, foram conduzidos testes de carga para medir a performance sob diferentes cenários, cujos resultados são apresentados e analisados abaixo.

## Metodologia

Os testes de carga foram realizados com o objetivo de simular um ambiente de produção, permitindo avaliar o comportamento dos servidores em situações de alta demanda. As métricas de throughput, latência e estabilidade foram monitoradas.

## Configuração dos Testes de Carga

Os testes foram executados com os seguintes parâmetros, conforme configurado no Apache JMeter:

- **Número de Threads (usuários)**: 100
- **Ramp-up period (segundos)**: 10 segundos
- **Loop Count**: 1 (os usuários executam uma única iteração do teste)
- **Duração do teste**: indefinida (teste encerrado após a execução de todos os usuários)
- **Mesma Thread em cada iteração**: Sim

Essas configurações indicam que o teste simula 100 usuários virtuais sendo distribuídos ao longo de 10 segundos, com cada usuário executando uma única requisição à API do sistema de pagamentos.

## Configuração do Ambiente

- **Versão Java**: 17 (JDK 18.0.1.1)
- **Framework**: Spring Boot 3.3.4
- **Aplicação**: Payment System
- **Servidores Avaliados**:
    - **Tomcat**: versão 10.1.30
    - **Undertow**: versão 2.3.17.Final

## Resultados

### 1. **Throughput**
- **Tomcat**: **555 requisições por segundo (req/s)**
- **Undertow**: **515 requisições por segundo (req/s)**

**Análise**: O **Tomcat** apresentou um throughput superior, processando um maior número de requisições por segundo. Isso faz com que ele seja mais adequado para cenários com alta demanda de transações por segundo.

**Pontuação**:
- **Tomcat**: 8/10
- **Undertow**: 7/10

### 2. **Latência Média**
- **Tomcat**: **18.84 ms**
- **Undertow**: **15.11 ms**

**Análise**: O **Undertow** teve um desempenho superior em termos de latência média, com tempos de resposta mais rápidos e consistentes.

**Pontuação**:
- **Tomcat**: 7/10
- **Undertow**: 9/10

### 3. **Desvio Padrão da Latência**
- **Tomcat**: **1.34 ms**
- **Undertow**: **0.21 ms**

**Análise**: O **Undertow** demonstrou maior estabilidade na latência, com um desvio padrão muito menor, resultando em tempos de resposta mais previsíveis.

**Pontuação**:
- **Tomcat**: 6/10
- **Undertow**: 9/10

### 4. **Percentil 90 da Latência**
- **Tomcat**: **8.30 ms**
- **Undertow**: **1.46 ms**

**Análise**: A análise do percentil 90 mostra que o **Undertow** se comporta de forma mais consistente mesmo em cenários de carga elevada, oferecendo latências muito menores.

**Pontuação**:
- **Tomcat**: 6/10
- **Undertow**: 10/10

### 5. **Latência Máxima**
- **Tomcat**: **166 ms**
- **Undertow**: **144 ms**

**Análise**: O **Undertow** apresentou melhores resultados também em termos de latência máxima, mantendo as requisições dentro de um intervalo de latência mais controlado em momentos de pico.

**Pontuação**:
- **Tomcat**: 6/10
- **Undertow**: 9/10

### 6. **Requisições Simultâneas (Concorrência)**
- **Tomcat**: **318 requisições simultâneas**
- **Undertow**: **315 requisições simultâneas**

**Análise**: Ambos os servidores apresentaram resultados muito semelhantes em termos de concorrência, com o **Tomcat** lidando com um número ligeiramente maior de requisições simultâneas.

**Pontuação**:
- **Tomcat**: 8/10
- **Undertow**: 8/10

## Pontuação Final

| Critério                   | Tomcat | Undertow |
|----------------------------|--------|----------|
| **Throughput**              | 8/10   | 7/10     |
| **Latência Média**          | 7/10   | 9/10     |
| **Desvio Padrão da Latência**| 6/10   | 9/10     |
| **Percentil 90 da Latência**| 6/10   | 10/10    |
| **Latência Máxima**         | 6/10   | 9/10     |
| **Requisições Simultâneas** | 8/10   | 8/10     |
| **Total**                   | 41/60  | 52/60    |

## Conclusão

Com base nos resultados, o **Undertow** se destaca por oferecer uma latência mais baixa e maior consistência nos tempos de resposta, sendo indicado para aplicações que priorizam baixa latência e estabilidade. O **Tomcat**, por sua vez, demonstrou um throughput superior, sendo mais adequado para ambientes que requerem processamento elevado de requisições por segundo.

**Recomendação**: Para a aplicação "Payment System", onde a latência e a consistência de tempos de resposta são fatores críticos, o **Undertow** seria a escolha mais adequada. Entretanto, para cenários que priorizam o throughput absoluto, o **Tomcat** pode ser preferível.
