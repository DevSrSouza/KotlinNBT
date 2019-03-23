package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class IntTag(val value: Int) : ITag {
    override val type = TagType.INT
    override fun data() = value.toString()
}
