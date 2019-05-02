package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

class ShortTag(val value: Short) : ITag {
    override val type = TagType.SHORT
    override fun data() = value.toString()

    companion object IO : NbtIO<ShortTag>() {
        override fun write(tag: ShortTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeShort(tag.value)
        }

        override fun read(packet: ByteReadPacket): ShortTag {
            val short = packet.readShort()

            return ShortTag(short)
        }
    }
}
