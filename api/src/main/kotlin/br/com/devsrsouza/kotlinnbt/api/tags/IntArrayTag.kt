package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class IntArrayTag(override val name: String?, val value: IntArray) : Tag() {
    override val type = TagType.INT_ARRAY
    override fun data() = value.contentToString()
}
