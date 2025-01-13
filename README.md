# ze-delivery

## Sobre

Aplicação de geolocalização de parceiros. 

[Link do desafio](https://github.com/ab-inbev-ze-company/ze-code-challenges/blob/master/backend.md).

## Modelo

# Fucionalidades

- Criar parceiro.
- Carregar parceiro pelo id.
- Pesquisar parceiro pela longitude e latitude.

# Recusos do projeto

## Ze Delivery Spring Boot Back End Java

- Java 17.
- Spring Boot.
- MVC.
- SOLID.
- Swagger.
- H2 SQL.
- JUnit 5.
- Lombok.
- Validation.
- Ulid Creator.
- Hibernate/JPA.

# Requsições

## Parceiro

### Criar parceiro

```json
POST
/api/partners/create-partner

{
  "tradingName": "string",
  "ownerName": "string",
  "document": "string",
  "coverageArea": {
    "type": "MultiPolygon",
    "coordinates": [
      [
        [
          [
            0
          ]
        ]
      ]
    ]
  },
  "address": {
    "type": "Point",
    "coordinates": [
      0
    ]
  }
}
```

### Carregar parceiro pelo id

```json
GET
/api/partners/load-partner-by-id?id=1
```

### Pesquisar parceiro pela longitude e latitude

```json
GET
/api/partners/search-partner-by-longitude-and-latitude?longitude=1&latitude=1
```

# Execução Do Projeto

- Copie e execute repositório em uma IDE.
- Acesse [a docmentação da API](http://localhost:8080/swagger-ui/index.html) ou use outra plataforma para testa a API.

```bash
# clone repository
git clone https://github.com/abnerjosefelixbarbosa/challenge-back-end-hit.git
```

# Autor

Abner José Felix Barbosa

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/abner-jose-feliz-barbosa/)
