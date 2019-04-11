package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

class IntTag(val value: Int) : ITag {
    override val type = TagType.INT
    override fun data() = value.toString()

    companion object IO : NbtIO<IntTag>() {
        override fun write(tag: IntTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeInt(tag.value)
        }

        override fun read(packet: ByteReadPacket): IntTag {
            val int = packet.readInt()

            return IntTag(int)
        }
    }
}
