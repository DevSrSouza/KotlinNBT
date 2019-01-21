package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class IntTag(override val name: String?, val value: Int) : Tag() {
    override val type = TagType.INT
    override fun data() = value.toString()
}
