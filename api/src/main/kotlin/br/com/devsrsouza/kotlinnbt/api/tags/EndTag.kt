package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.TagType

class EndTag(override val name: String? = null) : Tag() {
    override val type = TagType.END
    override fun data() = ""
}