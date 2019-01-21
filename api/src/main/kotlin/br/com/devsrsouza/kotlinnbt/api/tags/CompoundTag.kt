package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

fun nbtCompound(name: String? = "", block: CompoundTag.() -> Unit) = CompoundTag(
    name
).apply(block)

class CompoundTag(override val name: String? = null) : Tag() {
    override val type = TagType.COMPOUND
    override fun data(): String = tags.joinToString("\n", "entries: ${tags.size} \n{\n", "\n}") { it.toString().prependIndent("  ") }

    val tags = mutableListOf<ITag>()

    val byte = TagSetter<Byte> { name: String, value: Byte -> ByteTag(name, value) }
    val short = TagSetter<Short> { name: String, value: Short -> ShortTag(name, value) }
    val int = TagSetter<Int> { name: String, value: Int -> IntTag(name, value) }
    val long = TagSetter<Long> { name: String, value: Long -> LongTag(name, value) }
    val float = TagSetter<Float> { name: String, value: Float -> FloatTag(name, value) }
    val double = TagSetter<Double> { name: String, value: Double -> DoubleTag(name, value) }
    val byteArray = TagSetter<ByteArray> { name: String, value: ByteArray -> ByteArrayTag(name, value) }
    val intArray = TagSetter<IntArray> { name: String, value: IntArray -> IntArrayTag(name, value) }
    val longArray = TagSetter<LongArray> { name: String, value: LongArray -> LongArrayTag(name, value) }
    val string = TagSetter<String> { name: String, value: String -> StringTag(name, value) }

    inline fun <reified T : ITag> list(name: String? = null, block: ListTag<T>.() -> Unit) {
        tags.add(ListTag(T::class, name).apply(block))
    }

    fun compound(name: String? = null, block: CompoundTag.() -> Unit) {
        tags.add(CompoundTag().apply(block))
    }

    inner class TagSetter<T>(private val tagFactory: (name: String, value: T) -> ITag) {
        operator fun set(name: String, value: T) {
            tags.add(tagFactory.invoke(name, value))
        }
    }

    /*inline fun list(name: String? = null, vararg bytes: Byte) {
        list<ByteTag>(name) { for (entry in bytes) { byte = entry } }
    }
    inline fun list(name: String? = null, vararg strings: String) {
        list<StringTag>(name) { for (entry in strings) { string = entry } }
    }*/
}