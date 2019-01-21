# KotlinNBT
A easy way to create NBTs using DSL

#### Example

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
