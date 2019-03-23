package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class ByteArrayTag(val value: ByteArray) : ITag {
    override val type = TagType.BYTE_ARRAY
    override fun data() = value.contentToString()
}
