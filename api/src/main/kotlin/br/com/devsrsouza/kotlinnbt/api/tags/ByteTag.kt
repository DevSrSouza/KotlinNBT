package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class ByteTag(override val name: String?, val value: Byte) : Tag() {
    override val type = TagType.BYTE
    override fun data() = value.toString()
}
