package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class DoubleTag(override val name: String?, val value: Double) : Tag() {
    override val type = TagType.DOUBLE
    override fun data() = value.toString()
}
