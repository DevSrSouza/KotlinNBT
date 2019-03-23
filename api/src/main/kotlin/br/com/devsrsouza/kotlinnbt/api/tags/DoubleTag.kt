package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class DoubleTag(val value: Double) : ITag {
    override val type = TagType.DOUBLE
    override fun data() = value.toString()
}
