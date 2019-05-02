package br.com.devsrsouza.kotlinnbt.api.io

import br.com.devsrsouza.kotlinnbt.api.ITag
import br.com.devsrsouza.kotlinnbt.api.TagType
import kotlinx.io.core.BytePacketBuilder
import kotlinx.io.core.ByteReadPacket

fun ITag.write(builder: BytePacketBuilder) {
    builder.writeTag(this)
}

fun BytePacketBuilder.writeTag(tag: ITag) {
    tag.type.io.write(tag, this)
}

fun ByteReadPacket.readTag(): ITag {
    val typeId = readByte()
    val type = TagType.byID(typeId)
    if(type != null) {
        return type.io.read(this)
    } else throw RuntimeException("readded tag type '$type' not supported")
}