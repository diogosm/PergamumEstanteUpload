package biblioteca_app


import grails.rest.*

@Resource(readOnly = false, formats = ['json', 'xml'])
class Mensagem {
    String codigo
    String descricao
}