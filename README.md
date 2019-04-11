# KotlinNBT
Named Binary Tag (NBT) library for Kotlin Multiplatform

## Dependencies
 - Kotlin Standard Library (1.3.20)
 - [Kotlinx.io](https://github.com/Kotlin/kotlinx-io) (0.1.7)

## Examples

**Read NBT from file**
```kotlin
import java.io.File
import kotlinx.io.core.ByteReadPacket
import br.com.devsrsouza.kotlinnbt.api.io.readTag

val player = "069a79f4-44e9-4726-a5be-fca90e38aaf5" // notch uuid
    
val playerData = File("$player.dat").readBytes()
val packet = ByteReadPacket(playerData)

val tag = packet.readTag()

println(tag)
```

**Compound DSL**
```kotlin
val nbt = nbtCompound {
  string["key"] = "value"
  list<IntTag> {
    int = 5
    int = 6
    int = 7
  }
  string["name"] = "im a name"
}
println(nbt)
```
