package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class StringTag(override val name: String?, val value: String) : Tag() {
    override val type = TagType.STRING
    override fun data() = "'$value'"
}
