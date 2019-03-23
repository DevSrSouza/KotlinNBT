package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class FloatTag(val value: Float) : ITag {
    override val type = TagType.FLOAT
    override fun data() = value.toString()
}
