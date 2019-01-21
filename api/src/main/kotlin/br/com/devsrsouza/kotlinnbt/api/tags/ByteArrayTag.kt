package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class ByteArrayTag(override val name: String?, val value: ByteArray) : Tag() {
    override val type = TagType.BYTE_ARRAY
    override fun data() = value.contentToString()
}
