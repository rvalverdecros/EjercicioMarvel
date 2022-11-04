import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory
import kotlin.system.exitProcess

fun main() {
    println("Hola, seleccione una opcion de las posibles")
    println("1. Informacion de un personaje")
    println("2. Cantidad de comics que aparece el personaje")
    println("3. Mostrar comic por id")
    println("4. Comparar poppularidad entre dos heroes")
    println("5. XML del personaje y comic")

    val res = readln().toInt()

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
    }else if (res == 3){

    }else if (res == 4){

    }else if (res == 5){

    }else{
        println("Error! Opcion no identificada")
    }

}