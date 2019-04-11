package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

class FloatTag(val value: Float) : ITag {
    override val type = TagType.FLOAT
    override fun data() = value.toString()

    companion object IO : NbtIO<FloatTag>() {
        override fun write(tag: FloatTag, builder: BytePacketBuilder) {
            writeType(tag, builder)

            builder.writeFloat(tag.value)
        }

        override fun read(packet: ByteReadPacket): FloatTag {
            val float = packet.readFloat()

            return FloatTag(float)
        }
    }
}
