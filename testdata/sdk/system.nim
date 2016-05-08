type
  int* {.magic: Int.}
  int8* {.magic: Int8.}
  int16* {.magic: Int16.}
  int32* {.magic: Int32.}
  int64* {.magic: Int64.}
  uint* {.magic: UInt.}
  uint8* {.magic: UInt8.}
  uint16* {.magic: UInt16.}
  uint32* {.magic: UInt32.}
  uint64* {.magic: UInt64.}
  float* {.magic: Float.}
  float32* {.magic: Float32.}
  float64* {.magic: Float.}

type
  bool* {.magic: Bool.} = enum
    false = 0, true = 1

type
  char* {.magic: Char.}
  string* {.magic: String.}
  cstring* {.magic: Cstring.}
  pointer* {.magic: Pointer.}
