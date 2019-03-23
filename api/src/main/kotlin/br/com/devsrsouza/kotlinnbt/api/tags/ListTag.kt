package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import kotlin.reflect.KClass

class ListTag<T : ITag>(clazz: KClass<T>) : ITag {
    override val type = TagType.LIST
    override fun data() = tags.joinToString("\n", "entries: ${tags.size} \n{\n", "\n}") { it.toString(null).prependIndent("  ") }

    val tags = mutableListOf<T>()
    val typeId = TagType.byClass(clazz)
}

var ListTag<StringTag>.string get() = ""
    set(value) { tags.add(StringTag(value)) }

var ListTag<IntTag>.int get() = 0
    set(value) { tags.add(IntTag(value)) }