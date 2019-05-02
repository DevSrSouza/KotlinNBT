package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket
import kotlin.reflect.KClass

open class ListTag<T : ITag>(clazz: KClass<T>) : ITag, MutableList<T> by mutableListOf() {
    override val type = TagType.LIST
    override fun data() = joinToString("\n", "entries: $size \n{\n", "\n}") { it.toString(null).prependIndent("  ") }

    val typeId = TagType.byClass(clazz)

    companion object IO : NbtIO<ListTag<ITag>>() {
        override fun write(tag: ListTag<ITag>, builder: BytePacketBuilder) {

            val listType = tag.typeId
            if(listType != null) {
                writeType(tag, builder)
                builder.writeByte(listType.id)
                builder.writeInt(tag.size)

                tag.forEach { listType.io.write(it, builder) }
            } else throw RuntimeException("List Tag type can't be null")
        }

        override fun read(packet: ByteReadPacket): ListTag<ITag> {
            val typeId = packet.readByte()
            val type = TagType.byID(typeId)

            if(type != null) {
                val length = packet.readInt()
                val list = ListTag(type.clazz as KClass<ITag>)

                for (i in 1..length) {
                    val entry = type.io.read(packet)
                    list.add(entry)
                }

                return list
            } else throw RuntimeException("readded list type '$type' not supported")
        }
    }
}

var ListTag<StringTag>.string get() = ""
    set(value) { add(StringTag(value)) }

var ListTag<IntTag>.int get() = 0
    set(value) { add(IntTag(value)) }