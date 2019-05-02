package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

class DoubleTag(val value: Double) : ITag {
    override val type = TagType.DOUBLE
    override fun data() = value.toString()

    companion object IO : NbtIO<DoubleTag>() {
        override fun write(tag: DoubleTag, builder: BytePacketBuilder) {
            write(tag, builder)
            
            builder.writeDouble(tag.value)
        }

        override fun read(packet: ByteReadPacket): DoubleTag {
            val double = packet.readDouble()

            return DoubleTag(double)
        }
    }
}
