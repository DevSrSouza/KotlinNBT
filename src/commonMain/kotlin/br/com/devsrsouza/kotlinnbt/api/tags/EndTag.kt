package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

class EndTag : ITag {
    override val type = TagType.END
    override fun data() = ""

    companion object IO : NbtIO<EndTag>() {
        override fun write(tag: EndTag, builder: BytePacketBuilder) {
            writeType(tag, builder)
        }

        override fun read(packet: ByteReadPacket): EndTag {
            return EndTag()
        }
    }
}