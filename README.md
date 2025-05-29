# API REST com Spring Boot - Aula Prática

Nesta aula prática, mergulharemos na criação de uma API REST com Spring MVC. 

Iniciaremos configurando nosso projeto Spring Boot e exploraremos as principais anotações, como:
- `@RestController`
- `@RequestMapping`
- `@GetMapping`

Essas anotações são essenciais para definir nossos endpoints. Com a anotação `@RestController`, transformamos nossa classe em um controlador REST, enquanto `@RequestMapping` e `@GetMapping` nos permitem mapear as requisições HTTP para métodos específicos.

## Camada de Serviço e Repositório

Para a camada de serviço, utilizaremos a anotação `@Service`, que indica que a classe fornece serviços de negócio.

Já a camada de repositório será configurada com a anotação `@Repository`, integrando o Spring Data para facilitar operações de banco de dados.

Utilizaremos o banco de dados em memória **H2**, configurando-o no arquivo `application.properties` com as propriedades:

- `spring.datasource.url`
- `spring.datasource.username`
- `spring.datasource.password`

Essa configuração permite uma inicialização rápida e eficiente do projeto.

## Validação e Tratamento de Exceções

A validação dos dados será realizada com a anotação `@Valid`, assegurando que os dados de entrada estejam corretos antes de processá-los.

Abordaremos também o tratamento de exceções com a anotação `@ExceptionHandler`, garantindo que os erros sejam gerenciados de maneira adequada e informativa.

---

Cada passo será ilustrado com exemplos de código, proporcionando uma compreensão clara e prática de como construir uma **API REST completa e funcional** com Spring Boot.

---

