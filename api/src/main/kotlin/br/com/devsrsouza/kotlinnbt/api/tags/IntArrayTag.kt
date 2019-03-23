package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class IntArrayTag(val value: IntArray) : ITag {
    override val type = TagType.INT_ARRAY
    override fun data() = value.contentToString()
}
