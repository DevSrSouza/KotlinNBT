package br.com.devsrsouza.kotlinnbt.api

import br.com.devsrsouza.kotlinnbt.api.tags.*
import kotlin.reflect.KClass

enum class TagType(val id: Int, val tagName: String, val clazz: KClass<out ITag>) {
    BYTE(1, "Byte", ByteTag::class),
    SHORT(2, "Short", ShortTag::class),
    INT(3, "Int", IntTag::class),
    LONG(4, "Long", LongTag::class),
    FLOAT(5, "Float", FloatTag::class),
    DOUBLE(6, "Double", DoubleTag::class),
    BYTE_ARRAY(7, "Byte_Array", ByteArrayTag::class),
    STRING(8, "String", StringTag::class),
    LIST(9, "List", ListTag::class),
    COMPOUND(10, "Compound", CompoundTag::class),
    INT_ARRAY(11, "Int_Array", IntArrayTag::class),
    LONG_ARRAY(12, "Long_Array", LongArrayTag::class);

    companion object {
        fun byID(id: Int) = values().find { it.id == id }
        fun <T : ITag> byClass(clazz: KClass<T>) = values().find { it.clazz == clazz }
    }
}