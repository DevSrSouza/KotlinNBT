package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class LongArrayTag(override val name: String?, val value: LongArray) : Tag() {
    override val type = TagType.LONG_ARRAY
    override fun data() = value.contentToString()
}
