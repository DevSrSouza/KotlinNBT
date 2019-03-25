package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType

inline fun nbtCompound(block: CompoundTag.() -> Unit) = CompoundTag().apply(block)

open class CompoundTag : ITag, MutableMap<String, ITag> by mutableMapOf() {
    override val type = TagType.COMPOUND
    override fun data(): String = entries.joinToString("\n", "entries: $size \n{\n", "\n}") { it.value.toString(it.key).prependIndent("  ") }

    val byte = TagSetter<Byte> { name: String, value: Byte -> ByteTag(value) }
    val short = TagSetter<Short> { name: String, value: Short -> ShortTag(value) }
    val int = TagSetter<Int> { name: String, value: Int -> IntTag(value) }
    val long = TagSetter<Long> { name: String, value: Long -> LongTag(value) }
    val float = TagSetter<Float> { name: String, value: Float -> FloatTag(value) }
    val double = TagSetter<Double> { name: String, value: Double -> DoubleTag(value) }
    val byteArray = TagSetter<ByteArray> { name: String, value: ByteArray -> ByteArrayTag(value) }
    val intArray = TagSetter<IntArray> { name: String, value: IntArray -> IntArrayTag(value) }
    val longArray = TagSetter<LongArray> { name: String, value: LongArray -> LongArrayTag(value) }
    val string = TagSetter<String> { name: String, value: String -> StringTag(value) }

    inline fun <reified T : ITag> list(name: String, block: ListTag<T>.() -> Unit) {
        put(name, ListTag(T::class).apply(block))
    }

    inline fun compound(name: String, block: CompoundTag.() -> Unit) {
        put(name, CompoundTag().apply(block))
    }

    inner class TagSetter<T>(private val tagFactory: (name: String, value: T) -> ITag) {
        operator fun set(name: String, value: T) {
            put(name, tagFactory.invoke(name, value))
        }
    }

    /*inline fun list(name: String? = null, vararg bytes: Byte) {
        list<ByteTag>(name) { for (entry in bytes) { byte = entry } }
    }
    inline fun list(name: String? = null, vararg strings: String) {
        list<StringTag>(name) { for (entry in strings) { string = entry } }
    }*/
}