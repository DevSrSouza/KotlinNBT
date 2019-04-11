package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.*

class ByteArrayTag(val value: ByteArray) : ITag {
    override val type = TagType.BYTE_ARRAY
    override fun data() = value.contentToString()

    companion object IO : NbtIO<ByteArrayTag>() {
        override fun write(tag: ByteArrayTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeInt(tag.value.size)
            builder.writeFully(tag.value)
        }

        override fun read(packet: ByteReadPacket): ByteArrayTag {
            val lenght = packet.readInt()
            val bytes = packet.readBytes(lenght)

            return ByteArrayTag(bytes)
        }
    }
}
