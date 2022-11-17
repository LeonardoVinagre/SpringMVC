PROJETO SPRING MVC

Como rodar o projeto:

1° Alterando o login da conexão:
Na pasta resources do projeto você verá um arquivo 'application.properties' 
nele está configurado o username e o password de seu mysql, 
altere para o que está configurado em seu computador.

2° Criação da base (temos 2 opções)
	
	Opção 1:(RECOMENDADA)

	-Dentro da pasta 'dump' tem um dump do mysql que pode ser importado, 
	automaticamente ele ira criar a base necessaria junto com algumas 
	informações ja inseridas.

	-Apos o dump importado e com a base criada ja pode iniciar o projeto.

	
	Opção 2:
	OBS: ESSA OPÇÃO NÃO POSSUI EXEMPLOS JA INSERIDOS NO BANCO, VISTO QUE ESTÃO DENTRO DO DUMP
	
	-Em 'application.properties' novamente, você verá uma configuração que está comentada:
		#spring.jpa.hibernate.ddl-auto=update
	Você pode descomenta-la se desejar, mas então tera que criar uma base em seu mysql
	com o nome que está configurado na url do banco, nesse caso está configurado para 'postmvc',
	basta então criar a base com o mesmo nome e descomentar a configuração a cima.
	-Apos feito a configuração ja pode iniciar o projeto.