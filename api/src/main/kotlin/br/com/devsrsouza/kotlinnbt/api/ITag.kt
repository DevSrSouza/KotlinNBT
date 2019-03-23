package br.com.devsrsouza.kotlinnbt.api

interface ITag {
    val type: TagType
    fun data(): String
    fun toString(name: String?): String = "TAG_${type.tagName}(${name?.let { "'$it'" } ?: "None"}): ${data()}"
}