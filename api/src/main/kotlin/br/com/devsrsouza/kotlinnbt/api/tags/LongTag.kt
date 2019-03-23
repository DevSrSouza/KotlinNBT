package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class LongTag(val value: Long) : ITag {
    override val type = TagType.LONG
    override fun data() = type.toString()
}
