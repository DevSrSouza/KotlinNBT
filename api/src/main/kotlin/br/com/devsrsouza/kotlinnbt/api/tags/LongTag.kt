package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class LongTag(override val name: String?, val value: Long) : Tag() {
    override val type = TagType.LONG
    override fun data() = type.toString()
}
