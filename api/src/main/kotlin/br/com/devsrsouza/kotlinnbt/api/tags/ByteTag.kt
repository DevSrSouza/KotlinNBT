package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class ByteTag(val value: Byte) : ITag {
    override val type = TagType.BYTE
    override fun data() = value.toString()
}
