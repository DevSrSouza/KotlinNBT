package br.com.devsrsouza.kotlinnbt.api

interface ITag {
    val type: TagType
    fun data(): String
    fun toString(name: String?): String = "${type.tagName}(${name?.let { "'$it'" } ?: "None"}): ${data()}"
}