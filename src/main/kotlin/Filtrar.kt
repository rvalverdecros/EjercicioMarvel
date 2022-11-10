import org.w3c.dom.Element
import org.w3c.dom.Node
import java.io.File
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory

object Filtrar {

    fun popularidad(per: String): Int {
        var pop = 0
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

                                                for (o in 0..cantidad.length - 1) {
                                                    val available = cantidad.item(o) as Element
                                                    pop = available.textContent.toInt()
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
        return pop
    }

    fun idper(per: String): Int {
        var idperxml = 0
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
                                var i = result.item(k) as Element
                                var id = i.getElementsByTagName("id")

                                for (o in 0..id.length - 1) {
                                    val idper = id.item(o) as Element
                                    idperxml = idper.textContent.toInt()
                                }
                            }
                        }
                    }
                }
            }
        }
        return idperxml
    }
    fun desper(per: String): String {
        var desperxml = ""
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
                                var des = result.item(k) as Element
                                var descripcion = des.getElementsByTagName("description")

                                for (o in 0..descripcion.length - 1) {
                                    val desper = descripcion.item(o) as Element
                                    desperxml = desper.textContent.toString()
                                }
                            }
                        }
                    }
                }
            }
        }
        return desperxml
    }
    fun idcomic(per: String): ArrayList<Int> {
        var idcomics = arrayListOf<Int>()
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

                                                for (o in 0..cantidad.length - 1) {
                                                    val available = cantidad.item(o) as Element
                                                    val number: Int = available.textContent.toInt()

                                                    for (m in 0..number - 1) {
                                                        if (items.item(m).nodeType == Node.ELEMENT_NODE) {
                                                            val idc = items.item(m) as Element
                                                            val idcomic = idc.getElementsByTagName("resourceURI")
                                                            for (n in 0..idcomic.length - 1) {
                                                                val idcmc = idcomic.item(n) as Element
                                                                val cmc = idcmc.textContent.split("/").last().toInt()
                                                                idcomics += cmc
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
        return idcomics
    }
    fun nombrecomics(per:String): ArrayList<String>{
        var nomcomic = arrayListOf<String>()
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

                                                for (o in 0..cantidad.length - 1) {
                                                    val available = cantidad.item(o) as Element
                                                    val number: Int = available.textContent.toInt()

                                                    for (m in 0..number - 1) {
                                                        if (items.item(m).nodeType == Node.ELEMENT_NODE) {
                                                            val namec = items.item(m) as Element
                                                            val namecomic = namec.getElementsByTagName("name")

                                                            for (n in 0..namecomic.length - 1) {
                                                                val comic = namecomic.item(n) as Element
                                                                nomcomic += comic.textContent
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
        return nomcomic
    }
    fun compdesc(id:Int):String {
        var descomic = ""
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
                                var idc = result.item(k) as Element
                                var idcomic = idc.getElementsByTagName("id")
                                var descripcomic = idc.getElementsByTagName("description")
                                for (l in 0..idcomic.length - 1) {
                                    val desc = descripcomic.item(l) as Element
                                    val descripcion = desc.textContent
                                    val idco = idcomic.item(l) as Element
                                    val idcomicmarvel = "${idco.textContent}"
                                    if (id.toString() == idcomicmarvel) {
                                        descomic = descripcion
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return descomic
    }
}