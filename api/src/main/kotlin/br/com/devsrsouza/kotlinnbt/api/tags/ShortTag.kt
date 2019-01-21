package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class ShortTag(override val name: String?, val value: Short) : Tag() {
    override val type = TagType.SHORT
    override fun data() = value.toString()
}
