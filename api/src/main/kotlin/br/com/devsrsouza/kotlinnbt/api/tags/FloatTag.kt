package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class FloatTag(override val name: String?, val value: Float) : Tag() {
    override val type = TagType.FLOAT
    override fun data() = value.toString()
}
