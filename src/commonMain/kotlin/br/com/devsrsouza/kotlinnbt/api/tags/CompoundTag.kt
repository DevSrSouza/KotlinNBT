package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import br.com.devsrsouza.kotlinnbt.api.io.readTag
import kotlinx.io.core.*

inline fun nbtCompound(block: CompoundTag.() -> Unit) = CompoundTag().apply(block)

open class CompoundTag : ITag, MutableMap<String, ITag> by mutableMapOf() {
    override val type = TagType.COMPOUND
    override fun data(): String =
        entries.joinToString("\n", "entries: $size \n{\n", "\n}") { it.value.toString(it.key).prependIndent("  ") }

    val byte = TagProperty<Byte> { name: String, value: Byte -> ByteTag(value) }
    val short = TagProperty<Short> { name: String, value: Short -> ShortTag(value) }
    val int = TagProperty<Int> { name: String, value: Int -> IntTag(value) }
    val long = TagProperty<Long> { name: String, value: Long -> LongTag(value) }
    val float = TagProperty<Float> { name: String, value: Float -> FloatTag(value) }
    val double = TagProperty<Double> { name: String, value: Double -> DoubleTag(value) }
    val byteArray = TagProperty<ByteArray> { name: String, value: ByteArray -> ByteArrayTag(value) }
    val intArray = TagProperty<IntArray> { name: String, value: IntArray -> IntArrayTag(value) }
    val longArray = TagProperty<LongArray> { name: String, value: LongArray -> LongArrayTag(value) }
    val string = TagProperty<String> { name: String, value: String -> StringTag(value) }

    inline fun <reified T : ITag> list(name: String, block: ListTag<T>.() -> Unit) {
        put(name, ListTag(T::class).apply(block))
    }

    inline fun compound(name: String, block: CompoundTag.() -> Unit) {
        put(name, CompoundTag().apply(block))
    }

    inner class TagProperty<T>(private val tagFactory: (name: String, value: T) -> ITag) {
        operator fun get(name: String): T {
            return this@CompoundTag[name] as T
        }
        operator fun set(name: String, value: T) {
            put(name, tagFactory.invoke(name, value))
        }
    }

    companion object IO : NbtIO<CompoundTag>() {
        override fun write(tag: CompoundTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            for ((name, tag) in tag.entries) {
                val bytes = name.toByteArray()
                builder.writeShort(bytes.size.toShort())
                builder.writeFully(bytes)

                tag.type.io.write(tag, builder)
            }

            builder.writeByte(TagType.END.id)
        }

        override fun read(packet: ByteReadPacket): CompoundTag {
            val compound = CompoundTag()

            do {
                val nameLength = packet.readShort()
                val nameBytes = packet.readBytes(nameLength.toInt())

                val name = String(nameBytes)

                val tag = packet.readTag()

                if (tag !is EndTag)
                    compound[name] = tag

            } while (tag !is EndTag)

            return compound
        }
    }

    /*inline fun list(name: String? = null, vararg bytes: Byte) {
        list<ByteTag>(name) { for (entry in bytes) { byte = entry } }
    }
    inline fun list(name: String? = null, vararg strings: String) {
        list<StringTag>(name) { for (entry in strings) { string = entry } }
    }*/
}