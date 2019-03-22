package br.com.devsrsouza.kotlinnbt.api.tags

import br.com.devsrsouza.kotlinnbt.api.ITag

abstract class Tag : ITag {
    override fun toString() = "TAG_${type.tagName}(${name?.let { "'$it'" } ?: "None"}): ${data()}"
}