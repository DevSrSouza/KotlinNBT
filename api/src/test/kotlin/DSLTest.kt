import br.com.devsrsouza.kotlinnbt.api.tags.nbtCompound
import br.com.devsrsouza.kotlinnbt.api.tags.IntTag
import br.com.devsrsouza.kotlinnbt.api.tags.*
import kotlin.test.Test
import kotlin.test.assertEquals

@Test
fun `simple dsl test`() {
    nbtCompound {
        string["teste"] = "value"
        list<IntTag>("lista") {
            int = 5
            int = 6
            int = 7
        }
    }.also { println(it) }
    assertEquals(true, true, "rapaz")
}
