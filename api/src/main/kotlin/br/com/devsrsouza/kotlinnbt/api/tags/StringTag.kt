package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class StringTag(val value: String) : ITag {
    override val type = TagType.STRING
    override fun data() = "'$value'"
}
