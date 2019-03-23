package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

class EndTag : ITag {
    override val type = TagType.END
    override fun data() = ""
}