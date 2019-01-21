package br.com.devsrsouza.kotlinnbt.api

interface ITag {
    val type: TagType
    val name: String?
    fun data(): String
    override fun toString(): String
}