package biblioteca_app


import grails.rest.*
@Resource(uri='/estante',readOnly = false, formats = ['json', 'xml'])
class Estante {
    String id
    String nome
}