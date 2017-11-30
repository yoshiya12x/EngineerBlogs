package com.example.maeda_yos.engineerblogs.rss.hatena

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root

/**
 * Created by maeda-yos on 2017/11/12.
 */

@Root(name = "rdf:RDF", strict = false)
class HatenaRssXml {
    @set:ElementList(inline = true)
    @get:ElementList(inline = true)
    var list: List<HatenaRssItemXml>? = null
}

@Root(name = "item", strict = false)
class HatenaRssItemXml {
    @set:Element
    @get:Element
    var title: String = ""

    @set:Element
    @get:Element
    var link: String = ""

    @set:Element(required = false)
    @get:Element(required = false)
    var description: String = ""

    @Path("dc/creator")
    @set:Element
    @get:Element
    var creator: String = ""
}