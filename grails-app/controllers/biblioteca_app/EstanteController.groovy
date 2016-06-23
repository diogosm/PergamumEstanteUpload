package biblioteca_app

import grails.rest.RestfulController
import org.apache.tomcat.util.http.fileupload.IOUtils
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.MultipartHttpServletRequest

class EstanteController extends RestfulController {
    static responseFormats = ['json', 'xml']
    EstanteController() {
        super(Estante)
    }
    //
    // curl -F "image[]=@/home/dev/Downloads/th_01.gif" -F "image[]=@/home/dev/Downloads/th_02.gif"  http://localhost:8080/estante/1
    // /
    def mostra(Integer max){
        def m = new Mensagem()
        println 'ola'
        String fileLabel = params.fileLabel
        MultipartFile uploadedFile = null
        String fileName=""
        try{
            if (request instanceof MultipartHttpServletRequest){
                //Get the file's name from request
                fileName = request.getFileNames()[0]
                //Get a reference to the uploaded file.
                uploadedFile = request.getFile(fileName)
                fileLabel +=".${uploadedFile.originalFilename.split("\\.")[-1]}"

            }
            //get uploaded file's inputStream
            InputStream inputStream = uploadedFile.inputStream
            //get the file storage location
            def fileTobeStoredInDirPath = '/home/proeg/Pictures/' ///grailsApplication.config.myapp.file.storage.location
            //create a new file with fileLabel
            File file = new File(fileTobeStoredInDirPath, fileLabel)
            //This support both overriding and creating new file
            //If two of these fails, that means got some internal issue. May be new file creation permissions issue
            if (file.exists() || file.createNewFile()) {

                //to close the fileOutStream, opening it using withOutStream closure
                file.withOutputStream{fos->
                    IOUtils.copyLarge(inputStream, fos)
                }

                m.codigo = '200'
                m.descricao = 'Arquivo importado com sucessso'

            }else{
                m.codigo = '410'
                m.descricao = "Aconteceu um erro ao enviar o arquivo  ${file} no servidor ${fileTobeStoredInDirPath}"
            }
        }
        catch (Exception e){
            m.codigo = '500'
            m.descricao = "Erro ao enviar os arquivos ${e.message}"

        }
        respond m
    }
    
}
