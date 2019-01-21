import br.com.devsrsouza.kotlinnbt.api.tags.nbtCompound
import br.com.devsrsouza.kotlinnbt.api.tags.IntTag
import br.com.devsrsouza.kotlinnbt.api.tags.*

fun main() {
    nbtCompound {
        string["teste"] = "value"
        list<IntTag>("lista") {
            int = 5
            int = 6
            int = 7
        }
    }.also { println(it) }
}
