import org.w3c.dom.*
import java.io.File
import java.util.*
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.Source
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import kotlin.system.exitProcess

fun main() {
    println("Hola, seleccione una opcion de las posibles")
    println("1. ¿Existe el personaje?")
    println("2. Comics en los que aparece el personaje")
    println("3. Mostrar comic por id")
    println("4. Comparar poppularidad entre dos heroes")
    println("5. XML del personaje y comic")

    val res = readln().toInt()

    val hola = File("fileName").writeText("hola")
    if (res ==1){
        println("Introduce el nombre del personaje")
        val per = readLine().toString()
        val mayuscula = per.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val ficheroXML = File("resources/personajesMarvel.xml")
        val nodoPadre = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ficheroXML)

        val root = nodoPadre.getElementsByTagName("root")

        for (i in 0..root.length-1){
            if (root.item(i).nodeType== Node.ELEMENT_NODE){
                var dat = root.item(i) as Element
                var data = dat.getElementsByTagName("data")

                for (j in 0..data.length-1){
                    if (data.item(j).nodeType == Node.ELEMENT_NODE){
                        val res = data.item(j) as Element
                        val result = res.getElementsByTagName("results")

                        for (k in 0..result.length-1){
                            if (result.item(k).nodeType == Node.ELEMENT_NODE){

                                var na = result.item(k) as Element
                                var name = na.getElementsByTagName("name")

                                for (l in 0 .. name.length-1){
                                    val nombre = name.item(0) as Element
                                    val nombreper = ("Name: ${nombre.textContent}")
                                    if (mayuscula == nombre.textContent){
                                        Buscar.buscarPj()
                                        println("Se encontro correctamente")
                                        println(nombreper)
                                        exitProcess(-1)
                                    }else{
                                        Buscar.buscarPj()
                                    }
                                }

                            }
                        }
                    }
                }

            }
        }
    }else if (res == 2) {
        println("Introduce el nombre del personaje")
        val per = readLine().toString()
        val mayuscula =
            per.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val ficheroXML = File("resources/personajesMarvel.xml")
        val nodoPadre = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ficheroXML)

        val root = nodoPadre.getElementsByTagName("root")

        for (i in 0..root.length - 1) {
            if (root.item(i).nodeType == Node.ELEMENT_NODE) {
                var dat = root.item(i) as Element
                var data = dat.getElementsByTagName("data")

                for (j in 0..data.length - 1) {
                    if (data.item(j).nodeType == Node.ELEMENT_NODE) {
                        val res = data.item(j) as Element
                        val result = res.getElementsByTagName("results")
                        for (k in 0..result.length - 1) {
                            if (result.item(k).nodeType == Node.ELEMENT_NODE) {
                                var na = result.item(k) as Element
                                var name = na.getElementsByTagName("name")

                                for (l in 0..name.length - 1) {
                                    val nombre = name.item(0) as Element
                                    val nombreper = ("Name: ${nombre.textContent}")
                                    if (mayuscula == nombre.textContent) {

                                        var comic = result.item(k) as Element
                                        var comics = comic.getElementsByTagName("comics")

                                        for (l in 0..comics.length - 1) {
                                            if (comics.item(l).nodeType == Node.ELEMENT_NODE) {
                                                val item = comics.item(l) as Element
                                                val cantidad = item.getElementsByTagName("available")
                                                val items = item.getElementsByTagName("items")

                                                for( o in 0..cantidad.length-1) {
                                                    val available = cantidad.item(o) as Element
                                                    val number: Int = available.textContent.toInt()

                                                    for (m in 0..number - 1) {
                                                        if (items.item(m).nodeType == Node.ELEMENT_NODE) {
                                                            val namec = items.item(m) as Element
                                                            val namecomic = namec.getElementsByTagName("name")

                                                            for (n in 0..namecomic.length-1) {
                                                                val comic = namecomic.item(n) as Element
                                                                val comicper =
                                                                    ("Nombre del comic: ${comic.textContent}")
                                                                println(comicper)
                                                            }
                                                        }
                                                    }
                                                    exitProcess(-1)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }else if (res == 3) {
        println("Inserte ID del comic")
        val comic = readLine().toString()
        val mayuscula =
            comic.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val ficheroXML = File("resources/comicsMarvel.xml")
        val nodoPadre = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(ficheroXML)
        val root = nodoPadre.getElementsByTagName("root")

        for (i in 0..root.length - 1) {
            if (root.item(i).nodeType == Node.ELEMENT_NODE) {
                var dat = root.item(i) as Element
                var data = dat.getElementsByTagName("data")
                for (j in 0..data.length - 1) {
                    if (data.item(j).nodeType == Node.ELEMENT_NODE) {
                        val res = data.item(j) as Element
                        val result = res.getElementsByTagName("results")

                        for (k in 0..result.length - 1) {
                            if (result.item(k).nodeType == Node.ELEMENT_NODE) {

                                var id = result.item(k) as Element
                                var idcomic = id.getElementsByTagName("id")
                                var titulocomic = id.getElementsByTagName("title")

                                for (l in 0..idcomic.length - 1) {
                                    val nombr = titulocomic.item(l) as Element
                                    val nombrecomic = ("Nombre del comic: ${nombr.textContent}")
                                    val idc = idcomic.item(l) as Element
                                    val idcomicmarvel = "${idc.textContent}"
                                    if (comic == idcomicmarvel) {
                                        println("Comic Valido")
                                        println(nombrecomic)
                                        exitProcess(-1)
                                    } else {
                                        Buscar.buscarComic()
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }else if (res == 4){
        println("Introduce el nombre del primer personaje")
        val peruno = readLine().toString()
        println("Introduce el nombre del segundo personaje")
        val perdos = readLine().toString()
        val popprim = Filtrar.popularidad(peruno)
        val popseg = Filtrar.popularidad(perdos)

        if (popprim > popseg){
            println("Tiene mas popularidad $peruno")
        }else if (popprim == popseg){
            println("Tienen la misma popularidad")
        }else{
            println("Tiene mas popularidad $perdos")
        }
    }else if (res == 5){
        println("Introduce el nombre del personaje")
        val per = readLine().toString()

        val idper = Filtrar.idper(per)

        val desper = Filtrar.desper(per)

        val popper = Filtrar.popularidad(per)

        val idcom = Filtrar.idcomic(per)

        val nomcom = Filtrar.nombrecomics(per)

        val factory: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
        val builder: DocumentBuilder = factory.newDocumentBuilder()
        val imp: DOMImplementation = builder.domImplementation

        val document: Document = imp.createDocument(null, "personajes", null)
        val personaje: Element = document.createElement("personaje")
        val id: Element = document.createElement("id")
        val textoId: Text = document.createTextNode(idper.toString())
        id.appendChild(textoId)
        document.documentElement.appendChild(id)
        val name: Element = document.createElement("name")
        val nameper: Text = document.createTextNode(per)
        name.appendChild(nameper)
        document.documentElement.appendChild(name)
        val description: Element = document.createElement("description")
        val descriptionper: Text = document.createTextNode(desper)
        description.appendChild(descriptionper)
        document.documentElement.appendChild(description)
        val comics: Element = document.createElement("comics")
        val comic: Element = document.createElement("comic")

        for (i in 0..popper -1){
            val idcomic: Element = document.createElement("id")
            val idcomics: Text = document.createTextNode(idcom[i].toString())
            idcomic.appendChild(idcomics)
            document.documentElement.appendChild(idcomic)
            val titcomic: Element = document.createElement("titulo")
            val titulocomic: Text = document.createTextNode(nomcom[i])
            titcomic.appendChild(titulocomic)
            document.documentElement.appendChild(titcomic)
            val comicdes = Filtrar.compdesc(idcom[i])
            val descom: Element = document.createElement("description")
            val description: Text = document.createTextNode(comicdes)
            descom.appendChild(description)
            document.documentElement.appendChild(descom)
        }
        document.documentElement.appendChild(comic)
        document.documentElement.appendChild(comics)
        document.documentElement.appendChild(personaje)

        val source: Source = DOMSource(document)

        val result= StreamResult(File("resources/perycomic.xml"))

        val transformer: Transformer = TransformerFactory.newInstance().newTransformer()

        transformer.setOutputProperty(OutputKeys.INDENT, "yes")

        transformer.transform(source, result)

    }else{
        println("Error! Opcion no identificada")
    }

}