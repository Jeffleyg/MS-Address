# MICROSERVICE ADDRESS

# Visão Geral
O MS Address tem a responsabilidade de armazenar os endereços e vincula-lo a um usuário.
- Encapsular a api https://viacep.com.br/
 
## Requisitos
 
- Java 17 
- Banco de dados MySQL
- Spring Boot
- RabbitMQ
- Docker

 
## Configuração

1. Clone o repositório:
 
```bash
https://github.com/Jeffleyg/MS-Address.git
 
2. Configure o banco de dados no arquivo `application.properties`.
 
3. Execute a aplicação:
 
```bash
mvn spring-boot:run
```
2. RabbitMQ

   ```bash
https://localhost:15762
 
Ele armazena as informações do endereço que existe no cep informado pelo usuario no banco.
### Importante

```json
{
  
"Ele armazena o endereço do usuario com o numero do cep que o ususario informou no MsUser no banco Mysql. não consegui implemetei no banco de Aws pois não tinha tempo para resolver isso"
"percebi que o get do Endereço não está funcionando também na minha opinião é causa do JWT(security) porém ele armazenar normalmente"
}
```

Este README serve como um guia para utilizar do MS Address, fornecendo informações sobre como configurar, usar e entender como ele se funciona.






