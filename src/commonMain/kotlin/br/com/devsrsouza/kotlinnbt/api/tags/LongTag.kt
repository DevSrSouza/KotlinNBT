package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

class LongTag(val value: Long) : ITag {
    override val type = TagType.LONG
    override fun data() = value.toString()

    companion object IO : NbtIO<LongTag>() {
        override fun write(tag: LongTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeLong(tag.value)
        }

        override fun read(packet: ByteReadPacket): LongTag {
            val long = packet.readLong()

            return LongTag(long)
        }
    }
}
