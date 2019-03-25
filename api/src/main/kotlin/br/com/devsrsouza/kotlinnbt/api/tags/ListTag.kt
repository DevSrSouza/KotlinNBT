package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import kotlin.reflect.KClass

open class ListTag<T : ITag>(clazz: KClass<T>) : ITag, MutableList<T> by mutableListOf() {
    override val type = TagType.LIST
    override fun data() = joinToString("\n", "entries: $size \n{\n", "\n}") { it.toString(null).prependIndent("  ") }

    val typeId = TagType.byClass(clazz)
}

var ListTag<StringTag>.string get() = ""
    set(value) { add(StringTag(value)) }

var ListTag<IntTag>.int get() = 0
    set(value) { add(IntTag(value)) }