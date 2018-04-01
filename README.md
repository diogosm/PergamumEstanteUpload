# PergamumEstanteUpload

Aplicação que realiza importação de imagens da estante para dentro do pergamum através de aplicação externa usando POST request. A aplicação deve ficar no mesmo deploy da aplicação pergamum. A requisição via método POST pode ser chamada de outras aplicações em qualquer linguagem.

Para realizar testes utilize o comando abaixo:

curl -F "image[]=@/home/dev/Downloads/th_01.gif" -F "image[]=@/home/dev/Downloads/th_02.gif"  http://localhost:8080/estante/1

# Como utilizar?

A inserção de imagens é feita através de requisição via POST request. Configure a partição de imagens da estante do pergamum na linha:

```
static final String DIRETORIO_PERGAMUM = '/usr/src/pergamum/pergamumweb/estante/'
```

Arquivo a ser editado: [EstanteController.groovy](https://github.com/diogosm/PergamumEstanteUpload/blob/master/grails-app/controllers/biblioteca_app/EstanteController.groovy)
