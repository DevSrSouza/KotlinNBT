package br.com.devsrsouza.kotlinnbt.api.io

import br.com.devsrsouza.kotlinnbt.api.ITag
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

abstract class NbtIO<T : ITag> {
    abstract fun write(tag: T, builder: BytePacketBuilder)

    abstract fun read(packet: ByteReadPacket): T

    fun writeType(tag: T, builder: BytePacketBuilder) {
        builder.writeByte(tag.type.id)
    }
}