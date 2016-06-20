package biblioteca_app


import grails.rest.*
import grails.converters.*

class EstanteController extends RestfulController {
    static responseFormats = ['json', 'xml']
    EstanteController() {
        super(Estante)
    }
    def mostra(Integer max){
        def e = new Estante()
        e.id = '1'
        e.nome = 'Primeira estante'
        respond e
    }

}
