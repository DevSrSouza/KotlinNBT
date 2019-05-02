package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket
import kotlinx.io.core.readFully
import kotlinx.io.core.writeFully

class LongArrayTag(val value: LongArray) : ITag {

    override val type = TagType.LONG_ARRAY
    override fun data() = value.contentToString()

    companion object IO : NbtIO<LongArrayTag>() {
        override fun write(tag: LongArrayTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeInt(tag.value.size)
            builder.writeFully(tag.value)
        }

        override fun read(packet: ByteReadPacket): LongArrayTag {
            val length = packet.readInt()
            val longs = LongArray(length).also { packet.readFully(it) }

            return LongArrayTag(longs)
        }
    }
}
