package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class LongArrayTag(val value: LongArray) : ITag {
    override val type = TagType.LONG_ARRAY
    override fun data() = value.contentToString()
}
