# mytrades
Projeto que tem por objetivo fazer consultas em um serviço rest de uma exchange de criptomoedas chamada HitBTC, e recupera em intervalos de 30 segundos o valor que estão pagando por determinada moeda (Bytecoin), e se por acaso estiverem pagando um valor maior que 60% do valor pago pela ultima aquisição, o mesmo envia e-mails de 1 em 1 hora avisando que é um momento bom para vender.


Se quiser testar, é necessário configurar o e-mail de envio no arquivo application.properties e também na classe MyTradeService.java alterar o e-mail de quem receberá o aviso.

Lembrando também que é necessário o banco de dados PostgreSQL instalado (conforme configuração do projeto, configurações no arquivo application.properties)
