package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.*

class StringTag(val value: String) : ITag {

    companion object IO : NbtIO<StringTag>() {
        override fun write(tag: StringTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            val bytes = tag.value.toByteArray()

            builder.writeShort(bytes.size.toShort())
            builder.writeFully(bytes)
        }

        override fun read(packet: ByteReadPacket): StringTag {
            val length = packet.readShort()
            val bytes = packet.readBytes(length.toInt())

            return StringTag(String(bytes))
        }
    }

    override val type = TagType.STRING
    override fun data() = "'$value'"
}
