package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.*

class IntArrayTag(val value: IntArray) : ITag {
    override val type = TagType.INT_ARRAY
    override fun data() = value.contentToString()

    companion object IO : NbtIO<IntArrayTag>() {
        override fun write(tag: IntArrayTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeInt(tag.value.size)
            builder.writeFully(tag.value)
        }

        override fun read(packet: ByteReadPacket): IntArrayTag {
            val length = packet.readInt()
            val ints = IntArray(length).also { packet.readFully(it) }

            return IntArrayTag(ints)
        }
    }
}
