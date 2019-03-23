package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class ShortTag(val value: Short) : ITag {
    override val type = TagType.SHORT
    override fun data() = value.toString()
}
