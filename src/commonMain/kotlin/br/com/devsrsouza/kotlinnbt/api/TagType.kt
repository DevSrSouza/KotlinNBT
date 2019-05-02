package br.com.devsrsouza.kotlinnbt.api

import br.com.devsrsouza.kotlinnbt.api.io.NbtIO
import br.com.devsrsouza.kotlinnbt.api.tags.*
import kotlin.reflect.KClass

enum class TagType(
    val id: Byte,
    val tagTypeName: String,
    val clazz: KClass<out ITag>,
    val io: NbtIO<ITag>
) {
    END(0, "End", EndTag::class, EndTag as NbtIO<ITag>),
    BYTE(1, "Byte", ByteTag::class, ByteTag as NbtIO<ITag>),
    SHORT(2, "Short", ShortTag::class, ShortTag as NbtIO<ITag>),
    INT(3, "Int", IntTag::class, IntTag as NbtIO<ITag>),
    LONG(4, "Long", LongTag::class, LongTag as NbtIO<ITag>),
    FLOAT(5, "Float", FloatTag::class, FloatTag as NbtIO<ITag>),
    DOUBLE(6, "Double", DoubleTag::class, DoubleTag as NbtIO<ITag>),
    BYTE_ARRAY(7, "Byte_Array", ByteArrayTag::class, ByteArrayTag as NbtIO<ITag>),
    STRING(8, "String", StringTag::class, StringTag as NbtIO<ITag>),
    LIST(9, "List", ListTag::class, ListTag as NbtIO<ITag>),
    COMPOUND(10, "Compound", CompoundTag::class, CompoundTag as NbtIO<ITag>),
    INT_ARRAY(11, "Int_Array", IntArrayTag::class, IntArrayTag as NbtIO<ITag>),
    LONG_ARRAY(12, "Long_Array", LongArrayTag::class, LongArrayTag as NbtIO<ITag>);

    val tagName = "TAG_$tagTypeName"

    companion object {
        fun byID(id: Byte) = values().find { it.id == id }
        fun <T : ITag> byClass(clazz: KClass<T>) = values().find { it.clazz == clazz }
    }
}