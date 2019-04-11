package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

class ByteTag(val value: Byte) : ITag {
    override val type = TagType.BYTE
    override fun data() = value.toString()

    companion object IO : NbtIO<ByteTag>() {
        override fun write(tag: ByteTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeByte(tag.value)
        }

        override fun read(packet: ByteReadPacket): ByteTag {
            val byte = packet.readByte()

            return ByteTag(byte)
        }
    }
}
