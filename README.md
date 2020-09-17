
### Back-end-Engineer-GB

##### Sobre

<p>O projeto é um Mock de uma API de transações</p>
<p>As transações são geradas com dados aleatórios, com seguinte formato</p>

##### Link da api 
<https://backend-guiabolso.herokuapp.com>

<p>/{id}/transacao/{ano}/{mes} -GET Retorna uma lista com transações aleatorios para cada mes ano e id </p>

- @params id(number)
- @params cnpj(number)
- @params vmld(number)


```
[
  {
     "descricao": "string(10, 120)"
     "data": "long(timestamp)"
     "valor": "integer(-9.999.999, 9.999.999)"
     "duplicated": "boolean"
  }  
]

```
<p>Para a geração dos dados aleatórios, foi utilizado o
  <a href="https://github.com/DiUS/java-faker">JavaFaker</a></p>
  
  ```kotlin
/*
Exemplo do JavaFaker
*/

//Classe que define uma transação
data class Transaction(
        val id: Int,
        val descricao: String,
        var duplicated: Boolean,
        val valor: Int,
        val timestamp: Long
)
// Instancia do JavaFaker
val faker = Faker(Random())
//Mock da transação
val transaction = Transaction(
        1, // O id não é gerado de forma randomica, ja que vem via endpoint
        faker.regexify("([bcdfghjklmnpqrstvxyz][aeiou]){10,120}"), //gera uma descrição aleatorio de acordo com a regex passada
        true, // a descrição não é gerada de forma randomica, ja q é passada via endpoint
        faker.number().numberBetween(-9999999, 9999999), // gera um conjunto de numero seguindo  o intervalo determinado
        faker.number().numberBetween(1577836800, 1609459199).toLong() // gera um conjunto de numero seguindo o intervalo
                                                                      //neste caso o intervalo equivale a 30 dia  

)

  ```
  
  


##### Pré Requisitos para rodar o projeto
- Java 8 JVM - pelo menos a versão 8u171 .
- Gradlee 6.6.1
- Docker (Opcional)

#### Executando o projeto localmente

<p>Baixe o repositório:</p>

```
https://github.com/danilocutrim/Back-end-Engineer-GB.git
```
<p>Entre no diretorio do projeto </p>

```
cd Back-end-Engineer-GB
```
<p>Compile o projeto </p>

```
./gradlew build
```

<p>Execute o projeto </p>

```
java -jar build/libs/transactions-0.0.1-SNAPSHOT.jar 
```

#### Executando o projeto com o docker

<p>Construa a imagem </p>

```
docker build . -t transaction-api
```
<p>Execute a imagem</p>

```
docker run -p 8080:8080 transaction-api
```
