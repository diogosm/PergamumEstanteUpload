# PergamumEstanteUpload
Aplicação que realiza exportação de imagens da estante para dentro do pergamum através de aplicação externa. A aplicação deve ficar no mesmo deploy da aplicação pergamum. A requisição via método POST pode ser chamada de outras aplicações em qualquer linguagem.

Para realizar testes utilize o comando abaixo:

curl -F "image[]=@/home/dev/Downloads/th_01.gif" -F "image[]=@/home/dev/Downloads/th_02.gif"  http://localhost:8080/estante/1

Insere imagens na estante 1 através de POST.
