## O projeto

Este projeto é uma API REST desenvolvida com Spring Boot para uma agenda telefônica 
de contatos.

A ideia deste projeto surgiu após eu fazer um curso de Spring Boot do [Alura](https://www.alura.com.br/). 
Decidi criar uma simples API para testar o meu aprendizado durante o curso.

Se você encontrou algum problema ou tem alguma dúvida de algo deste projeto, 
por favor entre em contato comigo por e-mail.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [JWT](https://jwt.io/)
- [Swagger](https://swagger.io/)


## Conhecimentos explorados

### CRUD

Neste projeto eu consegui implementar o CRUD completo de um recurso utilizando o Spring Boot. 
Eu já tive contato com Java EE e ExpressJS para construção de API's. Sinceramente, me impressionei
com a flexibilidade que o Spring Boot me proporcionou a fazer um projeto tão simples. Desenvolver API's
REST com Java EE é um pouco mais burocrático (no sentido que precisamos levantar um 
ambiente, gerenciar dependências básicas, etc) e torna a entrega de produtos curtos um pouco mais lento.

O Spring Boot definitivamente quebrou esse "tabu" em minha mente sobre projetos pequenos com Java.

### Cache

O próprio Spring Boot fornece formas muito simples de implementar cache em API's. Neste exemplo, não implementei usando
nenhum banco como Redis. Eu utilizei apenas o cache em memória. Mas o uso de annotations para gerenciar cache torna o trabalho
muito simples de ser feito.

### Segurança

Apesar de um pouco complicado de proteger rotas com JWT no Spring Boot, após o trabalho feito o código não precisa
ser revisado. O Spring Boot garante essa estabilidade para os nós desenvolvedores.

### Paginação e Ordenação

Para implementar as paginações e ordenações em endpoints de listagem eu sempre utilizei o criteria manualmente no JavaEE ou utilizando 
o DeltaSpike. Mas a forma de paginar e ordenar no Spring Boot é muito simples e chega ser inacreditável até você realizar o teste e ver
com os próprios olhos. Sem dúvidas um ponto excelente para o Spring Boot.

### Documentação

Para a documentação eu testei o Swagger com o SpringFox. É uma ferramente bem simples que basicamente 
exigiu apenas uma configuração básica e ele fez todo o trabalho chato de documentar uma API REST.

### Monitoramento

O Spring Boot fornece uma forma de extrair os dados da API (como saúde, logs, configurações, etc) para
realizar monitoramento. Com os dados em mãos é possível criar sua própria ferramenta de monitoramento ou
utilizar ferramentas prontas como [Spring Boot Admin](https://github.com/codecentric/spring-boot-admin).

### Conclusão

Este projeto atingiu o objetivo esperado, que era testar meu aprendizado no Spring Boot neste contato inicial, e 
quebrou o "tabu" de que desenvolver com Java sempre é burocrático.
